# Demo 1: Stateful vs. stateless

## Goal

Show the difference between one-off API calls and stateful conversations, emphasizing when to use each.

**Teaching style**: Problem-first approach, practical comparison

---

## Before the demo

- Have API client ready (Postman, curl, or code example)
- Have LLM API access (OpenAI, Anthropic, or similar)
- Prepare two examples: Stateless (one-off) and stateful (conversation)
- Have code examples ready

---

## Steps

**Problem-first approach**: Start with simple API call, show conversation need

### 1. Set up the problem (2 min)

**Say:** "You're building an app that uses AI APIs. Do you need one-off questions or conversations?"

**Show the scenarios:**
- **Scenario 1**: User asks "What is Spring Boot?" → Simple answer
- **Scenario 2**: User asks "What is Spring Boot?" then "How do I use it?" → Needs context

**Talking point:** "Let's see the difference: Stateless vs. stateful APIs."

---

### 2. Stateless API — one-off call (4 min)

**Say:** "First, stateless API — simple, one-off questions."

**Demonstrate:**

**Request 1:**
```json
POST /api/chat
{
  "message": "What is Spring Boot?"
}
```

**Response 1:**
```json
{
  "response": "Spring Boot is a Java framework..."
}
```

**Request 2:**
```json
POST /api/chat
{
  "message": "How do I use it?"
}
```

**Response 2:**
```json
{
  "response": "To use Spring Boot, you need to..."
}
```

**Point out:**
- ❌ No context maintained between calls
- ❌ Second question doesn't know about first question
- ❌ Answer is generic — doesn't reference Spring Boot

**What to say:**
- "Stateless: Each request is independent"
- "No context maintained between calls"
- "Second question doesn't know about first"
- "Good for: Simple, one-off questions"

---

### 3. Stateful API — conversation (5 min)

**Say:** "Now stateful API — maintains conversation context."

**Demonstrate:**

**Request 1:**
```json
POST /api/chat
{
  "conversation_id": null,
  "message": "What is Spring Boot?"
}
```

**Response 1:**
```json
{
  "conversation_id": "conv_123",
  "response": "Spring Boot is a Java framework..."
}
```

**Request 2:**
```json
POST /api/chat
{
  "conversation_id": "conv_123",
  "message": "How do I use it?"
}
```

**Response 2:**
```json
{
  "conversation_id": "conv_123",
  "response": "To use Spring Boot, you can start by creating a new project..."
}
```

**Point out:**
- ✅ Context maintained — conversation_id links requests
- ✅ Second question knows about first
- ✅ Answer references Spring Boot from first question
- ✅ Natural conversation flow

**What to say:**
- "Stateful: Maintains conversation context"
- "Conversation_id links requests together"
- "Second question knows about first"
- "Good for: Conversations, follow-up questions"

---

### 4. Compare: When to use each (3 min)

**Say:** "When should you use stateless vs. stateful?"

**Show comparison:**

| Use Case | Stateless | Stateful |
|----------|-----------|----------|
| **Simple Q&A** | ✅ Best | ⚠️ Overkill |
| **Conversations** | ❌ Poor | ✅ Best |
| **Follow-up questions** | ❌ Poor | ✅ Best |
| **Context matters** | ❌ Poor | ✅ Best |
| **Simple, independent** | ✅ Best | ⚠️ Overkill |

**What to say:**
- "Stateless: Simple, one-off questions"
- "Stateful: Conversations, follow-up questions, context matters"
- "Choose based on use case"
- "Most chat UIs use stateful — conversations need context"

---

### 5. Real-world example (1 min)

**Say:** "Here's a real-world example."

**Show chat UI:**
- User: "What is Spring Boot?"
- AI: "Spring Boot is a Java framework..."
- User: "How do I create a REST API with it?"
- AI: "To create a REST API with Spring Boot, you can use @RestController..."

**What to say:**
- "Chat UIs need stateful APIs — conversations need context"
- "Each message builds on previous messages"
- "This is why most AI chat tools use stateful APIs"

---

## Code examples

**Stateless (simple):**
```python
# Each request is independent
response1 = api.chat("What is Spring Boot?")
response2 = api.chat("How do I use it?")  # No context
```

**Stateful (conversation):**
```python
# Maintain conversation context
conversation_id = None
response1 = api.chat("What is Spring Boot?", conversation_id)
conversation_id = response1.conversation_id
response2 = api.chat("How do I use it?", conversation_id)  # Has context
```

---

## Teaching Tips

- **Emphasize**: Choose stateless for simple Q&A, stateful for conversations
- **Watch for**: Delegates who want to use only one — show flexibility
- **Adapt**: If no API access, use slides with examples

---

## Time Allocation

- Set up problem: 2 min
- Stateless API: 4 min
- Stateful API: 5 min
- Compare when to use: 3 min
- Real-world example: 1 min
- **Total: ~15 minutes**
