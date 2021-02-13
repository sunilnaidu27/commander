package applicationPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import frameworkLibrary.FrameworkVariables;

public class Flows extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	UploadDocumentsPage UploadDocumentsPage;
	UploadPhoto_SignaturePage UploadPhoto_SignaturePage;
	LLSlotBookingPagee LLSlotBookingPage;
	LLFEEPaymentPagee LLFEEPaymentPage;
	LLModule universalstate;
	Commom_RTO_Menu menuitem;
	LoginRTO RTO;
	ScrutinyPage Scrutiny;
	CapturebiometricsPage Capturebiometrics;
	LLTestResultsPage LLTestResults;
	LLApprovalbatch LLApproval;
	LLPrintpage LLPrint;
	NewDLSlotBookingPage NewDLSlotBookingPage;
	Login_DLTestResultsPage Login_DLTestResultsPage;
	Login_DLApprovalPage Login_DLApprovalPage;
	DLPrintpage DLPrint;
	DL_Service_DLExtract DL_Extract;
	DLEndorsementApprove DLEndorsementApprove;
	OnlineTest onlinetest;

	@FindBy(how = How.XPATH, using = "//h3[text()='Application is under processing at RTO Level.']")
	WebElement CaptureText;
	@FindBy(how = How.XPATH, using = "//input[@value='Process Flow']")
	WebElement Processflowbutton;
	@FindBy(how = How.XPATH, using = "//h3[text()='Licence has been Approved.']")
	WebElement CaptureCompletedText;
	@FindBy(how = How.XPATH, using = "//h3[text()='Application for  DL Backlog entry has been approved successfully']")
	WebElement CaptureCompletedTextforbacklog;
	@FindBy(how = How.XPATH, using = "//a[text()='Home']")
	WebElement VerifyHome;
	@FindBy(how = How.XPATH, using = "//a[text()=' Upload Document ']")
	WebElement Elementhover;
	@FindBy(how = How.XPATH, using = "//a[text()='Upload Photograph and Signature']")
	WebElement Elementhoverclick;
	@FindBy(how = How.XPATH, using = "//h3[text()='DL Backlog Saved Successfully......']")
	WebElement CaptureDLBAcklogmesg;
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;
	@FindBy(how = How.XPATH, using = "//h3[text()='Application is under processing at RTO Level.']/following::table[1]/tbody/tr/td[5]")
	WebElement Allotmentinfonotavailable;
	@FindBy(how = How.XPATH, using = "//label[text()='Photo and Signature are Visible Properly']")
	WebElement labelforPhotoSign;

	public Flows(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void VerifyFlows() throws IOException, InterruptedException {
		if (iselementExist(driver, "//button[@id='trsaction_ack_nextStatus']")) {
			driver.findElement(By.xpath("//button[@id='trsaction_ack_nextStatus']")).click();
		}
		Verify_ApplicationCurrentStatus();
		// RTOLevel_Status();
	}

	public void Verify_ApplicationCurrentStatus() throws IOException, InterruptedException {
		wait(1);
		if (driver.getPageSource().contains("Stage(s) to be Completed")) {
			System.out.println("Starting Public Side Flows");
			scrooldown(driver);
			Initiate_Public_Flows();
		}

		else if (driver.getPageSource().contains("Application is under processing at RTO Level.")) {

			if (driver.getPageSource().contains("Date of Birth")) {
				System.out.println(
						"Applicatioin is under processing at RTO Level.Please wait Logging into for RTO process");
				scrooldown(driver);
				Login();
			} else {
				System.out.println("Applicatioin is under processing at RTO Level.Please wait starting RTO process");
				RTOLevel_Status();
			}
		} else if (driver.getPageSource().contains("DL Backlog Saved Successfully......")) {
			System.out.println("Continueing DL Backlog Approval Process");
			RTOLevel_Status();
		}

		else {
			System.out.println("Getting Miscommunication Please check");
		}
	}

	public void Login() {
		RTO = new LoginRTO(driver);
		driver.navigate().to(prop.getProperty(getdata("CASENV")));
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
	}

	public void RTOLevel_Status() throws IOException {
		menuitem = new Commom_RTO_Menu(driver);
		menuitem.Clickon_Misc();
		menuitem.Click_on_applicationstatus();
		menuitem.EnterApplicationNumber(getdata("ApplicationNo"));
		menuitem.Click_on_viewflows();
		Initiate_RTO_Flows();
	}

	public void Initiate_Public_Flows() throws IOException, InterruptedException {
		List<WebElement> ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
		int count = ele.size();
		for (int i = 0; i < count; i++) {
			ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
			WebElement webele = ele.get(i);
			String text = webele.getText();

			if (!text.contains("Completed")) {

				if (!text.contains("Exempted")) {
					WebElement Flowtext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
							+ "]/td[@id='statusId']/preceding-sibling::td"));
					String flowtext = Flowtext.getText();
					if (flowtext.contains("UPLOAD DOCUMENTS")) {
						UploadDocuments();
					} else if (flowtext.contains("UPLOAD PHOTO AND SIGNATURE")) {
						UploadPhotoandSignature();
					} else if (flowtext.contains("FEE PAYMENT")) {
						FeePayment();
					} else if (flowtext.contains("LL SLOT BOOK")) {
						LLSlotBooking();
					} else if (flowtext.contains("DL SLOT BOOK")) {
						DLSlotbooking();
					} else if (flowtext.trim().contains("LL/DL SERVICES SLOT BOOK")) {
						LL_DL_ServiceSlotbooking();
					} else {
						System.out.println(flowtext + " Applicant Flow is Not Availble");
					}
				} else {
					System.out.println("Flow Exempted");
				}

			} else {
				System.out.println(text);
			}
		}
		Verify_ApplicationCurrentStatus();
		RTOLevel_Status();

	}

	public void Initiate_RTO_Flows() throws IOException {

		wait(1);
		if (driver.getPageSource().contains("Stage(s) to be Completed") == false) {
			System.out.println("There is no public flows identified");

			if (driver.getPageSource().contains("Application is under processing at RTO Level.") == true) {
				WebElement rtoflowstatus = driver.findElement(By.xpath(
						"//h3[text()='Application is under processing at RTO Level.']/following::table[1]/tbody/tr/td[2]"));
				String rtoflowtext = rtoflowstatus.getText();
				System.out.println(rtoflowtext);
				if (rtoflowtext.contains("SCRUTINY - (Document Verification)")) {
					menuitem.Click_on_processflow();
					Scrutiny();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("CAPTURE PHOTO & SIGNATURE OFAPPLICANT")) {
					wait(2);
					menuitem.Click_on_processflow();
					CapturePhotoandSignature();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("CAPTURE PHOTO AND SIGNATURE OF APPLICANT")) {
					wait(2);
					menuitem.Click_on_processflow();
					OldCaptureBiometricsatFirefox();
					RTOLevel_Status();
				}

				else if (rtoflowtext.contains("RECORDING LL TEST RESULTS")) {
					menuitem.Click_on_processflow();
					RecordLLTestResults();
				} else if (rtoflowtext.contains("APPROVAL OF LL BY LICENCING AUTHORITY")) {
					wait(2);
					ApproveLL();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("PRINTING OF LEARNING LICENCE")) {
					LLPrint();
				} else if (rtoflowtext.contains("RECORD TEST RESULTS OF DRIVING TEST")) {
					menuitem.Click_on_processflow();
					RecordDLTestResults();
					wait(1);
					RTOLevel_Status();

				} else if (rtoflowtext.equals("APPROVAL OF DL")) {
					wait(2);
					menuitem.Click_on_processflow();
					ApproveDL();
					RTOLevel_Status();
				} else if (rtoflowtext.contains("PRINTING OF DL IN FORM 7 ( SMART CARD )")) {
					wait(2);
					menuitem.Click_on_processflow();
					DLPrint();
					wait(2);
					RTOLevel_Status();
				} else if (rtoflowtext.equals("APPROVAL OF DL BACKLOG")) {
					System.out.println("DLBACKLOG APPROVAL FLOW");
					wait(2);
					menuitem.Click_on_processflow();
					ApproveDLBacklog();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DLEXTRACT REPORT")) {
					wait(2);
					menuitem.Click_on_processflow();
					DLExtract();
				} else if (rtoflowtext.equals("APPROVAL OF ENDORSEMENTS ON DL")) {
					wait(2);
					menuitem.Click_on_processflow();
					ApproveOfENDORSEMENTSONDL();
					RTOLevel_Status();
				} else if (rtoflowtext.equals("DISPATCH OF THE DL AND PSV BADGE")) {
					wait(2);
					try {
						menuitem.Click_on_processflow();
						VerifyDispatchdetails();
					} catch (NoSuchElementException e) {
						if (isDisplayed(Allotmentinfonotavailable) == true) {
							System.out.println(
									"Process Flow Button is not Available and " + Allotmentinfonotavailable.getText());
							clickElement(Logout);
							wait(2);
							driver.quit();
						}
					}

				}

				else {
					System.out.println("There is no RTO Flow found");
				}

			} else {
				if (driver.getPageSource().contains("Licence has been Approved.") == true) {
					System.out.println("RTO Flows has been Completed for the Application number: "
							+ getdata("ApplicationNo") + " and  " + CaptureCompletedText.getText());
					clickElement(Logout);
//					driver.quit();
				} else if (driver.getPageSource()
						.contains("Application for  DL Backlog entry has been approved successfully") == true) {
					System.out.println(CaptureCompletedTextforbacklog.getText() + " for the Application Number: "
							+ getdata("ApplicationNo"));
					clickElement(Logout);
					driver.quit();
				}

			}
		} else {
			System.out.println("Public Flows Identified from RTO Side");
			List<WebElement> ele = driver
					.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
			int count = ele.size();
			for (int i = 0; i < count; i++) {
				ele = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[@id='statusId']"));
				WebElement webele = ele.get(i);
				String text = webele.getText();

				if (!text.contains("Completed")) {

					if (!text.contains("Exempted")) {
						WebElement Flowtext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+"
								+ i + "]/td[@id='statusId']/preceding-sibling::td"));
						String flowtext = Flowtext.getText();
						if (flowtext.contains("UPLOAD DOCUMENTS")) {
							try {
								UploadDocuments();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						} else if (flowtext.contains("UPLOAD PHOTO AND SIGNATURE")) {
							UploadPhotoandSignature();
						} else if (flowtext.contains("FEE PAYMENT")) {
							FeePayment();
						} else if (flowtext.contains("LL SLOT BOOK")) {
							LLSlotBooking();
						} else if (flowtext.contains("DL SLOT BOOK")) {
							DLSlotbooking();
						} else if (flowtext.trim().contains("LL/DL SERVICES SLOT BOOK")) {
							LL_DL_ServiceSlotbooking();
						} else {
							System.out.println(flowtext + " Applicant Flow is Not Availble");
						}
					} else {
						System.out.println("Flow Exempted");
					}

				} else {
					System.out.println(text);
				}
			}
			try {
				Verify_ApplicationCurrentStatus();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void UploadDocuments() throws IOException, InterruptedException {
		UploadDocumentsPage = new UploadDocumentsPage(driver);
		UploadDocumentsPage.Clickon_Proceed_Button();
		UploadDocumentsPage.Clickon_Submit1_Button();
		UploadDocumentsPage.Clickon_ok_Button();
	}

	public void UploadPhotoandSignature() throws IOException {
		if (driver.getPageSource().contains("Logout")) {
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				driver.navigate().to("https://sarathicov.nic.in:8443/sarathiservice/stateSelection.do");
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				driver.navigate().to("https://sarathiprod.nic.in/sarathiservice/stateSelection.do");
			} else if (env.equalsIgnoreCase("CAS_SarathiCOV")) {
				driver.navigate().to("https://sarathicov.nic.in:8443/sarathiservice/stateSelection.do");
			} else if (env.equalsIgnoreCase("CAS_SarathiProd")) {
				driver.navigate().to("https://sarathiprod.nic.in/sarathiservice/stateSelection.do");
			} else {
				System.out.println("Navigation URL is not matched at Upload Photo and Signature Flow.Please try again");
			}
			loaddata();
			NewDLSubmissionPage NewDLSubmissionPage = new NewDLSubmissionPage(driver);
			NewDLSubmissionPage.Selectstatename(prop.getProperty(getdata("State")));
			mouseHover(Elementhover, driver);
			clickElement(Elementhoverclick);
			UploadPhoto_SignaturePage = new UploadPhoto_SignaturePage(driver);
			UploadPhoto_SignaturePage.Set_Application_Number(getdata("ApplicationNo"));
			UploadPhoto_SignaturePage.Set_DateofBirth(getdata("DateofBirth"));
			UploadPhoto_SignaturePage.click_on_Getdetails();
			UploadPhoto_SignaturePage.Clickon_Browse_Button1();
			UploadPhoto_SignaturePage.Clickon_Browse_Button2();
			UploadPhoto_SignaturePage.Clickon_UploadandViewfiles();
			UploadPhoto_SignaturePage.Clickon_SavephotoandSignature();
			UploadPhoto_SignaturePage.Clickon_Next();

		} else {
			UploadPhoto_SignaturePage = new UploadPhoto_SignaturePage(driver);
			UploadPhoto_SignaturePage.Clickon_Proceed_Button();
			UploadPhoto_SignaturePage.Clickon_Browse_Button1();
			UploadPhoto_SignaturePage.Clickon_Browse_Button2();
			UploadPhoto_SignaturePage.Clickon_UploadandViewfiles();
			UploadPhoto_SignaturePage.Clickon_SavephotoandSignature();
			UploadPhoto_SignaturePage.Clickon_Next();
		}

	}

	public void FeePayment() throws IOException {
		LLFEEPaymentPage = new LLFEEPaymentPagee(driver);
		LLFEEPaymentPage.Clickon_Proceed_Button();

	}

	public void LLSlotBooking() throws IOException {
		LLSlotBookingPage = new LLSlotBookingPagee(driver);
		LLSlotBookingPage.Clickon_Proceed_Button();
		LLSlotBookingPage.Booking_Slot();
		LLSlotBookingPage.Clickon_Bookslotbutton();
		LLSlotBookingPage.Clickon_Confirm_slotbookingbutton();
		LLSlotBookingPage.Clickon_Next();
	}

	public void DLSlotbooking() throws IOException {
		NewDLSlotBookingPage = new NewDLSlotBookingPage(driver);
		NewDLSlotBookingPage.Clickon_Proceed_Button();
		NewDLSlotBookingPage.Booking_Slot();
		NewDLSlotBookingPage.Clickon_Bookslotbutton();
		NewDLSlotBookingPage.Clickon_Confirm_slotbookingbutton();
		NewDLSlotBookingPage.Clickon_Next();
	}

	public void LL_DL_ServiceSlotbooking() throws IOException {
		NewDLSlotBookingPage = new NewDLSlotBookingPage(driver);
		NewDLSlotBookingPage.Clickon_ProceedforDLServices();
		NewDLSlotBookingPage.Booking_SlotforDLServices();
		NewDLSlotBookingPage.Clickon_Bookslotbutton();
		NewDLSlotBookingPage.Clickon_Confirm_slotbooking();
		NewDLSlotBookingPage.Clickon_Next();
	}

	public void Scrutiny() {
		scrooldown(driver);
		// if (isDisplayed(labelforPhotoSign) == false) {
		Scrutiny = new ScrutinyPage(driver);
		Scrutiny.Clickon_VerificationofDocuments_Link();
		Scrutiny.Clickon_prooflinks();
		Scrutiny.Clickon_Scrutinybutton();
		// } else {
		// System.out.println("Displaying message --> Photo and Signature are Visible
		// Properly");
		// driver.findElement(By.xpath("//input[@type='radio'][1]")).click();
		// }

	}

	public void CapturePhotoandSignature() {
		Capturebiometrics = new CapturebiometricsPage(driver);
		Capturebiometrics.Set_CanvasSignature("#thecanvas");
		Capturebiometrics.Clickon_Capturesignaturebutton();
		Capturebiometrics.Set_PhotoCapture();
		Capturebiometrics.StartCamera();
		Capturebiometrics.TakeSnapshot();
		Capturebiometrics.StartCrop();
		Capturebiometrics.EndCrop();
		Capturebiometrics.Clickon_Snapokbutton();
		Capturebiometrics.Clickon_Savebutton();
	}

	public void OldCaptureBiometricsatFirefox() {
		System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.desktop-notification", 1);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);

		capabilities.setCapability("firefox_binary",
				new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe").getAbsolutePath());
		profile.setPreference("media.navigator.permission.disabled", true);
		profile.setPreference("media.navigator.streams.fake", true);
		WebDriver driverobj = new FirefoxDriver(capabilities);
		driverobj.get(
				"https://sarathiprod.nic.in/cas/login?service=https%3A%2F%2Fsarathiprod.nic.in%2Fsarathiservice%2Fsarathilogin.do");
		driverobj.manage().window().maximize();
		driverobj.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		LoginRTO RTO = new LoginRTO(driverobj);
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
		driverobj.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[6]/a")).click();
		driverobj.findElement(By.xpath("//a[text()='CAPTURE PHOTO AND SIGNATURE']")).click();
		driverobj.findElement(By.xpath("//input[@name='appnumber']")).sendKeys(getdata("ApplicationNo"));
		driverobj.findElement(By.xpath("//button[@id='thumbdetform__populateData']")).click();

		CapturebiometricsPage Capturebiometrics = new CapturebiometricsPage(driverobj);
		Capturebiometrics.Set_CanvasSignature("#thecanvas");
		Capturebiometrics.Clickon_Capturesignaturebutton();
		Capturebiometrics.Set_PhotoCapture();
		wait(2);
		driverobj.findElement(By.xpath("//li[@class='crop']")).click();
		wait(1);
		driverobj.findElement(By.xpath("//li[@class='trigger']")).click();
		wait(1);
		driverobj.findElement(By.xpath("//input[@id='photoCaptre']")).click();
		wait(1);
		driverobj.findElement(By.xpath("//div[@class='col-md-12 top-space text-center']/input[1]")).click();
		Commom_RTO_Menu menuitem = new Commom_RTO_Menu(driverobj);
		menuitem.Clickon_Misc();
		menuitem.Click_on_applicationstatus();
		menuitem.EnterApplicationNumber(getdata("ApplicationNo"));
		menuitem.Click_on_viewflows();
		menuitem.Click_on_processflow();
		scrooldown(driverobj);
		driverobj.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		driverobj.quit();
	}

	public void RecordLLTestResults() throws IOException {

		if (driver.getPageSource().contains("is customized for Online Learner Licence Test")) {
			onlinetest = new OnlineTest(driver);
			onlinetest.Clickon_Stall();
			onlinetest.Clickon_PickCandidate_for_LLTest();
			onlinetest.Enter_ApplicationNumber();
			onlinetest.Clickon_Submit();
			onlinetest.Clickon_Confirm();
			onlinetest.DisplayPinNumber();
			onlinetest.Clickon_Stall();
			onlinetest.Clickon_DisplayLLTestPassword();
			onlinetest.Enter_ApplicationNumber();
			onlinetest.Clickon_Submit();
			onlinetest.LLTestPassword();
			onlinetest.Clickon_Logout();
			onlinetest.navigatetonewwindow();
			onlinetest.SelectLanguageandPin();
			Login();
			RTOLevel_Status();
		} else {
			LLTestResults = new LLTestResultsPage(driver);
			LLTestResults.Set_TestResult(getdata("TestResult"));
			LLTestResults.ClickonbSubmitutton();
			RTOLevel_Status();
		}

	}

	public void RecordDLTestResults() {
		scrooldown(driver);
		Login_DLTestResultsPage = new Login_DLTestResultsPage(driver);
		List<WebElement> Totalcovs = driver.findElements(By.xpath("//table[@id='testresult']/tbody/tr"));
		int size = Totalcovs.size();
		System.out.println(size);
		for (int i = 1; i < size; i++) {
			WebElement testreele = driver
					.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td/div/select"));
			Select testresult = new Select(testreele);
			testresult.selectByVisibleText(getdata("TestResult"));
			driver.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[6]/input"))
					.sendKeys("ap05nm888" + i + "");
			driver.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[10]/input[2]"))
					.click();

			WebElement ele = driver
					.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[8]/input"));
			if (ele.getAttribute("value").isEmpty()) {
				ele.sendKeys(GetCurrentDate());
				ele.sendKeys(Keys.ESCAPE);
				WebElement lstopn = driver
						.findElement(By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[9]/select"));
				Select timeslot = new Select(lstopn);
				List<WebElement> op = timeslot.getOptions();
				for (int j = 0; j < op.size(); j++) {
					lstopn = driver.findElement(
							By.xpath("//table[@id='testresult']/tbody/tr[" + 1 + "+" + i + "]/td[9]/select"));
					timeslot = new Select(lstopn);
					op = timeslot.getOptions();
					System.out.println(op.get(1).getText());
					timeslot.selectByVisibleText(op.get(1).getText());
					break;

				}
			} else {
				System.out.println("Options are Entered and Selected");
			}

		}
		Login_DLTestResultsPage.ClickonConfirmcheck();
		Login_DLTestResultsPage.ClickonSubmit();
		wait(2);
	}

	public void ApproveLL() {
		LLApproval = new LLApprovalbatch(driver);
		LLApproval.ClickonLLLink();
		LLApproval.ClickonLLAprovalbatchLink();
		LLApproval.ClickonRadiobutton();
		LLApproval.Set_Application_Number(getdata("ApplicationNo"));
		LLApproval.Clickon_Submitbutton();
		LLApproval.Clickon_Selectallcheckbox();
		LLApproval.Clickon_Issueallbutton();
		NewLLNumber = LL_No(driver, "//table/tbody/tr/td[5]/p");
		LLApproval.setdata("LLNumber", NewLLNumber.substring(25, 43).trim());

	}

	public void ApproveDL() {
		scrooldown(driver);
		Login_DLApprovalPage = new Login_DLApprovalPage(driver);
		Login_DLApprovalPage.ClickonApprove();
		NewDLNumber = DL_No(driver, "//div[@class='col-md-12 text-center']/h4");
		Login_DLApprovalPage.setdata("DLNumber", NewDLNumber.substring(74).trim());
	}

	public void ApproveOfENDORSEMENTSONDL() {
		scrooldown(driver);
		DLEndorsementApprove = new DLEndorsementApprove(driver);
		DLEndorsementApprove.Clickon_Approve();
	}

	public void VerifyDispatchdetails() {
		if (driver.getPageSource().contains("For this RTO Dispatch agency Master details not avaliable")) {
			clickElement(Logout);
			wait(2);
			driver.quit();
		} else {
			System.out.println("Implement Pending for this FLOW");
		}

	}

	public void ApproveDLBacklog() {
		scrooldown(driver);
		DL_Backlog DL_Backlog = new DL_Backlog(driver);
		// driver.findElement(By.xpath("//div[@id='dlbacklogApproveId']/following::input[1]")).click();
		try {
			DL_Backlog.Verify_GenerateOTPforApproval();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void LLPrint() {
		LLPrint = new LLPrintpage(driver);
		LLPrint.ClickonLLLink();
		LLPrint.ClickonLLPrinting();
		LLPrint.ClickonRadiobutton();
		LLPrint.Set_Application_Number(getdata("ApplicationNo"));
		LLPrint.Clickon_ViewApplications();
		LLPrint.ClickonLicNummbertoPrint();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		int size = tabs.size();
		System.out.println("Size of windows" + size);
		if (size > 1) {
			driver.switchTo().window(tabs.get(1));
			if (driver.getPageSource()
					.contains("No Complete Details Available like(Images/Personal Data/Licence Data)")) {
				System.out.println("New Error window opened");
				driver.switchTo().window(tabs.get(1)).close();
				driver.switchTo().window(tabs.get(0));
				LLPrint.Clickon_Logout_Button();
				try {
					UpdateLLValidities();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("There is no new window opened.");
			removeDownloadpopup();
			LLPrint.ClickonHome();
			LLPrint.Clickon_Logout_Button();
			try {
				UpdateLLValidities();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void DLPrint() {
		DLPrint = new DLPrintpage(driver);

		if (driver.getPageSource()
				.contains("You do not have permission to view this page or perform this action") == false) {
			DLPrint.ClickonPaperCard();
			DLPrint.ClickonTodaysDate();
			DLPrint.ClickonYes();
			DLPrint.ClickonSubmit();
			DLPrint.Clickon_PrintALL();
			DLPrint.ClickonProceed();
		} else {
			driver.findElement(By.xpath("//span[text()='HOME']")).click();
			driver.quit();
		}

	}

	public void DLExtract() {
		DL_Extract = new DL_Service_DLExtract(driver);
		DL_Extract.Clickon_submitin_DLExtact();
		// DL_Extract.Clickon_Approve_DLExtact();
	}

	public void removeDownloadpopup() {
		Robot bot;
		try {
			bot = new Robot();
			wait(1);
			bot.keyPress(KeyEvent.VK_CONTROL);
			bot.keyPress(KeyEvent.VK_J);
			bot.keyRelease(KeyEvent.VK_CONTROL);
			bot.keyRelease(KeyEvent.VK_J);
			String winHandleBefore = driver.getWindowHandle();
			for (String winHandle : driver.getWindowHandles()) {
				driver.switchTo().window(winHandle);
				closeWindowByTitle("Downloads", driver);
				driver.switchTo().window(winHandleBefore);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void UpdateLLValidities() throws IOException {
		wait(2);
		driver.navigate().to("https://sarathicov.nic.in:8443/LLValidityUpdater/home");
		driver.findElement(By.xpath("//input[@id='getLLDetails_llno']")).sendKeys(getdata("LLNumber"));
		driver.findElement(By.xpath("//input[@id='getLLDetails_dob']")).sendKeys(getdata("DateofBirth"));
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String txtdata = driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr[3]/td[1]")).getText();
		if (txtdata.equals(getdata("LLNumber"))) {
			scrooldown(driver);
			try {
				driver.findElement(By.xpath("//button[@name='confirmDate']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='Yes']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Login();
				RTOLevel_Status();
			} catch (ElementClickInterceptedException e) {
				driver.findElement(By.xpath("//button[@name='confirmDate']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='Yes']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Login();
				RTOLevel_Status();
			}

		}
	}
}
