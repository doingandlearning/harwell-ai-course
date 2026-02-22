# Copy-paste prompts — Harwell Prompt Engineering

Key prompts from the course demos. Paste into your AI tool and adjust as needed.

---

## Module 1 — GenAI (public vs. enterprise, hallucination)

Use your own variants for “public” vs “enterprise” or “hallucination check” (e.g. ask something false or out-of-date and correct the model).

---

## Module 2 — Three prompts (weak → better → strong)

**Weak:** “Write a method to find books by author.”

**Better:** “You are a senior Java developer. Write a Spring Boot service method that finds all books by author. Use constructor injection. Return a list.”

**Strong:** Add context (stack, style) and constraints (e.g. “Do not use Optional in the return type; use ResponseEntity with proper status codes.”).

---

## Module 3 — Spring Boot generation

**Prompt 1 — Entity**  
Generate a Spring Boot 3 JPA entity for a Book with: id (Long, PK, auto-generated), title (String, required), author (String, required), isbn (String, unique, required), publishedYear (Integer). Use Java 17 and proper JPA annotations.

**Prompt 2 — Repository and service**  
Generate a JPA repository interface for this Book entity and a service class with a method to find all books. Use constructor injection, not @Autowired. Return ResponseEntity<List<Book>>.

**Prompt 3 — Refine**  
Update the service method to not use Optional for return types. Use ResponseEntity with proper HTTP status codes. Include error handling for empty results.

---

## Module 3 — Legacy explanation (layered)

1. **What does this do?** — “Explain what this code does step by step. Break down each part.” [Paste legacy code.]
2. **Why written this way?** — “Why might this have been written this way? What patterns or frameworks? What was common at the time?”
3. **Modern equivalent** — “What would be the modern Spring Boot 3 equivalent? Show a simple example.”
4. **Risks** — “What are the risks or dependencies if I refactor this? What might break?”

---

## Module 3 — Refactoring

**Refactor to Streams**  
Refactor this method to use Java 17 Streams API. Replace nested loops with streams, extract null checks into filters, improve readability. Maintain exact same behavior.

```java
public List<String> getActiveUserEmails(List<User> users) {
    List<String> emails = new ArrayList<>();
    for (User user : users) {
        if (user != null && user.isActive()) {
            String email = user.getEmail();
            if (email != null && !email.isEmpty()) emails.add(email);
        }
    }
    return emails;
}
```

**If test breaks:** “Fix the refactoring — the test expects emails for active users only, filtering null users and empty emails. Maintain exact behavior.”

---

## Module 3 — Unit testing

**Generate tests**  
Generate JUnit 5 and Mockito tests for this service method. Cover happy path, null input, empty list. Use Java 17.

```java
public List<Book> findBooksByAuthor(String author) {
    if (author == null || author.trim().isEmpty()) return Collections.emptyList();
    return repository.findByAuthorContainingIgnoreCase(author);
}
```

**Fix / edge cases:** “Fix the test for empty string. Add edge cases: whitespace-only author, author not found, repository throws.”

---

## Module 4 — Context header (sidecar)

Paste this above your code when using browser-based AI:

```
Context:
- Framework: Spring Boot 3
- Java version: 17
- Style: Constructor injection (no @Autowired)
- Testing: JUnit 5, Mockito
- Database: JPA/Hibernate

Code:
[Paste your code here]

Question: [Your question]
```

---

*From the Harwell Prompt Engineering course. See module folders for full demo scripts and code samples.*
