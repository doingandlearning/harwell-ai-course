package com.example.rag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Seeds the vector store with sample policy chunks so the RAG demo can answer
 * questions like "What's our data retention policy?" without requiring manual ingestion.
 * Set app.rag.seed-on-startup=false after first run to avoid duplicate chunks.
 */
@Component
@ConditionalOnProperty(name = "app.rag.seed-on-startup", havingValue = "false")
public class DocumentSeeder implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DocumentSeeder.class);

    private final VectorStore vectorStore;

    public DocumentSeeder(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Document> docs = List.of(
                new Document(
                        "Data Retention Policy: Keep customer data for 7 years after account closure. " +
                                "After 7 years, data must be securely deleted or anonymized.",
                        Map.of("source", "data-retention-policy", "section", "customer-data")),
                new Document(
                        "Internal policy: Employee records must be retained for 6 years for compliance. " +
                                "Payroll and tax records: 7 years.",
                        Map.of("source", "hr-policy", "section", "employee-records")),
                new Document(
                        "Security and access: Only authorized personnel may access customer PII. " +
                                "Access is logged and audited quarterly.",
                        Map.of("source", "security-policy", "section", "access-control")),
                new Document(
                        "Data retention exception: Legal hold may extend retention beyond 7 years " +
                                "until the hold is released by Legal.",
                        Map.of("source", "data-retention-policy", "section", "exceptions"))
        );
        vectorStore.add(docs);
        log.info("Seeded vector store with {} sample documents for RAG demo", docs.size());
    }
}
