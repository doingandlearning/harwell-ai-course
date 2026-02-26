package com.example.library.repository;

import com.example.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for Book entities.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(String author, String title);

    void deleteByAuthorContainingIgnoreCase(String author);
}
