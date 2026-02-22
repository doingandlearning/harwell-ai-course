# Module 7 — Exercises

**For delegates.** Complete these during or after the Module 7 session. You can do them on your own or in pairs.

---

## Objective

By completing these exercises, you will:

- Choose appropriate temperature settings for different tasks
- Design a simple streaming API integration flow
- Estimate token costs for typical usage scenarios
- Understand the practical implications of LLM API differences

---

## Scenario

You're building a backend service that calls LLM APIs. These exercises will help you understand the practical implications of LLM API differences.

---

## Exercise 1: Temperature settings

**Your task:**

For each task below, suggest a **temperature** setting (low, medium, or high) and justify in **one sentence**.

**Tasks:**
1. Generate unit tests for a Java method
2. Generate a creative product description
3. Explain what a code snippet does
4. Brainstorm feature ideas for an app

**Hints:**

- Low temperature (0-0.3): Code generation, factual answers, tests
- Medium temperature (0.5-0.7): General use
- High temperature (0.8-1.0): Creative writing, brainstorming

**Your answers:**

1. Temperature: [ ] Low / [ ] Medium / [ ] High — because...
2. Temperature: [ ] Low / [ ] Medium / [ ] High — because...
3. Temperature: [ ] Low / [ ] Medium / [ ] High — because...
4. Temperature: [ ] Low / [ ] Medium / [ ] High — because...

**Then:** Compare with a partner. Discuss: What factors influenced your choices?

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 1</summary>

**Example answers:**

1. **Generate unit tests** → **Low temperature** — because tests need to be consistent and correct, not creative.

2. **Generate creative product description** → **High temperature** — because creativity and variety are desired.

3. **Explain code snippet** → **Low temperature** — because explanations should be factual and consistent.

4. **Brainstorm feature ideas** → **High temperature** — because brainstorming benefits from creative, varied ideas.

**Key insight:** Match temperature to task — low for consistency (code, facts), high for creativity (writing, brainstorming).

</details>

---

## Exercise 2: Design a streaming flow

**Your task:**

Sketch a simple flow diagram showing:

**User question → Your backend → LLM API (streaming) → UI**

**Requirements:**

- Show where streaming happens
- Show where you would buffer tokens
- Show where you would display to user
- Label key decision points

**Hints:**

- Streaming happens between LLM API and your backend
- You may buffer tokens before displaying (for smooth UX)
- Display happens in UI as tokens arrive
- Consider: How do you handle errors mid-stream?

**Format:** Simple diagram or flow chart.

**Then:** Share with a partner. Discuss: Where would you buffer? How would you handle errors?

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 2</summary>

**Example flow:**

```
[User Question]
    ↓
[Your Backend]
    ↓ (send request with streaming=true)
[LLM API]
    ↓ (stream tokens)
[Your Backend] ← buffer tokens here (optional)
    ↓ (forward tokens)
[UI] ← display tokens incrementally
```

**Key points:**
- Streaming: LLM API → Your Backend (tokens arrive incrementally)
- Buffering: Optional buffer in backend for smooth display
- Display: UI shows tokens as they arrive
- Error handling: Handle mid-stream errors gracefully

**Key insight:** Streaming improves UX, but requires handling partial responses and errors.

</details>

---

## Exercise 3: Cost estimation

**Your task:**

Given these approximate token counts for a typical user flow, estimate the **relative cost per session** (order of magnitude):

- User question: ~200 tokens (input)
- AI response: ~500 tokens (output)
- Follow-up question: ~150 tokens (input)
- AI response: ~400 tokens (output)

**Assumptions:**

- Pricing: $0.01 per 1K input tokens, $0.03 per 1K output tokens
- One session = initial question + follow-up

**Your calculation:**

- Input tokens: ___ + ___ = ___
- Output tokens: ___ + ___ = ___
- Cost: (input × $0.01/1K) + (output × $0.03/1K) = $___

**Then:** Scale this to 1000 sessions/day. What's the daily cost? Monthly cost?

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 3</summary>

**Calculation:**

**Input tokens:**
- Initial question: 200 tokens
- Follow-up: 150 tokens
- **Total input: 350 tokens**

**Output tokens:**
- Initial response: 500 tokens
- Follow-up response: 400 tokens
- **Total output: 900 tokens**

**Cost per session:**
- Input: 350 tokens × $0.01/1K = $0.0035
- Output: 900 tokens × $0.03/1K = $0.027
- **Total: ~$0.03 per session**

**Scale to 1000 sessions/day:**
- Daily: 1000 × $0.03 = $30/day
- Monthly: $30 × 30 = $900/month

**Key insight:** Costs scale with usage. Monitor token usage and optimize prompts to reduce costs.

</details>

---

## Final Deliverables

Before moving to Module 8, ensure you have:

- [ ] Chosen temperature settings for different tasks (Exercise 1)
- [ ] Designed a streaming flow (Exercise 2)
- [ ] Estimated costs for typical usage (Exercise 3)

---

## Extensions (Optional)

If you finish early or want to go deeper:

1. **Compare APIs:** Research OpenAI API vs. Anthropic API vs. other LLM APIs. What are the differences in how they handle stateful conversations? Streaming? Pricing?

2. **Error handling:** Design error handling for streaming responses. What happens if the stream fails mid-response? How do you handle partial responses?

3. **Caching strategy:** Think about caching LLM API responses. When can you cache? What are the trade-offs? How does caching affect cost?

4. **Rate limiting:** Design rate limiting for LLM API calls. How do you prevent cost overruns? How do you handle rate limit errors?

---

## Key Learning Points

- **Stateful vs. stateless**: Choose based on whether you need context (conversations vs. one-off)
- **Temperature**: Low for consistency (code), high for creativity (writing)
- **Streaming**: Improves UX, requires handling partial responses
- **Cost**: Token-based, monitor usage, optimize prompts
- **Practical focus**: Understand differences to use APIs effectively

---

## After the exercises

- Keep your **temperature guidelines** and **cost estimates** — they'll help you use LLM APIs effectively
- In Module 8 we'll explore **the future** — what's coming next for AI and development
- Understanding API differences helps you build better AI-integrated applications
