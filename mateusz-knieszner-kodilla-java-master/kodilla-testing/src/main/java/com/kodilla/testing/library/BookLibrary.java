package com.kodilla.testing.library;

import java.util.*;

/**
 * BookLibrary.
 */
public class BookLibrary {
    private final LibraryDatabase libraryDatabase;

    public BookLibrary(final LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(final String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) {
            return bookList;
        }
        final List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) {
            return bookList;
        }
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(final LibraryUser libraryUser) {
        return libraryDatabase.listBookInHandsOf(libraryUser);
    }
}