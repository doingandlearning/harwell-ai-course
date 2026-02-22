# Module 6 — Demos

This folder contains facilitator notes and materials for the Module 6 demos.

## Demo 1: Without MCP vs. with MCP diagram

**Purpose:** Show the difference between manual copy-paste and MCP-enabled access.

**Materials:** 
- Slide or whiteboard showing two scenarios
- Diagram: "Without MCP" (manual paste) vs. "With MCP" (protocol-based)

**Setup:** 
- Prepare diagram showing:
  - **Without MCP**: User → Copy code → Paste in AI → Get answer
  - **With MCP**: User → Ask AI → AI requests via MCP → Context server responds → AI answers

**Steps:**
1. Show "Without MCP" scenario: Manual copy-paste, lose context
2. Show "With MCP" scenario: Structured protocol, maintain context
3. Compare: Manual vs. protocol-based
4. Emphasize: Structured, safer, less manual work

**Key points:**
- Without MCP: Manual, error-prone, loses context
- With MCP: Structured, controlled, maintains context
- MCP enables AI to "see" your project structure

---

## Demo 2: Spring Boot MCP server POC

**Purpose:** Show a working MCP server built in Spring Boot so delegates see MCP as something they can build in their own stack.

**Materials:**
- POC project in `mcp-server-poc/` (build and run before the session)
- IDE with the POC open
- Optional: Claude Desktop (or another MCP client) configured to connect to the POC

**Setup:**
- See **02-spring-boot-mcp-server-poc.md** for full script and **mcp-server-poc/README.md** for build/run and client config.
- Use **synthetic/demo data only** — no real internal systems.

**Steps:**
1. Bridge from “what is MCP” to “we can build the server ourselves.”
2. Show POC project structure (pom.xml, application.yml, main class, `DemoMcpTools`).
3. Walk through one or two `@McpTool` methods (name, description, parameters).
4. Run the server; optionally show a client (e.g. Claude Desktop) calling the tools.
5. Recap: why build your own MCP server, and point delegates at the POC.

**Key points:**
- One extra dependency: `spring-ai-starter-mcp-server-webmvc`.
- Tools = annotated methods; Spring AI discovers and registers them.
- POC is minimal on purpose; production would add auth, error handling, etc.

**Note:** If the annotation package doesn’t resolve, see **mcp-server-poc/README.md** (Troubleshooting).

---

## Demo 3: Optional live client demo (if available)

**Purpose:** Show MCP in action with Claude Desktop or similar connecting to an MCP server (e.g. the POC above, or a filesystem server).

**Materials:**
- Claude Desktop (or similar) with MCP server configured
- MCP server running (e.g. the Spring Boot POC, or a filesystem server)

**Setup:**
- Only if you have access to an MCP-enabled client
- Configure client to point at your server URL
- Prepare to show: AI calling tools, answers using server context

**Steps:**
1. Show AI asking something that triggers a tool call (e.g. “What is this MCP server for?”).
2. Show MCP request/response if visible.
3. Show AI answering using the tool result.
4. Compare to manual copy-paste.

**Key points:**
- MCP enables structured access.
- AI can call your tools without manual paste.
- Less manual copy-paste needed.

**Note:** Only run if you have client access. Otherwise, Demo 1 + Demo 2 (POC) are sufficient.

---

## Presenter notes

- **Keep scope to orientation** — this is not an adoption session
- Emphasize that **MCP is still early** — understanding, not rollout
- Use **conceptual examples** — not real internal systems
- Focus on **understanding** — what MCP is and when it might help
- **Avoid implying production readiness** — MCP is still evolving
- If delegates want implementation details, note it for follow-up
