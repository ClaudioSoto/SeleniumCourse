package SeleniumFrameworkDesign.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed implements IRetryAnalyzer {
	
	public int count = 0;
	public int maxTry = 2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count < maxTry) {
			//try again
			count++;
			return true;
		}
		return false;
	}

}
