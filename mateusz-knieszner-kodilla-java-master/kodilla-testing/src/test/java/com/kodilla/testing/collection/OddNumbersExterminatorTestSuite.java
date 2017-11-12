package com.kodilla.testing.collection;

import org.hamcrest.CoreMatchers;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class tests OddNumbersExterminator class.
 */
public class OddNumbersExterminatorTestSuite {
    OddNumbersExterminator oddNumbersExterminator;

    @Before
    public void before() {
        System.out.println("Test Case: begin");
        oddNumbersExterminator = new OddNumbersExterminator();
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

    @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
    @Test(expected = NullPointerException.class)
    public void testOddNumbersExterminatorNull() {
        //Given
        final List<Integer> nullList = null;

        // When
        oddNumbersExterminator.exterminate(nullList);

        //Then
        //exception should be thrown
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        final OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        final ArrayList result = oddNumbersExterminator.exterminate(new ArrayList<>());
        System.out.println("Testing " + result);
        //Then
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        final OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        final List<Integer> testArrayList = new ArrayList<>();

        testArrayList.add(1);
        testArrayList.add(2);
        testArrayList.add(3);
        //When
        final ArrayList<Integer> result = oddNumbersExterminator.exterminate(testArrayList);
        System.out.println("Testing " + result);
        //Then
        Assert.assertThat(result, CoreMatchers.hasItem(2));
    }
}