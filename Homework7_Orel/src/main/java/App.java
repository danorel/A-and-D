import library.Book;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        OptimalSet<Integer> A = new OptimalSet<>("A");
        A.insert(6, A);
        A.insert(10, A);

        OptimalSet<Integer> B = new OptimalSet<>("B");
        B.insert(5, B);
        B.insert(11, B);

        OptimalSet<Integer> C = new OptimalSet<>("C");
        C.intersection(A, B, C);
        System.out.println(Arrays.toString(C.getSet().getArrayFromList()));

        OptimalSet<Integer> D = new OptimalSet<>("D");
        D.union(A, B, D);
        System.out.println(Arrays.toString(D.getSet().getArrayFromList()));

        OptimalSet<Integer> E = new OptimalSet<>("E");
        E.difference(A, B, E);
        System.out.println(Arrays.toString(E.getSet().getArrayFromList()));

        OptimalSet<Integer> F = new OptimalSet<>("F");
        F.merge(A, B, F);
        System.out.println(Arrays.toString(F.getSet().getArrayFromList()));

        OptimalSet<Integer> G = new OptimalSet<>("G");
        G.union(A, B, G);
        G.makeNull(G);
        System.out.println(Arrays.toString(G.getSet().getArrayFromList()));

        OptimalSet<Integer> H = new OptimalSet<>("H");
        H.union(A, A, H);
        H.delete(5, H);
        System.out.println(Arrays.toString(H.getSet().getArrayFromList()));

        OptimalSet<Integer> I = new OptimalSet<>("I");
        I.assign(I, D);
        System.out.println(Arrays.toString(I.getSet().getArrayFromList()));

        System.out.println("Smallest element in set " + I + " is " + I.min(I));
        System.out.println("Biggest element in set " + I + " is " + I.max(I));

        System.out.println("Are sets " + I + " and " + D + " equal? Answer: " + I.equal(I, D));

        System.out.println(I.find(
                new OptimalSet[]{A, B, G}, 12
        ) + " set contains the element 12");

        System.out.println(I.showSetVariables(I));

        /*
        System.out.println();
        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.appendArrayToList(new Integer[]{5, 7, 1, 3});
        integers.restructureList();
        integers.showDoublyLinkedList();
        */

        /*
        OptimalSet<Book> bookSet = new OptimalSet<>("BookSet");
        bookSet.insert(new Book("Show me the Truth!", "Daniel Orel", 54.55, 4.93), bookSet);
        bookSet.insert(new Book("Catch me, if you can!", "Olia Perch", 59.45, 4.97), bookSet);
        */
    }
}
