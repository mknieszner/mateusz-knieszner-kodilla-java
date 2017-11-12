package com.kodilla.testing.library;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * BookDirectoryTestSuite.
 */
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(final int booksQuantity) {
        final List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            final Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultListOf0Books = new ArrayList<Book>();
        final List<Book> resultListOf15Books = generateListOfNBooks(15);
        final List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(
                anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition(
                "ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition(
                "FourtyBooks")).thenReturn(resultListOf40Books);

        // When
        final List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        final List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        final List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultListOfBooks = new ArrayList<Book>();
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        final Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        final Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        final List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksInHandsOftest() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultUserInHandsBooks = new ArrayList<Book>();
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        final Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        final Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultUserInHandsBooks.add(book1);
        resultUserInHandsBooks.add(book2);
        resultUserInHandsBooks.add(book3);
        resultUserInHandsBooks.add(book4);
        final LibraryUser user = new LibraryUser("M", "K", "1");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultUserInHandsBooks);

        // When
        final List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(4, theListOfBooks.size());
    }


    @Test
    public void testList5BooksInHandsOfMock() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultListOf5Books = generateListOfNBooks(5);
        final LibraryUser user = new LibraryUser("A", "A", "1");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultListOf5Books);

        // When
        final List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(5, theListOfBooks5.size());
    }

    @Test
    public void testListZeroBooksInHandsOfMock() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final LibraryUser user = new LibraryUser("A", "A", "1");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(Collections.emptyList());

        // When
        final List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(0, theListOfBooks0.size());
    }

    @Test
    public void testListOneBooksInHandsOfMock() {
        // Given
        final LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        final BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        final List<Book> resultListOf1Books = generateListOfNBooks(1);
        final LibraryUser user = new LibraryUser("B", "B", "2");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultListOf1Books);

        // When
        final List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(1, theListOfBooks1.size());
    }


    @Test
    public void testListFiveBooksInHandsOf() {
        //Given
        final LibraryDatabase libraryDatabase = new LibraryDatabaseImpl(Collections.emptyList());
        final LibraryUser user1 = new LibraryUser("A", "A", "1");
        libraryDatabase.rentABook(user1, new Book("Title A", "Author A", 1970));
        libraryDatabase.rentABook(user1, new Book("Title B", "Author A", 1971));
        libraryDatabase.rentABook(user1, new Book("Title C", "Author A", 1972));
        libraryDatabase.rentABook(user1, new Book("Title E", "Author A", 1973));
        libraryDatabase.rentABook(user1, new Book("Title F", "Author A", 1974));
        //When
        final List<Book> theListOfBooks0 = libraryDatabase.listBookInHandsOf(user1);
        //Then
        assertEquals(5, theListOfBooks0.size());
    }


    @Test
    public void testListOneBooksInHandsOf() {
        //Given
        final LibraryDatabase libraryDatabase = new LibraryDatabaseImpl(Collections.emptyList());
        final LibraryUser user1 = new LibraryUser("A", "A", "1");
        final Book theBook = new Book("Title", "Author ", 1970);
        libraryDatabase.rentABook(user1, theBook);
        //When
        final List<Book> theListOfBooks0 = libraryDatabase.listBookInHandsOf(user1);
        //Then
        assertEquals(1, theListOfBooks0.size());
    }

    @Test
    public void testListZeroBooksInHandsOf() {
        //Given
        final LibraryDatabase libraryDatabase = new LibraryDatabaseImpl(Collections.emptyList());
        final LibraryUser user1 = new LibraryUser("A", "A", "1");
        //When
        final List<Book> theListOfBooks0 = libraryDatabase.listBookInHandsOf(user1);
        //Then
        assertEquals(0, theListOfBooks0.size());
    }
}
