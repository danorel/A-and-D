package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getAuthor().compareTo(secondBook.getAuthor());
    }
}
