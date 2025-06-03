package io.akto.mcp.config;

public class AuthTokenContext {

    private static final ThreadLocal<String> bearerToken = new ThreadLocal<>();

    public static void setToken(String token) {
        bearerToken.set(token);
    }

    public static String getToken() {
        return bearerToken.get();
    }

    public static void clear() {
        bearerToken.remove();
    }
}
