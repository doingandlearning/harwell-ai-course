package com.example.library.service;

import com.example.library.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Demo 3 (Refactoring): Test must PASS with original getActiveUserEmails.
 * After refactoring UserService with AI, run this again — test should still pass.
 */
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final UserService service = new UserService();

    @Test
    void getActiveUserEmails_returnsOnlyActiveUsersWithNonEmptyEmail() {
        User activeUser = new User("John", "john@example.com", true);
        User inactiveUser = new User("Jane", "jane@example.com", false);
        User nullEmailUser = new User("Bob", null, true);
        User emptyEmailUser = new User("Alice", "", true);

        List<User> users = Arrays.asList(activeUser, inactiveUser, nullEmailUser, emptyEmailUser, null);

        List<String> emails = service.getActiveUserEmails(users);

        assertEquals(1, emails.size());
        assertEquals("john@example.com", emails.get(0));
    }
}
