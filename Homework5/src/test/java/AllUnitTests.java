import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
				BubbleSortStrategyUnitTester.class,
				CombSortStrategyUnitTester.class,
				ComparedMergeSortStrategyUnitTester.class,
				DefaultQuickSortStrategyUnitTester.class,
				DefaultMergeSortStrategyUnitTester.class,
				DijkstraQuickSortStrategyUnitTester.class,
				HeapSortStrategyUnitTester.class,
				InsertionQuickSortStrategyUnitTester.class,
				InsertionMergeSortStrategyUnitTester.class,
				InsertionSortStrategyUnitTester.class,
				MixedQuickSortStrategyUnitTester.class,
				MixedMergeSortStrategyUnitTester.class,
				SelectionSortStrategyUnitTester.class,
				ShellSortStrategyUnitTester.class,

				SortStrategyUnitTester.class
})

public class AllUnitTests {

}
