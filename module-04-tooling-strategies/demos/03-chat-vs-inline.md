# Demo 3: Chat vs. inline comparison

## Goal

Show delegates when to use chat vs. inline completion for the same task, emphasizing that both have their place.

**Teaching style**: Problem-first approach, conceptual comparison

---

## Before the demo

- Have both chat interface and IDE with inline completion ready (or simulate)
- Prepare same task for both approaches: "Add validation to email field"
- Have Spring Boot entity ready to modify

---

## Steps

**Problem-first approach**: Start with a task, show both approaches

### 1. Set up the task (1 min)

**Say:** "Here's a common task: Add email validation to a Spring Boot entity. Let's see two ways to do this."

**Show the task:**
- Entity: `User` class with `email` field
- Goal: Add validation (e.g., `@Email` annotation)
- Context: Spring Boot 3, Java 17

**Talking point:** "Same task, two approaches — chat vs. inline."

---

### 2. Chat approach (5 min)

**Say:** "First approach: Chat — ask AI how to do it."

**Demonstrate:**
1. Open chat interface (browser or IDE chat)
2. Ask: "How do I add email validation to a Spring Boot entity?"
3. Show AI response:
   - Explanation of validation
   - Example code
   - Best practices
4. Copy-paste into code
5. Review and adapt

**Point out:**
- ✅ Get explanation and context
- ✅ Learn best practices
- ✅ See example code
- ✅ Understand why

**What to say:**
- "Chat gives us explanation and context"
- "We learn why we're doing this"
- "We see best practices"
- "Good for learning and exploration"

---

### 3. Inline approach (5 min)

**Say:** "Second approach: Inline — let AI suggest as you type."

**Demonstrate:**
1. Open IDE with inline completion
2. Start typing: `@Email` or `@NotNull`
3. Show inline suggestion appearing
4. Accept suggestion (Tab)
5. Continue typing — more suggestions

**Point out:**
- ✅ Fast — no switching
- ✅ Context-aware suggestions
- ✅ Quick edits
- ✅ No explanation needed

**What to say:**
- "Inline is fast — no switching to chat"
- "Suggestions appear automatically"
- "Good for quick edits when you know what you want"
- "No explanation needed — just code"

---

### 4. Compare: When to use each (3 min)

**Say:** "Both work, but when should you use each?"

**Show comparison:**

| Use Case | Chat | Inline |
|----------|------|--------|
| Learning | ✅ Best | ❌ No explanation |
| Exploration | ✅ Best | ❌ No context |
| Design decisions | ✅ Best | ❌ No discussion |
| Quick edits | ⚠️ Slower | ✅ Best |
| Boilerplate | ⚠️ Slower | ✅ Best |
| Refactoring | ✅ Best | ⚠️ Limited |

**What to say:**
- "Chat: Learning, exploration, design decisions"
- "Inline: Quick edits, boilerplate, when you know what you want"
- "Both have their place — choose based on task"
- "Don't force one approach — use what fits"

---

### 5. Real-world example (1 min)

**Say:** "Here's a real-world example: Adding a new REST endpoint."

**Show the flow:**
1. **Chat**: "How do I create a REST endpoint in Spring Boot 3?"
   - Get explanation, example, best practices
   - Learn the pattern
2. **Inline**: Type `@GetMapping` → accept suggestion
   - Fast completion
   - No need to explain again

**What to say:**
- "Start with chat to learn the pattern"
- "Then use inline for similar endpoints"
- "Chat for learning, inline for speed"

---

## Teaching Tips

- **Emphasize**: Both approaches are valid — choose based on task
- **Watch for**: Delegates who want to use only one approach — show flexibility
- **Adapt**: If no inline completion, focus on chat optimization

---

## Time Allocation

- Set up task: 1 min
- Chat approach: 5 min
- Inline approach: 5 min
- Compare when to use: 3 min
- Real-world example: 1 min
- **Total: ~15 minutes**
