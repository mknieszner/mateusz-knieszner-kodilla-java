package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;


public class CollectionTestSuite {
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
        System.out.println("Test Collection: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Collection: end");
    }

    @Test
    public void testOddNumbersExterminatorNull() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList result = oddNumbersExterminator.exterminate(null);
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals(null, result);
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList result = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        ArrayList<Integer> testArrayList = new ArrayList<Integer>();
        ArrayList<Integer> expectedArrayList = new ArrayList<Integer>();

        testArrayList.add(1);
        testArrayList.add(2);
        testArrayList.add(3);
        expectedArrayList.add(2);
        //When
        ArrayList result = oddNumbersExterminator.exterminate(testArrayList);
        System.out.println("Testing " + result);
        //Then
        Assert.assertEquals(expectedArrayList, result);
    }
}
