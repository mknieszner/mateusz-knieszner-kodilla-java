package com.kodilla.stream.portfolio;

/**
 * User class.
 */
public final class User {
    private final String username;
    private final String realName;

    public User(final String username, final String realName) {
        this.username = username;
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        final User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + realName.hashCode();
        return result;
    }
}