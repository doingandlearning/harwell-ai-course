# Module 4 — Demos

This folder contains facilitator notes and materials for the Module 4 demos.

## Demo 1: Sidecar workflow (optimized)

**Purpose:** Show how to use browser-based AI effectively alongside an IDE without native plugins.

**Materials:** 
- Browser-based AI tool (MS Copilot, ChatGPT, or similar)
- IDE without AI plugins (NetBeans, Eclipse, or similar)
- Sample Spring Boot code snippet

**Setup:** 
- Have browser and IDE side-by-side
- Prepare a context header template
- Use generic Spring Boot example (not proprietary code)

**Steps:**
1. Show naive approach: copy code, paste, get generic answer
2. Show optimized approach: include context header
3. Compare results: generic vs. contextualized
4. Demonstrate progressive building: add file context, dependencies, specific problem

**Key points:**
- Context header makes a huge difference
- Progressive building improves results
- Always review before pasting back

---

## Demo 2: Integrated workflow (if available)

**Purpose:** Show IDE plugin features: inline completion, chat with context, diff views.

**Materials:**
- IDE with AI plugin (JetBrains AI Assistant, GitHub Copilot, VS Code Copilot)
- Sample project with multiple files

**Setup:**
- Ensure plugin is configured and working
- Have sample code ready
- Prepare to show diff view

**Steps:**
1. Show inline completion: type method signature, see suggestions
2. Show chat with project context: ask about project structure
3. Show diff view: propose change, review, apply selectively
4. Compare speed vs. sidecar workflow

**Key points:**
- Context is automatic (no manual headers)
- Diff views enable safe review
- Faster iteration for local edits

**Note:** Only run if you have access to IDE with AI plugin. If not, use screenshots or skip.

---

## Demo 3: Chat vs. inline comparison

**Purpose:** Show when to use chat vs. inline completion for the same task.

**Materials:**
- Both chat interface and IDE with inline completion (or simulate)

**Setup:**
- Prepare same task: "Add validation to email field"
- Show both approaches

**Steps:**
1. **Chat approach**: Ask "How do I add email validation to a Spring Boot entity?"
   - Get explanation and example
   - Copy-paste into code
   - Review and adapt
2. **Inline approach**: Start typing validation annotation
   - See inline suggestion
   - Accept/reject
   - Continue typing
3. **Compare**: Chat for learning/exploration, inline for quick edits

**Key points:**
- Chat: exploration, learning, design
- Inline: quick edits, boilerplate
- Both have their place

---

## Presenter notes

- **Do not** paste real proprietary code in public tools during the session
- Use generic Spring Boot examples
- If you don't have access to integrated workflow, focus on sidecar optimization
- Emphasize that both workflows can be effective
- Show context header templates delegates can reuse
- If running live demos, have backup screenshots in case of connectivity issues
