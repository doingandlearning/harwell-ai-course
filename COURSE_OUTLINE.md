# Harwell Prompt Engineering — Course Outline

**Format:** 2-day in-person  
**Audience:** Developer-first, practical (Java/Spring context)  
**Goal:** By Monday morning, delegates know what to try, what to avoid, and how to prompt effectively.

---

## Course flow at a glance

| Day | Focus | Modules |
|-----|--------|---------|
| **Day 1** | Foundations & AI-assisted coding | Welcome → 1 (GenAI) → 2 (Prompting) → 3 (Java) → 4 (Tooling) |
| **Day 2** | Architecture & integration | Opening → 5 (RAG) → 6 (MCP) → 7 (APIs) → 8 (Future) → Closing |

---

## Day 1: Foundations & AI-Assisted Coding

### Welcome & course overview (30 min)
- Introductions, agenda, housekeeping
- Set expectations: practical, safe use, review-and-verify

### Module 1: Introduction to GenAI (80 min)
- **Objectives:** LLM landscape, public vs. enterprise AI, safe use, limitations (hallucinations, cut-offs, bias), when to verify.
- **Demos:** Public vs. enterprise, hallucination check, model comparison (optional).
- **Materials in repo:** `module-01-intro-genai/` (slides, demos, exercises).

### Module 2: Core Prompt Engineering (75 min)
- **Objectives:** 3 Cs (Context, Clarity, Constraints), few-shot, debugging prompts.
- **Demos:** Three prompts, few-shot, debug prompt.
- **Materials in repo:** `module-02-core-prompt-engineering/` (slides, demos, exercises).

### Module 3: AI-Assisted Java (150 min) — Anchor module
- **Objectives:** Code generation, legacy explanation, refactoring (test-first), unit test generation.
- **Demos:** Spring Boot generation, legacy explanation, refactoring, unit testing. Prompts and code in `demos/prompts/` and `demos/code-samples/`.
- **Materials in repo:** `module-03-ai-assisted-java/` (slides, demos, prompts, code-samples, DEMO_PREPARATION.md, exercises).

### Module 4: Tooling Strategies (85 min)
- **Objectives:** Sidecar vs. integrated workflow, context headers, chat vs. inline.
- **Demos:** Sidecar workflow, integrated workflow, chat vs. inline.
- **Materials in repo:** `module-04-tooling-strategies/` (slides, demos, exercises).

---

## Day 2: Advanced Architecture & Integration

### Day 2 opening (15 min)
- Day 1 recap, Day 2 agenda, questions.

### Module 5: Introduction to RAG (80 min)
- **Objectives:** What RAG is, retrieve → augment → generate, RAG vs. fine-tuning vs. long context, use cases.
- **Demos:** RAG flow diagram, without vs. with RAG. **Optional hands-on:** `module-05-rag/demos/rag-server-poc/` (runnable).
- **Materials in repo:** `module-05-rag/` (slides, demos, rag-server-poc, exercises).

### Module 6: Model Context Protocol (55 min)
- **Objectives:** What MCP is, without vs. with MCP, minimal MCP server.
- **Demos:** Without vs. with MCP diagram, Spring Boot MCP server POC. **POC:** `module-06-mcp/demos/mcp-server-poc/` (runnable).
- **Materials in repo:** `module-06-mcp/` (slides, demos, mcp-server-poc, exercises).

### Module 7: AI APIs (75 min)
- **Objectives:** Stateful vs. stateless, temperature, streaming, cost.
- **Demos:** Stateful vs. stateless, temperature comparison, streaming, cost estimation.
- **Materials in repo:** `module-07-ai-apis/` (slides, demos, exercises).

### Module 8: Future of AI (65 min)
- **Objectives:** Near-term trends, what to try next, action plans.
- **Materials in repo:** `module-08-future-of-ai/` (slides, exercises).

### Course closing (25 min)
- Action plans, Q&A, feedback.

---

## In this repo

| What | Where |
|------|--------|
| Copy-paste prompts | [PROMPTS.md](PROMPTS.md) |
| Handouts | [resources/](resources/) |
| RAG POC | [module-05-rag/demos/rag-server-poc/](module-05-rag/demos/rag-server-poc/) |
| MCP POC | [module-06-mcp/demos/mcp-server-poc/](module-06-mcp/demos/mcp-server-poc/) |
| Links & docs | [RESOURCES.md](RESOURCES.md) |

---

## Timing summary

| Day | Content | Breaks | Total |
|-----|---------|--------|--------|
| Day 1 | ~6.5 h | 1.5 h | ~8 h |
| Day 2 | ~5 h | 1.5 h | ~6.5 h |

Trim if needed: Module 3, Module 5, or Module 8; move exercises to homework.
