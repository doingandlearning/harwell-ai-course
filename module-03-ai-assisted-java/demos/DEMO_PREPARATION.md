# Module 3 Demo Preparation Guide

**CRITICAL:** Module 3 is the anchor module. These demos must work.

---

## Ready-to-use demo app

A **pre-built Spring Boot 3 demo application** is in **`demo-app/`** in this directory. You can use it as-is instead of creating a project from scratch.

- **Open** `demo-app/` in your IDE (or run `mvn spring-boot:run` from `demo-app/`).
- **Verify:** `mvn test` — `UserServiceTest` should pass (1 test). `BookServiceTest` is empty for Demo 4.
- **Demo 1:** Use the same prompts to generate entity/repository/service (or show on top of existing code).
- **Demo 3:** Refactor `UserService.getActiveUserEmails` with AI; re-run `UserServiceTest`.
- **Demo 4:** Generate tests for `BookService.findBooksByAuthor` into `BookServiceTest`.

See **`demo-app/README.md`** for what each class is for. If you prefer to build the project yourself, follow the checklist below.

---

## Pre-Demo Setup Checklist

### IDE Setup (Do This First)

**Option A:** Use the pre-built **`demo-app/`** (see above).

**Option B — Create Spring Boot 3 Project yourself:**

1. **Project Structure:**
   ```
   src/main/java/com/example/library/
   ├── LibraryApplication.java
   ├── model/
   │   ├── Book.java
   │   └── User.java
   ├── repository/
   │   └── BookRepository.java
   └── service/
       └── BookService.java
   
   src/test/java/com/example/library/
   ├── service/
   │   └── BookServiceTest.java
   └── util/
       └── UserServiceTest.java (for refactoring demo)
   ```

2. **Dependencies** (pom.xml or build.gradle):
   - Spring Boot Starter Web
   - Spring Boot Starter Data JPA
   - H2 Database (for testing)
   - JUnit 5
   - Mockito

3. **Classes to Create:**

   **Book.java** - Use `code-samples/Book.java` as template
   **User.java** - Use `code-samples/User.java` as template
   **BookRepository.java** - Interface extending JpaRepository<Book, Long>
   **BookService.java** - Service with findBooksByAuthor method (see Demo 4)
   **UserService.java** - Service with getActiveUserEmails method (see Demo 3)

4. **Test Classes:**
   - **BookServiceTest.java** - Empty initially, will generate in Demo 4
   - **UserServiceTest.java** - Has test for getActiveUserEmails (see Demo 3)

5. **VERIFY:**
   - [ ] Project compiles
   - [ ] All classes exist
   - [ ] Tests compile (even if empty)
   - [ ] Can run tests in IDE

---

## Demo-by-Demo Preparation

### Demo 1: Spring Boot Generation

**What You Need:**
- [ ] AI chat tool open (MS Copilot or approved tool)
- [ ] Prompts ready (from `prompts/01-spring-boot-generation-prompts.txt`)
- [ ] IDE open with Spring Boot project
- [ ] New package ready for generated code (or paste location)

**Test Beforehand:**
- [ ] Run Prompt 1 - Does it generate good entity?
- [ ] Run Prompt 2 - Does it generate repository + service?
- [ ] Run Prompt 3 - Does refinement work?
- [ ] Time yourself - Does it fit in 15 min?

**Backup:**
- [ ] Screenshots of all three prompts and outputs
- [ ] Generated code saved in files
- [ ] Can show slides if live fails

---

### Demo 2: Legacy Explanation

**What You Need:**
- [ ] AI chat tool open
- [ ] Legacy code snippet ready (from `code-samples/LegacyUserBean.java`)
- [ ] Prompts ready (from `prompts/02-legacy-explanation-prompts.txt`)

**Test Beforehand:**
- [ ] Run all 4 prompts with legacy code
- [ ] Verify explanations are helpful
- [ ] Time yourself - Does it fit in 15 min?

**Backup:**
- [ ] Screenshots of all 4 layers of explanation
- [ ] Pre-written explanations (if AI fails)
- [ ] Can show slides with explanations

---

### Demo 3: Refactoring (CRITICAL - Most Complex)

**What You Need:**
- [ ] IDE open with UserService class
- [ ] Original verbose method in UserService
- [ ] Test class with test that PASSES with original code
- [ ] AI chat tool open
- [ ] Prompt ready (from `prompts/03-refactoring-prompts.txt`)

**CRITICAL Setup Steps:**

1. **Create UserService.java:**
   ```java
   @Service
   public class UserService {
       public List<String> getActiveUserEmails(List<User> users) {
           List<String> emails = new ArrayList<>();
           for (User user : users) {
               if (user != null) {
                   if (user.isActive()) {
                       String email = user.getEmail();
                       if (email != null && !email.isEmpty()) {
                           emails.add(email);
                       }
                   }
               }
           }
           return emails;
       }
   }
   ```

2. **Create UserServiceTest.java:**
   ```java
   @ExtendWith(MockitoExtension.class)
   class UserServiceTest {
       private UserService service = new UserService();
       
       @Test
       void testGetActiveUserEmails() {
           User activeUser = new User("John", "john@example.com", true);
           User inactiveUser = new User("Jane", "jane@example.com", false);
           User nullEmailUser = new User("Bob", null, true);
           
           List<User> users = Arrays.asList(activeUser, inactiveUser, nullEmailUser, null);
           
           List<String> emails = service.getActiveUserEmails(users);
           
           assertEquals(1, emails.size());
           assertEquals("john@example.com", emails.get(0));
       }
   }
   ```

3. **VERIFY TEST PASSES** with original code

4. **Test Refactoring:**
   - Run prompt to generate refactored code
   - Replace method in IDE
   - Run test - does it still pass?
   - If not, refine prompt and try again

**Test Beforehand:**
- [ ] Original code compiles
- [ ] Test passes with original code
- [ ] Refactored code compiles
- [ ] Test passes with refactored code
- [ ] Time yourself - Does it fit in 15 min?

**Backup:**
- [ ] Screenshots of before/after code
- [ ] Screenshot of test passing before
- [ ] Screenshot of test passing after
- [ ] Can show slides if IDE fails

---

### Demo 4: Unit Testing (CRITICAL - High Tech Dependency)

**What You Need:**
- [ ] IDE open with BookService class
- [ ] BookService has findBooksByAuthor method
- [ ] BookRepository interface exists
- [ ] JUnit 5 and Mockito configured
- [ ] AI chat tool open
- [ ] Prompts ready (from `prompts/04-unit-testing-prompts.txt`)

**CRITICAL Setup Steps:**

1. **Verify BookService exists:**
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

2. **Verify BookRepository exists:**
   ```java
   public interface BookRepository extends JpaRepository<Book, Long> {
       List<Book> findByAuthorContainingIgnoreCase(String author);
   }
   ```

3. **Create empty test class:**
   ```java
   @ExtendWith(MockitoExtension.class)
   class BookServiceTest {
       // Will generate tests here
   }
   ```

**Test Beforehand:**
- [ ] Run Prompt 1 - Do generated tests compile?
- [ ] Do generated tests pass?
- [ ] If not, test Prompt 2 (refinement)
- [ ] Time yourself - Does it fit in 15 min?

**Backup:**
- [ ] Screenshots of generated tests
- [ ] Pre-written tests that work
- [ ] Can show slides if IDE fails

---

## Demo Execution Tips

### If Demo Goes Wrong:

**Demo 1 (Generation):**
- If output is poor → "This is why we review! Let me refine..."
- Show refinement process
- Emphasize iterative improvement

**Demo 2 (Explanation):**
- If explanation is wrong → "This is why we verify! Let me check..."
- Show how to verify explanation
- Emphasize explanation is starting point

**Demo 3 (Refactoring):**
- If test fails → "Perfect! This is why we test! Let me fix..."
- Show refinement process
- Emphasize safety-first approach

**Demo 4 (Testing):**
- If tests don't compile → "This happens! Let me refine..."
- Show refinement process
- Emphasize iterative test generation

### If Tech Fails:

- Stay calm
- Use backup screenshots
- Explain conceptually
- "Let me show you what should happen..."
- Move to next demo

---

## Time Management

**Total Demo Time:** ~60 minutes (4 demos × 15 min)

**If Running Behind:**
- Demo 1: Can trim to 10 min (skip refinement)
- Demo 2: Can trim to 10 min (skip risk analysis)
- Demo 3: Keep full - most important
- Demo 4: Can trim to 10 min (skip edge cases)

**If Running Ahead:**
- Add more examples
- Show more refinement rounds
- Let delegates try prompts themselves

---

## Success Criteria

**Demo 1 Success:**
- ✅ Shows generation is fast
- ✅ Shows refinement process
- ✅ Shows review checklist

**Demo 2 Success:**
- ✅ Shows layered explanation approach
- ✅ Shows how to understand legacy code
- ✅ Shows migration path

**Demo 3 Success:**
- ✅ Shows test-first refactoring
- ✅ Shows safety approach
- ✅ Shows before/after comparison

**Demo 4 Success:**
- ✅ Shows test generation
- ✅ Shows iterative refinement
- ✅ Shows running tests is essential

---

## Final Check Before Delivery

- [ ] All code compiles
- [ ] All tests pass
- [ ] All prompts tested
- [ ] All demos timed
- [ ] Backup materials ready
- [ ] IDE ready to show
- [ ] AI tool access confirmed

**You're ready!** 🚀
