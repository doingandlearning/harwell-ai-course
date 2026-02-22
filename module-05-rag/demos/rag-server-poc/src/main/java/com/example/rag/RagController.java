package com.example.rag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * RAG endpoint: accepts a query, retrieves relevant chunks from the vector store,
 * enriches the prompt with that context, and sends to the configured LLM (OpenAI or Ollama).
 */
@RestController
@RequestMapping("/api")
public class RagController {

    private static final Logger log = LoggerFactory.getLogger(RagController.class);

    private final ChatClient ragChatClient;

    public RagController(ChatClient ragChatClient) {
        this.ragChatClient = ragChatClient;
    }

    @PostMapping("/rag")
    public ResponseEntity<Map<String, String>> rag(@RequestBody Map<String, String> body) {
        String query = body != null ? body.get("query") : null;
        if (query == null || query.isBlank()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Missing or empty 'query' in request body"));
        }
        log.info("RAG request: query=\"{}\"", query);

        String answer = ragChatClient.prompt()
                .user(query)
                .call()
                .content();

        log.info("RAG response generated (length={})", answer != null ? answer.length() : 0);
        return ResponseEntity.ok(Map.of("query", query, "answer", answer != null ? answer : ""));
    }
}
