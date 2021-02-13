package frameworkLibrary;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import applicationPages.BasePage;

public class BaseClass extends BasePage
{
	public static LinkedHashMap<String, Boolean> allTestItems = new LinkedHashMap<String, Boolean>();
	public static int currentIteration = 0;
	@BeforeSuite
	public void beforesuite()
	{
		CreateNewExtentReportInResultsFolderWithDateAndTimeStamp();
	}
	
	@BeforeMethod
	public void beforemethod(ITestContext context)
	{
		//get all test methods and store in the form of key and value pairs, with key = ModuleName+MethodName+InvocationNumber and Value = isExecuted
		for(ITestNGMethod testMethod:context.getAllTestMethods())
		{
			String moduleName = testMethod.getTestClass().getRealClass().getSimpleName();
			String testMethodName = testMethod.getMethodName();
			int totalIterations = testMethod.getInvocationCount();
			for(int iteration = 1;iteration<=totalIterations;iteration++)
			{
				String key = moduleName + ";;" + testMethodName + ";;" + iteration;
				if(!allTestItems.containsKey(key))
				{
					allTestItems.put(key, false);
				}
			}
		}

		//get the key of the next method which is about to execute
		String currentKey = null;
		for(String key:allTestItems.keySet())
		{
			if(allTestItems.get(key)==false)
			{
				currentKey = key;
				allTestItems.put(key, true);
				break;
			}
		}
		
		if(currentKey==null) return;
		
		//from the current key, get current modulename,testname,invocation count
		String currentModuleName = currentKey.split(";;")[0];
		String currentTestMethodName = currentKey.split(";;")[1];
		String currentInvocationCount = currentKey.split(";;")[2];
		
		currentIteration = Integer.parseInt(currentInvocationCount);
		
		FrameworkVariables.getInstance().setCurrentTestCaseName(currentTestMethodName);
		FrameworkVariables.getInstance().setCurrentModuleName(currentModuleName);
		FrameworkVariables.getInstance().setDataFilesPath(FrameworkVariables.getInstance().getCurrentFolderPath() + "\\DataFiles");
		FrameworkVariables.getInstance().setCurrentTestData();
		
		loadDataFromExceltoHashMap(currentIteration);
		
		startExtentTestForCurrentTestCase(currentIteration);
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result,ITestContext testmethod)
	{
		endExtentTestForCurrentTestCase();
		loadDataFromHashMaptoExcel(currentIteration);
	}
	
	@AfterSuite
	public void aftersuite() throws IOException
	{
		closeExtentReport();
		BackupFile(FrameworkVariables.getInstance().getCurrentModuleName(), FrameworkVariables.getInstance().getCurrentModuleName()+"_TestBackupFile");
		launchResult();
	}
}
