# Demo 3: Debug a prompt — iterative refinement

## Goal

Show the iterative process of refining a prompt when output is poor.

**Teaching style**: Problem-first approach, show what goes wrong, then fix it

---

## Before the demo

- Open a chat interface (public or enterprise).
- Have the refinement examples ready (see `prompts/refinement-examples.txt`).
- Use synthetic Spring Boot examples only.

---

## Steps

**Problem-first approach**: Show bad output, diagnose, fix, re-run

### 1. Set up the problem (1 min)

**Say:** "Sometimes output is wrong or doesn't match your needs. Let's see how to fix it iteratively."

**Show the initial prompt:** (Use a real example that produces poor output)

---

### 2. Show bad output (2 min)

**Run the initial prompt and show the output.**

**Point out problems:**

- ❌ Uses @Autowired (we use constructor injection)
- ❌ Uses Spring Boot 2 patterns (we use Spring Boot 3)
- ❌ Doesn't match our style
- ❌ Missing error handling

**Talking point:** "The output is wrong. How do we fix it?"

---

### 3. Read the output — diagnose (2 min)

**Step-by-step diagnosis:**

1. **What's missing?** — Error handling, proper patterns
2. **What's wrong?** — @Autowired, Spring Boot 2 patterns
3. **What would make this better?** — Add constraints, update context

**Talking point:** "Read the output to identify what needs fixing."

---

### 4. Refine the prompt (3 min)

**Show the refined prompt:**

**Add missing context:**
> "I'm using Spring Boot 3, not 2"

**Tighten instructions:**
> "Use constructor injection, not @Autowired"

**Add constraints:**
> "Include proper error handling. Don't use Optional for return types."

**Talking point:** "Add what's missing, fix what's wrong."

---

### 5. Re-run and compare (2 min)

**Run the refined prompt and show the output.**

**Compare before/after:**

- Before: @Autowired, Spring Boot 2, no error handling
- After: Constructor injection, Spring Boot 3, error handling

**Key lesson:**

- Prompting is iterative, not one-shot
- Refine based on output until it works
- Each iteration gets closer to what you need

---

## Teaching Tips

- **Emphasize**: Iterative refinement is normal — don't expect perfect output first time
- **Watch for**: Delegates who give up after one try — show that refinement is part of the process
- **Adapt**: Use a real example from your own experience if possible

---

## Time Allocation

- Set up problem: 1 min
- Show bad output: 2 min
- Diagnose: 2 min
- Refine: 3 min
- Re-run and compare: 2 min
- **Total: ~10 minutes**
