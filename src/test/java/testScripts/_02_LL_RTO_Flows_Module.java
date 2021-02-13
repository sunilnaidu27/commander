package testScripts;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import applicationPages.ScrutinyPage;
import applicationPages.CapturebiometricsPage;
import applicationPages.LLTestResultsPage;
import applicationPages.LLApprovalbatch;
import frameworkLibrary.BaseClass;

public class _02_LL_RTO_Flows_Module extends BaseClass {
	WebDriver driver;
	ScrutinyPage Login_ScrutinyPage;
	CapturebiometricsPage CapturebiometricsPage;
	LLTestResultsPage LLTestResultsPage;
	LLApprovalbatch LLApprovalbatch;

	/*
	 * New LL RTO Side flows Covered in this Module To do Scrutiny for New LL
	 * Application We have to Run TC101 Test Case. To Run Single Application we have
	 * to give invocationCount = 1 for multiple Applications invocationCount should
	 * be user defined iteration number.
	 */

	@Test(invocationCount = 9)
	public void TC101() {
		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://s4preprod.nic.in:8443/sarathiservice/stateSelectBean.do");
		driver.manage().window().maximize();
		Login_ScrutinyPage = new ScrutinyPage(driver);

		Login_ScrutinyPage.Clickon_Login_Button();
		Login_ScrutinyPage.setUserName(getdata("UserName"));
		Login_ScrutinyPage.setpassword(getdata("Password"));
		Login_ScrutinyPage.ClickonLogin();
		// Login_ScrutinyPage.SelectRTOtype();
		Login_ScrutinyPage.SelectRTOtypo();
		Login_ScrutinyPage.Clickonlogin();
		Login_ScrutinyPage.Clickon_General_button();
		Login_ScrutinyPage.Clickon_Scrutiny_Link();
		Login_ScrutinyPage.Set_Application_Number(getdata("ApplicationNo"));
		Login_ScrutinyPage.Clickon_Proceed_button();
		Login_ScrutinyPage.Clickon_VerificationofDocuments_Link();
		Login_ScrutinyPage.Clickon_prooflinks();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Login_ScrutinyPage.Clickon_Scrutinybutton();
		wait(1);
		driver.quit();

	}

	/* To do CaptureBiometrics we have to Run TC102 Test Case */
	@Test(invocationCount = 3)
	public void TC102() {
		// System.setProperty("webdriver.chrome.driver",
		// "BrowserServers\\chromedriver.exe");
		// driver = new ChromeDriver();
		// driver.get(
		// "https://s4preprod.nic.in:8443/cas/login?service=https%3A%2F%2Fs4preprod.nic.in%3A8443%2Fsarathiservice%2Fsarathilogin.do");
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// System.setProperty("webdriver.gecko.driver",
		// "BrowserServers\\geckodriver.exe");
		// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		// capabilities.setCapability("marionette", true);
		// capabilities.setCapability("firefox_binary",
		// new File("C:\\Program Files (x86)\\Mozilla
		// Firefox\\firefox.exe").getAbsolutePath());
		//
		// WebDriver ff = new FirefoxDriver(capabilities);
		// ff.get("https://s4preprod.nic.in:8443/cas/login?service=https%3A%2F%2Fs4preprod.nic.in%3A8443%2Fsarathiservice%2Fsarathilogin.do");
		// ff.manage().window().maximize();
		// ff.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		/*
		 * if we can use ff broweser we can initilize ff driver instance in below line
		 */
	
				
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false);
		capabilities.setCapability("firefox_binary",
				new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get(
				"https://s4preprod.nic.in:8443/cas/login?service=https%3A%2F%2Fs4preprod.nic.in%3A8443%2Fsarathiservice%2Fsarathilogin.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		CapturebiometricsPage = new CapturebiometricsPage(driver);
		// Login_CapturebiometricsPage.Clickon_Login_Button();
		CapturebiometricsPage.setUserName(getdata("UserName"));
		CapturebiometricsPage.setpassword(getdata("Password"));
		CapturebiometricsPage.ClickonLogin();
		CapturebiometricsPage.SelectRTOtype();
		CapturebiometricsPage.Clickonlogin();
		CapturebiometricsPage.Clickon_General_button();
		CapturebiometricsPage.Clickon_BiometricsLink();
		CapturebiometricsPage.Set_Application_Number(getdata("ApplicationNo"));
		//Login_CapturebiometricsPage.Set_Application_Number("510419");
	
		CapturebiometricsPage.Clickon_Getdetails();
		CapturebiometricsPage.Set_CanvasSignature("#thecanvas");
		CapturebiometricsPage.Clickon_Capturesignaturebutton();
		CapturebiometricsPage.Set_PhotoCapture();
		CapturebiometricsPage.Clickon_CropSelected();
		CapturebiometricsPage.Clickon_Phototriggerbutton();
		CapturebiometricsPage.Clickon_Snapokbutton();
		CapturebiometricsPage.Clickon_Savebutton();
		wait(1);
		// driver.quit();
	}

	/* To do LL TEST to Pass/Fail in Offline we have to Run TC103 Test Case */
	@Test(invocationCount = 10)
	public void TC103() {
		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://s4preprod.nic.in:8443/sarathiservice/stateSelectBean.do");
		driver.manage().window().maximize();
		LLTestResultsPage = new LLTestResultsPage(driver);
		LLTestResultsPage.Clickon_Login_Button();
		LLTestResultsPage.setUserName(getdata("UserName"));
		LLTestResultsPage.setpassword(getdata("Password"));
		LLTestResultsPage.ClickonLogin();
		LLTestResultsPage.SelectRTOtype();
		LLTestResultsPage.Clickonlogin();
		LLTestResultsPage.ClickonLL_Link();
		LLTestResultsPage.ClickonLLTestResultsLink();
		LLTestResultsPage.Set_Application_Number(getdata("ApplicationNo"));
		LLTestResultsPage.ClickonFetchbutton();
		LLTestResultsPage.Set_TestResult("PASS");
		LLTestResultsPage.ClickonbSubmitutton();
		wait(1);
		driver.quit();
	}

	/* To give an approval for New LL we have to Run TC104 Test Case */
	@Test(invocationCount = 2)
	public void TC104() {
		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://s4preprod.nic.in:8443/sarathiservice/sarathiHomePublic.do");
		driver.manage().window().maximize();
		LLApprovalbatch = new LLApprovalbatch(driver);
		LLApprovalbatch.Clickon_Login_Button();
		LLApprovalbatch.setUserName(getdata("UserName"));
		LLApprovalbatch.setpassword(getdata("Passwor d"));
		LLApprovalbatch.ClickonLogin();
		LLApprovalbatch.SelectRTOtype();
		LLApprovalbatch.Clickonlogin();
		LLApprovalbatch.ClickonLLLink();
		LLApprovalbatch.ClickonLLAprovalbatchLink();
		LLApprovalbatch.ClickonRadiobutton();
		LLApprovalbatch.Set_Application_Number(getdata("ApplicationNo"));
		LLApprovalbatch.Clickon_Submitbutton();
		LLApprovalbatch.Clickon_Selectallcheckbox();
		LLApprovalbatch.Clickon_Issueallbutton();
		s3 = LL_No(driver, "//table/tbody/tr/td[5]/p");
		LLApprovalbatch.setdata("LLNumber", s3.substring(25, 43));

	}

}
