//package main.java;
//
//import java.util.Arrays;
//import java.util.Comparator;
//
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public abstract class SortStrategyUnitTester {
//
//	static Sorter mySorter;
//	static Comparable[] testData;
//	static Comparable[] testDataCopy;
//
//	protected boolean isSortedAsc(Comparable[] arr) {
//		boolean result = true;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (arr[i].compareTo(arr[i + 1]) > 0) {
//				result = false;
//				break;
//			}
//		}
//
//		return result;
//	}
//
//	protected boolean isSortedDesc(Comparable[] arr) {
//		boolean result = true;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (arr[i].compareTo(arr[i + 1]) < 0) {
//				result = false;
//				break;
//			}
//		}
//
//		return result;
//	}
//
//	protected boolean isSortedAsc(Comparable[] arr, Comparator comparator) {
//		boolean result = true;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (comparator.compare(arr[i], arr[i + 1]) > 0) {
//				result = false;
//				break;
//			}
//		}
//
//		return result;
//	}
//
//	protected boolean isSortedDesc(Comparable[] arr, Comparator comparator) {
//		boolean result = true;
//
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (comparator.compare(arr[i], arr[i + 1]) < 0) {
//				result = false;
//				break;
//			}
//		}
//
//		return result;
//	}
//
//	@BeforeClass
//	public static void initialSetUp() {
//		mySorter = new Sorter();
//
//		testData = new Integer[]{35, 2, 11, -50, 44, 10, 18, 5, 0, 22};
//	}
//
//	@Before
//	public void setup() {
//		testDataCopy = Arrays.copyOf(testData, testData.length);
//	}
//
//	@Test
//	abstract void testSortAscNoComparator();
//
//	@Test
//	abstract void testSortDescNoComparator();
//
//	@Test
//	abstract void testSortAscWithComparator();
//
//	@Test
//	abstract void testSortDescWithComparator();
//
//}
