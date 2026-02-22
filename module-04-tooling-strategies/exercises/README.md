# Module 4 — Exercises

**For delegates.** Complete these during or after the Module 4 session. You can do them on your own or in pairs.

---

## Objective

By completing these exercises, you will:

- Map your current AI tool setup and identify improvements
- Create a reusable context header template for your workflow
- Compare workflows with teammates using different tools
- Apply chat vs. inline decision framework to real tasks

---

## Scenario

You're a Java developer working in a mixed environment: some teammates use IntelliJ with AI plugins, others use NetBeans or VS Code. You want to optimize your AI workflow regardless of your tools.

These exercises will help you create a practical workflow that works in your environment.

---

## Exercise 1: Map your setup

**Your task:**

- Write down your current setup:
  - IDE(s) you use
  - AI tool(s) you have access to (browser-based, IDE plugins, or both)
  - Label whether you're primarily "sidecar" or "integrated"
- List **one improvement** you could make this week to optimize your workflow

**Hints:**

- Be honest about what you actually use (not what you wish you had)
- "Sidecar" = browser AI + IDE without native plugins
- "Integrated" = IDE with AI features built-in
- Improvement could be: better context headers, learning a new feature, standardizing prompts

**Format:** Short list or table.

**Then:** Share with a partner. Compare setups and note one thing you'll try based on their workflow.

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 1</summary>

**Example answers:**

**My setup:**
- IDE: IntelliJ IDEA (Community Edition)
- AI tools: MS Copilot in browser (enterprise instance)
- Workflow: Sidecar (no AI plugin in Community Edition)
- Current approach: Copy-paste code, sometimes include context

**One improvement:**
- Create a reusable context header template with my stack (Spring Boot 3, Java 17, JPA) and include it in every prompt

**Key insight:** Even without IDE plugins, sidecar can be effective with good context headers.

</details>

---

## Exercise 2: Create your context header template

**Your task:**

Draft a **2–3 line "context header"** template you'll paste into chat prompts. It should include:

- Your tech stack (framework, language version, key libraries)
- Project type or structure (if relevant)
- Any constraints or standards (e.g. "use constructor injection, not @Autowired")

**Hints:**

- Keep it concise but informative
- Make it reusable — you'll paste this into many prompts
- Include only what's relevant to most of your work
- You can add file-specific context after the header

**Format:** Plain text template you can copy-paste.

**Then:** Test it with a real prompt (e.g. "Generate a Spring Boot entity for...") and compare results with and without the header.

**Time:** About 10–15 minutes.

<details>
<summary>Example Solution for Exercise 2</summary>

**Example context header:**

```
I'm working in a Spring Boot 3 application, Java 17, using JPA and Spring Security.
Project structure: standard Maven layout.
Use constructor injection, not @Autowired. Follow Spring Boot best practices.
```

**Variations:**

**Minimal:**
```
Spring Boot 3, Java 17, JPA
```

**Detailed:**
```
Spring Boot 3.2, Java 17, JPA (Hibernate), Spring Security, Maven
Project: REST API with standard layered architecture (controller → service → repository)
Standards: Constructor injection, DTOs for API responses, validation annotations
```

**Key insight:** Start minimal, add detail as needed. The header should save you time, not create overhead.

</details>

---

## Exercise 3: Chat vs. inline decision

**Your task:**

For each task below, decide whether you would use **chat** or **inline completion** (or both). Write **one sentence** explaining why.

**Tasks:**
1. Generate a complete REST controller with CRUD operations
2. Add a @NotNull validation annotation to an entity field
3. Refactor a method to extract common logic into a helper class
4. Explain what a complex legacy method does
5. Fix a compilation error (missing import)

**Hints:**

- Chat: exploration, design, multi-file, explanation, learning
- Inline: localized edits, boilerplate, quick completions, simple fixes
- Some tasks might use both: chat to design, inline to implement

**Your answers:**

1. [ ] Chat / [ ] Inline / [ ] Both — because...
2. [ ] Chat / [ ] Inline / [ ] Both — because...
3. [ ] Chat / [ ] Inline / [ ] Both — because...
4. [ ] Chat / [ ] Inline / [ ] Both — because...
5. [ ] Chat / [ ] Inline / [ ] Both — because...

**Then:** Compare with a partner. If you disagreed, discuss what factors influenced your choice.

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 3</summary>

**Example answers:**

1. **Chat** — because generating a complete controller involves design decisions (endpoints, response types) and multiple methods. Chat allows exploration and iteration.

2. **Inline** — because adding a single annotation is a quick, localized edit. Inline completion can suggest the annotation as you type.

3. **Both** — because refactoring involves design (chat to explore approach) and implementation (inline for quick edits). Start with chat to plan, then use inline for edits.

4. **Chat** — because explanation requires exploration and context. Chat can analyze the method and provide detailed explanation.

5. **Inline** — because fixing a missing import is a quick, localized fix. Most IDEs suggest imports automatically, and inline can help if needed.

**Key insight:** Match the tool to the task. Chat for exploration and design, inline for quick edits. Many tasks benefit from both.

</details>

---

## Exercise 4: Pair — compare workflows

**Your task:**

- Find someone using a **different setup** than you (different IDE or different AI tools)
- Explain your workflow to them (how you use AI tools)
- Ask them to explain their workflow
- Note **one tip** you'll try from their approach

**Hints:**

- Focus on practical workflow, not tool comparison
- Ask: "How do you handle context?" "When do you use chat vs. inline?" "What's your biggest challenge?"
- Look for techniques you can adapt, not tools you need to buy

**Format:** Brief notes on their workflow and your takeaway.

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 4</summary>

**Example notes:**

**Partner's setup:**
- IDE: VS Code with GitHub Copilot
- Workflow: Uses inline for quick edits, chat for exploration
- Tip: Creates prompt templates for common tasks (e.g. "generate entity", "add validation")

**My takeaway:**
- I'll create prompt templates for my most common tasks, even though I use sidecar workflow
- This will save time and ensure consistency

**Key insight:** Good practices (like prompt templates) work across different tools. Focus on techniques, not tools.

</details>

---

## Final Deliverables

Before moving to Module 5, ensure you have:

- [ ] Mapped your setup (Exercise 1) — know your current workflow
- [ ] Created your context header template (Exercise 2) — have reusable context
- [ ] Applied chat vs. inline framework (Exercise 3) — can choose the right tool
- [ ] Compared workflows with a partner (Exercise 4) — learned from others

---

## Extensions (Optional)

If you finish early or want to go deeper:

1. **Test your context header:** Use the same prompt with and without your context header. Compare results. Refine your header based on what works.

2. **Create prompt templates:** For your 3 most common tasks (e.g. "generate entity", "add validation", "explain code"), create reusable prompt templates that include your context header.

3. **Document your workflow:** Write a short guide for your team on your AI workflow, including context headers and when to use chat vs. inline.

4. **Experiment with both:** If you have access to both sidecar and integrated workflows, try the same task both ways. Compare speed, quality, and ease of use.

---

## Key Learning Points

- **Tool-agnostic approach:** Good workflows work regardless of specific tools
- **Context is critical:** Context headers dramatically improve results in sidecar workflow
- **Right tool for the task:** Chat for exploration, inline for quick edits
- **Learn from others:** Different tools can teach you techniques to improve your workflow

---

## After the exercises

- Keep your **context header template** somewhere you can reuse (e.g. notes file or team wiki).
- In Module 5 we'll explore **RAG** — connecting AI to your own knowledge base.
- Your optimized workflow will help you use RAG-enhanced systems effectively.
