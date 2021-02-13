package testScripts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationPages.ApplicationStatusPage;
import applicationPages.DLModule;
import applicationPages.Flows;
import applicationPages.LLModule;
import applicationPages.NewDLSubmissionPage;
import frameworkLibrary.BaseClass;

public class TestGeneric extends BaseClass {

	WebDriver driver;
	LLModule llmodule;
	Flows validate;
	ApplicationStatusPage appstatus;
	NewDLSubmissionPage NewDLSubmissionPage;
	DLModule dl;

	@BeforeMethod
	public void Predatacheck() throws IOException {
		loaddata();
		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.addArguments("use-fake-device-for-media-stream");
		capability.addArguments("use-fake-ui-for-media-stream");
		capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT_AND_NOTIFY);
		Map<String, Object> preferences = new Hashtable<String, Object>();
		capability.setExperimentalOption("prefs", preferences);
		preferences.put("plugins.always_open_pdf_externally", true);
		driver = new ChromeDriver(capability);
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			driver.get(prop.getProperty("SarathiCOV"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to SarathiCOV");
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			driver.get(prop.getProperty("SarathiProd"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to Sarathiprod");
		} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
			driver.get(prop.getProperty("CAS_SarathiCOV"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to CAS_SarathiCOV");
		} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
			driver.get(prop.getProperty("CAS_SarathiProd"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Welcome to CAS_SarathiProd");
		} else {
			System.out.println("Application URL is not matched.Please try again");
		}

	}

	@Test(invocationCount = 1)
	public void TC01() throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		llmodule = new LLModule(driver);
		llmodule.ArrangeDataSet();
		llmodule.SelectState();
		llmodule.Initiate_Process();
		llmodule.Validating_Flows();
	}

	@Test(invocationCount = 1, dependsOnMethods = { "TC01" })
	public void TC02() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		dl = new DLModule(driver);
		dl.selectState();
		dl.Initiating_DL();
		dl.Validating_Flows();

	}

	@Test(invocationCount = 1,dependsOnMethods = { "TC01","TC02" })
	public void TC03() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		llmodule = new LLModule(driver);
		llmodule.ArrangeDataSet();
		llmodule.Submit_LLBacklog();

	}

	@Test(invocationCount = 1, dependsOnMethods = { "TC01","TC02","TC03" })
	public void TC04() throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		llmodule = new LLModule(driver);
		llmodule.ArrangeDataSet();
		llmodule.SelectState();
		llmodule.Initiate_Process();
		llmodule.Validating_Flows();
	}

	@Test(invocationCount = 1,dependsOnMethods = {"TC04" })
	public void TC05() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		dl = new DLModule(driver);
		dl.Initiating_DLBacklog();

	}

	@Test(invocationCount = 1, dependsOnMethods = { "TC05" })
	public void TC06() throws ClassNotFoundException, IOException, SQLException, InterruptedException {
		llmodule = new LLModule(driver);
		llmodule.ArrangeDataSet();
		llmodule.SelectState();
		llmodule.Initiate_Process();
		llmodule.Validating_Flows();
	}

	/*@Test(invocationCount = 1, dependsOnMethods = { "TC06" })
	public void TC07() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		dl = new DLModule(driver);
		dl.selectState();
		dl.Validate_Service();

	}*/

	@AfterMethod
	public void CloseBrowser() {
		System.out.println("**************After Method***************");
		quitdriver(driver);
	}

}
