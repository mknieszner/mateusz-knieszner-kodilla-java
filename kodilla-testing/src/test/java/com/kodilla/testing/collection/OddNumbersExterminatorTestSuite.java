package com.kodilla.testing.collection;

import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Class tests OddNumbersExterminator class.
 */
public class OddNumbersExterminatorTestSuite {
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
        System.out.println("Test OddNumbersExterminator: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test OddNumbersExterminator: end");
    }

    @Test(expected = NullPointerException.class)
    public void testOddNumbersExterminatorNull() {
        Assert.assertTrue(new OddNumbersExterminator().exterminate(null).isEmpty());
    }


    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List result = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Testing " + result);
        //Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> testArrayList = new ArrayList<>();

        testArrayList.add(1);
        testArrayList.add(2);
        testArrayList.add(3);
        //When
        List<Integer> result = oddNumbersExterminator.exterminate(testArrayList);
        System.out.println("Testing " + result);
        //Then
        Assert.assertThat(result, CoreMatchers.hasItems(2));
    }
}
