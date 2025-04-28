package com.financial;

public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returns true if the provided password matches the stored password.
     */
    public boolean authenticate(String username, String password) {
        String stored = userRepository.findPassword(username);
        return stored != null && stored.equals(password);
    }
}
