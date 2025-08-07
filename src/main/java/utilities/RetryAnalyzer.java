package utilities;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryAnalyzer implements IRetryAnalyzer{

    private int count = 0;
    private final int maxRetry = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetry) {
            count++;
            System.out.println("Retrying test " + result.getName() + " for the " + count + " time.");
            return true;
        }
        return false;
    }
}
