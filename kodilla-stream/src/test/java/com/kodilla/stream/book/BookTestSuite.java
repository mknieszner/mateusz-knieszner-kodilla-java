package com.kodilla.stream.book;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Test Suite for Book class.
 */
public class BookTestSuite {
    @Test
    public void testGetListUsingFor() {
        //Given
        final BookDirectory bookDirectory = new BookDirectory();

        //When
        final List<Book> books = bookDirectory.getList();

        //Then
        int numberOfBooksPublicatedAfter2007 = 0;
        for (final Book book : books) {
            if (book.getYearOfPublication() > 2007) {
                numberOfBooksPublicatedAfter2007++;
            }
        }
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void testGetListUsingIntStream() {
        //Given
        final BookDirectory bookDirectory = new BookDirectory();

        //When
        final List<Book> books = bookDirectory.getList();

        //Then
        final int numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .map(n -> 1)
                .sum();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }

    @Test
    public void testGetListUsingIntStreamTestCountFunc() {
        //Given
        final BookDirectory bookDirectory = new BookDirectory();

        //When
        final List<Book> books = bookDirectory.getList();

        //Then
        final long numberOfBooksPublicatedAfter2007 = IntStream.range(0, books.size())
                .filter(n -> books.get(n).getYearOfPublication() > 2007)
                .count();
        Assert.assertEquals(3, numberOfBooksPublicatedAfter2007);
    }
}