# Demo 3: Streaming response

## Goal

Show how streaming improves UX vs. waiting for complete response, emphasizing incremental display.

**Teaching style**: Problem-first approach, UX comparison

---

## Before the demo

- Have API client that supports streaming (or code example)
- Have LLM API with streaming enabled
- Prepare a longer prompt that generates substantial output
- Show both streaming and non-streaming approaches

---

## Steps

**Problem-first approach**: Start with waiting for complete response, show streaming solution

### 1. Set up the problem (2 min)

**Say:** "You're building a chat UI. User asks a question. How do you show the response?"

**Show the scenarios:**
- **Without streaming**: User waits → sees nothing → gets complete answer
- **With streaming**: User sees tokens appearing → incremental display → better UX

**Talking point:** "Let's see the difference: Non-streaming vs. streaming."

---

### 2. Without streaming — waiting (4 min)

**Say:** "First, without streaming — user waits for complete response."

**Demonstrate:**

**Request:**
```json
POST /api/chat
{
  "message": "Explain how Spring Boot dependency injection works in detail",
  "stream": false
}
```

**Show the wait:**
- User sees: "Loading..." or spinner
- No output for 5-10 seconds
- Then complete response appears

**Show the response:**
```
Spring Boot dependency injection works through the IoC (Inversion of Control) 
container. When you annotate a class with @Component, @Service, @Repository, 
or @Controller, Spring automatically detects it and creates a bean. The 
container manages the lifecycle of these beans and injects dependencies 
through constructor injection, setter injection, or field injection...
```

**Point out problems:**
- ❌ User sees nothing until complete
- ❌ Poor perceived performance
- ❌ Feels slow even if fast
- ❌ No feedback during generation

**What to say:**
- "Without streaming: User waits for complete response"
- "No output until everything is generated"
- "Poor perceived performance — feels slow"
- "User sees nothing for 5-10 seconds"

---

### 3. With streaming — incremental (5 min)

**Say:** "Now with streaming — incremental display."

**Demonstrate:**

**Request:**
```json
POST /api/chat
{
  "message": "Explain how Spring Boot dependency injection works in detail",
  "stream": true
}
```

**Show incremental display:**

**Token 1:** "Spring"
**Token 2:** "Spring Boot"
**Token 3:** "Spring Boot dependency"
**Token 4:** "Spring Boot dependency injection"
**Token 5:** "Spring Boot dependency injection works"
... (continues incrementally)

**Show the flow:**
- User sees tokens appearing immediately
- Response builds incrementally
- Better perceived performance

**Point out benefits:**
- ✅ User sees progress immediately
- ✅ Better perceived performance
- ✅ Feels faster even if same speed
- ✅ Feedback during generation

**What to say:**
- "With streaming: User sees tokens appearing immediately"
- "Response builds incrementally"
- "Better perceived performance — feels faster"
- "User sees progress right away"

---

### 4. Side-by-side comparison (3 min)

**Say:** "Let's compare side-by-side."

**Show comparison:**

| Aspect | Without Streaming | With Streaming |
|--------|-------------------|----------------|
| **User experience** | Wait → complete | Incremental |
| **Perceived speed** | Slow | Fast |
| **Feedback** | None until complete | Immediate |
| **Use case** | Simple, short responses | Longer responses |
| **Complexity** | Simpler | More complex |

**What to say:**
- "Without streaming: Simple, but poor UX for longer responses"
- "With streaming: Better UX, incremental display"
- "Use streaming for longer responses"
- "Most chat UIs use streaming"

---

### 5. Implementation note (1 min)

**Say:** "Quick implementation note."

**Show code example:**

**Non-streaming:**
```python
response = api.chat("Explain Spring Boot", stream=False)
# Wait for complete response
print(response.text)
```

**Streaming:**
```python
for chunk in api.chat("Explain Spring Boot", stream=True):
    print(chunk.text, end='', flush=True)
    # Display incrementally
```

**What to say:**
- "Streaming requires handling chunks"
- "Display incrementally as tokens arrive"
- "Most modern chat UIs use streaming"
- "Better UX for longer responses"

---

## Visual aids

**Prepare these visuals:**

1. **Without streaming** (wait → complete)
2. **With streaming** (incremental display)
3. **Side-by-side comparison** (UX difference)

---

## Teaching Tips

- **Emphasize**: Streaming improves UX for longer responses
- **Watch for**: Delegates who want to skip streaming — show UX difference
- **Adapt**: If no API access, use slides with examples

---

## Time Allocation

- Set up problem: 2 min
- Without streaming: 4 min
- With streaming: 5 min
- Side-by-side comparison: 3 min
- Implementation note: 1 min
- **Total: ~15 minutes**
