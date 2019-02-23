package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {
    @Override
    public int compare(Book first, Book second) {
        return first.compareTo(second);
    }
}
