package books.comparators;

import books.Book;

import java.util.Comparator;

public class BookPageComparator implements Comparator<Book> {
    public int compare(Book firstBook, Book secondBook) {
        return firstBook.getPages() - secondBook.getPages();
    }
}
