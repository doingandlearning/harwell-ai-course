# Module 3 Demo Application

Spring Boot 3 app for **Harwell Prompt Engineering** Module 3 demos (AI-assisted Java). Use this project live in the IDE during the demos.

## What's in this app

| Item | Purpose |
|------|--------|
| **Book** | Entity for Demo 1 (generate) and Demo 4 (generate tests). |
| **User** | POJO for Demo 3 (refactoring). |
| **BookRepository** | JPA repository; `findByAuthorContainingIgnoreCase`. |
| **BookService** | `findBooksByAuthor` — generate unit tests in Demo 4. |
| **UserService** | `getActiveUserEmails` (verbose) — refactor in Demo 3, then re-run tests. |
| **UserServiceTest** | One test; must pass before and after refactoring. |
| **BookServiceTest** | Empty; generate tests in Demo 4 with AI. |

## Run

```bash
mvn spring-boot:run
```

Or open in your IDE and run `LibraryApplication`.

## Tests

```bash
mvn test
```

- **Before Demo 3:** `UserServiceTest` should pass (original `getActiveUserEmails`).
- **After Demo 3:** Replace `UserService.getActiveUserEmails` with AI-refactored version; run tests again — they should still pass.
- **Demo 4:** Paste AI-generated tests into `BookServiceTest`, then run tests.

## Demo prep

See **DEMO_PREPARATION.md** in this directory’s parent for full checklist and prompts. Prompts live in **prompts/** (01–04). Legacy snippet for Demo 2 is in **code-samples/LegacyUserBean.java** (paste into AI; not part of this app).

## Requirements

- Java 17+
- Maven 3.6+
