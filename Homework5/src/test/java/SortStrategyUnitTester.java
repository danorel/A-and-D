import movie.*;
import algorithms.*;
import algorithms.merge.ComparedMergeSort;
import algorithms.merge.DefaultMergeSort;
import algorithms.merge.InsertionMergeSort;
import algorithms.merge.MixedMergeSort;
import algorithms.quick.DefaultQuickSort;
import algorithms.quick.DijkstraQuickSort;
import algorithms.quick.InsertionQuickSort;
import algorithms.quick.MixedQuickSort;
import org.junit.*;

import java.util.ArrayList;
import java.util.Comparator;

public class SortStrategyUnitTester {
	private Movie[] albums;
	private ArrayList<Sort> sorts;
	private ArrayList<Comparator> comparators;

	@Before
	public void defineTestingData(){
		sorts = new ArrayList<>();
		sorts.add(new BubbleSort());
		sorts.add(new CombSort());
		sorts.add(new HeapSort());
		sorts.add(new InsertionSort());
		sorts.add(new SelectionSort());
		sorts.add(new ShellSort());
		sorts.add(new DefaultMergeSort());
		sorts.add(new ComparedMergeSort());
		sorts.add(new InsertionMergeSort());
		sorts.add(new MixedMergeSort());
		sorts.add(new DefaultQuickSort());
		sorts.add(new DijkstraQuickSort());
		sorts.add(new InsertionQuickSort());
		sorts.add(new MixedQuickSort());

		comparators = new ArrayList<>();
		comparators.add(new MovieTitleComparator());
		comparators.add(new MovieDirectorComparator());
		comparators.add(new MovieDurationComparator());
		comparators.add(new MovieProfitComparator());

		albums = new Movie[5];
		albums[0] = new Movie("B", "Y", 3.41, 99.99);
		albums[1] = new Movie("A", "A", 1.51, 67.99);
		albums[2] = new Movie("P", "W", 31.90, 45.99);
		albums[3] = new Movie("U", "G", 6.45, 85.99);
		albums[4] = new Movie("F", "C", 5.15, 13.99);
	}

	@Test
	public void setSortStrategy(){
		Strategy strategy = new Strategy();
		for(Sort sort : sorts){
			strategy.setSortStrategy(sort);
		}
	}

	@Test
	public void sortArray(){
		Strategy defaultStrategy = new Strategy();
		defaultStrategy.setSortStrategy(new HeapSort());
		Strategy strategy = new Strategy();
		for(Sort sort : sorts){
			strategy.setSortStrategy(sort);
			for(Comparator comparator : comparators){
				Assert.assertEquals(defaultStrategy.sortArray(albums, comparator), strategy.sortArray(albums, comparator));
			}
		}
	}
}
