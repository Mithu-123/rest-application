package testrunner.com;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junittest.com.TestAssertionsApi;

public class TestRunnerAssertionsApi {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestAssertionsApi.class);
		for (Failure failure : result.getFailures())
			System.out.println(failure.toString());

		System.out.println(result.wasSuccessful());
	}

}
