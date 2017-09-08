package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Test suite for Library class.
 */
public class LibraryTestSuite {
  private Library library;
  private Library shallowClonedLibrary;
  private Library deepClonedLibrary;

  @Test
  public void testShallowCopy() throws CloneNotSupportedException {
    //Given
    library = new Library("Base Library");
    library.addBook(new Book("Den vita lejoninnan", "Henning Mankell",
        LocalDate.of(1993, 12, 31)));

    //When
    shallowClonedLibrary = library.shallowCopy();
    library.addBook(new Book("Luftslottet som sprängdes", "Stieg Larsson",
        LocalDate.of(2007, 12, 31)));

    //Then
    Assert.assertTrue(library.getBooks().equals(shallowClonedLibrary.getBooks()));
  }

  @Test
  public void testDeepCopy() throws CloneNotSupportedException {
    //Given
    library = new Library("Base Library");
    library.addBook(new Book("Nattfak ", "Johan Theorin",
        LocalDate.of(2007, 12, 31)));

    //When
    deepClonedLibrary = library.deepCopy();
    library.addBook(new Book("Se deg ikke tilbake!", "Karin Fossum",
        LocalDate.of(1995, 1, 1)));

    //Then
    Assert.assertFalse(library.getBooks().equals(deepClonedLibrary.getBooks()));
  }

  @Test
  public void testEqualListDeepCopy() throws CloneNotSupportedException {
    //Given
    final Book book = new Book("Nattfak ", "Johan Theorin",
        LocalDate.of(2007, 12, 31));
    library = new Library("Base Library");

    //When
    deepClonedLibrary = library.deepCopy();
    library.addBook(book);
    deepClonedLibrary.addBook(book);
    System.out.println(library.getBooks().hashCode());
    System.out.println(deepClonedLibrary.getBooks().hashCode());

    //Then
    Assert.assertTrue(library.getBooks().equals(deepClonedLibrary.getBooks()));
  }

  @Test
  public void testEmptyListDeepCopy() throws CloneNotSupportedException {
    //Given
    library = new Library("Base Library");

    //When
    deepClonedLibrary = library.deepCopy();
    System.out.println(library.getBooks().hashCode());
    System.out.println(deepClonedLibrary.getBooks().hashCode());

    //Then
    Assert.assertTrue(library.getBooks().equals(deepClonedLibrary.getBooks()));
  }

}
