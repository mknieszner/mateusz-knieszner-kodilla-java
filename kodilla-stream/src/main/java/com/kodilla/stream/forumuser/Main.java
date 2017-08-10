package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Main class runs Forum.
 */
public class Main {
    public static void main(String[] args) {
        Forum forum = new Forum();
        forum.add(1, "janusz2", 'M', LocalDate.of(1970, 1, 1), 1);
        forum.add(2, "zbyszek", 'K', LocalDate.of(1980, 1, 1), 0);
        forum.add(3, "marian", 'M', LocalDate.of(1997, 12, 1), 1);
        forum.add(4, "baska", 'K', LocalDate.of(1980, 1, 1), 1);
        forum.add(5, "zigi", 'M', LocalDate.of(1990, 1, 1), 1);
        forum.add(6, "janusz", 'M', LocalDate.of(1997, 1, 1), 1);
        forum.add(7, "seba", 'M', LocalDate.of(1980, 1, 1), 1);
        forum.add(8, "nepomucen", 'M', LocalDate.of(1980, 1, 1), 0);
        forum.add(9, "lona", 'K', LocalDate.of(1980, 1, 1), 0);
        forum.add(10, "kaska", 'K', LocalDate.of(1975, 1, 1), 1);

        Map<Integer, ForumUser> result = forum.getUserList()
                .stream().filter(u -> u.getSex() == 'M')
                .filter(s -> (Calendar.getInstance().get(Calendar.YEAR)
                        > s.getBirthDate().plusYears(20).getYear()
                        || Calendar.getInstance().get(Calendar.YEAR)
                        == s.getBirthDate().plusYears(20).getYear()
                        && Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
                        > s.getBirthDate().getDayOfYear()))
                .filter(s -> s.getPostCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));
        result.forEach((integer, forumUser) -> System.out.println(forumUser.toString()));
    }
}
