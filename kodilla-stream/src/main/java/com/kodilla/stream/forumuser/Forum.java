package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * List of users.
 */
public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public void add(final int userId, final String username,
                    final char sex, final LocalDate birthDate, final int postCount) {
        userList.add(new ForumUser(userId, username, sex, birthDate, postCount));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
