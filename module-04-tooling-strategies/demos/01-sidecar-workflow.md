# Demo 1: Sidecar workflow (optimized)

## Goal

Show delegates how to use browser-based AI effectively alongside an IDE without native plugins, using context headers and progressive building.

**Teaching style**: Problem-first approach, progressive building

---

## Before the demo

- Ensure you have access to browser-based AI tool (MS Copilot, ChatGPT, or similar)
- Have IDE open without AI plugins (NetBeans, Eclipse, or similar)
- Prepare a sample Spring Boot code snippet (generic example)
- Have browser and IDE side-by-side on screen
- Prepare context header template

---

## Steps

**Problem-first approach**: Start with naive approach, show the pain

### 1. Set up the problem (2 min)

**Say:** "Many of you work in IDEs without AI plugins. You're copying code to a browser, pasting it, and getting generic answers. Sound familiar?"

**Show the pain:**
- ❌ Copy code → paste in browser → get generic answer
- ❌ No context about your project
- ❌ Answer doesn't match your codebase style
- ❌ Have to explain everything manually

**Talking point:** "Let's see how to optimize this workflow with context headers."

---

### 2. Show naive approach (3 min)

**Say:** "Here's what most people do — the naive approach."

**Demonstrate:**
1. Copy a Spring Boot method to clipboard
2. Paste into browser AI chat
3. Ask: "How do I refactor this?"

**Show the result:**
- Generic answer
- Doesn't know your project structure
- Doesn't know your dependencies
- Doesn't match your team's style

**What to say:**
- "This answer is generic — it doesn't know about our project"
- "It doesn't know we use Spring Boot 3, Java 17, constructor injection"
- "We're losing context every time we copy-paste"

---

### 3. Show optimized approach with context header (4 min)

**Say:** "Now let's optimize this with a context header."

**Show the context header template:**

```
Context:
- Framework: Spring Boot 3
- Java version: 17
- Style: Constructor injection (no @Autowired)
- Testing: JUnit 5, Mockito
- Database: JPA/Hibernate

Code:
[Paste code here]

Question: [Your question]
```

**Demonstrate:**
1. Copy the same method
2. Paste into browser AI chat WITH context header
3. Ask the same question: "How do I refactor this?"

**Show the result:**
- Answer references Spring Boot 3
- Uses constructor injection
- Matches your style
- More relevant suggestions

**What to say:**
- "Notice the difference — now it knows our context"
- "The answer matches our style — constructor injection, not @Autowired"
- "This is the power of context headers"

---

### 4. Progressive building — add file context (3 min)

**Say:** "But we can do even better — progressive building."

**Show enhanced context:**

```
Context:
- Framework: Spring Boot 3
- Java version: 17
- Style: Constructor injection (no @Autowired)
- Testing: JUnit 5, Mockito
- Database: JPA/Hibernate

File: BookService.java
- Purpose: Service layer for book management
- Dependencies: BookRepository (JPA repository)
- Related files: Book.java (entity), BookController.java (REST)

Code:
[Paste code here]

Question: [Your question]
```

**Demonstrate:**
1. Add file context (what file, purpose, dependencies)
2. Paste same code with enhanced context
3. Ask: "How do I add error handling?"

**Show the result:**
- Answer references BookRepository
- Suggests patterns consistent with existing code
- More specific to your codebase

**What to say:**
- "Progressive building — start with basic context, add more as needed"
- "Now it knows about our dependencies and related files"
- "The answer is more specific to our codebase"

---

### 5. Progressive building — add specific problem (2 min)

**Say:** "One more layer — add the specific problem you're solving."

**Show final context:**

```
Context:
- Framework: Spring Boot 3
- Java version: 17
- Style: Constructor injection (no @Autowired)
- Testing: JUnit 5, Mockito

File: BookService.java
- Purpose: Service layer for book management
- Dependencies: BookRepository (JPA repository)
- Problem: Need to handle case where author search returns empty list
- Current behavior: Returns null, causes NullPointerException in controller

Code:
[Paste code here]

Question: How do I add proper error handling for empty results?
```

**Demonstrate:**
1. Add specific problem context
2. Paste code with full context
3. Ask the question

**Show the result:**
- Answer addresses the specific problem
- Suggests proper error handling
- Matches your codebase patterns

**What to say:**
- "Progressive building — each layer adds more context"
- "The answer is now highly specific to our problem"
- "This is how to get the best results from sidecar workflow"

---

### 6. Review checklist (1 min)

**Show the sidecar workflow checklist:**

- ✅ **Context header**: Framework, version, style
- ✅ **File context**: Purpose, dependencies, related files
- ✅ **Problem context**: Specific issue you're solving
- ✅ **Review before paste**: Always review AI output before pasting back

**What to say:**
- "Context headers make a huge difference"
- "Progressive building improves results"
- "Always review before pasting back into your code"

---

## Context header template (for delegates)

**Save this template** — delegates can reuse it:

```
Context:
- Framework: [Your framework]
- Language version: [Your version]
- Style: [Your coding style]
- Testing: [Your testing framework]
- Database: [Your database/ORM]

File: [filename]
- Purpose: [What this file does]
- Dependencies: [What it depends on]
- Related files: [Related files]

Problem: [Specific problem you're solving]

Code:
[Paste code here]

Question: [Your question]
```

---

## If you can't run live

- Show pre-prepared screenshots comparing naive vs. optimized
- Use slides showing the difference
- Emphasize the process: context header → progressive building → review

---

## Teaching Tips

- **Emphasize**: Context headers are the key to effective sidecar workflow
- **Watch for**: Delegates who want to skip context — show the difference
- **Adapt**: If delegates use different frameworks, adjust context header template

---

## Time Allocation

- Set up problem: 2 min
- Show naive approach: 3 min
- Show optimized with context header: 4 min
- Progressive building — file context: 3 min
- Progressive building — problem context: 2 min
- Review checklist: 1 min
- **Total: ~15 minutes**
