package com.financial;

import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    @Mock private UserRepository userRepository;
    private AuthenticationService authService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        authService = new AuthenticationService(userRepository);
    }

    @Test
    void authenticate_validCredentials_shouldReturnTrue() {
        when(userRepository.findPassword("alice")).thenReturn("pass123");
        assertTrue(authService.authenticate("alice", "pass123"),
            "Correct password must authenticate successfully");
        verify(userRepository).findPassword("alice");
    }

    @Test
    void authenticate_invalidCredentials_shouldReturnFalse() {
        when(userRepository.findPassword("alice")).thenReturn("pass123");
        assertFalse(authService.authenticate("alice", "wrong"),
            "Wrong password must be rejected");
    }
}
