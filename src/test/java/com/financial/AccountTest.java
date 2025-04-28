package com.financial;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("001", "John Doe", 100.0);
    }

    @Test
    void deposit_shouldIncreaseBalance() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 
            "Balance must reflect deposit");
    }

    @Test
    void withdraw_shouldDecreaseBalance() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(),
            "Balance must reflect withdrawal");
    }

    @Test
    void withdraw_moreThanBalance_shouldThrow() {
        assertThrows(InsufficientFundsException.class,
            () -> account.withdraw(200.0),
            "Withdrawing above balance should trigger InsufficientFundsException");
    }
}
