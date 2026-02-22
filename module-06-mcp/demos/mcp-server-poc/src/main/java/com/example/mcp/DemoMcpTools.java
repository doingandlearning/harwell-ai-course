package com.example.mcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Demo MCP tools for Module 6 — Harwell Prompt Engineering.
 * Exposes simple tools that an MCP client (e.g. Cursor) can discover and call.
 * Each tool logs when it is invoked and can call into other components for dynamic behaviour.
 */
@Component
public class DemoMcpTools {

    private static final Logger log = LoggerFactory.getLogger(DemoMcpTools.class);
    private static final DateTimeFormatter ISO_FORMAT = DateTimeFormatter.ISO_INSTANT;

    private final ServerRuntime serverRuntime;

    public DemoMcpTools(ServerRuntime serverRuntime) {
        this.serverRuntime = serverRuntime;
    }

    @McpTool(
            name = "get_project_info",
            description = "Get a short description of this demo MCP server project (Harwell Module 6 POC)")
    public String getProjectInfo() {
        log.info("MCP tool called: get_project_info");
        serverRuntime.incrementAndGetCallCount();
        return "This is a demo MCP server POC built with Spring Boot and Spring AI. "
                + "It exposes a few tools for demonstration. Used in the Harwell Prompt Engineering course, Module 6.";
    }

    @McpTool(
            name = "list_demo_tools",
            description = "List the names of the tools this demo server exposes (for demonstration only)")
    public String listDemoTools() {
        log.info("MCP tool called: list_demo_tools");
        serverRuntime.incrementAndGetCallCount();
        return "This server exposes: get_project_info, list_demo_tools, get_server_status, analyze_text. "
                + "In a real MCP server you might expose tools like list_files, read_file, or query_database.";
    }

    @McpTool(
            name = "get_server_status",
            description = "Get current server status: current time (UTC), uptime, and number of MCP tool calls since startup. "
                    + "Use this when you need live server-side data that cannot be obtained from the codebase.")
    public String getServerStatus() {
        log.info("MCP tool called: get_server_status");
        long callCount = serverRuntime.incrementAndGetCallCount();
        long uptimeMillis = serverRuntime.getUptimeMillis();
        String currentTimeUtc = ISO_FORMAT.format(Instant.now());
        String uptimeHuman = formatUptime(uptimeMillis);
        return String.format(
                "Server status: currentTimeUtc=%s, uptime=%s, mcpToolCallsSinceStartup=%d",
                currentTimeUtc, uptimeHuman, callCount);
    }

    @McpTool(
            name = "analyze_text",
            description = "Analyze a text string on the server: returns character count, word count, and line count. "
                    + "Use when you need the server to compute these values rather than inferring from context.")
    public String analyzeText(
            @McpToolParam(description = "The text to analyze", required = true) String text) {
        log.info("MCP tool called: analyze_text (input length={})", text != null ? text.length() : 0);
        serverRuntime.incrementAndGetCallCount();
        if (text == null || text.isEmpty()) {
            return "Analysis: characters=0, words=0, lines=0 (empty or null input)";
        }
        int chars = text.length();
        int words = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
        int lines = (int) text.lines().count();
        return String.format("Analysis: characters=%d, words=%d, lines=%d", chars, words, lines);
    }

    private static String formatUptime(long millis) {
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        if (hours > 0) {
            return String.format("%dh %dm %ds", hours, minutes, seconds);
        }
        if (minutes > 0) {
            return String.format("%dm %ds", minutes, seconds);
        }
        return String.format("%ds", seconds);
    }
}
