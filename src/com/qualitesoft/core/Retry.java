package com.qualitesoft.core;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private int maxRetryCount = 0;

	@Override
	public boolean retry(ITestResult result) {

		if (InitializeTest.retryCount != null) {
			maxRetryCount = Integer.parseInt(InitializeTest.retryCount);
		}

		if (retryCount < maxRetryCount) {
			ScreenShot.takeScreenShotOnFailure("TestSkipped");
			Log.info("============================================================================");
			Log.info("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus())
					+ " for the " + (retryCount + 1) + " time(s).");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
}
