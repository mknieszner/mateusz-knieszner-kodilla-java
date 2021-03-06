package com.kodilla.stream.book;

import java.util.stream.Collectors;

/**
 * Temporary test class.
 */
public class TempMain {
    //public static void main(String[] args)
    {
        final BookDirectory theBookDirectory = new BookDirectory();
        final String theResultStringOfBooks = theBookDirectory
                .getList()
                .stream()
                .filter(book -> book.getYearOfPublication()
                        > 2005).map(Book::toString)
                .collect(Collectors.joining(",\n", "<<", ">>"));

        System.out.println(theResultStringOfBooks);
    }
}