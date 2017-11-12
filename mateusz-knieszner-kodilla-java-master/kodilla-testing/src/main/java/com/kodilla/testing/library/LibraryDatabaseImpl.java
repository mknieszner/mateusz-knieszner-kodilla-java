package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Default implementation of LibraryDatabase interface.
 */
public class LibraryDatabaseImpl implements LibraryDatabase {
    private List<Book> libraryBooks = new ArrayList<>();
    private Map<LibraryUser, List<Book>> rentedBooks = new HashMap<>();

    public LibraryDatabaseImpl(final List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    @Override
    public List<Book> listBooksWithCondition(final String titleFragment) {
        final List<Book> returnList = new ArrayList<Book>();
        for (final Book book : libraryBooks) {
            if (book.getTitle().contains(titleFragment)) {
                returnList.add(book);
            }
        }
        return returnList;
    }

    @Override
    public List<Book> listBookInHandsOf(final LibraryUser libraryUser) {
        for (final Map.Entry<LibraryUser, List<Book>> entry : rentedBooks.entrySet()) {
            if (entry.getKey().equals(libraryUser)) {
                return entry.getValue();
            }
        }
        return new ArrayList<>();
    }

    @Override
    public boolean rentABook(final LibraryUser libraryUser, final Book book) {
        for (final Map.Entry<LibraryUser, List<Book>> entry : rentedBooks.entrySet()) {
            if (entry.getKey().equals(libraryUser)) {
                entry.getValue().add(book);
                return true;
            }
        }
        rentedBooks.put(libraryUser, new ArrayList<Book>());
        rentABook(libraryUser, book);
        return true;
    }

    @Override
    public int returnBooks(final LibraryUser libraryUser) {
        int returnedBooksCount = 0;

        for (final Map.Entry<LibraryUser, List<Book>> entry : rentedBooks.entrySet()) {
            if (entry.getKey().equals(libraryUser)) {
                returnedBooksCount = entry.getValue().size();
                entry.setValue(new ArrayList<>());
                return returnedBooksCount;
            }
        }
        return returnedBooksCount;
    }
}
