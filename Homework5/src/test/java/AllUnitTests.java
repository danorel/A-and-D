import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BubbleSortStrategyUnitTester.class,
				CombSortStrategyUnitTester.class,
				InsertionSortStrategyUnitTester.class,
				SelectionSortStrategyUnitTester.class,
				ShellSortStrategyUnitTester.class,
				HeapSortStrategyUnitTester.class,
				ComparedMergeSortStrategyUnitTester.class,
				DefaultMergeSortStrategyUnitTester.class,
				InsertionSortStrategyUnitTester.class,
//				MixedMergeSortStrategyUnitTester.class,
				DefaultQuickSortStrategyUnitTester.class,
				DijkstraQuickSortStrategyUnitTester.class,
				InsertionQuickSortStrategyUnitTester.class,
				MixedQuickSortStrategyUnitTester.class,
				StrategyUnitTester.class
			})

public class AllUnitTests {

}
