package lab2;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@IncludeCategory(SmokeTests.class)
@SuiteClasses(TestLab2.class)
public class SuiteTestLab2 {
	
}
