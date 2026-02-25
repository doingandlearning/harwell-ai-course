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
import static org.mockito.ArgumentMatchers.any;
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

    // --- findBooksByAuthorAndTitle ---

    @Test
    void findBooksByAuthorAndTitle_withValidAuthorAndTitle_returnsBooksFromRepository() {
        String author = "Tolkien";
        String title = "Hobbit";
        Book book = new Book(1L, "The Hobbit", "J.R.R. Tolkien", "978-0-54", 1937);
        when(repository.findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title))
                .thenReturn(Arrays.asList(book));

        List<Book> result = service.findBooksByAuthorAndTitle(author, title);

        assertEquals(1, result.size());
        assertEquals("The Hobbit", result.get(0).getTitle());
        verify(repository).findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title);
    }

    @Test
    void findBooksByAuthorAndTitle_withNullAuthor_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthorAndTitle(null, "Hobbit");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findBooksByAuthorAndTitle_withEmptyAuthor_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthorAndTitle("", "Hobbit");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findBooksByAuthorAndTitle_withNullTitle_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthorAndTitle("Tolkien", null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findBooksByAuthorAndTitle_withEmptyTitle_returnsEmptyList() {
        List<Book> result = service.findBooksByAuthorAndTitle("Tolkien", "");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void findBooksByAuthorAndTitle_whenNoMatchingBooks_returnsEmptyList() {
        String author = "Unknown";
        String title = "Nothing";
        when(repository.findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title))
                .thenReturn(Collections.emptyList());

        List<Book> result = service.findBooksByAuthorAndTitle(author, title);

        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(repository).findByAuthorContainingIgnoreCaseAndTitleContainingIgnoreCase(author, title);
    }

    // --- addBook ---

    @Test
    void addBook_withValidBook_returnsSavedBookAndCallsRepository() {
        Book book = new Book(null, "New Book", "Author", "978-0-99", 2020);
        Book saved = new Book(1L, "New Book", "Author", "978-0-99", 2020);
        when(repository.save(any(Book.class))).thenReturn(saved);

        Book result = service.addBook(book);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Book", result.getTitle());
        verify(repository).save(book);
    }

    // --- updateBook ---

    @Test
    void updateBook_withValidBook_returnsUpdatedBookAndCallsRepository() {
        Book book = new Book(1L, "Updated Title", "Author", "978-0-99", 2020);
        when(repository.save(any(Book.class))).thenReturn(book);

        Book result = service.updateBook(book);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Updated Title", result.getTitle());
        verify(repository).save(book);
    }

    // --- deleteBook ---

    @Test
    void deleteBook_withValidId_callsRepositoryDeleteById() {
        Long id = 1L;

        service.deleteBook(id);

        verify(repository).deleteById(id);
    }
}
