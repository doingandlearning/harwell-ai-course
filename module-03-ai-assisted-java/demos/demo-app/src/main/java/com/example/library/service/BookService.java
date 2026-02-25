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
