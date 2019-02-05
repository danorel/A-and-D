package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getTitle().compareTo(secondBook.getTitle());
    }
}
