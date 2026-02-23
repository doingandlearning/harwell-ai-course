package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for BookService (Module 3 — Demo 4).
 * Covers findBooksByAuthor: happy path, unhappy path, and edge cases.
 */
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    void findBooksByAuthor_withValidAuthor_returnsBooksFromRepository() {
        String author = "Tolkien";
        Book book = new Book(1L, "The Hobbit", "J.R.R. Tolkien", "978-0-54", 1937);
        when(repository.findByAuthorContainingIgnoreCase(author)).thenReturn(Arrays.asList(book));

        List<Book> result = service.findBooksByAuthor(author);

        assertEquals(1, result.size());
        assertEquals("The Hobbit", result.get(0).getTitle());
        assertEquals("J.R.R. Tolkien", result.get(0).getAuthor());
        verify(repository).findByAuthorContainingIgnoreCase(author);
    }

    @Test
    void findBooksByAuthor_withValidAuthor_returnsMultipleBooks() {
        String author = "Tolkien";
        Book book1 = new Book(1L, "The Hobbit", "J.R.R. Tolkien", "978-0-54", 1937);
        Book book2 = new Book(2L, "The Fellowship", "J.R.R. Tolkien", "978-0-55", 1954);
        when(repository.findByAuthorContainingIgnoreCase(author)).thenReturn(Arrays.asList(book1, book2));

        List<Book> result = service.findBooksByAuthor(author);

        assertEquals(2, result.size());
        assertEquals("The Hobbit", result.get(0).getTitle());
        assertEquals("The Fellowship", result.get(1).getTitle());
        verify(repository).findByAuthorContainingIgnoreCase(author);
    }

    @Test
    void findBooksByAuthor_withNullAuthor_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthor(null);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        // Repository is not called when author is null
    }

    @Test
    void findBooksByAuthor_withEmptyString_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthor("");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        // Repository is not called when author is empty
    }

    @Test
    void findBooksByAuthor_withWhitespaceOnly_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthor("   ");

        assertNotNull(result);
        assertTrue(result.isEmpty());
        // Repository is not called when author is blank
    }

    @Test
    void findBooksByAuthor_whenNoMatchingBooks_returnsEmptyList() {
        String author = "Unknown";
        when(repository.findByAuthorContainingIgnoreCase(author)).thenReturn(Collections.emptyList());

        List<Book> result = service.findBooksByAuthor(author);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(repository).findByAuthorContainingIgnoreCase(author);
    }

    @Test
    void findBooksByAuthor_withValidAuthor_delegatesToRepositoryWithSameArgument() {
        String author = "Rowling";
        when(repository.findByAuthorContainingIgnoreCase(author)).thenReturn(Collections.emptyList());

        service.findBooksByAuthor(author);

        verify(repository).findByAuthorContainingIgnoreCase("Rowling");
    }
}
