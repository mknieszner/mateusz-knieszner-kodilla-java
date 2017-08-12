package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main class runs Forum.
 */
public class Main {

    private static void implementForum(final Forum forum) {
        forum.add(new ForumUser.Builder()
                .userId(1)
                .username("janusz2")
                .sex('M')
                .birthDate(LocalDate.of(1970, 1, 1))
                .postCount(1)
                .build());

        forum.add(new ForumUser.Builder()
                .userId(2)
                .username("zbyszek")
                .sex('M')
                .birthDate(LocalDate.of(1980, 1, 1))
                .postCount(0)
                .build());

        forum.add(new ForumUser.Builder()
                .userId(3)
                .username("bolek")
                .sex('M')
                .birthDate(LocalDate.of(1997, 12, 1))
                .postCount(1)
                .build());

        forum.add(new ForumUser.Builder()
                .userId(3)
                .username("marian")
                .sex('M')
                .birthDate(LocalDate.of(1997, 1, 1))
                .postCount(1)
                .build());

        forum.add(new ForumUser.Builder()
                .userId(4)
                .username("baska")
                .sex('K')
                .birthDate(LocalDate.of(1980, 1, 1))
                .postCount(1)
                .build());
        forum.add(new ForumUser.Builder()
                .userId(5)
                .username("zigi")
                .sex('M')
                .birthDate(LocalDate.of(1990, 1, 1))
                .postCount(1)
                .build());
    }

    public static void main(String[] args) {

        Forum forum = new Forum();
        implementForum(forum);

        Map<Integer, ForumUser> result = forum.getUserList()
                .stream().filter(u -> u.getSex() == 'M')
                .filter(s -> (s.getBirthDate().plusYears(20).isBefore(LocalDate.now())))
                .filter(s -> s.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));
        result.forEach((integer, forumUser) -> System.out.println(forumUser.toString()));
    }
}
