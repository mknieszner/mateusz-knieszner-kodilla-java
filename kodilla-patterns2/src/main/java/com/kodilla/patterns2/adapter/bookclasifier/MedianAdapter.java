package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.company.newhrsystem.Employee;

import java.math.BigDecimal;
import java.util.*;

/**
 * Library Median Adapter.
 */
public class MedianAdapter extends MedianAdaptee implements Classifier {

  @Override
  public int publicationYearMedian(final Set<Book> oldBookSet) {
    final Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> newBookMap = new HashMap<>();
    oldBookSet.stream().forEach(oldBook -> newBookMap.put(
        new BookSignature(oldBook.getSignature()),
        new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(oldBook.getAuthor(), oldBook.getTitle(), oldBook.getPublicationYear())));
    return medianPublicationYear(newBookMap);
  }
}