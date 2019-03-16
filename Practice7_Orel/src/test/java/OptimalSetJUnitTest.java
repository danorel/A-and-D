import org.junit.jupiter.api.*;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

class OptimalSetJUnitTest {

    private OptimalSet A, B, C;
    private static Integer[][] results =
            new Integer[8][100];

    @BeforeAll
    static void setUpResults(){
        results[0] = new Integer[]{5, 11};
        results[1] = new Integer[]{3, 5, 6, 11};
        results[2] = new Integer[]{3};
        results[3] = new Integer[]{5};
        results[4] = new Integer[]{1, 5, 6, 7};
        results[5] = new Integer[]{};
        results[6] = new Integer[]{1, 4, 5, 7};
        results[7] = new Integer[]{3, 5, 7};
    }

    @BeforeEach
    void setUp() {
        A = new OptimalSet("A");
        B = new OptimalSet("B");
        C = new OptimalSet("C");
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void insert() {
        A.insert(5, A);
        A.insert(11, A);
        Assertions.assertArrayEquals(results[0], A.getIntegerSet(A));
    }

    @Test
    void union() {
        A.insert(5, A);
        A.insert(11, A);
        B.insert(3, B);
        B.insert(6, B);
        C.union(A, B, C);
        Assertions.assertArrayEquals(results[1], C.getIntegerSet(C));
    }

    @Test
    void intersection() {
        A.insert(5, A);
        A.insert(3, A);
        B.insert(3, B);
        B.insert(6, B);
        C.intersection(A, B, C);
        Assertions.assertArrayEquals(results[2], C.getIntegerSet(C));
    }

    @Test
    void difference() {
        A.insert(5, A);
        A.insert(1, A);
        B.insert(1, B);
        B.insert(6, B);
        C.difference(A, B, C);
        Assertions.assertArrayEquals(results[3], C.getIntegerSet(C));
    }

    @Test
    void merge() {
        A.insert(5, A);
        A.insert(1, A);
        B.insert(7, B);
        B.insert(6, B);
        C.merge(A, B, C);
        Assertions.assertArrayEquals(results[4], C.getIntegerSet(C));
    }

    @Test
    void makeNull() {
        A.insert(5, A);
        A.insert(1, A);
        A.makeNull(A);
        Assertions.assertArrayEquals(results[5], A.getIntegerSet(A));
    }

    @Test
    void member() {
        A.insert(5, A);
        A.insert(1, A);
        Assertions.assertArrayEquals(new boolean[]{true}, new boolean[]{ A.member(1, A) });
    }

    @Test
    void delete() {
        A.insert(5, A);
        A.insert(1, A);
        A.insert(3, A);
        A.insert(4, A);
        A.insert(7, A);
        A.delete(3, A);
        Assertions.assertArrayEquals(results[6], A.getIntegerSet(A));
    }

    @Test
    void assign() {
        A.insert(5, A);
        A.insert(7, A);
        A.insert(3, A);
        B.assign(B, A);
        Assertions.assertArrayEquals(results[7], B.getIntegerSet(B));
    }

    @Test
    void min() {
        A.insert(75, A);
        A.insert(72, A);
        A.insert(43, A);
        Assertions.assertEquals(43, (int )A.min(A));
    }

    @Test
    void max() {
        A.insert(75, A);
        A.insert(72, A);
        A.insert(43, A);
        Assertions.assertEquals(75, (int) A.max(A));
    }

    @Test
    void equal() {
        A.insert(43, A);
        A.insert(72, A);
        A.insert(75, A);
        B.insert(43, B);
        B.insert(72, B);
        B.insert(75, B);
        Assertions.assertEquals(Arrays.toString(A.getIntegerSet(A)), Arrays.toString(B.getIntegerSet(B)));
    }

    @Test
    void find() {
        A.insert(75, A);
        A.insert(72, A);
        A.insert(43, A);
        B.insert(5, B);
        B.insert(11, B);
        C.insert(3, C);
        C.insert(6, C);
        Assertions.assertEquals("C", new OptimalSet("D").find(new OptimalSet[]{A, B, C}, 6));
    }
}