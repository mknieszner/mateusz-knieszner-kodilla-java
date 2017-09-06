package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Before;
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
  public void testShallowCopy() {
    //Given
    library = new Library("Base Library");
    library.addBook(new Book("Den vita lejoninnan", "Henning Mankell",
        LocalDate.of(1993, 12, 31)));
    library.addBook(new Book("Luftslottet som sprängdes", "Stieg Larsson",
        LocalDate.of(2007, 12, 31)));

    //When
    try {
      shallowClonedLibrary = library.shallowCopy();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    library.addBook(new Book("Det som inte dödar oss", "David Lagercrantz",
        LocalDate.of(2015, 12, 31)));
    final int shallowCopyTestResult = shallowClonedLibrary.getBooks().size();
    final int expectedResult = 3;

    //Then
    Assert.assertEquals(expectedResult, shallowCopyTestResult);
  }

  @Test
  public void testDeepCopy() {
    //Given
    library = new Library("Base Library");
    library.addBook(new Book("Nattfak ", "Johan Theorin",
        LocalDate.of(2007, 12, 31)));

    //When
    try {
      deepClonedLibrary = library.deepCopy();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    library.addBook(new Book("Se deg ikke tilbake!", "Karin Fossum",
        LocalDate.of(1995, 1, 1)));
    final int deepCopyTestResult = deepClonedLibrary.getBooks().size();
    final int expectedResult = 1;

    //Then
    Assert.assertEquals(expectedResult, deepCopyTestResult);
  }
}
