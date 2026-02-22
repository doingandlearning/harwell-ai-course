# Demo 1: RAG flow diagram

## Goal

Walk through a single RAG flow visually to show how query → retrieve → augment → generate works, using a concrete example.

**Teaching style**: Problem-first approach, progressive building

---

## Before the demo

- Prepare slide or whiteboard with RAG flow diagram
- Have example query ready: "What's our data retention policy?"
- Prepare sample document chunks (synthetic)
- Have comparison ready: Generic answer vs. RAG answer

---

## Steps

**Problem-first approach**: Start with the problem — generic AI doesn't know your internal docs

### 1. Set up the problem (2 min)

**Say:** "You need to know your company's data retention policy. You ask AI: 'What's our data retention policy?'"

**Show the problem:**
- ❌ Generic AI doesn't know your internal policies
- ❌ It might guess or make something up
- ❌ It can't access your internal documents
- ❌ Answer may be wrong or generic

**Talking point:** "RAG solves this — it retrieves your actual documents and uses them to answer."

---

### 2. Show the RAG flow diagram (5 min)

**Say:** "Here's how RAG works — Retrieve, Augment, Generate."

**Draw or show diagram:**

```
Documents → Chunking → Embeddings → Vector Database
                                              ↓
User Query → Embed Query → Search Vector DB → Retrieve Relevant Chunks
                                              ↓
                                    Augment Prompt with Chunks
                                              ↓
                                    Generate Answer from Chunks
```

**Walk through each step:**

**Step 1: Documents → Chunks**
- "We have internal documents — policies, docs, code comments"
- "We break them into chunks — small pieces that can be searched"
- "Example: 'Data Retention Policy: Keep customer data for 7 years'"

**Step 2: Chunks → Embeddings → Vector DB**
- "Each chunk is converted to an embedding — a vector representation"
- "Embeddings capture meaning — similar content = similar vectors"
- "Stored in vector database — fast similarity search"

**Step 3: Query → Embed → Search**
- "User asks: 'What's our data retention policy?'"
- "Query is embedded — converted to vector"
- "Search vector database for similar chunks"

**Step 4: Retrieve Relevant Chunks**
- "Vector DB returns most relevant chunks"
- "Example: 'Data Retention Policy: Keep customer data for 7 years'"
- "These chunks are retrieved"

**Step 5: Augment Prompt**
- "Add retrieved chunks to the prompt"
- "Prompt becomes: 'Context: [retrieved chunks]. Question: What's our data retention policy?'"

**Step 6: Generate Answer**
- "AI generates answer using retrieved chunks"
- "Answer is grounded in actual documents"
- "Can cite sources"

**What to say:**
- "RAG = Retrieve + Augment + Generate"
- "Retrieval finds relevant chunks from your documents"
- "Augmentation adds chunks to prompt"
- "Generation uses retrieved context"

---

### 3. Walk through concrete example (5 min)

**Say:** "Let's walk through a concrete example."

**Example Query:** "What's our data retention policy?"

**Step 1: Show documents**
```
Document 1: "Data Retention Policy: Keep customer data for 7 years after account closure."
Document 2: "Employee records must be retained for 5 years."
Document 3: "Financial records: 10 years retention."
```

**Step 2: Show chunking**
```
Chunk 1: "Data Retention Policy: Keep customer data for 7 years after account closure."
Chunk 2: "Employee records must be retained for 5 years."
Chunk 3: "Financial records: 10 years retention."
```

**Step 3: Show query**
```
Query: "What's our data retention policy?"
```

**Step 4: Show retrieval**
- "Vector search finds Chunk 1 — most relevant"
- "Retrieved: 'Data Retention Policy: Keep customer data for 7 years after account closure.'"

**Step 5: Show augmentation**
```
Prompt: 
Context: "Data Retention Policy: Keep customer data for 7 years after account closure."

Question: What's our data retention policy?
```

**Step 6: Show generation**
```
Answer: "According to your data retention policy, customer data must be kept for 7 years after account closure."
```

**What to say:**
- "Notice — answer is grounded in actual document"
- "Answer cites the source"
- "Answer is specific to your policy"

---

### 4. Compare: Generic vs. RAG (2 min)

**Say:** "Let's compare: Generic AI vs. RAG."

**Show comparison:**

**Generic AI:**
- Query: "What's our data retention policy?"
- Answer: "Data retention policies vary by organization. Typically, data is retained for 3-7 years..."
- ❌ Generic, may be wrong
- ❌ Doesn't know your actual policy

**RAG:**
- Query: "What's our data retention policy?"
- Answer: "According to your data retention policy, customer data must be kept for 7 years after account closure."
- ✅ Specific, accurate
- ✅ Grounded in your documents

**What to say:**
- "Generic AI: Answers from training data — may be wrong"
- "RAG: Answers from your documents — accurate and specific"
- "RAG enables accurate internal knowledge Q&A"

---

### 5. Key takeaways (1 min)

**Show key points:**

- ✅ **RAG = Retrieve + Augment + Generate**
- ✅ **Retrieval finds relevant chunks from your documents**
- ✅ **Augmentation adds chunks to prompt**
- ✅ **Generation uses retrieved context**
- ✅ **RAG enables accurate internal knowledge Q&A**

**What to say:**
- "RAG solves the problem of generic AI answers"
- "It retrieves your actual documents and uses them"
- "Answers are grounded in your knowledge base"

---

## Visual aids

**Prepare these visuals:**

1. **RAG flow diagram** (slide or whiteboard)
2. **Example documents** (synthetic)
3. **Chunking example** (show how documents become chunks)
4. **Retrieval example** (show query → chunks)
5. **Comparison slide** (Generic vs. RAG)

---

## If you can't run live

- Use slides with RAG flow diagram
- Walk through example step-by-step on slides
- Show comparison: Generic vs. RAG answers
- Emphasize the process: Retrieve → Augment → Generate

---

## Teaching Tips

- **Emphasize**: RAG solves the problem of generic AI answers
- **Watch for**: Delegates who want to build RAG — emphasize understanding first
- **Adapt**: If delegates want implementation details, note for follow-up

---

## Time Allocation

- Set up problem: 2 min
- Show RAG flow diagram: 5 min
- Walk through concrete example: 5 min
- Compare generic vs. RAG: 2 min
- Key takeaways: 1 min
- **Total: ~15 minutes**
