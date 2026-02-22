package com.example.mcp;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Tracks server startup time and tool invocation count.
 * Used by MCP tools to return dynamic, runtime-only data (not available from the codebase).
 */
@Component
public class ServerRuntime {

    private final long startupMillis = System.currentTimeMillis();
    private final AtomicLong toolCallCount = new AtomicLong(0);

    public long getStartupMillis() {
        return startupMillis;
    }

    public long getUptimeMillis() {
        return System.currentTimeMillis() - startupMillis;
    }

    public long incrementAndGetCallCount() {
        return toolCallCount.incrementAndGet();
    }

    public long getCallCount() {
        return toolCallCount.get();
    }
}
