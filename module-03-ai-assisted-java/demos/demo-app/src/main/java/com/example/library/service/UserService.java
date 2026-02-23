package com.example.library.service;

import com.example.library.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo service for Module 3 — Demo 3 (refactoring).
 * Original verbose implementation: refactor with AI to use Streams, then re-run UserServiceTest.
 */
@Service
public class UserService {

    public List<String> getActiveUserEmails(List<User> users) {
        List<String> emails = new ArrayList<>();
        for (User user : users) {
            if (user != null) {
                if (user.isActive()) {
                    String email = user.getEmail();
                    if (email != null && !email.isEmpty()) {
                        emails.add(email);
                    }
                }
            }
        }
        return emails;
    }
}
