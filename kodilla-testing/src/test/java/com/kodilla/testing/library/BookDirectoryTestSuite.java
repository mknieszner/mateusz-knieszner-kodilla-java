package com.kodilla.testing.library;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * BookDirectoryTestSuite.
 */
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(
                anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition(
                "ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition(
                "FourtyBooks")).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksInHandsOftest() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultUserInHandsBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultUserInHandsBooks.add(book1);
        resultUserInHandsBooks.add(book2);
        resultUserInHandsBooks.add(book3);
        resultUserInHandsBooks.add(book4);
        LibraryUser user = new LibraryUser("M", "K", "1");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultUserInHandsBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user);

        // Then
        assertEquals(4, theListOfBooks.size());
    }


    @Test
    public void testList5BooksInHandsOfMock() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf5Books = generateListOfNBooks(5);
        LibraryUser user = new LibraryUser("A", "A", "1");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultListOf5Books);
        // When
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(user);
        // Then
        assertEquals(5, theListOfBooks5.size());
    }

    @Test
    public void testListZeroBooksInHandsOfMock() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = generateListOfNBooks(0);
        LibraryUser user = new LibraryUser("A", "A", "1");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultListOf0Books);
        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(user);
        // Then
        assertEquals(0, theListOfBooks0.size());
    }

    @Test
    public void testListOneBooksInHandsOfMock() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf1Books = generateListOfNBooks(1);
        LibraryUser user = new LibraryUser("B", "B", "2");
        when(libraryDatabaseMock.listBookInHandsOf(user)).thenReturn(resultListOf1Books);
        // When
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(user);
        // Then
        assertEquals(1, theListOfBooks1.size());
    }


    @Test
    public void testListFiveBooksInHandsOf() {
        //Given
        LibraryDatabase libraryDatabase = new TheLibraryDatabase(generateListOfNBooks(0));
        LibraryUser user1 = new LibraryUser("A", "A", "1");
        Book theBook = new Book("Title", "Author ", 1970);
        libraryDatabase.rentABook(user1, theBook);
        libraryDatabase.rentABook(user1, theBook);
        libraryDatabase.rentABook(user1, theBook);
        libraryDatabase.rentABook(user1, theBook);
        libraryDatabase.rentABook(user1, theBook);
        //When
        List<Book> theListOfBooks0 = libraryDatabase.listBookInHandsOf(user1);
        //Then
        assertEquals(5, theListOfBooks0.size());
    }


    @Test
    public void testListOneBooksInHandsOf() {
        //Given
        LibraryDatabase libraryDatabase = new TheLibraryDatabase(generateListOfNBooks(0));
        LibraryUser user1 = new LibraryUser("A", "A", "1");
        Book theBook = new Book("Title", "Author ", 1970);
        libraryDatabase.rentABook(user1, theBook);
        //When
        List<Book> theListOfBooks0 = libraryDatabase.listBookInHandsOf(user1);
        //Then
        assertEquals(1, theListOfBooks0.size());
    }

    @Test
    public void testListZeroBooksInHandsOf() {
        //Given
        LibraryDatabase libraryDatabase = new TheLibraryDatabase(generateListOfNBooks(0));
        LibraryUser user1 = new LibraryUser("A", "A", "1");
        //When
        List<Book> theListOfBooks0 = libraryDatabase.listBookInHandsOf(user1);
        //Then
        assertEquals(0, theListOfBooks0.size());
    }
}
