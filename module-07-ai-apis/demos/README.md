# Module 7 — Demos

This folder contains facilitator notes and materials for the Module 7 demos.

## Demo 1: Stateful vs. stateless

**Purpose:** Show the difference between one-off API calls and stateful conversations.

**Materials:**
- API client (Postman, curl, or code example)
- LLM API access (OpenAI, Anthropic, or similar)

**Setup:**
- Prepare two examples:
  1. Stateless: One-off question
  2. Stateful: Multi-turn conversation with conversation ID or message list

**Steps:**
1. **Stateless**: Show one-off API call
   - Request: "What is Spring Boot?"
   - Response: Answer
   - Point out: No context maintained
2. **Stateful**: Show conversation
   - Request 1: "What is Spring Boot?" (get conversation_id)
   - Request 2: "How do I use it?" (include conversation_id)
   - Response: Answer that references previous question
   - Point out: Context maintained
3. **Compare**: Stateless vs. stateful

**Key points:**
- Stateless: Simple, one-off questions
- Stateful: Conversations, follow-up questions, context matters
- Choose based on use case

---

## Demo 2: Temperature comparison

**Purpose:** Show how temperature affects output determinism and creativity.

**Materials:**
- AI API access
- Same prompt with different temperature settings

**Setup:**
- Prepare same prompt: "Generate a Java method to calculate factorial"
- Run at temperature 0 (deterministic) and temperature 0.8 (creative)

**Steps:**
1. **Temperature 0**: Show response
   - Point out: More deterministic, focused, consistent
   - Good for: Code generation, factual answers
2. **Temperature 0.8**: Show response
   - Point out: More varied, creative, different each time
   - Good for: Creative tasks, brainstorming
3. **Compare**: Same prompt, different outputs
4. **Guidance**: When to use each

**Key points:**
- Low temperature: Deterministic, good for code
- High temperature: Creative, good for brainstorming
- Choose based on task

---

## Demo 3: Streaming response

**Purpose:** Show how streaming improves UX vs. waiting for complete response.

**Materials:**
- API client that supports streaming (or code example)
- LLM API with streaming enabled

**Setup:**
- Prepare a longer prompt that generates substantial output
- Show both streaming and non-streaming approaches

**Steps:**
1. **Without streaming**: Show waiting for complete response
   - Point out: User sees nothing until complete
   - Poor perceived performance
2. **With streaming**: Show incremental tokens
   - Point out: User sees progress immediately
   - Better perceived performance
3. **Compare**: UX difference

**Key points:**
- Streaming: Better UX, incremental display
- Non-streaming: Simpler, but slower perceived performance
- Use streaming for longer responses

---

## Demo 4: Cost estimation

**Purpose:** Show how to estimate token costs for API usage.

**Materials:**
- Token counter or estimation tool
- Sample prompts/responses
- Pricing information

**Setup:**
- Prepare sample request with token counts
- Show cost calculation

**Steps:**
1. Show sample request: Prompt + response
2. Count tokens: Input + output
3. Calculate cost: Tokens × pricing
4. Scale: Show cost for typical usage (e.g. 1000 requests/day)
5. **Optimization**: Show how shorter prompts reduce cost

**Key points:**
- Cost = (input tokens + output tokens) × pricing
- Monitor usage
- Optimize prompts to reduce costs
- Set usage limits

---

## Presenter notes

- **Focus on the delta** — what's different from standard REST APIs
- Use **practical examples** — connect to real development scenarios
- **Keep it condensed** — not a full SDK deep dive
- If delegates want more detail, note it for follow-up
- Emphasize **practical implications** — stateful for conversations, temperature for code vs. creative, streaming for UX, cost monitoring
