package pl.coderslab;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

// Class to manage remember me tokens
public class RememberMeTokenManager {

    // Map to store the valid tokens and corresponding usernames
    private static Map<String, String> validTokens = new HashMap<>();

    // Method to generate a unique token
    public static String generateUniqueToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] tokenBytes = new byte[64];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(tokenBytes);
    }

    // Method to validate a token and get the associated username
    public static String getUsernameFromToken(String token) {
        return validTokens.get(token);
    }

    // Method to check if a token is valid
    public static boolean isValidToken(String token) {
        return validTokens.containsKey(token);
    }

    // Method to store a valid token and its associated username
    public static void addValidToken(String token, String username) {
        validTokens.put(token, username);
    }

    // Method to remove an expired token
    public static void removeToken(String token) {
        validTokens.remove(token);
    }
}
