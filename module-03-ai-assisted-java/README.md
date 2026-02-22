# Module 3: AI-Assisted Java Development (Core Focus)

## Learning objectives

- Use AI to generate boilerplate, entities (Hibernate/JPA), and service layers in Spring Boot and vanilla Java.
- Use AI to explain legacy code (e.g. older JSF/GWT components) and unfamiliar codebases.
- Apply refactoring strategies with AI: modernising code and improving readability.
- Generate unit tests (JUnit/Mockito) for Spring Boot applications with AI assistance.
- Evaluate AI output for correctness, style, and fit before applying it.

## Suggested talking points

- Code generation: when to ask for full snippets vs. incremental changes; entities, DTOs, services.
- Code explanation: prompting for “what does this do?” and “why was it written this way?” for legacy.
- Refactoring: clear instructions (e.g. “extract method,” “replace with Stream API,” “add null-safety”).
- Unit testing: structuring prompts for JUnit/Mockito; covering edge cases and mocks.
- Review before paste: spot wrong APIs, outdated patterns, and security issues.

## Suggested demos

- **Spring Boot:** Generate a JPA entity + repository + simple service from a short spec; show one refinement round.
- **Legacy:** Paste a short JSF or GWT-style snippet; get an explanation and a “modern equivalent” summary.
- **Refactor:** Take a procedural or verbose method; ask for a refactor (e.g. streams, optional); apply and compare.
- **Tests:** Generate JUnit/Mockito tests for a service method; run them and fix one failure by refining the prompt.

## Suggested exercises

- **Generate:** From a 2–3 sentence spec, generate a small CRUD service (entity + repo + service method); run it.
- **Explain:** Bring (or use provided) legacy snippet; get an explanation and list of risks/dependencies.
- **Test:** Pick one existing method; generate tests; run and extend with one edge case.
- **Refactor:** Choose one method from your codebase (or provided); refactor with AI; review diff and discuss what you’d change.

## Suggested running time

90–120 minutes (anchor module; allow time for hands-on)
