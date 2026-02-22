# Demo 2: Spring Boot MCP server POC

## Goal

Show delegates a working proof-of-concept MCP server built with Spring Boot and Spring AI, so they see MCP as something they can build in their own stack.

**Teaching style**: Problem-first approach, progressive building

**Note:** This demo uses the companion POC project in `mcp-server-poc/`. Set it up and test it before the session.

---

## Before the demo

- [ ] Build and run the MCP server POC (`mcp-server-poc/`) — see [mcp-server-poc/README.md](mcp-server-poc/README.md)
- [ ] Option A: Configure Claude Desktop (or another MCP client) to connect to the POC server
- [ ] Option B: Use a simple HTTP/SSE client or curl to show the server is up and list tools
- [ ] Have the POC code open in your IDE so you can walk through it
- [ ] Use **synthetic/demo data only** — no real internal systems

---

## Steps

**Problem-first approach**: Recap “without MCP” pain, then show “we can build the server ourselves”

### 1. Bridge from “what is MCP” (2 min)

**Say:** “We’ve seen the difference between manual copy-paste and MCP. But MCP servers don’t have to be third-party only — you can build one in your own stack.”

**Show the idea:**
- MCP = protocol; servers expose **tools** (and optionally resources/prompts)
- AI clients (Claude Desktop, IDEs, your own app) call those tools over the protocol
- A Spring Boot app can be an MCP server using Spring AI

**Talking point:** “Next we’ll look at a minimal MCP server POC in Spring Boot.”

---

### 2. Show the POC project structure (3 min)

**Say:** “This is a minimal Spring Boot app that acts as an MCP server.”

**Show in IDE:**

- **pom.xml** — Spring Boot + `spring-ai-starter-mcp-server-webmvc`
- **application.yml** — `spring.ai.mcp.server.protocol=SSE` (and port if set)
- **Main class** — standard `@SpringBootApplication`
- **One component** — e.g. `DemoMcpTools` with `@McpTool` methods

**What to say:**
- “Only one extra dependency: the MCP server WebMVC starter.”
- “We enable the SSE transport so clients can connect over HTTP.”
- “Tools are just methods on a Spring bean, annotated with `@McpTool`.”

---

### 3. Walk through the tool code (5 min)

**Open the class that defines the MCP tools** (e.g. `DemoMcpTools`).

**Show one simple tool**, for example:

```java
@McpTool(name = "get_project_info", description = "Get a short description of this demo project")
public String getProjectInfo() {
    return "This is a demo MCP server POC. It exposes a few tools for demonstration.";
}
```

**Point out:**
- `@McpTool` with **name** and **description** — the AI uses these to decide when to call the tool
- Method parameters can use `@McpToolParam(description = "...", required = true/false)`
- Return type can be a simple type or a DTO — the framework handles serialization

**Show a second tool** if you have one (e.g. list files in a safe demo directory, or “get_demo_summary”):

- “We can add more tools in the same class or in other `@Component` classes.”
- “Spring AI discovers all beans with `@McpTool` and registers them with the MCP server.”

**What to say:**
- “No low-level protocol code — we just write normal Java methods and annotations.”
- “The server exposes these as MCP tools; any MCP client can discover and call them.”

---

### 4. Run the server and show it’s alive (3 min)

**Start the POC** (from IDE or `mvn spring-boot:run`).

**Option A — Claude Desktop (or similar) connected:**
- Show Claude (or another client) configured to use this server (e.g. in config pointing at `http://localhost:8080` or the POC port).
- Ask something that triggers a tool call, e.g. “What is this MCP server for?” or “What tools does this server expose?”
- Show the answer that comes from the tool(s).

**Option B — No MCP client:**
- Show the app running (e.g. “Started … in X seconds”).
- Explain: “An MCP client would connect to this endpoint, discover tools, and call them. We’re not running a client here, but the server is ready.”
- Optionally show a simple health or info endpoint if you added one for the demo.

**What to say:**
- “The server is a normal Spring Boot app — we just added the MCP starter and a few annotated methods.”
- “This is a POC to show that building an MCP server in Spring Boot is straightforward.”

---

### 5. Connect to “why this matters” (2 min)

**Say:** “Why would you build your own MCP server?”

**Suggest use cases:**
- Expose **internal APIs or services** to AI in a controlled way (e.g. “search our docs”, “check deployment status”).
- Expose **project or repo context** (e.g. list modules, get file contents) so the AI can reason about your codebase.
- **Prototype** before committing to a full integration.

**What to say:**
- “MCP gives you a standard way for AI tools to call into your systems.”
- “Spring Boot + Spring AI lets you implement that in the stack you already use.”
- “This POC is minimal on purpose — you can extend it with more tools and real back-ends.”

---

### 6. Recap and hand out the POC (1 min)

**Recap:**
- MCP = protocol; servers expose tools (and optionally resources/prompts).
- This POC = Spring Boot + one dependency + one (or two) `@McpTool` methods.
- Delegates can run and modify the POC themselves.

**Point them to:**
- `module-06-mcp/demos/mcp-server-poc/` — code and README
- README has: how to run, how to connect Claude Desktop (or another client), and that it’s demo-only

**What to say:**
- “The full POC is in the course materials — you can run it and add your own tools.”
- “MCP is still evolving; this gives you a concrete starting point in Spring Boot.”

---

## If something goes wrong

- **Server won’t start:** Check Java version (e.g. 17+), Spring Boot and Spring AI versions, and that no other app is using the same port.
- **Client can’t connect:** Confirm URL/port in client config, and that the server is running with SSE enabled.
- **Tools not found:** Ensure the tool class is a Spring `@Component` (or equivalent) and in a package scanned by `@SpringBootApplication`.

**Fallback:** Walk through the code and the flow on slides/screenshots; run the server after the session and share a short recording if useful.

---

## Teaching tips

- **Emphasize:** This is a POC — minimal on purpose. Production would add auth, error handling, and proper back-ends.
- **Watch for:** Delegates asking “can we use this in production?” — acknowledge the idea, then stress “orientation and POC; production design is a separate step.”
- **Adapt:** If time is short, focus on the one `@McpTool` method and the single dependency; skip running a client.

---

## Time allocation

- Bridge from “what is MCP”: 2 min  
- POC project structure: 3 min  
- Walk through tool code: 5 min  
- Run server / show it’s alive: 3 min  
- “Why this matters”: 2 min  
- Recap and hand out POC: 1 min  
- **Total: ~15–17 minutes**
