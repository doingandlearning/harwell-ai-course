# Module 5 — Demos

This folder contains facilitator notes and materials for the Module 5 demos.

## Demo 1: RAG flow diagram

**Purpose:** Walk through a single RAG flow visually to show how query → retrieve → augment → generate works.

**Materials:** 
- Slide or whiteboard with RAG flow diagram
- Example query: "What's our data retention policy?"
- Sample document chunks (synthetic)

**Setup:** 
- Prepare diagram showing: Documents → Chunks → Embeddings → Vector DB → Query → Retrieve → Augment → Generate
- Have sample document chunks ready to show retrieval

**Steps:**
1. Show the query: "What's our data retention policy?"
2. Walk through retrieval: Find relevant chunks from vector DB
3. Show augmentation: Add chunks to prompt
4. Show generation: Answer based on retrieved chunks
5. Compare: Generic answer vs. RAG answer

**Key points:**
- RAG is "retrieve + augment + generate"
- Retrieval finds relevant chunks
- Augmentation adds context to prompt
- Generation uses retrieved context

---

## Demo 2: Without RAG vs. with RAG

**Purpose:** Show the difference between generic AI answers and RAG-grounded answers.

**Materials:**
- AI chat interface (public or enterprise)
- Sample internal policy document (synthetic)
- Slide showing comparison

**Setup:**
- Prepare a synthetic policy document (e.g. "Data Retention Policy: Keep data for 7 years")
- Have both "without RAG" and "with RAG" answers ready

**Steps:**
1. **Without RAG**: Ask "What's our data retention policy?"
   - Show generic answer (not your actual policy)
   - Point out: Generic, may be wrong
2. **With RAG**: Same query, but with policy document as context
   - Show answer grounded in actual policy
   - Point out: Specific, accurate, cites source
3. **Compare**: Generic vs. grounded answer

**Key points:**
- Without RAG: Generic answers from training data
- With RAG: Answers grounded in your documents
- RAG enables accurate internal knowledge Q&A

**Note:** If you can't run live, use pre-prepared screenshots or slides showing the comparison.

---

## Demo 3: Light hands-on (optional)

**Purpose:** Show a simple RAG demo if time/tools allow.

**Materials:**
- **RAG Server POC** (Java/Spring Boot): `rag-server-poc/` in this folder
  - Docker (pgvector) + Spring AI + Ollama or OpenAI
  - `POST /api/rag` with `{"query": "What's our data retention policy?"}` returns an answer grounded in seeded policy chunks
  - See `rag-server-poc/README.md` for run instructions
- Or: Pre-built RAG demo (e.g. Streamlit app, simple Python script)
- Or: Use a RAG service demo (Azure OpenAI with your data, etc.)

**Setup:**
- Only if time allows and tools are available
- For the Java POC: `docker compose up -d`, pull Ollama models, `mvn spring-boot:run`, then call `/api/rag`
- Keep it simple — just show retrieval + generation
- Use synthetic documents only

**Steps:**
1. Show documents being chunked and embedded (or point to seeder in the POC)
2. Show query being processed
3. Show retrieval of relevant chunks
4. Show answer generated from chunks

**Key points:**
- RAG can be simple to set up (with right tools)
- Focus on understanding, not building
- This is optional — conceptual demos are sufficient

**Note:** Only run if explicitly agreed and time allows. Otherwise, stick to conceptual demos.

---

## Presenter notes

- **Keep scope to understanding** — this is not a "build RAG" session unless explicitly agreed
- Use **synthetic examples** only (not real internal documents)
- Focus on **conceptual understanding** — what RAG is and when to use it
- **Avoid production wiring** unless delegates explicitly want implementation details
- If delegates want to build RAG, note it for follow-up or advanced session
- Emphasize that **RAG-enhanced tools exist** — they don't need to build it themselves
