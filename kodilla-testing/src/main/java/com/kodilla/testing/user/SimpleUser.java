package com.kodilla.testing.user;

/**
 * Class contains basic credentials.
 */
public class SimpleUser {
    private final String username;
    private final String realName;

    public SimpleUser(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }
}