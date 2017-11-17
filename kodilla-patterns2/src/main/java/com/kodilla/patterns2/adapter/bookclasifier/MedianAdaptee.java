package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Library Median Adaptee.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MedianAdaptee implements BookStatistics {
  private final Statistics statistics;

  @Override
  public int averagePublicationYear(final Map<BookSignature, Book> books) {
    return statistics.averagePublicationYear(books);
  }

  @Override
  public int medianPublicationYear(final Map<BookSignature, Book> books) {
    return statistics.medianPublicationYear(books);
  }
}
