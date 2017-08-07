package com.kodilla.testing.library;

/**
 * Class represents Library Books.
 */
public class Book {
    private final String title;
    private final String author;
    private final int publicationYear;

    public Book(final String title, final String author, final int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', "
                + "author='%s', publicationYear=%d}", title, author, publicationYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (publicationYear != book.publicationYear) {
            return false;
        }
        if (!title.equals(book.title)) {
            return false;
        }
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publicationYear;
        return result;
    }
}
