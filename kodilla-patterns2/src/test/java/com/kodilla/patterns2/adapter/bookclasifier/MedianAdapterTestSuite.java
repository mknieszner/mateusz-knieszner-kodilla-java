package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MedianAdapterTestSuite {
  @Autowired
  private MedianAdapter medianAdapter;

  @Test
  public void publicationYearMedianTest() {
    //Given
    final Set<Book> books = new HashSet<>();
    books.add(new Book("book1", "title1", 1, "sign1"));
    books.add(new Book("book2", "title2", 2, "sign2"));
    books.add(new Book("book3", "title3", 2, "sign3"));
    books.add(new Book("book4", "title4", 4, "sign4"));
    books.add(new Book("book5", "title5", 5, "sign5"));

    //When
    final int median = medianAdapter.publicationYearMedian(books);

    //Then
    assertEquals(2, median);
  }
}
