# Demo 4: Unit test generation — tests that work

## Goal

Show delegates how to generate JUnit 5/Mockito tests for a service method, run them, and refine iteratively when tests fail.

**Teaching style**: Problem-first approach, progressive building

---

## Before the demo

- Ensure you have access to an AI chat tool.
- Have an IDE ready with Spring Boot project, JUnit 5, and Mockito.
- Prepare a sample service method to test (synthetic example provided).
- Use only **synthetic** examples.

---

## Steps

**Problem-first approach**: Start with manual test writing pain

### 1. Set up the problem (2 min)

**Say:** "You need to write tests for this service method. How long does it take you to write a comprehensive test manually?"

**Show the service method** (example provided below).

**Show the pain:**
- ❌ Write test class: 2 minutes
- ❌ Set up mocks: 3 minutes
- ❌ Write happy path test: 3 minutes
- ❌ Write edge case tests: 5 minutes
- ❌ **Total: 13+ minutes** per method

**Talking point:** "Let's see how AI can generate comprehensive tests in seconds, then we'll refine them."

---

### 2. Generate basic tests (3 min)

**Show the prompt:**

> "Generate JUnit 5 and Mockito tests for this service method. Cover the happy path, null input, and empty list scenarios. Use Java 17."

**Include the service method:**

```java
@Service
public class BookService {
    private final BookRepository repository;
    
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    
    public List<Book> findBooksByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findByAuthorContainingIgnoreCase(author);
    }
}
```

**Run the prompt** and show the generated tests.

**Point out:**
- ✅ Test class structure
- ✅ Mock setup
- ✅ Multiple test cases (happy path, null, empty)

---

### 3. Run the tests (3 min)

**Show the generated tests** in the IDE.

**Say:** "Let's run these tests and see if they work."

**Run the tests.**

**If they pass:**
- ✅ "Great! But let's add more edge cases."

**If they fail:**
- Show the failure: "One test failed. Let's see why."
- Diagnose: "The mock isn't set up correctly for the empty string case."
- **This is the key learning moment** — show iterative refinement.

---

### 4. Refine the tests (3 min)

**If tests failed, show refinement:**

**Refine prompt:**

> "Fix the test for empty string input. The service should return an empty list when author is null or empty. Update the mock setup accordingly."

**Run the refined prompt** and show improved tests.

**Re-run tests** — they should pass now.

**Say:** "Test generation is iterative — generate, run, refine, repeat."

---

### 5. Add more edge cases (2 min)

**Refine prompt:**

> "Add tests for edge cases: author with only whitespace, author not found (empty result), and repository throws exception."

**Run and show additional tests.**

**Point out:**
- ✅ More comprehensive coverage
- ✅ Exception handling tested
- ✅ Edge cases covered

**Say:** "Progressive building — start with basics, add complexity."

---

### 6. Test quality checklist (2 min)

**Show the test quality checklist:**

- ✅ **Coverage:** Happy path, edge cases, exceptions?
- ✅ **Mocks:** Properly set up?
- ✅ **Assertions:** Clear and specific?
- ✅ **Run:** Do tests actually pass?

**Say:** "Generate tests, but always run and verify. Don't trust tests without running them."

---

## Sample service method to test

**BookService method** (synthetic):

```java
@Service
public class BookService {
    private final BookRepository repository;
    
    public BookService(BookRepository repository) {
        this.repository = repository;
    }
    
    public List<Book> findBooksByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findByAuthorContainingIgnoreCase(author);
    }
}
```

**Expected generated tests** (what AI should generate):

```java
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    private BookRepository repository;
    
    @InjectMocks
    private BookService service;
    
    @Test
    void testFindBooksByAuthor_HappyPath() {
        String author = "Tolkien";
        List<Book> expectedBooks = Arrays.asList(
            new Book(1L, "The Hobbit", "Tolkien", "123", 1937),
            new Book(2L, "The Lord of the Rings", "Tolkien", "456", 1954)
        );
        
        when(repository.findByAuthorContainingIgnoreCase(author))
            .thenReturn(expectedBooks);
        
        List<Book> result = service.findBooksByAuthor(author);
        
        assertEquals(2, result.size());
        assertEquals("Tolkien", result.get(0).getAuthor());
        verify(repository).findByAuthorContainingIgnoreCase(author);
    }
    
    @Test
    void testFindBooksByAuthor_NullInput() {
        List<Book> result = service.findBooksByAuthor(null);
        
        assertTrue(result.isEmpty());
        verify(repository, never()).findByAuthorContainingIgnoreCase(anyString());
    }
    
    @Test
    void testFindBooksByAuthor_EmptyString() {
        List<Book> result = service.findBooksByAuthor("");
        
        assertTrue(result.isEmpty());
        verify(repository, never()).findByAuthorContainingIgnoreCase(anyString());
    }
}
```

---

## If you can't run live

- Show pre-prepared screenshots of generated tests.
- Use slides with test examples.
- Emphasize the process: generate → run → refine → verify.

---

## Teaching Tips

- **Emphasize**: Generate tests, but always run them — AI can generate tests that don't compile or don't test the right thing
- **Watch for**: Delegates who trust tests without running — show a failure example
- **Adapt**: If test generation fails, show iterative refinement process

---

## Time Allocation

- Set up problem: 2 min
- Generate basic tests: 3 min
- Run the tests: 3 min
- Refine the tests: 3 min
- Add edge cases: 2 min
- Test quality checklist: 2 min
- **Total: ~15 minutes**
