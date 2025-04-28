package com.financial;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void usersWithSameId_shouldBeEqual() {
        User u1 = new User("u-123", "Alice");
        User u2 = new User("u-123", "Alice");
        assertEquals(u1, u2, "Users sharing the same ID must be equal");
    }

    @Test
    void usersWithDifferentId_shouldNotBeEqual() {
        User u1 = new User("u-123", "Alice");
        User u2 = new User("u-456", "Bob");
        assertNotEquals(u1, u2, "Users with different IDs must not be equal");
    }
}
