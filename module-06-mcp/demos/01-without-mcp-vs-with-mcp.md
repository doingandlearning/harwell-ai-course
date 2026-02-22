# Demo 1: Without MCP vs. with MCP diagram

## Goal

Show the difference between manual copy-paste and MCP-enabled access, emphasizing structured protocol vs. manual work.

**Teaching style**: Problem-first approach, conceptual comparison

---

## Before the demo

- Prepare slide or whiteboard showing two scenarios
- Diagram: "Without MCP" (manual paste) vs. "With MCP" (protocol-based)
- Have example ready: Asking AI about project structure

---

## Steps

**Problem-first approach**: Start with manual copy-paste pain, show MCP solution

### 1. Set up the problem (2 min)

**Say:** "You want AI to understand your project structure. How do you do it today?"

**Show the pain:**
- ❌ Copy files manually
- ❌ Paste into AI chat
- ❌ Lose context when switching
- ❌ Can't ask follow-up questions easily
- ❌ Manual, error-prone

**Talking point:** "MCP solves this — structured protocol for AI to access your project."

---

### 2. Without MCP — manual approach (4 min)

**Say:** "Here's how it works today — without MCP."

**Show the flow:**

```
User → Copy code/file → Paste in AI chat → Get answer
```

**Walk through example:**

**Scenario:** "How does authentication work in my project?"

**Step 1: Manual copy**
- User opens `AuthService.java`
- Copies code
- Switches to AI chat
- Pastes code

**Step 2: Ask question**
- Types: "How does authentication work in this code?"
- AI answers based on pasted code

**Step 3: Follow-up question**
- User wants to know about related files
- Must copy `AuthController.java` manually
- Paste again
- Ask follow-up

**Point out problems:**
- ❌ Manual copy-paste — tedious
- ❌ Lose context — AI doesn't see project structure
- ❌ Can't easily ask about related files
- ❌ Error-prone — might miss important files
- ❌ No structured access

**What to say:**
- "This is manual and tedious"
- "AI doesn't see project structure — only what you paste"
- "Follow-up questions require more copy-paste"
- "This is the 'silo' problem — information is isolated"

---

### 3. With MCP — protocol-based approach (5 min)

**Say:** "Now let's see how MCP solves this — structured protocol."

**Show the flow:**

```
User → Ask AI → AI requests via MCP → Context server responds → AI answers
```

**Walk through same example:**

**Scenario:** "How does authentication work in my project?"

**Step 1: Ask question**
- User asks: "How does authentication work in my project?"
- AI uses MCP to request project structure

**Step 2: MCP request**
- AI requests: "List files in project"
- MCP server responds: `["AuthService.java", "AuthController.java", ...]`

**Step 3: AI reads files**
- AI requests: "Read AuthService.java"
- MCP server responds: File contents
- AI requests: "Read AuthController.java"
- MCP server responds: File contents

**Step 4: AI answers**
- AI understands project structure
- Answers based on actual files
- Can reference specific files

**Step 5: Follow-up question**
- User asks: "What about the security configuration?"
- AI requests: "Read SecurityConfig.java" via MCP
- Answers without user copying anything

**Point out benefits:**
- ✅ Structured protocol — no manual copy-paste
- ✅ AI sees project structure automatically
- ✅ Can ask about related files easily
- ✅ Less error-prone — AI requests what it needs
- ✅ Maintains context — AI understands relationships

**What to say:**
- "MCP enables structured access — no manual copy-paste"
- "AI can 'see' your project structure automatically"
- "Follow-up questions work seamlessly"
- "This is the power of MCP — structured, controlled access"

---

### 4. Side-by-side comparison (3 min)

**Say:** "Let's compare side-by-side."

**Show comparison:**

| Aspect | Without MCP | With MCP |
|--------|--------------|----------|
| **Access** | Manual copy-paste | Structured protocol |
| **Context** | Only what you paste | Full project structure |
| **Follow-up** | More copy-paste | Automatic |
| **Error-prone** | Yes — might miss files | No — AI requests what it needs |
| **Security** | Less control | More control (server decides) |
| **Speed** | Slower (manual) | Faster (automatic) |

**What to say:**
- "Without MCP: Manual, error-prone, loses context"
- "With MCP: Structured, controlled, maintains context"
- "MCP enables AI to 'see' your project structure"
- "Less manual copy-paste needed"

---

### 5. MCP context servers (1 min)

**Say:** "MCP uses context servers — standardized ways to access information."

**Show examples:**
- ✅ **Filesystem server**: Access files and directories
- ✅ **Git server**: Access git history, branches, commits
- ✅ **Database server**: Access database schema, queries
- ✅ **Custom servers**: Your own context servers

**What to say:**
- "MCP uses context servers — standardized access"
- "Filesystem server: Read files, list directories"
- "Git server: Access git history"
- "You can build custom servers for your needs"

---

## Visual aids

**Prepare these visuals:**

1. **Without MCP diagram** (manual copy-paste flow)
2. **With MCP diagram** (protocol-based flow)
3. **Side-by-side comparison** (table)
4. **MCP context servers** (examples)

---

## If you can't run live

- Use slides with diagrams
- Show conceptual comparison
- Emphasize the difference: Manual vs. protocol-based
- Note: MCP is still early — understanding, not rollout

---

## Teaching Tips

- **Emphasize**: MCP solves the "silo" problem — structured access vs. manual copy-paste
- **Watch for**: Delegates who want to implement MCP — emphasize it's still early
- **Adapt**: If delegates want implementation details, note for follow-up

---

## Time Allocation

- Set up problem: 2 min
- Without MCP — manual approach: 4 min
- With MCP — protocol-based: 5 min
- Side-by-side comparison: 3 min
- MCP context servers: 1 min
- **Total: ~15 minutes**
