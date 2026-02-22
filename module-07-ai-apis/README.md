# Module 7: Developing with AI APIs (Condensed)

## Learning objectives

- Explain the “delta” between standard REST APIs and LLM APIs: stateful vs. stateless, non-determinism, streaming.
- Describe why LLM APIs differ from typical REST: stateful conversations, non-deterministic responses.
- Control non-determinism: temperature and top-p; when to use low vs. high.
- Handle streaming responses and implications for UX (tokens/sec, buffering).
- Understand cost drivers: token economics (input vs. output), and how to reason about cost when designing features.

## Suggested talking points

- Scope: this is the *delta*—what’s different when calling LLM APIs, not a full SDK deep dive.
- Stateful vs. stateless: conversations vs. one-off calls; session/thread handling.
- Non-determinism: same prompt → different answers; temperature and top-p; when you need reproducibility.
- Streaming: tokens/sec, chunked responses, and why it matters for perceived performance.
- Cost: input vs. output tokens; ballpark how length and frequency affect cost; design choices that reduce cost.
- If they want more depth, something else in the course may need to shrink.

## Suggested demos

- **Stateful vs. stateless:** One-off prompt vs. multi-turn “conversation” (e.g. via API or Postman); show conversation ID or message list.
- **Temperature:** Same prompt at temperature 0 vs. 0.8; show different outputs (e.g. code vs. creative).
- **Streaming:** Short demo of a streaming response (e.g. in a simple app or API client); point out tokens/sec or incremental display.
- **Cost:** Show a simple token-count or cost estimate for a sample request (input + output tokens).

## Suggested exercises

- **Settings:** For “generate tests” vs. “generate a comment,” suggest temperature (low vs. higher) and justify in one sentence.
- **Design:** Sketch a simple flow: user question → your backend → LLM API (streaming) → UI; where would you buffer?
- **Estimate:** Given approximate token counts for a typical user flow, estimate relative cost per session (order of magnitude).

## Suggested running time

45–60 minutes (condensed; expand only if scope agreed)
