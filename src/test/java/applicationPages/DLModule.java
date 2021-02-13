package applicationPages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.PageFactory;

public class DLModule extends BasePage {

	NewDLSubmissionPage NewDLSubmissionPage;
	Flows flows;
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public DLModule(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void StartAPP() throws IOException {
		loaddata();
		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		capability.addArguments("use-fake-device-for-media-stream");
		capability.addArguments("use-fake-ui-for-media-stream");
		capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
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

	public void Validating_Flows() throws IOException, InterruptedException {
		flows = new Flows(driver);
		flows.VerifyFlows();
	}

	public void selectState() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		loaddata();
		stcode = getdata("State");
		NewDLSubmissionPage = new NewDLSubmissionPage(driver);
		if (stcode.equalsIgnoreCase("AN")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("AN"));
		} else if (stcode.equalsIgnoreCase("AP")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("AP"));

		} else if (stcode.equalsIgnoreCase("AR")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("AR"));

		} else if (stcode.equalsIgnoreCase("AS")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("AS"));

		} else if (stcode.equalsIgnoreCase("BR")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("BR"));

		} else if (stcode.equalsIgnoreCase("CG")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("CG"));

		} else if (stcode.equalsIgnoreCase("CH")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("CH"));

		} else if (stcode.equalsIgnoreCase("DD")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("DD"));

		} else if (stcode.equalsIgnoreCase("DL")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("DL"));

		} else if (stcode.equalsIgnoreCase("DN")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("DN"));

		} else if (stcode.equalsIgnoreCase("GA")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("GA"));

		} else if (stcode.equalsIgnoreCase("GJ")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("GJ"));

		} else if (stcode.equalsIgnoreCase("HP")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("HP"));

		} else if (stcode.equalsIgnoreCase("HR")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("HR"));

		} else if (stcode.equalsIgnoreCase("JH")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("JH"));

		} else if (stcode.equalsIgnoreCase("JK")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("JK"));

		} else if (stcode.equalsIgnoreCase("KA")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("KA"));

		} else if (stcode.equalsIgnoreCase("KL")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("KL"));

		} else if (stcode.equalsIgnoreCase("LA")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("LA"));

		} else if (stcode.equalsIgnoreCase("LD")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("LD"));

		} else if (stcode.equalsIgnoreCase("MH")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("MH"));

		} else if (stcode.equalsIgnoreCase("ML")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("ML"));

		} else if (stcode.equalsIgnoreCase("MN")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("MN"));

		} else if (stcode.equalsIgnoreCase("MP")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("MP"));

		} else if (stcode.equalsIgnoreCase("MZ")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("MZ"));

		} else if (stcode.equalsIgnoreCase("NL")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("NL"));

		} else if (stcode.equalsIgnoreCase("OD")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("OD"));

		} else if (stcode.equalsIgnoreCase("PB")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("PB"));

		} else if (stcode.equalsIgnoreCase("PY")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("PY"));

		} else if (stcode.equalsIgnoreCase("RJ")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("RJ"));

		} else if (stcode.equalsIgnoreCase("SK")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("SK"));

		} else if (stcode.equalsIgnoreCase("TN")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("TN"));

		} else if (stcode.equalsIgnoreCase("TR")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("TR"));

		} else if (stcode.equalsIgnoreCase("TS")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("TS"));

		} else if (stcode.equalsIgnoreCase("UA")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("UA"));

		} else if (stcode.equalsIgnoreCase("UK")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("UK"));

		} else if (stcode.equalsIgnoreCase("UP")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("UP"));

		} else if (stcode.equalsIgnoreCase("WB")) {
			NewDLSubmissionPage.Selectstatename(prop.getProperty("WB"));

		} else {
			System.out.println("Selected State is not available.Please check and Try Again.");
		}

	}

	public void Initiating_DL() throws IOException {
		NewDLSubmissionPage = new NewDLSubmissionPage(driver);
		NewDLSubmissionPage.Mouserhoveron_DrivingLicence();
		NewDLSubmissionPage.clickon_NewDrivinglicence();
		NewDLSubmissionPage.clickon_Contuinebutton();
		NewDLSubmissionPage.Set_LearnersLicenceNumber(getdata("LLNumber"));
		NewDLSubmissionPage.Set_DateofBirth(getdata("DateofBirth"));
		NewDLSubmissionPage.clickon_Okbutton();
		// driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("9949284540");
		driver.findElement(By.xpath("//input[1][@name='willingToDonate']")).click();
		NewDLSubmissionPage.clickon_Selectallcheckbox();
		NewDLSubmissionPage.clickon_Submitbutton();
		NewDLApplicationNo = DL_App_NO(driver,
				"//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		NewDLSubmissionPage.setdata("ApplicationNo", NewDLApplicationNo.substring(3));
	}

	public void Initiating_DLBacklog() throws IOException, InterruptedException {

		DL_Backlog DL_Backlog = new DL_Backlog(driver);
		DL_Backlog.ArrangeDataSet();
		LoginRTO RTO = new LoginRTO(driver);
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
		VerifyRTOSelection();
		DL_Backlog.ClickonDL();
		DL_Backlog.ClickonDLBacklog();
		DL_Backlog.SetFirstissuedate(getdata("Firstissuedate"));
		DL_Backlog.SetNumaricLLno(getdata("NumaricLLno"));
		DL_Backlog.SetOriginalDLno(getdata("OriginalDLno"));
		DL_Backlog.SetLasttransdate(getdata("Lasttransdate"));
		DL_Backlog.SetName(getdata("Name"));
		DL_Backlog.SetLastName(getdata("Lastname"));
		DL_Backlog.SetRelation(getdata("Relation"));
		DL_Backlog.SetRelationfirstname(getdata("RFName"));
		DL_Backlog.SetRelationLastname(getdata("RLName"));
		DL_Backlog.ClickonGender();
		DL_Backlog.SetAge(getdata("Age"));
		DL_Backlog.SetBloodgroup(getdata("Bgrp"));
		DL_Backlog.SetQualification(getdata("Qualification"));
		DL_Backlog.SetMobilenumber(getdata("Mobilenumber"));
		DL_Backlog.SetState(prop.getProperty(getdata("State")));
		DL_Backlog.TypeofDistdetails();
		DL_Backlog.SetPincode(getdata("Pincode"));
		DL_Backlog.ClickonCheckbox();
		DL_Backlog.ClickonLicenseDetails();
		int totalcovs = Integer.valueOf(getdata("TotalCOVS"));
		switch (totalcovs) {
		case 1:
			/* Adding Single COV */
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			break;
		case 2:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			break;
		case 3:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Third COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate3"));
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			DL_Backlog.ClickonAddbutton();

			break;
		case 4:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Third COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate3"));
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Fourth COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate4"));
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			wait(2);
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			DL_Backlog.ClickonAddbutton();
			break;
		case 5:
			DL_Backlog.SetSelectCOV(getdata("COV1"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Second COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate2"));
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV2"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Third COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate3"));
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			wait(1);
			DL_Backlog.SetSelectCOV(getdata("COV3"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Fourth COV */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate4"));
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			wait(2);
			DL_Backlog.SetSelectCOV(getdata("COV4"));
			DL_Backlog.ClickonAddbutton();
			/* Adding Fifth COVS */
			DL_Backlog.SelectState(prop.getProperty(getdata("State")));
			DL_Backlog.SetRTO(getdata("RTOCode"));
			DL_Backlog.SetCOVIssueDate(getdata("COVIssueDate5"));
			DL_Backlog.SetSelectCOV(getdata("COV5"));
			wait(2);
			DL_Backlog.SetSelectCOV(getdata("COV5"));
			DL_Backlog.ClickonAddbutton();
			break;

		default:
			System.out.println("Selected COV Count is not Availble Please Check");
			break;
		}

		String expire = getdata("DoYouWantExpireBacklog");
		if (expire.equals("Y")) {
			String typeofcov = getdata("COVType");
			if (typeofcov.equals("NON-TR")) {
				driver.findElement(By.xpath("//input[@name='ntToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(getdata("ExpireDate"));
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(Keys.ESCAPE);
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("Transport")) {
				driver.findElement(By.xpath("//input[@name='trToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='trToDate']")).sendKeys(getdata("ExpireDate"));
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("Hazardous")) {
				driver.findElement(By.xpath("//input[@name='hzToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='hzToDate']")).sendKeys(getdata("ExpireDate"));
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("Hill")) {
				driver.findElement(By.xpath("//input[@name='hillToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='hillToDate']")).sendKeys(getdata("ExpireDate"));
				DL_Backlog.ClickonSubmit();
			} else if (typeofcov.equals("NON-TR&Transport")) {
				driver.findElement(By.xpath("//input[@name='ntToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(getdata("ExpireDate"));
				driver.findElement(By.xpath("//input[@name='ntToDate']")).sendKeys(Keys.ESCAPE);
				driver.findElement(By.xpath("//input[@name='trToDate']")).clear();
				driver.findElement(By.xpath("//input[@name='trToDate']")).sendKeys(getdata("CExpireDate"));
				driver.findElement(By.xpath("//input[@name='trToDate']")).sendKeys(Keys.ESCAPE);
				DL_Backlog.ClickonSubmit();
			} else {
				System.out.println("COV type is not availble");
			}

		} else if (expire.equals("N")) {
			DL_Backlog.ClickonSubmit();
		} else {
			System.out.println("Invalid Option");
		}

	}

	public void Validate_Service() throws IOException, InterruptedException {

		DLServices Service = new DLServices(driver);
		Service.Mouserhoveron_DrivingLicence();
		Service.Clickon_ServicesonDL();

	}

	public void VerifyRTOSelection() {
		if (driver.getPageSource().contains("User RTO Login")) {
			DL_Backlog DL_Backlog = new DL_Backlog(driver);
			DL_Backlog.ClickonRadio();
			DL_Backlog.Clickonlogin();
		} else {
			System.out.println("There is no RTO Selection");
		}
	}
}
