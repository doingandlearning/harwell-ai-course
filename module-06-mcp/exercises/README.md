# Module 6 — Exercises

**For delegates.** Complete these during or after the Module 6 session. You can do them on your own or in pairs.

---

## Objective

By completing these exercises, you will:

- Understand when MCP would help your team
- Identify tasks that would benefit from MCP
- Compare MCP access vs. paste-only workflows
- Recognize that MCP is orientation, not adoption

---

## Scenario

You're exploring whether MCP could help your team work more effectively with AI tools. These exercises will help you understand when MCP might be useful.

**Remember:** MCP is still early/evolving. This is about understanding, not adoption.

---

## Exercise 1: Reflection — when would MCP help?

**Your task:**

Write **one sentence** completing this: "MCP would help my team if..."

**Hints:**

- Think about: Tasks that require AI to see multiple files or understand project structure
- Consider: When manual copy-paste is slow, risky, or loses context
- Examples: "MCP would help my team if we need AI to understand our entire codebase structure"
- Focus on the problem MCP solves, not implementation

**Format:** One sentence.

**Then:** Share with a partner. Compare scenarios and discuss what makes MCP useful.

**Time:** About 5 minutes.

<details>
<summary>Example Solution for Exercise 1</summary>

**Example answers:**

- "MCP would help my team if we need AI to understand relationships between multiple files in our codebase."

- "MCP would help my team if we want AI to answer questions about our project structure without manually pasting dozens of files."

- "MCP would help my team if we need AI to reason over our entire repository while maintaining data privacy."

**Key insight:** MCP helps when you need AI to understand project structure or multiple files, and manual copy-paste is insufficient.

</details>

---

## Exercise 2: Scenario — IDE with MCP

**Your task:**

Imagine your IDE could safely expose "only this module" to an AI via MCP. List **2 tasks** that would become easier.

**Requirements:**

- Tasks that require understanding multiple files or project structure
- Tasks where manual copy-paste is currently slow or risky
- Be specific about what makes MCP helpful

**Hints:**

- Think about: Code explanation, refactoring across files, understanding dependencies
- Consider: What's hard to do with manual copy-paste?
- Examples: "Explain how authentication works across this module" (requires multiple files)

**Format:** List of 2 tasks with brief explanation.

**Then:** Compare with a partner. Discuss: Would these tasks be easier with MCP? Why?

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 2</summary>

**Example tasks:**

1. **"Explain how authentication works across this module"**
   - Currently: Manually copy-paste multiple files (AuthService, AuthController, SecurityConfig)
   - With MCP: AI can request all relevant files automatically, understand relationships
   - Why easier: No manual file selection, AI sees full context

2. **"Refactor this module to extract common patterns"**
   - Currently: Copy-paste files one by one, lose project structure
   - With MCP: AI can see all files in module, understand patterns across files
   - Why easier: AI understands module structure, can suggest refactoring across files

**Key insight:** MCP helps when tasks require understanding multiple files or project structure.

</details>

---

## Exercise 3: Discussion — MCP vs. paste-only

**Your task:**

In pairs, discuss: **When would you want the AI to have direct access to your repo via MCP vs. paste-only?**

**Consider:**

- **MCP access**: Structured, can see project structure, less manual work
- **Paste-only**: Manual control, you choose what to share, more explicit

**Discussion points:**

- What are the benefits of each approach?
- What are the risks or concerns?
- When would you prefer MCP? When would you prefer paste-only?
- What factors influence your choice? (privacy, control, convenience, etc.)

**Format:** Brief notes from your discussion.

**Then:** Share key insights with the group (if time allows).

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 3</summary>

**Example discussion points:**

**MCP access — benefits:**
- Faster: No manual copy-paste
- Better context: AI sees project structure
- Safer: Structured, controlled access (can limit scope)

**MCP access — concerns:**
- Less control: AI sees what you configure, not what you explicitly paste
- Privacy: Need to trust MCP server configuration
- Still early: May have bugs or limitations

**Paste-only — benefits:**
- Full control: You choose exactly what to share
- Explicit: Clear what AI can see
- Simple: No configuration needed

**Paste-only — concerns:**
- Slow: Manual copy-paste
- Loses context: No project structure awareness
- Error-prone: Easy to miss files or lose context

**When to prefer MCP:**
- Need AI to understand project structure
- Working with many files
- Want faster iteration
- Trust MCP server configuration

**When to prefer paste-only:**
- Need explicit control over what AI sees
- Working with sensitive code
- One-off questions
- Don't have MCP configured

**Key insight:** Choose based on your needs: MCP for structure/context, paste-only for explicit control.

</details>

---

## Final Deliverables

Before moving to Module 7, ensure you have:

- [ ] Reflected on when MCP would help your team (Exercise 1)
- [ ] Identified 2 tasks that would benefit from MCP (Exercise 2)
- [ ] Discussed MCP vs. paste-only trade-offs (Exercise 3)

---

## Extensions (Optional)

If you finish early or want to go deeper:

1. **Research MCP adoption:** Look up which tools currently support MCP (Claude Desktop, etc.). What's the current state of adoption?

2. **MCP vs. RAG comparison:** Compare MCP and RAG. Both solve "AI doesn't know your context" — how are they different? When would you use each?

3. **Security considerations:** Think about security implications of MCP. What would you need to consider before adopting MCP? What access controls would you want?

4. **Future vision:** Imagine MCP is widely adopted. How would your workflow change? What new capabilities would become possible?

---

## Key Learning Points

- **MCP solves**: AI not accessing local files/repos/databases
- **MCP works by**: Standardized protocol for context servers
- **MCP helps when**: You need AI to understand project structure or multiple files
- **MCP is still early**: Orientation, not adoption — watch for evolution
- **MCP vs. paste-only**: Choose based on needs — structure vs. explicit control

---

## After the exercises

- Keep your **reflections** — they'll help you evaluate MCP as it evolves
- In Module 7 we'll explore **AI APIs** — the technical details of calling LLMs
- MCP uses APIs under the hood — understanding APIs will help you understand MCP better
