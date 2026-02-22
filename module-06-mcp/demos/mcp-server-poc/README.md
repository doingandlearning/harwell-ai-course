# MCP Server POC — Spring Boot

A minimal **Model Context Protocol (MCP) server** built with **Spring Boot** and **Spring AI**, for use in **Module 6** of the Harwell Prompt Engineering course.

## What this does

- Runs as a normal Spring Boot web app.
- Exposes MCP over **SSE (Server-Sent Events)** so clients (e.g. Claude Desktop, IDEs) can connect.
- Registers two demo tools:
  - **get_project_info** — Returns a short description of this POC.
  - **list_demo_tools** — Lists the tool names this server exposes.

No real filesystem or internal systems are accessed; everything is synthetic for the demo.

## Requirements

- **Java 17+**
- **Maven 3.6+** (installed on your PATH; this project has a POM only, no Maven wrapper)

## Build and run

```bash
mvn spring-boot:run
```

Or build and run the JAR:

```bash
mvn clean package -DskipTests
java -jar target/mcp-server-poc-0.0.1-SNAPSHOT.jar
```

To use the Maven wrapper instead (e.g. `./mvnw`), generate it once from this directory: `mvn wrapper:wrapper`.

The app starts on **port 8080** by default. The MCP SSE endpoint is exposed automatically by the Spring AI MCP server starter.

## Connecting a client

### Claude Desktop

1. Install [Claude Desktop](https://claude.ai/download) (or another MCP-capable client).
2. Configure an MCP server that points at this app. For example, in Claude Desktop config (e.g. `~/Library/Application Support/Claude/claude_desktop_config.json` on macOS):

```json
{
  "mcpServers": {
    "harwell-demo": {
      "url": "http://localhost:8080/sse"
    }
  }
}
```

For SSE clients (e.g. Cursor), use the `/sse` path. Exact config depends on your client (SSE vs Streamable HTTP). See [Spring AI MCP Server](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html) and your client’s docs.

3. Restart the client and ensure this POC is running; the client should discover the tools and you can ask things like “What is this MCP server for?” or “What tools does this server expose?”

### Other clients

Any MCP client that supports **SSE** should connect to **`http://localhost:8080/sse`** (Spring AI exposes the SSE endpoint at `/sse`). Configure the client with that full URL.

## Configuration

- **Port:** `server.port` in `application.yml` (default `8080`).
- **MCP protocol:** `spring.ai.mcp.server.protocol=SSE` (default for this starter).
- **Server type:** `spring.ai.mcp.server.type=SYNC`.

See [MCP Server Boot Starter](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html) for more options.

## Troubleshooting

### Compile error: package … does not exist (McpTool / McpToolParam)

This POC uses **`org.springaicommunity.mcp.annotation`** for `@McpTool` and `@McpToolParam` (pulled in transitively by `spring-ai-starter-mcp-server-webmvc`). If your Spring AI or MCP version uses a different package:

1. **Fix the imports in `DemoMcpTools.java`**  
   Use the package your dependencies provide. With Spring AI 1.1.2 it should be:
   - `import org.springaicommunity.mcp.annotation.McpTool;`
   - `import org.springaicommunity.mcp.annotation.McpToolParam;`

2. **Docs**  
   [MCP Server Annotations](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-annotations-server.html)

### Server starts but the client doesn’t see tools

- Confirm the client is pointing at the same host/port as this app (e.g. `http://localhost:8080`).
- Check that the client supports the same transport (SSE) and path as this server.
- Check the app logs for MCP registration or errors.

### Port already in use

Change `server.port` in `application.yml` (e.g. to `8081`) and point the client at the new URL.

## Course context

- **Module 6:** Model Context Protocol (MCP) — orientation and when it helps.
- **Demo 2:** “Spring Boot MCP server POC” uses this project to show a real MCP server in the Java/Spring stack.
- **Scope:** This is a **POC for teaching only**. It is not hardened for production (no auth, no rate limiting, etc.).

## References

- [Spring AI MCP Overview](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-overview.html)
- [MCP Server Boot Starter](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)
- [MCP Server Annotations](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-annotations-server.html)
- [Model Context Protocol](https://modelcontextprotocol.io/)
