# Module 2 — Exercises

**For delegates.** Complete these during or after the Module 2 session. You can do them on your own or in pairs.

---

## Objective

By completing these exercises, you will:

- Practice writing clear, contextual, and constrained prompts
- Apply zero-shot, few-shot, and chain-of-thought techniques
- Iteratively refine prompts based on output
- Build confidence in prompting as a skill

---

## Scenario

You're working on a Spring Boot application and need to use AI to help with various coding tasks. These exercises will help you practice the prompting techniques from Module 2.

**Remember:** Use only synthetic examples or generic Spring Boot patterns. Don't paste proprietary code or internal APIs.

---

## Exercise 1: Craft an effective prompt

**Your task:**

Write a prompt to ask AI to explain what this regex does:

```java
Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
```

**Requirements:**

- Use clarity: What do you want? (explain)
- Use context: What does the model need to know? (it's a regex pattern)
- Use constraints: Any rules? (explain in simple terms, give an example)

**Hints:**

- Start with the task: "Explain..."
- Add context: "This is a Java regex pattern..."
- Add constraints: "Explain in simple terms and give one example of a matching string"

**Then:** Run your prompt in a chat interface (MS Copilot or approved tool). Did you get a clear explanation?

**Time:** About 5 minutes.

<details>
<summary>Example Solution for Exercise 1</summary>

**Example prompt:**

> "Explain what this Java regex pattern does: `Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")`. Explain in simple terms and give one example of a string that would match this pattern."

**Why this works:**

- **Clarity**: Task is clear — "Explain"
- **Context**: Specifies it's a Java regex pattern
- **Constraints**: "Simple terms" and "give one example"

**Expected output:** Explanation that this is an email validation regex, with an example email address.

</details>

---

## Exercise 2: Refine a prompt

**Your task:**

Take this prompt that produced poor output:

> "Refactor this code"

**Your job:**

1. Identify what's missing (clarity, context, constraints)
2. Rewrite the prompt using the 3Cs
3. Re-run it (if possible) and compare

**Hints:**

- What task? (refactor)
- What code? (you need to provide it or describe it)
- What style? (Spring Boot 3, Java 17, constructor injection?)
- What patterns? (Streams? Optional? ResponseEntity?)

**Example code to use** (synthetic):

```java
public List<String> getNames(List<User> users) {
    List<String> names = new ArrayList<>();
    for (User user : users) {
        if (user != null && user.getName() != null) {
            names.add(user.getName());
        }
    }
    return names;
}
```

**Then:** Share your refined prompt with a partner. Compare approaches.

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 2</summary>

**Refined prompt:**

> "Refactor this Java method to use modern Java 17 style with Streams API. The method currently uses a for loop and null checks. Use Streams to filter null users and null names, then map to names. Keep the return type as List<String>. Here's the code:
> ```java
> public List<String> getNames(List<User> users) {
>     List<String> names = new ArrayList<>();
>     for (User user : users) {
>         if (user != null && user.getName() != null) {
>             names.add(user.getName());
>         }
>     }
>     return names;
> }
> ```"

**Why this works:**

- **Clarity**: Task is clear — "Refactor... to use modern Java 17 style with Streams"
- **Context**: Provides the code, specifies Java 17
- **Constraints**: Use Streams, filter nulls, keep return type

**Expected output:** Refactored method using streams, filter, and map.

</details>

---

## Exercise 3: Try few-shot prompting

**Your task:**

You want to generate a service class that matches your team's style. Use few-shot prompting.

**Requirements:**

1. Provide one example of your team's service style
2. Ask the model to generate another one following the same pattern

**Example service to use as template:**

```java
@Service
public class ProductService {
    private final ProductRepository repository;
    
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }
    
    public List<Product> findAll() {
        return repository.findAll();
    }
    
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}
```

**Your prompt should:**

- Include the example
- Ask for a similar service for a different entity (e.g. User)

**Hints:**

- Show the example code clearly
- Ask for "another one" or "similar one"
- Specify the new entity name

**Then:** Run your prompt. Does the output match the style of your example?

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 3</summary>

**Few-shot prompt:**

> "Generate a service class like this:
> ```java
> @Service
> public class ProductService {
>     private final ProductRepository repository;
>     
>     public ProductService(ProductRepository repository) {
>         this.repository = repository;
>     }
>     
>     public List<Product> findAll() {
>         return repository.findAll();
>     }
>     
>     public Optional<Product> findById(Long id) {
>         return repository.findById(id);
>     }
> }
> ```
> Now generate a similar one for User."

**Why this works:**

- Provides one example showing the style
- Asks for "similar one" — model learns the pattern
- Specifies the new entity (User)

**Expected output:** UserService with same structure, constructor injection, same method patterns.

</details>

---

## Exercise 4: Swap and improve

**Your task:**

1. Write a prompt for one of these tasks:
   - Explain what a Spring Boot annotation does (@RestController, @Service, @Autowired)
   - Generate a simple JPA repository interface
   - Suggest a refactor for a method

2. Exchange prompts with another attendee

3. Run their prompt and suggest one improvement

4. Share feedback

**Hints:**

- Look for missing clarity, context, or constraints
- Suggest one specific improvement
- Be constructive

**Then:** Discuss what you learned from the feedback.

**Time:** About 10 minutes.

---

## Final Deliverables

Before moving to Module 3, ensure you have:

- [ ] Written at least one clear, contextual, constrained prompt (Exercise 1)
- [ ] Refined a prompt iteratively (Exercise 2)
- [ ] Tried few-shot prompting (Exercise 3)
- [ ] Received feedback on your prompting (Exercise 4)

---

## Extensions (Optional)

If you finish early or want to go deeper:

1. **Try chain-of-thought**: Write a prompt that asks for step-by-step reasoning for a complex refactoring task.

2. **Compare techniques**: Try the same task with zero-shot, few-shot, and chain-of-thought. Which works best?

3. **Create a prompt template**: Draft a reusable template with placeholders for clarity, context, and constraints.

4. **Document your learnings**: Write down 2–3 prompting principles you'll use going forward.

---

## Key Learning Points

- **Clarity first**: Start with a clear task
- **Add context**: Tell the model what it needs to know
- **Add constraints**: Specify style, patterns, don'ts
- **Iterate**: Refine based on output
- **Techniques**: Zero-shot for simple, few-shot for style, chain-of-thought for complex

---

## After the exercises

- Keep your refined prompts as templates for future use
- In Module 3 we'll apply these prompting techniques to real Java development tasks
- Practice makes perfect — keep iterating and refining
