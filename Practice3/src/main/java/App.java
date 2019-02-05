import books.Book;
import books.comparators.*;
import sorter.Sorter;

public class App {
    public static void main(String[] args) {
        Integer[] ints = {15, -4, 0, 3, 5, -18};
        Sorter<Integer> integerSorter = new Sorter<Integer>();
        integerSorter.setArray(ints).quickSort(0, ints.length - 1).showArray();
//
//        Book[] books = new Book[3];
//        books[2] = new Book().setTitle("Forever").setAuthor("Daniel").setPages(244).setPrice(49.99);
//        books[1] = new Book().setTitle("Hero").setAuthor("Chatoux Bordeux").setPages(1329).setPrice(87.49);
//        books[0] = new Book().setTitle("Love is...").setAuthor("Olia").setPages(749).setPrice(124.99);
//        Sorter<Book> bookSorter = new Sorter<Book>();
//        bookSorter.setComparator(new BookPageComparator()).setArray(books).quickSort(0, 2);
//        bookSorter.showArray();
    }
}
