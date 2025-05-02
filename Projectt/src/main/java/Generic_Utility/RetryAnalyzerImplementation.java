package Generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{

	int count=0;
	int retryCount=4;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retryCount)
		{
			count++;
			return true;
		}
		return false;
	}

}
