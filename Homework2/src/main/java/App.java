public class App {
    public static void main(String[] args) {
        // Integer array
        Integer []ints = {5, 4, -5, 15, -1, 0};
        Sorter<Integer> sorter = new Sorter<Integer>();
        sorter.setArray(ints).brushSort().showArray();

        System.out.println();

        // Album array
        Album []albums = new Album[3];
        albums[0] = new Album();
        albums[0].setTitle("Hello, June!").setDirector("Daniel Orel").setPrice(500.99);
        albums[1] = new Album();
        albums[1].setTitle("Ohh, March!").setDirector("Oliver Koletzki").setPrice(123.49);
        albums[2] = new Album();
        albums[2].setTitle("My dear").setDirector("Olia Perch").setPrice(999.99);
        Sorter<Album> albumSorter = new Sorter<Album>();
        albumSorter.setArray(albums).insertionSort().showArray();
    }
}
