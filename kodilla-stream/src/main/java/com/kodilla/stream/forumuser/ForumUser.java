package com.kodilla.stream.forumuser;

import java.time.LocalDate;


/**
 * Forum user Class.
 */
public final class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postCount;

    /**
     * Builder pattern for ForumUser
     */
    public static class Builder {
        private int userId;
        private String username;
        private char sex;
        private LocalDate birthDate;
        private int postCount;

        public Builder userId(final int userId) {
            this.userId = userId;
            return this;
        }

        public Builder username(final String username) {
            this.username = username;
            return this;
        }

        public Builder sex(final char sex) {
            this.sex = sex;
            return this;
        }

        public Builder birthDate(final LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder postCount(final int postCount) {
            this.postCount = postCount;
            return this;
        }

        public ForumUser build() {
            return new ForumUser(this);
        }
    }

    private ForumUser(final Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.sex = builder.sex;
        this.birthDate = builder.birthDate;
        this.postCount = builder.postCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCount() {
        return postCount;
    }

    @Override
    public String toString() {
        return "ForumUser{"
                + "userId=" + userId
                + ", username='" + username + '\''
                + ", sex=" + sex
                + ", birthDate=" + birthDate
                + ", postCount=" + postCount + '}';
    }
}
