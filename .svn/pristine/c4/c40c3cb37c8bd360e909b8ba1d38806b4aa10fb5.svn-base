package testScripts;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationPages.CapturebiometricsPage;
import applicationPages.Commom_RTO_Menu;
import applicationPages.DLModule;
import applicationPages.FactoryUtilities;
import applicationPages.Flows;
import applicationPages.LoginRTO;
import frameworkLibrary.BaseClass;

public class NewDL extends BaseClass {
	WebDriver currentdriver;
	DLModule dl;
	FactoryUtilities Utility;

	@BeforeMethod
	public void before() throws IOException {
		System.out.println("Before Method");

	}

	@Test(invocationCount = 9)
	public void NewDL_Public() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		dl = new DLModule(currentdriver);
		dl.StartAPP();
		dl.PerformJob();
		dl.Initiating_DL();
		dl.Validating_Flows();

	}

	@Test(invocationCount = 16)
	public void DLBacklog() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		dl = new DLModule(currentdriver);
		dl.StartAPP();
		dl.Initiating_DLBacklog();

	}

	@Test(invocationCount = 4)
	public void RTOApplicationStatus() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.desktop-notification", 1);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		capabilities.setCapability("firefox_binary",
				new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
		profile.setPreference("media.navigator.permission.disabled", true);
		profile.setPreference("media.navigator.streams.fake", true);
		WebDriver ff = new FirefoxDriver(capabilities);
		ff.get("https://sarathiprod.nic.in/cas/login?service=https%3A%2F%2Fsarathiprod.nic.in%2Fsarathiservice%2Fsarathilogin.do");
		ff.manage().window().maximize();
		ff.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		LoginRTO RTO = new LoginRTO(ff);
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
		ff.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[6]/a")).click();
		ff.findElement(By.xpath("//a[text()='CAPTURE PHOTO AND SIGNATURE']")).click();
		ff.findElement(By.xpath("//input[@name='appnumber']")).sendKeys(getdata("ApplicationNo"));
		ff.findElement(By.xpath("//button[@id='thumbdetform__populateData']")).click();

		CapturebiometricsPage Capturebiometrics = new CapturebiometricsPage(ff);
		Capturebiometrics.Set_CanvasSignature("#thecanvas");
		Capturebiometrics.Clickon_Capturesignaturebutton();
		Capturebiometrics.Set_PhotoCapture();
		wait(1);
	//	ff.findElement(By.xpath("//button[@id='capBtn']")).click();
		wait(1);
	//	ff.findElement(By.xpath("//div[@class='dojoTab']/div/span[text()='Photo Capture']")).click();
		wait(1);
		ff.findElement(By.xpath("//li[@class='crop']")).click();
		wait(1);
		ff.findElement(By.xpath("//li[@class='trigger']")).click();
		wait(1);
		ff.findElement(By.xpath("//input[@id='photoCaptre']")).click();
		wait(1);
		ff.findElement(By.xpath("//div[@class='col-md-12 top-space text-center']/input[1]")).click();
		Commom_RTO_Menu menuitem = new Commom_RTO_Menu(ff);
		menuitem.Clickon_Misc();
		menuitem.Click_on_applicationstatus();
		menuitem.EnterApplicationNumber(getdata("ApplicationNo"));
		menuitem.Click_on_viewflows();
		menuitem.Click_on_processflow();
		scrooldown(ff);
		ff.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		ff.close();

	}

	@AfterMethod
	public void after() {
		System.out.println("After Method");
		// quitdriver(currentdriver);
	}

}
