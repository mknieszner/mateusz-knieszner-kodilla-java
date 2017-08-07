package com.kodilla.testing.statistics;

import static org.mockito.Mockito.*;

import org.junit.*;

import java.util.*;

import com.kodilla.testing.forum.statistics.*;

/**
 * TestsSuite for StatisticsCalculator class.
 */
public class StatisticsCalculatorTestSuite {

    @Test
    public void testCalculateAdvStatisticsZeroPost() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        names.add("John");
        int postCount = 0;
        int commentCount = 1;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();

        Assert.assertEquals(1, testUserCount);
        Assert.assertEquals(0, testPostCount);
        Assert.assertEquals(1, testCommentsCount);
        Assert.assertTrue(0 == testAvPostPerUser);
        Assert.assertTrue(1 == testAvCommentPerUser);
        Assert.assertTrue(-1 == testAvCommentPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsThousandPost() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        names.add("John");
        int postCount = 1000;
        int commentCount = 1000;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();

        Assert.assertEquals(1, testUserCount);
        Assert.assertEquals(1000, testPostCount);
        Assert.assertEquals(1000, testCommentsCount);
        Assert.assertTrue(1000 == testAvPostPerUser);
        Assert.assertTrue(1000 == testAvCommentPerUser);
        Assert.assertTrue(1 == testAvCommentPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsZeroComment() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        names.add("John");
        int postCount = 1;
        int commentCount = 0;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();

        Assert.assertEquals(1, testUserCount);
        Assert.assertEquals(1, testPostCount);
        Assert.assertEquals(0, testCommentsCount);
        Assert.assertTrue(1 == testAvPostPerUser);
        Assert.assertTrue(0 == testAvCommentPerUser);
        Assert.assertTrue(0 == testAvCommentPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentThenPosts() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        names.add("John");
        int postCount = 10;
        int commentCount = 10;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();
        double expectedTestAvCommentPerUser = 0.5;

        Assert.assertEquals(1, testUserCount);
        Assert.assertEquals(10, testPostCount);
        Assert.assertEquals(10, testCommentsCount);
        Assert.assertTrue(10 == testAvPostPerUser);
        Assert.assertTrue(10 == testAvCommentPerUser);
        Assert.assertTrue(1 == testAvCommentPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsLessPostsThanComments() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        names.add("John");
        int postCount = 5;
        int commentCount = 10;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();

        Assert.assertEquals(1, testUserCount);
        Assert.assertEquals(5, testPostCount);
        Assert.assertEquals(10, testCommentsCount);
        Assert.assertTrue(5 == testAvPostPerUser);
        Assert.assertTrue(10 == testAvCommentPerUser);
        Assert.assertTrue(2 == testAvCommentPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsZeroUser() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        int postCount = 1;
        int commentCount = 1;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();

        Assert.assertEquals(0, testUserCount);
        Assert.assertEquals(1, testPostCount);
        Assert.assertEquals(1, testCommentsCount);
        Assert.assertTrue(-1 == testAvPostPerUser);
        Assert.assertTrue(-1 == testAvCommentPerUser);
        Assert.assertTrue(1 == testAvCommentPerPost);
    }

    @Test
    public void testCalculateAdvStatisticsThousandUser() {
        Statistics statisticsMock = mock(Statistics.class);

        List<String> names = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            names.add("John");
        }
        int postCount = 1000;
        int commentCount = 10000;

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);

        StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        int testUserCount = statisticsCalculator.getUserCount();
        int testPostCount = statisticsCalculator.getPostCount();
        int testCommentsCount = statisticsCalculator.getCommentsCount();
        double testAvPostPerUser = statisticsCalculator.getAvPostPerUser();
        double testAvCommentPerPost = statisticsCalculator.getAvCommentPerPost();
        double testAvCommentPerUser = statisticsCalculator.getAvCommentPerUser();

        Assert.assertEquals(100, testUserCount);
        Assert.assertEquals(1000, testPostCount);
        Assert.assertEquals(10000, testCommentsCount);
        Assert.assertTrue(10 == testAvPostPerUser);
        Assert.assertTrue(100 == testAvCommentPerUser);
        Assert.assertTrue(10 == testAvCommentPerPost);
    }


}
