package TestCase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		// Invoked each time a test fails.
		System.out.println("****Testcase fail****" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		// Invoked each time a test succeeds.
		System.out.println("****Testcase pass****" + result.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		// Invoked each time before a test will be invoked.
		System.out.println("****Testcase started****" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// Invoked each time a test is skipped.
		System.out.println("****Testcase skipped****" + result.getName());
	}

	public void onFinish​(ITestContext context) {
		// Invoked after all the test methods belonging to the classes inside the <test>
		// tag have run and all their Configuration methods have been called.
		System.out.println("****AllTestCases Completed****" + context.getName());
	}

	@Override
	public void onStart(ITestContext context) {

		// Invoked before running all the test methods belonging to the classes inside
		// the <test> tag and calling all their Configuration methods.
		System.out.println("****AllTestCases started****" + context.getName());
	}

	public void onTestFailedButWithinSuccessPercentage​(ITestResult result) {
		// Invoked each time a method fails but has been annotated with
		// successPercentage and this failure still keeps it within the success
		// percentage requested.

	}

	public void onTestFailedWithTimeout​(ITestResult result) {
		// Invoked each time a test fails due to a timeout.

	}
}
