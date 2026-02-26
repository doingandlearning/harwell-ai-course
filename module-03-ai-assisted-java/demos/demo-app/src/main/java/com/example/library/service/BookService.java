package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Demo service for Module 3 — Demo 1 (generation) and Demo 4 (unit testing).
 * Use findBooksByAuthor as the target for generated tests.
 */
@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    /*
    * deleteBooksByAuthor method to delete all books by an author
    * @param author
    * @return the number of books deleted
    */
    public void deleteBooksByAuthor(String author) {
        // Add a log message that the books are being deleted
        System.out.println("Deleting books by author: " + author);
        repository.deleteByAuthorContainingIgnoreCase(author);
    }

    /**
     * Adds a review to the specified book by its ID.
     * 
     * @param bookId the ID of the book to add the review to
     * @param review the review text to be added
     * @throws IllegalArgumentException if the book does not exist or review is null/blank
     */
    public void addReviewToBook(Long bookId, String review) {
        if (bookId == null) {
            throw new IllegalArgumentException("Book ID cannot be null.");
        }
        if (review == null || review.trim().isEmpty()) {
            throw new IllegalArgumentException("Review cannot be null or empty.");
        }
        Book book = repository.findById(bookId).orElse(null);
        if (book == null) {
            throw new IllegalArgumentException("Book not found for ID: " + bookId);
        }
        if (book.getReviews() == null) {
            book.setReviews(new java.util.ArrayList<>());
        }
        book.getReviews().add(review);
        repository.save(book);
    }

    public List<Book> findBooksByAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findByAuthorContainingIgnoreCase(author);
    }

    public List<Book> findBooksByAuthorAndTitle(String author, String title) {
        if (author == null || author.trim().isEmpty() || title == null || title.trim().isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title);
    }

    /**
     * addBook method to add a new book to the repository
     * @param book
     * @return the added book
     */
    public Book addBook(Book book) {
        return repository.save(book);
    }

    /**
     * updateBook method to update a book in the repository
     * @param book
     * @return the updated book
     */
    public Book updateBook(Book book) {
        return repository.save(book);
    }

    /**
     * deleteBook method to delete a book from the repository
     * @param id
     * @return the deleted book
     */
    public void deleteBook(Long id) {
        repository.deleteById(id);
    }


    
}
