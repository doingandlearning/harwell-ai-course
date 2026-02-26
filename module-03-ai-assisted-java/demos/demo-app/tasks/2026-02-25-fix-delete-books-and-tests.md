/*
# LLM Task List: Get `mvn test` Passing and Fix Errors in Library Demo App

## Goal
Ensure all tests (`mvn test`) pass in the demo app. Fix any test or main-code errors, and set up a process for continuous test integrity.

---

## Step-by-Step Instructions

### 1. Ensure Test Environment Runs Locally

- Open a terminal in the project root (`for_repo/module-03-ai-assisted-java/demos/demo-app/`).
- Run the following:
  ```
  mvn clean test
  ```
- If any errors occur (test, compilation, or others), review the error logs and note the failing classes or methods.

### 2. Fix Compilation Errors

For any compilation errors (in `src/main/java` or `src/test/java`):

- Read the error message and path in the stack trace. 
- Open the relevant file.
- Fix missing classes, method signature mismatches, import errors, or annotation issues.

### 3. Fix Failing Unit Tests

For test failures (in `src/test/java`):

- Open the corresponding test file (e.g., `BookServiceTest.java`).
- Read the assertion error and the stack trace for clues.
- Compare test expectations with the logic in the main service code (e.g., `BookService.java`).
- Update either the test or the method-under-test as appropriate to ensure that the expected and actual results match the intended functionality.
- Common failure reasons:
  - Business logic errors in service methods
  - Mock data not set up correctly in tests
  - Changed interface/field but test not updated

### 4. Re-run Tests for Every Change

- After any fix, re-run:
  ```
  mvn test
  ```
- Repeat fixing and rerunning until **all tests pass** and there are **no errors**.

### 5. Keep Tests Up-to-Date (Continuous Process)

- With every code change (feature/fix), immediately run tests.
- If adding or changing behavior, add/update tests first (test-driven workflow preferred).
- Never leave broken or ignored tests in the codebase—every commit must keep the test suite passing.
- Document test setup/running instructions in a `README.md` if not already present.

---

## How to Run Tests

From the project root:

```
mvn clean test
```

All test results will appear in the console and in `target/surefire-reports/`.

---

## Prompt for LLM

"You are tasked with ensuring all `mvn test` unit tests in this Java Spring demo app pass and remain passing for every code change. When a test, compilation, or logic error is detected, repair the minimal necessary code and explain the fix in brief comments in this file with copies and links to the updated code. Always re-run all tests after a change. Never ignore or delete a failing test unless it is obsolete. Document any new or changed test logic. Update a `README.md` in the repo if standard test or run instructions change."

*/

---

## Fix log (2026-02-25)

### Compilation error fixed

- **Symptom:** `mvn clean test` failed with: `cannot find symbol: method deleteByAuthor(java.lang.String)` in `BookService.java` (line 31), location `BookRepository`.
- **Cause:** `BookService.deleteBooksByAuthor(String)` called `repository.deleteByAuthor(author)`, but `BookRepository` did not declare that method.
- **Change:**  
  - **BookRepository** ([BookRepository.java](../src/main/java/com/example/library/repository/BookRepository.java)): added `void deleteByAuthorContainingIgnoreCase(String author)` so delete semantics match the existing find method `findByAuthorContainingIgnoreCase`.  
  - **BookService** ([BookService.java](../src/main/java/com/example/library/service/BookService.java)): updated the call from `repository.deleteByAuthor(author)` to `repository.deleteByAuthorContainingIgnoreCase(author)`.
- **Verification:** `mvn test` — all 24 tests pass (BookServiceTest 23, UserServiceTest 1). No test changes were required.