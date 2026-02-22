# RAG Server POC — Spring Boot + pgvector

A **Retrieval-Augmented Generation (RAG)** demo built with **Spring Boot**, **Spring AI**, and **pgvector**. For **Module 5** of the Harwell Prompt Engineering course. Accepts a query over HTTP, retrieves relevant chunks from the vector database, enriches the prompt with that context, and sends to an LLM (**OpenAI** or **Ollama**).

## What this does

1. **Vector store**: PostgreSQL with the [pgvector](https://github.com/pgvector/pgvector) extension (run via Docker).
2. **Ingestion**: On first run, sample policy documents are embedded and stored (data retention, HR, security). Set `app.rag.seed-on-startup=false` after first run to avoid duplicates.
3. **RAG endpoint**: `POST /api/rag` with body `{"query": "What's our data retention policy?"}`:
   - Embeds the query and runs similarity search against pgvector.
   - Builds a prompt from the retrieved chunks plus the user query.
   - Sends the enriched prompt to the configured LLM (OpenAI or Ollama).
   - Returns `{"query": "...", "answer": "..."}`.

So the LLM answers using **your stored context**, not only its training data — same idea as the Module 5 RAG flow diagram, implemented in Java.

## Requirements

- **Java 17+**
- **Maven 3.6+**
- **Docker** (for pgvector)
- **Ollama** (default, local) or **OpenAI API key** (optional)

## Quick start (Ollama — local, no API key)

1. **Start pgvector** (from this directory):

   ```bash
   docker compose up -d
   ```

2. **Install and run Ollama**, and pull the models used by this app:

   ```bash
   # Install from https://ollama.com if needed, then:
   ollama pull llama3.2
   ollama pull nomic-embed-text
   ```

3. **Run the app**:

   ```bash
   mvn spring-boot:run
   ```

4. **Call the RAG endpoint**:

   ```bash
   curl -X POST http://localhost:8080/api/rag \
     -H "Content-Type: application/json" \
     -d '{"query": "What is our data retention policy?"}'
   ```

You should get an answer grounded in the seeded policy chunks (e.g. 7 years for customer data, 6 years for employee records).

## Using OpenAI instead

1. Set your API key (e.g. `export OPENAI_API_KEY=sk-...`).
2. Activate the `openai` profile and run:

   ```bash
   mvn spring-boot:run -Dspring.profiles.active=openai
   ```

3. Use the same `POST /api/rag` request. The app will use OpenAI for both embeddings and chat (1536-dimension embeddings; the vector store schema is created accordingly when using the openai profile).

## Configuration

| Property | Description | Default |
|----------|-------------|--------|
| `spring.datasource.url` | PostgreSQL JDBC URL | `jdbc:postgresql://localhost:5432/postgres` |
| `spring.ai.ollama.base-url` | Ollama API base URL | `http://localhost:11434` |
| `spring.ai.ollama.chat.options.model` | Ollama chat model | `llama3.2` |
| `spring.ai.ollama.embedding.options.model` | Ollama embedding model | `nomic-embed-text` |
| `app.rag.seed-on-startup` | Seed sample docs on startup | `true` |

For OpenAI, use profile `openai` and set `OPENAI_API_KEY`. Embedding dimension is set to 1536 for the vector store.

## Project layout

- `RagServerPocApplication.java` — Spring Boot entry point.
- `RagConfig.java` — Builds `QuestionAnswerAdvisor` (similarity threshold, top-k) and a `ChatClient` that uses it.
- `RagController.java` — `POST /api/rag` handler.
- `DocumentSeeder.java` — Seeds sample policy chunks when `app.rag.seed-on-startup=true`.
- `docker-compose.yml` — pgvector (PostgreSQL 16 + extension).

## Troubleshooting

### "Connection refused" to PostgreSQL

- Ensure pgvector is running: `docker compose up -d` and `docker compose ps`.
- If you use a different host/port, set `spring.datasource.url` (and username/password) accordingly.

### Ollama "connection refused" or "model not found"

- Start Ollama (e.g. `ollama serve` or run the Ollama app).
- Pull the models: `ollama pull llama3.2` and `ollama pull nomic-embed-text`.

### OpenAI profile: "API key not set"

- Set `OPENAI_API_KEY` in the environment or in `application-openai.yml` (do not commit secrets).

### Duplicate or too many seeded chunks

- Set `app.rag.seed-on-startup=false` and restart. Existing data in the vector store is left as-is.

## Course context

- **Module 5:** Introduction to RAG — flow diagram, without-RAG vs with-RAG.
- This POC implements that flow: **retrieve** (pgvector similarity search) → **augment** (add chunks to prompt) → **generate** (LLM response).
- **Scope:** Demo only. Not production-hardened (no auth, no rate limiting, minimal error handling).

## References

- [Spring AI RAG](https://docs.spring.io/spring-ai/reference/api/retrieval-augmented-generation.html)
- [Spring AI PGvector](https://docs.spring.io/spring-ai/reference/api/vectordbs/pgvector.html)
- [Spring AI Ollama](https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html)
- [pgvector](https://github.com/pgvector/pgvector)
