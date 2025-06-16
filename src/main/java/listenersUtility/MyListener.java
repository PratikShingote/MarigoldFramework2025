package listenersUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SkillioJava.Keywords;


public class MyListener implements ITestListener {

	Keywords key=new Keywords();
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			key.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			key.takeScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
