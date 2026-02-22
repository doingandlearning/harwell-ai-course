# Demo 2: Temperature comparison

## Goal

Show how temperature affects output determinism and creativity, emphasizing when to use low vs. high temperature.

**Teaching style**: Problem-first approach, side-by-side comparison

---

## Before the demo

- Have AI API access ready
- Prepare same prompt with different temperature settings
- Example prompt: "Generate a Java method to calculate factorial"
- Have both outputs ready (temperature 0 vs. 0.8)

---

## Steps

**Problem-first approach**: Start with same prompt, show different outputs

### 1. Set up the problem (2 min)

**Say:** "You're generating code with AI. Do you want consistent, deterministic output or creative, varied output?"

**Show the question:**
- Same prompt: "Generate a Java method to calculate factorial"
- Different settings: Temperature 0 vs. Temperature 0.8
- Different outputs: Deterministic vs. creative

**Talking point:** "Temperature controls this — let's see the difference."

---

### 2. Temperature 0 — deterministic (4 min)

**Say:** "First, temperature 0 — deterministic, consistent output."

**Show the prompt:**
```
Prompt: "Generate a Java method to calculate factorial"
Temperature: 0
```

**Show the output:**
```java
public static long factorial(int n) {
    if (n < 0) {
        throw new IllegalArgumentException("n must be non-negative");
    }
    if (n == 0 || n == 1) {
        return 1;
    }
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

**Run same prompt again** — show same output (or very similar).

**Point out:**
- ✅ Deterministic — same prompt → same output
- ✅ Consistent — good for code generation
- ✅ Focused — no randomness
- ✅ Reliable — predictable results

**What to say:**
- "Temperature 0: Deterministic, consistent output"
- "Same prompt → same output (or very similar)"
- "Good for: Code generation, factual answers"
- "Reliable and predictable"

---

### 3. Temperature 0.8 — creative (4 min)

**Say:** "Now temperature 0.8 — creative, varied output."

**Show the prompt:**
```
Prompt: "Generate a Java method to calculate factorial"
Temperature: 0.8
```

**Show the output (first run):**
```java
public static long factorial(int n) {
    return n <= 1 ? 1 : n * factorial(n - 1);
}
```

**Run same prompt again** — show different output.

**Show the output (second run):**
```java
public static long calculateFactorial(int number) {
    if (number < 0) throw new ArithmeticException("Negative input");
    return Stream.iterate(1, i -> i + 1)
                 .limit(number)
                 .reduce(1, (a, b) -> a * b);
}
```

**Point out:**
- ✅ Varied — same prompt → different outputs
- ✅ Creative — different approaches
- ✅ Less deterministic — more randomness
- ✅ Good for brainstorming

**What to say:**
- "Temperature 0.8: Creative, varied output"
- "Same prompt → different outputs each time"
- "Good for: Creative tasks, brainstorming"
- "Less deterministic — more randomness"

---

### 4. Side-by-side comparison (3 min)

**Say:** "Let's compare side-by-side."

**Show comparison:**

| Aspect | Temperature 0 | Temperature 0.8 |
|--------|---------------|-----------------|
| **Determinism** | High — same output | Low — varied output |
| **Consistency** | Consistent | Varied |
| **Creativity** | Low — focused | High — creative |
| **Use case** | Code generation | Brainstorming |
| **Reliability** | High — predictable | Lower — unpredictable |

**What to say:**
- "Low temperature: Deterministic, good for code"
- "High temperature: Creative, good for brainstorming"
- "Choose based on task"
- "Code generation: Low temperature (0-0.3)"
- "Creative tasks: Higher temperature (0.7-1.0)"

---

### 5. Guidance: When to use each (2 min)

**Say:** "Here's guidance on when to use each."

**Show guidance:**

**Low temperature (0-0.3):**
- ✅ Code generation
- ✅ Factual answers
- ✅ When consistency matters
- ✅ When you need reliable output

**High temperature (0.7-1.0):**
- ✅ Brainstorming
- ✅ Creative writing
- ✅ When variety matters
- ✅ When you want different approaches

**What to say:**
- "Code generation: Low temperature (0-0.3)"
- "Creative tasks: Higher temperature (0.7-1.0)"
- "Default: Start with 0.2-0.3 for code"
- "Adjust based on your needs"

---

## Visual aids

**Prepare these visuals:**

1. **Same prompt, different temperatures** (side-by-side)
2. **Output comparison** (deterministic vs. creative)
3. **Guidance table** (when to use each)

---

## Teaching Tips

- **Emphasize**: Low temperature for code, high temperature for creative tasks
- **Watch for**: Delegates who want to use only one — show flexibility
- **Adapt**: If no API access, use slides with examples

---

## Time Allocation

- Set up problem: 2 min
- Temperature 0 — deterministic: 4 min
- Temperature 0.8 — creative: 4 min
- Side-by-side comparison: 3 min
- Guidance: 2 min
- **Total: ~15 minutes**
