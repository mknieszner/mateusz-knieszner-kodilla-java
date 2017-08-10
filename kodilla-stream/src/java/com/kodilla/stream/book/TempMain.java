package com.kodilla.stream.book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TempMain {
    //public static void main(String[] args)
    {
        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);
    }
}