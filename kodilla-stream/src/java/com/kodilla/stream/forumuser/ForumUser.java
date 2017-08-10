package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class ForumUser {
    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int postCount;

    public ForumUser(final int userId, final String username,
                     final char sex, final LocalDate birthDate, final int postCount) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postCount = postCount;
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
        return "ForumUser{" + "userId=" + userId
                + ", username='" + username + '\''
                + ", sex=" + sex
                + ", birthDate=" + birthDate
                + ", postCount=" + postCount + '}';
    }
}
