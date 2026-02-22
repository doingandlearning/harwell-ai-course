# Demo 2: Without RAG vs. with RAG

## Goal

Show the difference between generic AI answers and RAG-grounded answers using a concrete example.

**Teaching style**: Problem-first approach, side-by-side comparison

---

## Before the demo

- Have AI chat interface ready (public or enterprise)
- Prepare sample internal policy document (synthetic)
- Have both "without RAG" and "with RAG" answers ready
- Prepare comparison slide

---

## Steps

**Problem-first approach**: Start with generic AI limitation, show RAG solution

### 1. Set up the problem (2 min)

**Say:** "You need to know your company's data retention policy. Let's see what happens when you ask AI."

**Show the scenario:**
- Internal policy document: "Data Retention Policy: Keep customer data for 7 years after account closure."
- Query: "What's our data retention policy?"
- Problem: Generic AI doesn't know your internal policy

**Talking point:** "Let's compare: Without RAG vs. With RAG."

---

### 2. Without RAG — generic answer (4 min)

**Say:** "First, let's ask generic AI — no RAG, no internal documents."

**Demonstrate:**
1. Open AI chat (public tool, no RAG)
2. Ask: "What's our data retention policy?"
3. Show generic answer:

```
Answer: "Data retention policies vary by organization and depend on 
regulatory requirements. Typically, organizations retain customer data 
for 3-7 years, employee records for 5-7 years, and financial records 
for 7-10 years. However, specific policies depend on your industry 
and jurisdiction..."
```

**Point out problems:**
- ❌ Generic answer — doesn't know your actual policy
- ❌ May be wrong — guesses based on training data
- ❌ Not specific — doesn't cite your documents
- ❌ Can't access internal documents

**What to say:**
- "This answer is generic — it doesn't know our actual policy"
- "It's guessing based on training data — may be wrong"
- "It can't access our internal documents"
- "This is the limitation of generic AI"

---

### 3. With RAG — grounded answer (5 min)

**Say:** "Now let's use RAG — same query, but with our policy document as context."

**Demonstrate:**
1. Show policy document: "Data Retention Policy: Keep customer data for 7 years after account closure."
2. Use RAG-enabled tool (or simulate by adding context)
3. Ask same question: "What's our data retention policy?"
4. Show RAG answer:

```
Answer: "According to your data retention policy, customer data must 
be kept for 7 years after account closure. This policy applies to all 
customer records and personal information."
```

**Point out benefits:**
- ✅ Specific answer — knows your actual policy
- ✅ Accurate — grounded in your documents
- ✅ Cites source — references your policy
- ✅ Can access internal documents

**What to say:**
- "This answer is specific — it knows our actual policy"
- "It's grounded in our documents — accurate"
- "It cites the source — we can verify"
- "This is the power of RAG"

---

### 4. Side-by-side comparison (3 min)

**Say:** "Let's compare side-by-side."

**Show comparison:**

| Aspect | Without RAG | With RAG |
|--------|-------------|----------|
| **Answer** | Generic, may be wrong | Specific, accurate |
| **Source** | Training data | Your documents |
| **Specificity** | General guidance | Your actual policy |
| **Verification** | Can't verify | Cites source |
| **Use case** | General knowledge | Internal knowledge |

**What to say:**
- "Without RAG: Generic answers from training data"
- "With RAG: Answers grounded in your documents"
- "RAG enables accurate internal knowledge Q&A"
- "Use RAG when you need answers from your internal docs"

---

### 5. Real-world use cases (1 min)

**Say:** "Here are real-world use cases for RAG."

**Show use cases:**
- ✅ **Internal documentation Q&A**: "What's our deployment process?"
- ✅ **Policy Q&A**: "What's our data retention policy?"
- ✅ **Codebase Q&A**: "How does authentication work in our codebase?"
- ✅ **Knowledge base**: "What are our coding standards?"

**What to say:**
- "RAG is perfect for internal knowledge Q&A"
- "Use it when you need answers from your documents"
- "It's more accurate than generic AI for internal questions"

---

## Sample materials

**Policy document (synthetic):**
```
Data Retention Policy

Customer Data:
- Retain customer data for 7 years after account closure
- Includes: Personal information, transaction history, communications

Employee Records:
- Retain employee records for 5 years after termination
- Includes: HR files, performance reviews, payroll records

Financial Records:
- Retain financial records for 10 years
- Includes: Invoices, receipts, tax documents
```

**Without RAG answer (generic):**
```
Data retention policies vary by organization and depend on regulatory 
requirements. Typically, organizations retain customer data for 3-7 
years, employee records for 5-7 years, and financial records for 7-10 
years...
```

**With RAG answer (grounded):**
```
According to your data retention policy:
- Customer data: 7 years after account closure
- Employee records: 5 years after termination
- Financial records: 10 years

This policy applies to all relevant records and must be followed 
according to your internal guidelines.
```

---

## If you can't run live

- Use pre-prepared screenshots showing both answers
- Use slides with side-by-side comparison
- Show example documents and answers
- Emphasize the difference: Generic vs. grounded

---

## Teaching Tips

- **Emphasize**: RAG enables accurate internal knowledge Q&A
- **Watch for**: Delegates who want to build RAG — emphasize understanding first
- **Adapt**: If delegates want implementation details, note for follow-up

---

## Time Allocation

- Set up problem: 2 min
- Without RAG — generic answer: 4 min
- With RAG — grounded answer: 5 min
- Side-by-side comparison: 3 min
- Real-world use cases: 1 min
- **Total: ~15 minutes**
