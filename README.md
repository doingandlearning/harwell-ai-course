# Harwell — Prompt Engineering for Developers

A practical, two-day course on prompting, AI-assisted Java, tooling, RAG, and MCP. This repository contains **slides**, **demo prompts**, **sample code**, and **runnable RAG and MCP demos** for use during or after the course.

## What's in this repo

- **Course outline** — [COURSE_OUTLINE.md](COURSE_OUTLINE.md) (structure, learning objectives, timing).
- **Resources** — [RESOURCES.md](RESOURCES.md) (links to Spring AI, MCP, Ollama, etc.).
- **Copy-paste prompts** — [PROMPTS.md](PROMPTS.md) (key prompts from demos in one place).
- **Handouts** — [resources/prompt-template.md](resources/prompt-template.md), [resources/context-header.md](resources/context-header.md).
- **Modules 1–8** — Each module folder has:
  - `slides.md` and `index.html` (reveal.js slides; open `index.html` in a browser).
  - `demos/` — Demo scripts, prompts, and (where applicable) code samples.
  - `exercises/README.md` — Exercise instructions.
- **RAG demo (Module 5)** — Runnable Spring Boot + pgvector + Ollama/OpenAI app: [module-05-rag/demos/rag-server-poc/](module-05-rag/demos/rag-server-poc/).
- **MCP demo (Module 6)** — Runnable Spring Boot MCP server: [module-06-mcp/demos/mcp-server-poc/](module-06-mcp/demos/mcp-server-poc/).

## Running the demos

### RAG Server POC (Module 5)

```bash
cd module-05-rag/demos/rag-server-poc
docker compose up -d
ollama pull llama3.2 && ollama pull nomic-embed-text
mvn spring-boot:run
# Then: curl -X POST http://localhost:8080/api/rag -H "Content-Type: application/json" -d '{"query": "What is our data retention policy?"}'
```

See [module-05-rag/demos/rag-server-poc/README.md](module-05-rag/demos/rag-server-poc/README.md) for details and OpenAI profile.

### MCP Server POC (Module 6)

```bash
cd module-06-mcp/demos/mcp-server-poc
mvn spring-boot:run
```

Then point an MCP client (e.g. Cursor, Claude Desktop) at `http://localhost:8080/sse`. See [module-06-mcp/demos/mcp-server-poc/README.md](module-06-mcp/demos/mcp-server-poc/README.md) for client config.

## Viewing slides

Open any module’s `index.html` in a browser (e.g. `module-01-intro-genai/index.html`). To export to PDF: **Print → Save as PDF**.

## License

Add a LICENSE file if you wish (e.g. CC BY 4.0 for slides/docs, MIT for code).
# harwell-ai-course
