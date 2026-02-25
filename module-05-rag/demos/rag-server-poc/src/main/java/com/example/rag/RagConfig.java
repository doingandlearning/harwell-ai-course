package com.example.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RagConfig {

    @Bean
    public QuestionAnswerAdvisor questionAnswerAdvisor(VectorStore vectorStore) {
        return QuestionAnswerAdvisor.builder(vectorStore)
                .searchRequest(SearchRequest.builder()
                        .similarityThreshold(0.5)
                        .topK(5)
                        .build())
                .build();
    }

    @Bean
    public ChatClient ragChatClient(ChatModel chatModel, QuestionAnswerAdvisor questionAnswerAdvisor) {
        return ChatClient.builder(chatModel)
                .defaultAdvisors(questionAnswerAdvisor)
                .build();
    }
}
