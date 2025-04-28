package com.financial;

public interface UserRepository {
    /**
     * Fetches the stored password (hashed or plain) for the given username.
     */
    String findPassword(String username);
}
