package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	
      ExtentReports re; // to make it as global because it access on another method
      
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is started",true);// Reporter in an class present in testNg package it is used to send string massage to HTML report
		
		
	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is pass",true);
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//String failreason = result.getThrowable().toString();// it will give the reason why testScript is failed
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is failed",true);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is skip",true);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
	
		//Reporter.log("TestScript execution is started",true);
	JavaUtils jutil=new JavaUtils();
		
		
		//  to use ExtentSparkReporter class just to configure extent
	ExtentSparkReporter repoter = new ExtentSparkReporter("./extentReport/Report"+jutil.getRandomNumber()+".html");// object of extentSparkreporter and in constructor pass the path
          repoter.config().setDocumentTitle("Vitigercrm");
          repoter.config().setTheme(Theme.DARK);
          repoter.config().setReportName("ExampleITTest");
          
          // use extentReport to generate extentReport
          ExtentReports re=new ExtentReports();
          // call method  re.attachReporter(null); and pass  ExtentSparkReporter object reference variable
          re.attachReporter(repoter);
          // call  re.setSystemInfo()
          re.setSystemInfo("OS", "Window");
          re.setSystemInfo("Browser", "Chrome");
          re.setSystemInfo("Choreversion", "122");
          re.setSystemInfo("Auther", "Chetan");
	
	}
		
	

	public void onFinish(ITestContext context) {
		
		//Reporter.log("TestScript execution is finish",true);
		re.flush();
		
	}
	

}
