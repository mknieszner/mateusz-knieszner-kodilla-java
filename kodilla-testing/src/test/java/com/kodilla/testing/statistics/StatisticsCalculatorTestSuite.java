package com.kodilla.testing.statistics;

import static org.mockito.Mockito.*;

import org.junit.*;

import java.util.*;

import com.kodilla.testing.forum.statistics.*;

/**
 * TestsSuite for StatisticsCalculator class.
 */
public class StatisticsCalculatorTestSuite {
    private int postCount;
    private int commentCount;
    private List<String> names;
    private StatisticsCalculator statisticsCalculator;
    private Statistics statisticsMock;

    @Before
    public void before() {
        statisticsCalculator = new StatisticsCalculator();
        statisticsMock = mock(Statistics.class);
        names = new ArrayList<>();
    }

    @Test
    public void testCalculateAdvStatisticsZeroPost() {
        //Given
        names.add("John");
        postCount = 0;
        commentCount = 1;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(1, statisticsCalculator.getUserCount());
        Assert.assertEquals(0, statisticsCalculator.getPostCount());
        Assert.assertEquals(1, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(0 == statisticsCalculator.getAvPostPerUser());
        Assert.assertTrue(-1 == statisticsCalculator.getAvCommentPerPost());
        Assert.assertTrue(1 == statisticsCalculator.getAvCommentPerUser());
    }

    @Test
    public void testCalculateAdvStatisticsThousandPost() {
        //Given
        names.add("John");
        postCount = 1000;
        commentCount = 1000;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(1, statisticsCalculator.getUserCount());
        Assert.assertEquals(1000, statisticsCalculator.getPostCount());
        Assert.assertEquals(1000, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(1000 == statisticsCalculator.getAvPostPerUser());
        Assert.assertTrue(1 == statisticsCalculator.getAvCommentPerPost());
        Assert.assertTrue(1000 == statisticsCalculator.getAvCommentPerUser());
    }

    @Test
    public void testCalculateAdvStatisticsZeroComment() {
        //Given
        names.add("John");
        postCount = 1;
        commentCount = 0;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(1, statisticsCalculator.getUserCount());
        Assert.assertEquals(1, statisticsCalculator.getPostCount());
        Assert.assertEquals(0, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(1 == statisticsCalculator.getAvPostPerUser());
        Assert.assertTrue(0 == statisticsCalculator.getAvCommentPerPost());
        Assert.assertTrue(0 == statisticsCalculator.getAvCommentPerUser());
    }

    @Test
    public void testCalculateAdvStatisticsLessCommentThenPosts() {
        //Given
        names.add("John");
        postCount = 10;
        commentCount = 5;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(1, statisticsCalculator.getUserCount());
        Assert.assertEquals(10, statisticsCalculator.getPostCount());
        Assert.assertEquals(5, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(10 == statisticsCalculator.getAvPostPerUser());
        Assert.assertEquals(0.5, statisticsCalculator.getAvCommentPerPost(), 0.0001);
        Assert.assertTrue(5 == statisticsCalculator.getAvCommentPerUser());
    }

    @Test
    public void testCalculateAdvStatisticsLessPostsThanComments() {
        //Given
        names.add("John");
        postCount = 5;
        commentCount = 10;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(1, statisticsCalculator.getUserCount());
        Assert.assertEquals(5, statisticsCalculator.getPostCount());
        Assert.assertEquals(10, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(5 == statisticsCalculator.getAvPostPerUser());
        Assert.assertTrue(2 == statisticsCalculator.getAvCommentPerPost());
        Assert.assertTrue(10 == statisticsCalculator.getAvCommentPerUser());
    }

    @Test
    public void testCalculateAdvStatisticsZeroUser() {

        //Given
        postCount = 1;
        commentCount = 1;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(0, statisticsCalculator.getUserCount());
        Assert.assertEquals(1, statisticsCalculator.getPostCount());
        Assert.assertEquals(1, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(-1 == statisticsCalculator.getAvPostPerUser());
        Assert.assertTrue(1 == statisticsCalculator.getAvCommentPerPost());
        Assert.assertTrue(-1 == statisticsCalculator.getAvCommentPerUser());
    }

    @Test
    public void testCalculateAdvStatisticsThousandUser() {
        //Given
        names.add("John");
        postCount = 1000;
        commentCount = 10000;

        //when
        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.postsCount()).thenReturn(postCount);
        when(statisticsMock.commentsCount()).thenReturn(commentCount);
        statisticsCalculator.calculateAdvStatistics(statisticsMock);

        //then
        Assert.assertEquals(1, statisticsCalculator.getUserCount());
        Assert.assertEquals(1000, statisticsCalculator.getPostCount());
        Assert.assertEquals(10000, statisticsCalculator.getCommentsCount());
        Assert.assertTrue(1000 == statisticsCalculator.getAvPostPerUser());
        Assert.assertTrue(10 == statisticsCalculator.getAvCommentPerPost());
        Assert.assertTrue(10000 == statisticsCalculator.getAvCommentPerUser());
    }
}