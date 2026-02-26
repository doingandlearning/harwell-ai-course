package com.example.library.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo entity for Module 3 — Demo 1 (generation) and Demo 4 (unit testing).
 * Synthetic example for course use only.
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(unique = true, nullable = false)
    private String isbn;

    private Integer publishedYear;

    @ElementCollection
    @CollectionTable(name = "book_reviews", joinColumns = @JoinColumn(name = "book_id"))
    @Column(name = "review")
    private List<String> reviews = new ArrayList<>();

    public Book() {}

    public Book(Long id, String title, String author, String isbn, Integer publishedYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedYear = publishedYear;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Integer getPublishedYear() { return publishedYear; }
    public void setPublishedYear(Integer publishedYear) { this.publishedYear = publishedYear; }
    public List<String> getReviews() { return reviews; }
    public void setReviews(List<String> reviews) { this.reviews = reviews != null ? reviews : new ArrayList<>(); }
}
