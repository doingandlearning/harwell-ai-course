# Demo 4: Cost estimation

## Goal

Show how to estimate token costs for API usage, emphasizing monitoring and optimization.

**Teaching style**: Problem-first approach, practical calculation

---

## Before the demo

- Have token counter or estimation tool ready
- Prepare sample prompts/responses
- Have pricing information ready (example: OpenAI pricing)
- Show cost calculation and scaling

---

## Steps

**Problem-first approach**: Start with cost concern, show how to estimate

### 1. Set up the problem (2 min)

**Say:** "You're building an app that uses AI APIs. How much will it cost?"

**Show the concern:**
- ❌ Don't know how to estimate costs
- ❌ Worried about unexpected bills
- ❌ Need to budget for usage
- ❌ Want to optimize costs

**Talking point:** "Let's see how to estimate costs using token counting."

---

### 2. Show token counting (4 min)

**Say:** "Cost is based on tokens — input tokens + output tokens."

**Show example:**

**Request:**
```
Prompt: "Explain how Spring Boot dependency injection works"
```

**Count tokens:**
- Input: ~10 tokens
- Output: ~150 tokens
- **Total: ~160 tokens**

**Show pricing (example — OpenAI GPT-4):**
- Input: $0.03 per 1K tokens
- Output: $0.06 per 1K tokens

**Calculate cost:**
- Input cost: (10 / 1000) × $0.03 = $0.0003
- Output cost: (150 / 1000) × $0.06 = $0.009
- **Total: $0.0093 per request**

**What to say:**
- "Cost = (input tokens + output tokens) × pricing"
- "Input tokens: Your prompt"
- "Output tokens: AI's response"
- "Pricing varies by model"

---

### 3. Scale to typical usage (4 min)

**Say:** "Now let's scale to typical usage."

**Show scaling:**

**Per request:** $0.0093

**Per day (1000 requests):**
- 1000 × $0.0093 = $9.30/day

**Per month (30 days):**
- $9.30 × 30 = $279/month

**Per year:**
- $279 × 12 = $3,348/year

**Point out:**
- ⚠️ Costs add up quickly
- ⚠️ Need to monitor usage
- ⚠️ Need to optimize prompts

**What to say:**
- "Costs scale with usage"
- "1000 requests/day = ~$280/month"
- "Need to monitor and optimize"
- "Set usage limits"

---

### 4. Show optimization (3 min)

**Say:** "Here's how to optimize costs."

**Show optimization strategies:**

**Strategy 1: Shorter prompts**
- Before: "Explain how Spring Boot dependency injection works in detail with examples"
- After: "Explain Spring Boot DI"
- Savings: ~50% fewer input tokens

**Strategy 2: Limit output length**
- Before: No limit → 500 tokens
- After: Max tokens: 200 → 200 tokens
- Savings: ~60% fewer output tokens

**Strategy 3: Use cheaper models**
- GPT-4: $0.03/$0.06 per 1K tokens
- GPT-3.5: $0.0015/$0.002 per 1K tokens
- Savings: ~95% cheaper

**What to say:**
- "Shorter prompts = lower costs"
- "Limit output length = lower costs"
- "Use cheaper models when appropriate"
- "Monitor usage and optimize"

---

### 5. Cost monitoring (2 min)

**Say:** "Finally, monitor your costs."

**Show monitoring:**

**Set usage limits:**
- Daily limit: $10/day
- Monthly limit: $300/month
- Alert when approaching limit

**Track usage:**
- Monitor token counts
- Track costs per request
- Identify expensive operations

**What to say:**
- "Set usage limits"
- "Monitor token counts"
- "Track costs per request"
- "Optimize expensive operations"

---

## Cost calculation formula

**Basic formula:**
```
Cost = (input_tokens / 1000 × input_price) + (output_tokens / 1000 × output_price)
```

**Example:**
- Input: 100 tokens, $0.03 per 1K
- Output: 200 tokens, $0.06 per 1K
- Cost = (100/1000 × $0.03) + (200/1000 × $0.06) = $0.003 + $0.012 = $0.015

---

## Teaching Tips

- **Emphasize**: Monitor usage and optimize costs
- **Watch for**: Delegates who ignore costs — show scaling impact
- **Adapt**: Use current pricing for your API provider

---

## Time Allocation

- Set up problem: 2 min
- Show token counting: 4 min
- Scale to typical usage: 4 min
- Show optimization: 3 min
- Cost monitoring: 2 min
- **Total: ~15 minutes**
