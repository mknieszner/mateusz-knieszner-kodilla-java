package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents library.
 */
public final class Library extends Prototype {
  private final String name;
  private Set<Book> books = new HashSet<>();

  public Library(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addBook(final Book book) {
    books.add(book);
  }

  public Set<Book> getBooks() {
    return Collections.unmodifiableSet(books);
  }

  public Library shallowCopy() throws CloneNotSupportedException {
    return (Library) super.clone();
  }

  public Library deepCopy() throws CloneNotSupportedException {
    final Library clonedLibrary = (Library) super.clone();
    clonedLibrary.books = new HashSet<>(books);
    return clonedLibrary;
  }
}