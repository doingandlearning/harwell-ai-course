# Module 3 — Exercises

**For delegates.** Complete these during or after the Module 3 session. You can do them on your own or in pairs.

---

## Objective

By completing these exercises, you will:

- Generate Spring Boot 3 code (entities, repositories, services) with AI
- Use AI to explain legacy code and plan modernization
- Refactor code safely with AI assistance (with tests)
- Generate and refine unit tests with AI
- Evaluate AI output before applying it to your codebase

---

## Scenario

You're working on a **Library Management System** — a Spring Boot 3 application for managing books, authors, and loans. These exercises will help you practice using AI for code generation, explanation, refactoring, and testing.

**Remember:** Use only synthetic examples or generic Spring Boot patterns. Don't paste proprietary code or internal APIs.

---

## Exercise 1: Generate a complete entity layer

**Your task:**

Generate a complete entity layer for a **Loan** entity using AI:

1. **Entity:** Loan with fields:
   - id: Long (primary key, auto-generated)
   - bookId: Long (foreign key to Book)
   - userId: Long (foreign key to User)
   - loanDate: LocalDate
   - returnDate: LocalDate (nullable)
   - status: String (enum-like: "ACTIVE", "RETURNED", "OVERDUE")

2. **Repository:** JPA repository interface for Loan

3. **Service:** Service class with method `findActiveLoans()` that returns all loans with status "ACTIVE"

**Requirements:**

- Use Spring Boot 3 and Java 17
- Use constructor injection (not @Autowired)
- Include proper JPA annotations
- Follow Spring Boot best practices

**Hints:**

- Start with the entity, then add repository, then service
- Be specific about Spring Boot version and Java version
- Specify constructor injection in your prompt
- Review the output before considering it done

**Then:** Review the generated code using the evaluation checklist:
- ✅ Does it compile?
- ✅ Right Spring Boot/Java version?
- ✅ Matches your style (constructor injection)?
- ✅ Any security issues?

**Time:** About 15 minutes.

<details>
<summary>Example Solution for Exercise 1</summary>

**Example prompt:**

> "Generate a Spring Boot 3 JPA entity for a Loan with the following fields:
> - id: Long, primary key, auto-generated
> - bookId: Long, foreign key reference
> - userId: Long, foreign key reference  
> - loanDate: LocalDate, required
> - returnDate: LocalDate, nullable
> - status: String, required (values: ACTIVE, RETURNED, OVERDUE)
> Use Java 17 and include proper JPA annotations. Then generate a JPA repository interface for this entity, and a service class with a method findActiveLoans() that returns all loans with status 'ACTIVE'. Use constructor injection, not @Autowired."

**Expected output:** Complete entity, repository, and service with proper annotations and constructor injection.

**Review checklist:**
- ✅ Compiles
- ✅ Spring Boot 3, Java 17
- ✅ Constructor injection used
- ✅ Proper JPA annotations

</details>

---

## Exercise 2: Explain legacy code

**Your task:**

Use AI to explain this legacy code snippet:

```java
public class OrderProcessor {
    private List<Order> orders = new ArrayList<>();
    private Map<String, Double> totals = new HashMap<>();
    
    public void processOrders() {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order != null && order.getStatus() != null) {
                if (order.getStatus().equals("PENDING")) {
                    String customerId = order.getCustomerId();
                    if (customerId != null) {
                        Double currentTotal = totals.get(customerId);
                        if (currentTotal == null) {
                            currentTotal = 0.0;
                        }
                        totals.put(customerId, currentTotal + order.getAmount());
                    }
                }
            }
        }
    }
    
    public Double getTotalForCustomer(String customerId) {
        return totals.get(customerId);
    }
}
```

**Your prompts should cover:**

1. **What does this do?** — Functional explanation
2. **Why might it be written this way?** — Historical context
3. **What's the modern equivalent?** — Spring Boot 3 / Java 17 version
4. **What are the risks if I refactor it?** — Dependencies and breaking changes

**Hints:**

- Ask one question at a time (layered approach)
- Build from "what" to "how to modernize"
- Use the explanation to plan refactoring (Exercise 3)

**Then:** Write a brief summary (2-3 sentences) of what you learned about this code.

**Time:** About 10 minutes.

<details>
<summary>Example Solution for Exercise 2</summary>

**Example prompts:**

**Layer 1:**
> "Explain what this Java code does step by step. Break down each part and explain the functionality."

**Layer 2:**
> "Why might this code have been written this way? What patterns does it use? What was common at the time?"

**Layer 3:**
> "What would be the modern Spring Boot 3 / Java 17 equivalent of this code? Show a simple example."

**Layer 4:**
> "What are the risks or dependencies if I try to refactor this code? What might break?"

**Expected insights:**
- Functional: Processes pending orders and calculates totals per customer
- Historical: Uses old Java patterns (indexed loops, manual null checks)
- Modern: Could use Streams API, Optional, better structure
- Risks: Depends on order status values, customer ID format, etc.

</details>

---

## Exercise 3: Refactor safely (with tests)

**Your task:**

Refactor the legacy code from Exercise 2 using AI, but **safely**:

1. **First:** Write a simple test for the existing code (or use AI to generate one)
2. **Run the test** — it should pass
3. **Refactor** the code using AI to modern Java 17 style (Streams, Optional, better structure)
4. **Run the test again** — it should still pass
5. **Review the diff** — what changed? Is behavior the same?

**Requirements:**

- Use Java 17 Streams API
- Improve readability
- Maintain exact same behavior
- Use proper null-safety

**Hints:**

- Start with: "Generate a JUnit 5 test for this method..."
- Then: "Refactor this method to use Java 17 Streams..."
- Always run tests before and after
- Review the diff carefully

**Then:** Write a brief reflection: What changed? Was the refactoring safe? What would you do differently?

**Time:** About 20 minutes.

<details>
<summary>Example Solution for Exercise 3</summary>

**Step 1: Generate test**

> "Generate a JUnit 5 test for this method. Cover happy path, null orders, and empty list scenarios."

**Step 2: Refactor**

> "Refactor this method to use Java 17 Streams API. Replace loops with streams, use Optional for null-safety, and improve readability. Maintain the exact same behavior."

**Refactored version:**

```java
public void processOrders() {
    orders.stream()
        .filter(Objects::nonNull)
        .filter(order -> "PENDING".equals(order.getStatus()))
        .filter(order -> order.getCustomerId() != null)
        .forEach(order -> {
            String customerId = order.getCustomerId();
            totals.merge(customerId, order.getAmount(), Double::sum);
        });
}
```

**Key changes:**
- Streams instead of indexed loop
- Functional style
- merge() instead of manual null check
- More readable

**Safety check:**
- ✅ Tests pass before
- ✅ Tests pass after
- ✅ Behavior unchanged
- ✅ More maintainable

</details>

---

## Exercise 4: Generate and refine unit tests

**Your task:**

Generate comprehensive unit tests for this service method:

```java
@Service
public class BookService {
    private final BookRepository repository;
    
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    
    public Optional<Book> findBookByIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            return Optional.empty();
        }
        return repository.findByIsbn(isbn);
    }
}
```

**Requirements:**

1. **Generate tests** using AI (JUnit 5, Mockito)
2. **Cover:** Happy path, null input, empty string, book not found
3. **Run the tests** — do they pass?
4. **If tests fail:** Refine the prompt and fix them
5. **Add one edge case** (e.g., whitespace-only ISBN, repository throws exception)

**Hints:**

- Specify JUnit 5 and Mockito in your prompt
- Ask for specific scenarios (null, empty, not found)
- Run tests immediately — don't assume they work
- Iterate if they fail

**Then:** Write a brief summary: How many tests did you generate? Did they all pass? What did you refine?

**Time:** About 15 minutes.

<details>
<summary>Example Solution for Exercise 4</summary>

**Initial prompt:**

> "Generate JUnit 5 and Mockito tests for this service method. Cover happy path, null input, empty string, and book not found scenarios. Use Java 17."

**Generated tests (example):**

```java
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository repository;
    
    @InjectMocks
    private BookService service;
    
    @Test
    void testFindBookByIsbn_HappyPath() {
        String isbn = "1234567890";
        Book book = new Book(1L, "Test Book", "Author", isbn, 2023);
        
        when(repository.findByIsbn(isbn)).thenReturn(Optional.of(book));
        
        Optional<Book> result = service.findBookByIsbn(isbn);
        
        assertTrue(result.isPresent());
        assertEquals("Test Book", result.get().getTitle());
        verify(repository).findByIsbn(isbn);
    }
    
    @Test
    void testFindBookByIsbn_NullInput() {
        Optional<Book> result = service.findBookByIsbn(null);
        
        assertTrue(result.isEmpty());
        verify(repository, never()).findByIsbn(anyString());
    }
    
    @Test
    void testFindBookByIsbn_EmptyString() {
        Optional<Book> result = service.findBookByIsbn("");
        
        assertTrue(result.isEmpty());
        verify(repository, never()).findByIsbn(anyString());
    }
    
    @Test
    void testFindBookByIsbn_NotFound() {
        String isbn = "9999999999";
        
        when(repository.findByIsbn(isbn)).thenReturn(Optional.empty());
        
        Optional<Book> result = service.findBookByIsbn(isbn);
        
        assertTrue(result.isEmpty());
    }
}
```

**Refinement (if needed):**

> "Add a test for whitespace-only ISBN input and a test for when repository throws an exception."

**Key learning:**
- Generate → Run → Refine → Verify
- Don't trust tests without running them
- Iterative process

</details>

---

## Final Deliverables

Before moving to Module 4, ensure you have:

- [ ] Generated a complete entity layer (entity, repository, service) with AI (Exercise 1)
- [ ] Explained legacy code using layered prompts (Exercise 2)
- [ ] Refactored code safely with tests (Exercise 3)
- [ ] Generated and refined unit tests (Exercise 4)
- [ ] Reviewed all AI output using the evaluation checklist

---

## Extensions (Optional)

If you finish early or want to go deeper:

1. **Generate a REST controller:** Use AI to generate a REST controller for your Loan entity with CRUD endpoints. Review it carefully.

2. **Explain a real method:** Find a method in your codebase (or use a provided example) that you don't fully understand. Use AI to explain it, then verify the explanation by reading the code yourself.

3. **Refactor with multiple strategies:** Take one method and refactor it using multiple AI prompts: (1) extract methods, (2) use Streams, (3) improve naming. Compare the results.

4. **Generate integration tests:** Use AI to generate integration tests (not just unit tests) for your service. What's different about integration test prompts?

5. **Create a prompt library:** Document your best prompts for generation, explanation, refactoring, and testing. Share with your team.

---

## Key Learning Points

- **Generation:** Fast and consistent for boilerplate — but always review
- **Explanation:** Layered approach (what → why → modern → risks) builds understanding
- **Refactoring:** Safe when you have tests — test before, refactor, test after
- **Testing:** Generate tests, but always run and refine — iterative process
- **Review:** Always evaluate before applying — correctness, version, style, security

---

## After the exercises

- Keep your **best prompts** as templates for future use
- In Module 4 we'll cover **tooling strategies** — IDE integrations and workflow optimization
- Practice makes perfect — keep generating, explaining, refactoring, and testing with AI
- Remember: AI assists, but you're responsible for the code — always review and test
