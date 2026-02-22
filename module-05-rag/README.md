# Module 5: Introduction to Retrieval-Augmented Generation (RAG)

## Learning objectives

- Explain the concept of RAG: moving beyond training data by connecting LLMs to your own documents/wiki.
- Describe how RAG works at a high level: embeddings, vector databases, retrieval, and generation.
- Compare when to use RAG vs. fine-tuning vs. long-context windows.
- Relate RAG to internal knowledge bases (e.g. searching internal documentation).

## Suggested talking points

- The problem: LLMs don’t know your internal docs, wikis, or proprietary knowledge.
- The idea: retrieve relevant chunks from your data, add them to the prompt, then generate.
- Architecture: documents → chunks → embeddings → vector store; query → embed → retrieve → augment prompt → generate.
- Use cases: internal doc search, Q&A over policies, codebase Q&A; when RAG is enough vs. when you need fine-tuning or long context.
- Relevance to this audience: internal knowledge bases, governance, and “search then answer.”

## Suggested demos

- **Diagram:** Walk through a single RAG flow (query → retrieve → prompt with context → answer).
- **Conceptual:** Show a “without RAG” answer (generic) vs. “with RAG” (answer grounded in a short sample doc); use slides or a simple tool.
- **Light hands-on (if time/tools allow):** Simple demo of embedding a few paragraphs and asking a question; or use a pre-built RAG demo (e.g. Streamlit) to show retrieval + generation.
- Keep scope to understanding; avoid production wiring unless agreed.

## Suggested exercises

- **Use case:** List 2–3 internal doc/wiki search pains in your organisation that RAG could address.
- **Trade-offs:** For one use case, decide: RAG vs. fine-tuning vs. long-context; one sentence why.
- **Design:** Sketch (on paper or slide) the four boxes: Documents → Embeddings → Vector DB → Retrieve; then Query → Retrieve → Augment → Generate.

## Suggested running time

45–60 minutes (understanding-focused; extend if enabling “build soon” is agreed)
