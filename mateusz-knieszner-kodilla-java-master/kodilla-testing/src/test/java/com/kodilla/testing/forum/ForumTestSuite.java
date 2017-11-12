package com.kodilla.testing.forum;

import org.junit.*;
import com.kodilla.testing.user.SimpleUser;

/**
 * Class contains tests for SimpleUser class.
 */
public class ForumTestSuite {
    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testCaseUsername() {
        //Given
        final SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        final String result = simpleUser.getUsername();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("theForumUser", result);
    }

    @Test
    public void testCaseRealName() {
        //Given
        final SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
        //When
        final String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals("John Smith", result);
    }
}