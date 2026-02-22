# Demo 2: Integrated workflow (if available)

## Goal

Show delegates IDE plugin features: inline completion, chat with context, diff views, and compare speed vs. sidecar workflow.

**Teaching style**: Problem-first approach, progressive building

**Note:** Only run if you have access to IDE with AI plugin. If not, use screenshots or skip.

---

## Before the demo

- Ensure IDE with AI plugin is configured and working (JetBrains AI Assistant, GitHub Copilot, VS Code Copilot)
- Have sample project with multiple files ready
- Prepare to show diff view
- Have same task ready as sidecar demo (for comparison)

---

## Steps

**Problem-first approach**: Start with sidecar limitations, show integrated solution

### 1. Set up the problem (2 min)

**Say:** "Sidecar workflow works, but it has limitations. You're switching between browser and IDE constantly. What if your IDE had AI built-in?"

**Show the pain of sidecar:**
- ❌ Switch between browser and IDE
- ❌ Copy-paste manually
- ❌ Lose context when switching
- ❌ Slower iteration

**Talking point:** "Let's see how integrated workflow solves these problems."

---

### 2. Show inline completion (4 min)

**Say:** "First feature: inline completion — AI suggests code as you type."

**Demonstrate:**
1. Open IDE with AI plugin
2. Start typing a method signature: `public List<Book> findBooksByAuthor(String author) {`
3. Show inline suggestions appearing
4. Accept suggestion (Tab or Enter)
5. Continue typing — more suggestions appear

**Point out:**
- ✅ Suggestions appear automatically
- ✅ Context-aware (knows your project)
- ✅ Fast iteration
- ✅ No copy-paste needed

**What to say:**
- "Notice — no switching to browser"
- "AI knows your project structure automatically"
- "Suggestions are context-aware — they match your codebase style"
- "This is much faster than sidecar workflow"

---

### 3. Show chat with project context (4 min)

**Say:** "Second feature: chat with automatic project context."

**Demonstrate:**
1. Open AI chat panel in IDE
2. Ask: "How do I add validation to the Book entity?"
3. Show that AI can see your project structure
4. Show answer that references your actual files

**Point out:**
- ✅ AI sees your project structure automatically
- ✅ No need to paste code manually
- ✅ Answers reference your actual files
- ✅ Can ask follow-up questions

**What to say:**
- "Notice — I didn't paste any code"
- "AI can see our project structure automatically"
- "The answer references our actual Book entity"
- "This is the power of integrated workflow"

---

### 4. Show diff view (4 min)

**Say:** "Third feature: diff view — review changes before applying."

**Demonstrate:**
1. Ask AI: "Refactor the BookService to use Streams API"
2. Show AI proposing changes
3. Show diff view — what will change
4. Review diff — accept/reject individual changes
5. Apply selectively

**Point out:**
- ✅ See exactly what will change
- ✅ Review before applying
- ✅ Apply selectively (accept/reject individual changes)
- ✅ Safe refactoring

**What to say:**
- "Diff view lets us review before applying"
- "We can see exactly what will change"
- "We can accept or reject individual changes"
- "This is safer than copy-paste"

---

### 5. Compare speed vs. sidecar (1 min)

**Say:** "Let's compare: sidecar vs. integrated workflow."

**Show comparison:**

| Aspect | Sidecar | Integrated |
|--------|---------|------------|
| Context | Manual (headers) | Automatic |
| Speed | Slower (switch apps) | Faster (no switching) |
| Review | Manual (copy-paste) | Diff view |
| Iteration | Slower | Faster |

**What to say:**
- "Integrated workflow is faster — no switching between apps"
- "Context is automatic — no manual headers needed"
- "Diff view enables safe review"
- "But sidecar works in any IDE — integrated requires plugin"

---

## If you don't have IDE plugin

**Alternative approaches:**

1. **Use screenshots:**
   - Show pre-prepared screenshots of inline completion
   - Show screenshots of chat with context
   - Show screenshots of diff view
   - Explain features conceptually

2. **Use slides:**
   - Create slides showing integrated workflow features
   - Compare to sidecar workflow
   - Emphasize: "If you have access, this is faster"

3. **Skip and emphasize sidecar:**
   - Focus on optimizing sidecar workflow
   - Mention integrated workflow as "nice to have"
   - Emphasize: "Sidecar works everywhere"

---

## Teaching Tips

- **Emphasize**: Integrated workflow is faster, but sidecar works everywhere
- **Watch for**: Delegates who don't have plugin access — reassure them sidecar is effective
- **Adapt**: If no plugin access, use screenshots or skip, focus on sidecar optimization

---

## Time Allocation

- Set up problem: 2 min
- Show inline completion: 4 min
- Show chat with context: 4 min
- Show diff view: 4 min
- Compare speed: 1 min
- **Total: ~15 minutes**

**Note:** If using screenshots, reduce to 10 minutes.
