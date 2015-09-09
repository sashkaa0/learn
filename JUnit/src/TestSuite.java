 
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
 
/*
* This is a test suite class that we will create to run all our tests
* Follow along to see how its done Pay special attention to annotations
*/
 
@RunWith(Suite.class)
@Suite.SuiteClasses({
      JunitMathProvider_1.class,
      JunitMathProvider_2.class
         })
 
public class TestSuite {
 
}