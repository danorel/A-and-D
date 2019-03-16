import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        OptimalSet A = new OptimalSet("A");
        A.insert(5, A);
        A.insert(54, A);

        OptimalSet B = new OptimalSet("B");
        B.insert(11, B);
        B.insert(15, B);

        OptimalSet C = new OptimalSet("C");
        C.insert(1, C);
        System.out.println(C.find(new OptimalSet[]{A, B, C}, 1));
        C.union(A, B, C);

        System.out.println(C.getSetLength(C));
        System.out.println(Arrays.toString(C.getIntegerSet(C)));
    }
}
