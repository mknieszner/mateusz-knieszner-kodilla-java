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


    public void storeStatistics(Statistics statistics) {
        userCount = statistics.usersNames().size();
        postCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();
        avPostPerUser = calculateAvPostPerUser(postCount, userCount);
        avCommentPerUser = calculateAvCommentPerUser(commentsCount, userCount);
        avCommentPerPost = calculateAvCommentPerPost(commentsCount, postCount);
    }

    private double calculateAvCommentPerPost(int commentsCount, int postCount) {
        if (postCount == 0) {
            return -1;
        } else {
            return (double) commentsCount / postCount;
        }
    }

    private double calculateAvCommentPerUser(int commentsCount, int userCount) {
        if (userCount == 0) {
            return -1;
        } else {
            return (double) commentsCount / userCount;
        }
    }

    private double calculateAvPostPerUser(int postCount, int userCount) {
        if (userCount == 0) {
            return -1;
        } else {
            return (double) postCount / userCount;
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
