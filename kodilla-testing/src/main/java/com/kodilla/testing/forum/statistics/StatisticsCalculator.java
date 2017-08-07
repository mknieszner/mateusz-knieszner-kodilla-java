package com.kodilla.testing.forum.statistics;

/**
 * Class contains methods and variables required to calculate forum averages.
 */
public class StatisticsCalculator {
    private int userCount;
    private int postCount;
    private int commentsCount;
    private double avPostPerUser;
    private double avCommentPerUser;
    private double avCommentPerPost;


    public void calculateAdvStatistics(Statistics statistics) {
        userCount = statistics.usersNames().size();
        postCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        if (userCount != 0) {
            avPostPerUser = (double) postCount / userCount;
            avCommentPerUser = (double) commentsCount / userCount;
        } else {
            avPostPerUser = -1;
            avCommentPerUser = -1;
        }
        if (postCount != 0) {
            avCommentPerPost = (double) commentsCount / postCount;
        } else {
            avCommentPerPost = -1;
        }
    }

    public void showStatistics() {
        System.out.printf("avPostPerUser= %d", userCount);
        System.out.printf("avPostPerUser= %d", postCount);
        System.out.printf("avPostPerUser= %d", commentsCount);
        System.out.printf("avPostPerUser= %.2f", avPostPerUser);
        System.out.printf("avCommentPerUser= %.2f", avCommentPerUser);
        System.out.printf("avCommentPerPost= %.2f", avCommentPerPost);
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvPostPerUser() {
        return avPostPerUser;
    }

    public double getAvCommentPerUser() {
        return avCommentPerUser;
    }

    public double getAvCommentPerPost() {
        return avCommentPerPost;
    }
}
