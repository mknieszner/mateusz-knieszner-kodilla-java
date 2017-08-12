package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

/**
 * List of users.
 */
public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public void add(ForumUser forumUser) {
        userList.add(forumUser);
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
