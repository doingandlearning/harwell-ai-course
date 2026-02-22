# Module 5 — Exercises

**For delegates.** Complete these during or after the Module 5 session. You can do them on your own or in pairs.

---

## Objective

By completing these exercises, you will:

- Identify use cases for RAG in your organization
- Compare RAG vs. fine-tuning vs. long context for different scenarios
- Design a simple RAG architecture diagram
- Understand when RAG is the right solution

---

## Scenario

Your organization has internal documentation, policies, and a codebase. You're exploring whether RAG could help make this knowledge more accessible through AI.

These exercises will help you think through RAG use cases and trade-offs.

---

## Exercise 1: Identify RAG use cases

**Your task:**

List **2–3 internal doc/wiki search pains** in your organization that RAG could address.

For each pain point, write:
- **The problem**: What's the current pain? (e.g. "Hard to find policy documents")
- **How RAG helps**: How would RAG solve this? (e.g. "AI could search docs and answer questions")
- **Why RAG (not fine-tuning or long context)**: One sentence why RAG is the right approach

**Hints:**

- Think about: Internal documentation, policies, procedures, codebase documentation
- RAG is good for: Multiple documents, frequent updates, need citations
- Consider: What knowledge do people struggle to find or access?

**Format:** Short list with problem, solution, and rationale.

**Then:** Share with a partner. Compare use cases and discuss which would have the most impact.

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 1</summary>

**Example answers:**

**Use case 1: Policy Q&A**
- **Problem**: Employees struggle to find specific policies (e.g. "What's our remote work policy?")
- **How RAG helps**: AI could search policy documents and answer questions with citations
- **Why RAG**: Policies change frequently, need citations, multiple documents — RAG fits perfectly

**Use case 2: Codebase documentation**
- **Problem**: New developers don't know how systems work, documentation is scattered
- **How RAG helps**: AI could answer questions about codebase by retrieving relevant code/docs
- **Why RAG**: Codebase is large, changes frequently, need to cite specific files — RAG is ideal

**Use case 3: Internal API documentation**
- **Problem**: Developers waste time searching for API documentation
- **How RAG helps**: AI could search API docs and answer questions about endpoints
- **Why RAG**: Multiple API docs, need accurate answers with citations — RAG works well

**Key insight:** RAG excels when you have multiple documents that change and need citations.

</details>

---

## Exercise 2: RAG vs. fine-tuning vs. long context

**Your task:**

For **one** of your use cases from Exercise 1, decide whether you would use **RAG**, **fine-tuning**, or **long context windows**. Write **one sentence** explaining why.

**Decision framework:**

- **RAG**: Multiple docs, frequent updates, need citations
- **Fine-tuning**: Need style/behavior change, large example dataset
- **Long context**: Few large documents, need full context

**Your answer:**

- [ ] RAG — because...
- [ ] Fine-tuning — because...
- [ ] Long context — because...

**Then:** Compare with a partner. If you disagreed, discuss what factors influenced your choice.

**Time:** About 5–10 minutes.

<details>
<summary>Example Solution for Exercise 2</summary>

**Example: Policy Q&A**

**Answer: RAG**

**Because:** Policies are multiple documents that change frequently, and we need to cite which policy document was used. RAG allows us to update documents without retraining, and provides citations.

**Why not fine-tuning?** Fine-tuning would require retraining every time policies change, which is expensive and slow.

**Why not long context?** We have many policy documents (not just one), and they're updated frequently. Long context would require sending all documents every time, which is expensive.

**Key insight:** RAG is the right choice when you have multiple documents that change and need citations.

</details>

---

## Exercise 3: Design a RAG architecture

**Your task:**

Sketch (on paper or slide) a simple RAG architecture diagram showing:

1. **Documents** → **Chunks** → **Embeddings** → **Vector DB**
2. **Query** → **Embed Query** → **Retrieve** → **Augment Prompt** → **Generate**

**Requirements:**

- Show the four main boxes: Documents, Embeddings, Vector DB, Retrieve
- Show the query flow: Query → Retrieve → Augment → Generate
- Label each step clearly
- Keep it simple — focus on the flow, not implementation details

**Hints:**

- Start with documents on the left
- Show chunking and embedding process
- Show vector database storage
- Show query processing on the right
- Connect retrieval to generation

**Then:** Share your diagram with a partner. Discuss: What happens at each step? Why is each step necessary?

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 3</summary>

**Simple RAG architecture:**

```
[Documents] 
    ↓ (chunk)
[Chunks]
    ↓ (embed)
[Embeddings]
    ↓ (store)
[Vector DB]

[Query]
    ↓ (embed)
[Query Embedding]
    ↓ (similarity search)
[Retrieve Top Chunks]
    ↓ (add to prompt)
[Augment Prompt]
    ↓ (generate)
[Answer]
```

**Key steps:**
1. **Documents → Chunks**: Break large documents into smaller pieces
2. **Chunks → Embeddings**: Convert text to numerical representations
3. **Embeddings → Vector DB**: Store for fast similarity search
4. **Query → Embed Query**: Convert query to embedding
5. **Retrieve**: Find similar chunks from vector DB
6. **Augment**: Add chunks to prompt as context
7. **Generate**: LLM generates answer based on retrieved chunks

**Key insight:** RAG is essentially "retrieve relevant docs, add to prompt, generate answer."

</details>

---

## Final Deliverables

Before moving to Module 6, ensure you have:

- [ ] Identified 2–3 RAG use cases in your organization (Exercise 1)
- [ ] Compared RAG vs. fine-tuning vs. long context for one use case (Exercise 2)
- [ ] Designed a simple RAG architecture diagram (Exercise 3)

---

## Extensions (Optional)

If you finish early or want to go deeper:

1. **Research RAG platforms:** Look up RAG-as-a-service platforms (Azure OpenAI with your data, AWS Bedrock Knowledge Bases, etc.). What do they offer? How do they compare?

2. **Chunking strategy:** Think about how you would chunk your documents. By paragraph? By section? By semantic meaning? What are the trade-offs?

3. **Retrieval quality:** How would you know if RAG is retrieving the right documents? What metrics or checks would you use?

4. **Cost estimation:** Roughly estimate: If you had 1000 policy documents, how many chunks would that create? How much would it cost to store embeddings? (Order of magnitude is fine)

---

## Key Learning Points

- **RAG solves**: AI not knowing your internal knowledge
- **RAG works by**: Retrieving relevant docs, augmenting prompt, generating answer
- **RAG is good for**: Multiple docs, frequent updates, need citations
- **RAG vs. alternatives**: RAG for docs, fine-tuning for style, long context for few large docs
- **You don't need to build RAG**: RAG-enhanced tools exist — understand when to use them

---

## After the exercises

- Keep your **use cases** and **architecture diagram** — they'll help you evaluate RAG solutions
- In Module 6 we'll explore **MCP** — another way to connect AI to your context (files, repos, databases)
- RAG and MCP both solve "AI doesn't know your context" but in different ways
