package applicationPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.google.common.io.Files;

import frameworkLibrary.FrameworkVariables;

public class LLModule extends BasePage {

	NewLLRegistrtionPage NewLLRegistrtionPage;
	Flows flows;
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public LLModule(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void SelectState() throws IOException, ClassNotFoundException, SQLException, InterruptedException {
		loaddata();
		stcode = getdata("State");
		NewLLRegistrtionPage = new NewLLRegistrtionPage(driver);
		if (stcode.equalsIgnoreCase("AN")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("AN"));

		} else if (stcode.equalsIgnoreCase("AP")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("AP"));

		} else if (stcode.equalsIgnoreCase("AR")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("AR"));

		} else if (stcode.equalsIgnoreCase("AS")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("AS"));

		} else if (stcode.equalsIgnoreCase("BR")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("BR"));

		} else if (stcode.equalsIgnoreCase("CG")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("CG"));

		} else if (stcode.equalsIgnoreCase("CH")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("CH"));

		} else if (stcode.equalsIgnoreCase("DD")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("DD"));

		} else if (stcode.equalsIgnoreCase("DL")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("DL"));

		} else if (stcode.equalsIgnoreCase("DN")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("DN"));

		} else if (stcode.equalsIgnoreCase("GA")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("GA"));

		} else if (stcode.equalsIgnoreCase("GJ")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("GJ"));

		} else if (stcode.equalsIgnoreCase("HP")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("HP"));

		} else if (stcode.equalsIgnoreCase("HR")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("HR"));

		} else if (stcode.equalsIgnoreCase("JH")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("JH"));

		} else if (stcode.equalsIgnoreCase("JK")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("JK"));

		} else if (stcode.equalsIgnoreCase("KA")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("KA"));

		} else if (stcode.equalsIgnoreCase("KL")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("KL"));

		} else if (stcode.equalsIgnoreCase("LA")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("LA"));

		} else if (stcode.equalsIgnoreCase("LD")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("LD"));

		} else if (stcode.equalsIgnoreCase("MH")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("MH"));

		} else if (stcode.equalsIgnoreCase("ML")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("ML"));

		} else if (stcode.equalsIgnoreCase("MN")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("MN"));

		} else if (stcode.equalsIgnoreCase("MP")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("MP"));

		} else if (stcode.equalsIgnoreCase("MZ")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("MZ"));

		} else if (stcode.equalsIgnoreCase("NL")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("NL"));

		} else if (stcode.equalsIgnoreCase("OD")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("OD"));

		} else if (stcode.equalsIgnoreCase("PB")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("PB"));

		} else if (stcode.equalsIgnoreCase("PY")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("PY"));

		} else if (stcode.equalsIgnoreCase("RJ")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("RJ"));

		} else if (stcode.equalsIgnoreCase("SK")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("SK"));

		} else if (stcode.equalsIgnoreCase("TN")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("TN"));

		} else if (stcode.equalsIgnoreCase("TR")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("TR"));

		} else if (stcode.equalsIgnoreCase("TS")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("TS"));

		} else if (stcode.equalsIgnoreCase("UA")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("UA"));

		} else if (stcode.equalsIgnoreCase("UK")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("UK"));

		} else if (stcode.equalsIgnoreCase("UP")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("UP"));

		} else if (stcode.equalsIgnoreCase("WB")) {
			NewLLRegistrtionPage.Selectstatename(prop.getProperty("WB"));

		} else {
			System.out.println("Selected State is not available.Please check and Try Again.");
		}

	}

	public void Validating_Flows() throws IOException, InterruptedException {
		flows = new Flows(driver);
		flows.VerifyFlows();
	}

	public void Initiate_Process() throws ClassNotFoundException, SQLException, IOException {
		ConnecttoExcel(prop.getProperty("RTOCheck"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("P")) {
			ConnecttoExcel(prop.getProperty("LLDLCheck"), prop.getProperty("DataFile_State"));
			Validating_lldl_same_time_Check();
			NewLLRegistrtionPage.clickonContinue();
			Before_ApplicationSubmission_Checks();
		} else if (outcome.equalsIgnoreCase("B")) {
			NewLLRegistrtionPage.SelectRTO_Office_AfterStateSelection(getdata("RTOCode"));
			ConnecttoExcel(prop.getProperty("LLDLCheck"), prop.getProperty("DataFile_State"));
			Validating_lldl_same_time_Check();
			NewLLRegistrtionPage.clickonContinue();
			Before_ApplicationSubmission_Checks();
		} else if (outcome.equalsIgnoreCase("C")) {
			ConnecttoExcel(prop.getProperty("LLDLCheck"), prop.getProperty("DataFile_State"));
			Validating_lldl_same_time_Check();
			NewLLRegistrtionPage.SelectRTO_Office_AfterApplyNewLL();
			NewLLRegistrtionPage.clickonContinue();
			Before_ApplicationSubmission_Checks();
		} else {
			System.out.println("************************RTO Checks*****************************");
		}
	}

	public void Validating_lldl_same_time_Check() throws ClassNotFoundException, SQLException {
		if (outcome.equalsIgnoreCase("1")) {
			System.out.println("********** Starting First Flow**************");
			NewLLRegistrtionPage.Mouserhoveron_LearnerLicence();
			NewLLRegistrtionPage.Clickon_Application_for_New_LearnerLicence();
		} else if (outcome.equalsIgnoreCase("0")) {
			System.out.println("********** Starting Second Flow**************");
			NewLLRegistrtionPage.Mouserhoveron_LearnerLicence();
			NewLLRegistrtionPage.Clickon_Application_for_New_LearnerLicence();

		} else {
			System.out.println("****Got New Key*****Please Verify*******");
		}

	}

	public void Before_ApplicationSubmission_Checks() throws ClassNotFoundException, SQLException, IOException {

		String Useroption = getdata("Choice");
		ConnecttoExcel(prop.getProperty("Educationins"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			if (Useroption.equalsIgnoreCase("Doesnothold_LLDL")) {
				System.out.println("Processing your request from value--> Y: Doesnothold_LLDL");
				ConnecttoExcel(prop.getProperty("Camp"), prop.getProperty("DataFile_State"));
				if (outcome.equalsIgnoreCase("Y")) {
					NewLLRegistrtionPage.clickonSubmitonebutton();
					ConnecttoExcel(prop.getProperty("eKYC"), prop.getProperty("DataFile_State"));
					if (outcome.equalsIgnoreCase("Y")) {
						NewLLRegistrtionPage.clickonapplyonApplicantdoesnotholdAadhaarnumber();
						NewLLRegistrtionPage.clickonapplyonSubmittwobutton();
						NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
						NewLLRegistrtionPage.ClickonGenerateOTP();
						String env = getdata("ApplicationEnvironment");
						if (env.equalsIgnoreCase("SarathiCOV")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
						} else if (env.equalsIgnoreCase("SarathiProd")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
						} else {
							System.out.println("Log URL is not matched.Please try again");
						}
						NewLLRegistrtionPage.ClickonAuthenticateWithSarathibutton();
						EnterApplicationFormDetails();
					} else if (outcome.equalsIgnoreCase("N")) {
						EnterApplicationFormDetails();
					} else {
						System.out.println("************Before_ApplicationSubmission_Checks_Camp=Y******************");
					}

				} else if (outcome.equalsIgnoreCase("N")) {
					NewLLRegistrtionPage.SelectRTOofficetodisplayCamp(getdata("RTOCode"));
						WebElement ele = driver.findElement(By.xpath(
								"//table[@class='scrollTable table-hover  table-striped table-bordered']/tbody/tr/td/input"));
						setCheckBox(ele, "ON");
					NewLLRegistrtionPage.clickonSubmitonebutton();
					ConnecttoExcel(prop.getProperty("eKYC"), prop.getProperty("DataFile_State"));
					if (outcome.equalsIgnoreCase("Y")) {
						NewLLRegistrtionPage.clickonapplyonApplicantdoesnotholdAadhaarnumber();
						NewLLRegistrtionPage.clickonapplyonSubmittwobutton();
						NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
						NewLLRegistrtionPage.ClickonGenerateOTP();
						String env = getdata("ApplicationEnvironment");
						if (env.equalsIgnoreCase("SarathiCOV")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
						} else if (env.equalsIgnoreCase("SarathiProd")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
						} else {
							System.out.println("Log URL is not matched.Please try again");
						}
						NewLLRegistrtionPage.ClickonAuthenticateWithSarathibutton();
						EnterApplicationFormDetails();
					} else if (outcome.equalsIgnoreCase("N")) {
						EnterApplicationFormDetails();
					} else {
						System.out.println("***********Before_ApplicationSubmission_Checks_Camp=N******************");
					}
				} else {
					System.out.println("********Before_ApplicationSubmission_Checks_Camp&eKYC*********");
				}

			} else if (Useroption.equalsIgnoreCase("LLRef")) {
				LL_Referencethrough_LLPage LL_Referencethrough_LL = new LL_Referencethrough_LLPage(driver);
				LL_Referencethrough_LL.Clickon_Applicantholds_LearnerLicence_Enter_LL_Number_Radiobutton();
				System.out.println("Processing your request from value--> Y: LL through Ref LL");
				LL_Referencethrough_LL.Enter_LearningLicenceNo_Number(getdata("LLNO"));
				LL_Referencethrough_LL.Enter_Dateofbirth(getdata("DateofBirth"));
				LL_Referencethrough_LL.click_Submitone();
				LL_Referencethrough_LL.click_confirm();
				Verify_Allow_otherstate_ll();
				Verify_Allow_addr_change_at_dlserv_reqst();
				LL_Referencethrough_LL.SelectCOV(getdata("COV1"));
				LL_Referencethrough_LL.Clickon_Rightarrow();
				Form_1_Check();
				Verify_LLRenew_Retest_Check();

			} else if (Useroption.equalsIgnoreCase("DLRef")) {
				LL_Referencethrough_DLPage LL_Referencethrough_DL = new LL_Referencethrough_DLPage(driver);
				LL_Referencethrough_DL.Clickon_Applicantholds_DrivingLicence_Enter_DL_Number_Radiobutton();
				System.out.println("Processing your request from the value 'Y': LL through Ref DL");
				LL_Referencethrough_DL.Enter_Enter_Driving_Licence_Number(getdata("DLNO"));
				LL_Referencethrough_DL.Enter_Dateofbirth(getdata("DateofBirth"));
				LL_Referencethrough_DL.click_Submitone();
				LL_Referencethrough_DL.click_confirm();
				Verify_coa_mand_other_rtos();
				Verify_Allow_addr_change_at_dlserv_reqst();
				LL_Referencethrough_DL.SelectCOV(getdata("COV1"));
				LL_Referencethrough_DL.Clickon_Rightarrow();
				Form_1_Check();
				Verify_ll_aedl_sametime();
				Verify_LLRenew_Retest_Check();

			} else if (Useroption.equalsIgnoreCase("FreshLL_EduIns")) {

				System.out.println("Processing your request from value--> Y: Fresh LL through Education Institutions");
				NewLLRegistrtionPage.Clickon_EduRadio();
				NewLLRegistrtionPage.Enter_EnrollmentNumber();
				NewLLRegistrtionPage.Enter_EnrollmentDateofBirth();
				NewLLRegistrtionPage.clickonSubmitonebutton();
				EnterApplicationFormDetailsforEduInst();
			}
		} else if (outcome.equalsIgnoreCase("N")) {
			if (Useroption.equalsIgnoreCase("Doesnothold_LLDL")) {
				System.out.println("Processing your request from value--> N: Doesnothold_LLDL");
				ConnecttoExcel(prop.getProperty("Camp"), prop.getProperty("DataFile_State"));
				if (outcome.equalsIgnoreCase("Y")) {
					NewLLRegistrtionPage.clickonSubmitonebutton();
					ConnecttoExcel(prop.getProperty("eKYC"), prop.getProperty("DataFile_State"));
					if (outcome.equalsIgnoreCase("Y")) {
						NewLLRegistrtionPage.clickonapplyonApplicantdoesnotholdAadhaarnumber();
						NewLLRegistrtionPage.clickonapplyonSubmittwobutton();
						NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
						NewLLRegistrtionPage.ClickonGenerateOTP();
						String env = getdata("ApplicationEnvironment");
						if (env.equalsIgnoreCase("SarathiCOV")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
						} else if (env.equalsIgnoreCase("SarathiProd")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
						} else {
							System.out.println("Log URL is not matched.Please try again");
						}
						NewLLRegistrtionPage.ClickonAuthenticateWithSarathibutton();
						EnterApplicationFormDetails();
					} else if (outcome.equalsIgnoreCase("N")) {
						EnterApplicationFormDetails();
					} else {
						System.out.println("************Before_ApplicationSubmission_Checks_Camp=Y******************");
					}

				} else if (outcome.equalsIgnoreCase("N")) {
					NewLLRegistrtionPage.SelectRTOofficetodisplayCamp(getdata("RTOCode"));
					WebElement ele = driver.findElement(By.xpath(
							"//table[@class='scrollTable table-hover  table-striped table-bordered']/tbody/tr/td/input"));
					setCheckBox(ele, "ON");
					NewLLRegistrtionPage.clickonSubmitonebutton();
					ConnecttoExcel(prop.getProperty("eKYC"), prop.getProperty("DataFile_State"));
					if (outcome.equalsIgnoreCase("Y")) {
						NewLLRegistrtionPage.clickonapplyonApplicantdoesnotholdAadhaarnumber();
						NewLLRegistrtionPage.clickonapplyonSubmittwobutton();
						NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
						NewLLRegistrtionPage.ClickonGenerateOTP();
						String env = getdata("ApplicationEnvironment");
						if (env.equalsIgnoreCase("SarathiCOV")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
						} else if (env.equalsIgnoreCase("SarathiProd")) {
							NewLLRegistrtionPage.Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
						} else {
							System.out.println("Log URL is not matched.Please try again");
						}
						NewLLRegistrtionPage.ClickonAuthenticateWithSarathibutton();
						EnterApplicationFormDetails();
					} else if (outcome.equalsIgnoreCase("N")) {
						EnterApplicationFormDetails();
					} else {
						System.out.println("***********Before_ApplicationSubmission_Checks_Camp=N******************");
					}
				} else {
					System.out.println("********Before_ApplicationSubmission_Checks_Camp&eKYC*********");
				}
			} else if (Useroption.equalsIgnoreCase("LLRef")) {
				LL_Referencethrough_LLPage LL_Referencethrough_LL = new LL_Referencethrough_LLPage(driver);
				LL_Referencethrough_LL.Clickon_Applicantholds_LearnerLicence_Enter_LL_Number_Radiobutton();
				System.out.println("Processing your requestfrom value--> N: LL through Ref LL");
				LL_Referencethrough_LL.Enter_LearningLicenceNo_Number(getdata("LLNO"));
				LL_Referencethrough_LL.Enter_Dateofbirth(getdata("DateofBirth"));
				LL_Referencethrough_LL.click_Submitone();
				LL_Referencethrough_LL.click_confirm();
				Verify_Allow_otherstate_ll();
				Verify_Allow_addr_change_at_dlserv_reqst();
				LL_Referencethrough_LL.SelectCOV(getdata("COV1"));
				LL_Referencethrough_LL.Clickon_Rightarrow();
				Form_1_Check();
				Verify_LLRenew_Retest_Check();
			} else if (Useroption.equalsIgnoreCase("DLRef")) {
				LL_Referencethrough_DLPage LL_Referencethrough_DL = new LL_Referencethrough_DLPage(driver);
				LL_Referencethrough_DL.Clickon_Applicantholds_DrivingLicence_Enter_DL_Number_Radiobutton();
				System.out.println("Processing your request from value--> N: LL through Ref DL");
				LL_Referencethrough_DL.Enter_Enter_Driving_Licence_Number(getdata("DLNO"));
				LL_Referencethrough_DL.Enter_Dateofbirth(getdata("DateofBirth"));
				LL_Referencethrough_DL.click_Submitone();
				LL_Referencethrough_DL.click_confirm();
				Verify_coa_mand_other_rtos();
				Verify_Allow_addr_change_at_dlserv_reqst();
				LL_Referencethrough_DL.SelectCOV(getdata("COV1"));
				LL_Referencethrough_DL.Clickon_Rightarrow();
				Form_1_Check();
				Verify_ll_aedl_sametime();
				Verify_LLRenew_Retest_Check();

			}
		} else {
			System.out.println("Options are not Availble.Please Check");
		}

	}

	public void EnterApplicationFormDetails() {
		String State = getdata("State");
		NewLLRegistrtionPage.Set_State(prop.getProperty(State, "Default"));
		Verifying_PinMappingCheck();
		NewLLRegistrtionPage.SetFirstName(getdata("FN"));
		NewLLRegistrtionPage.SetLastName(getdata("LN"));
		NewLLRegistrtionPage.SetRelationType(getdata("RT"));
		NewLLRegistrtionPage.SetRelationFirstName(getdata("RF"));
		NewLLRegistrtionPage.SetRelationLastName(getdata("RL"));
		NewLLRegistrtionPage.SetGender();
		NewLLRegistrtionPage.SetAge(getdata("Age"));
		NewLLRegistrtionPage.SetQualification(getdata("Qualification"));
		NewLLRegistrtionPage.SetBloodgroup(getdata("Bgrp"));
		NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
		NewLLRegistrtionPage.SetIdentificationMarks1("A mole on Right Side");
		NewLLRegistrtionPage.SetState();
		NewLLRegistrtionPage.TypeDist();
		NewLLRegistrtionPage.SetPincode(getdata("Pin"));
		NewLLRegistrtionPage.SetCopytopermenentaddress();
		NewLLRegistrtionPage.SetCOV(getdata("COV1"));
		NewLLRegistrtionPage.SetCOV1(getdata("COV2"));
		// NewLLRegistrtionPage.SetCOV2(getdata("COV3"));
		NewLLRegistrtionPage.SetRightarrow();
		NewLLRegistrtionPage.ClickonWillingToDonate();
		Form_1_Check();
		CaptureDetails();

	}

	public void EnterApplicationFormDetailsforEduInst() {
		// String State = getdata("State");
		// NewLLRegistrtionPage.Set_State(prop.getProperty(State, "Default"));
		// Verifying_PinMappingCheck();
		NewLLRegistrtionPage.SetFirstName(getdata("FN"));
		NewLLRegistrtionPage.SetLastName(getdata("LN"));
		NewLLRegistrtionPage.SetRelationType(getdata("RT"));
		NewLLRegistrtionPage.SetRelationFirstName(getdata("RF"));
		NewLLRegistrtionPage.SetRelationLastName(getdata("RL"));
		NewLLRegistrtionPage.SetGender();
		// NewLLRegistrtionPage.SetAge(getdata("Age"));
		NewLLRegistrtionPage.SetQualification(getdata("Qualification"));
		NewLLRegistrtionPage.SetBloodgroup(getdata("Bgrp"));
		NewLLRegistrtionPage.SetMobilenumber(getdata("Phone"));
		NewLLRegistrtionPage.SetIdentificationMarks1("A mole on Right Side");
		NewLLRegistrtionPage.SetState();
		NewLLRegistrtionPage.TypeDist();
		NewLLRegistrtionPage.SetPincode(getdata("Pin"));
		NewLLRegistrtionPage.SetCopytopermenentaddress();
		NewLLRegistrtionPage.SetCOV(getdata("COV1"));
		NewLLRegistrtionPage.SetCOV1(getdata("COV2"));
		// NewLLRegistrtionPage.SetCOV2(getdata("COV3"));
		NewLLRegistrtionPage.SetRightarrow();
		NewLLRegistrtionPage.ClickonWillingToDonate();
		Form_1_Check();
		CaptureDetails();
	}

	public void Form_1_Check() {
		ConnecttoExcel(prop.getProperty("Form1"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			Fill_Form1Details();
			NewLLRegistrtionPage.SetSubmitthree();
		} else if (outcome.equalsIgnoreCase("N")) {
			NewLLRegistrtionPage.SetSubmitthree();
		} else {
			System.out.println("******************FORM1**********************");
		}

	}

	public void Fill_Form1Details() {
		NewLLRegistrtionPage.ClickonForm1_buttton();
		SwitchtoWindowByTitle("formOne", driver);
		List<WebElement> radio = driver.findElements(By.xpath("//label[text()='No']/preceding-sibling::input[1]"));
		for (WebElement subradio : radio) {
			subradio.click();
		}
		NewLLRegistrtionPage.ClickonDeclareCheckbox();
		NewLLRegistrtionPage.ClickonSubmitbuttonatForm1();
		closeWindowByTitle("FormOneSuccess", driver);
		SwitchtoWindowByTitle("Application For NewLL", driver);
	}

	public void Verifying_PinMappingCheck() {
		ConnecttoExcel(prop.getProperty("PinMapping"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("N")) {
			NewLLRegistrtionPage.Set_RTO_Office(getdata("RTOCode"));
		} else if (outcome.equalsIgnoreCase("R")) {
			NewLLRegistrtionPage.EnterPinCode(getdata("GetPinCode"));
		} else {
			System.out.println("***************New PinCode Mapping Value Found.Please Check***************");
		}
	}

	public void CaptureDetails() {
		wait(1);
		AppNum = App_NO(driver, "//table/tbody/tr/td[text()='Application No  ']/following-sibling::td[1]");
		DOB = DOB(driver, "//table/tbody/tr[2]/td[3]/following-sibling::td");
		String title = driver.getTitle();
		if (title.equals("New LL Acknowledgement")) {
			NewLLRegistrtionPage.setdata("ApplicationNo", AppNum.substring(3).trim());
			NewLLRegistrtionPage.setdata("DateofBirth", DOB.substring(3).trim());
			NewLLRegistrtionPage.setdata("StatusofApplication", "Success");
		} else {
			System.out.println("New LL Acknowledgement is not Generated");
			NewLLRegistrtionPage.setdata("StatusofApplication", "Fail");
			driver.close();
		}
	}

	public void Submit_LLBacklog() {
		LoginRTO RTO = new LoginRTO(driver);
		System.out.println(GetCurrentDate());
		RTO.setUserName(getdata("UserName"));
		RTO.setpassword(getdata("Password"));
		RTO.ClickonLogin();
	//	VerifyRTOSelection();
		LLBacklogPage LLBacklogPage = new LLBacklogPage(driver);
		LLBacklogPage.Clickon_LL_Link();
		LLBacklogPage.Clickon_LLBacklog();
		LLBacklogPage.ArrangeDataSet();
		LLBacklogPage.Set_Issuedate("29-01-2021");
		LLBacklogPage.Set_OriginalLLno(getdata("OriginalLLno"));
		LLBacklogPage.Set_NumaricLLNo(getdata("NumaricLLNo"));
		WebElement refno = driver
				.findElement(By.xpath("//form[@id='LLBacklogAction']/center/h4[2][normalize-space(text())]"));
		String text = refno.getText();
		System.out.println(text);

		LLBacklogPage.setdata("ApplicationNo", text.substring(24).trim());

		WebElement LLtext = driver
				.findElement(By.xpath("//form[@id='LLBacklogAction']/center/h4[3][normalize-space(text())]"));
		String LLno = LLtext.getText();
		System.out.println(LLno);
		LLBacklogPage.setdata("LLNumber", LLno.substring(17).trim());
		LLBacklogPage.Clickon_LLLink();
		LLBacklogPage.Clickon_LLBacklogApprove();
		LLBacklogPage.Enter_LLBacklogApplicationno();
		LLBacklogPage.Clickon_LLBacklogApplicationnoProceed();
		LLBacklogPage.Clickon_LLBacklogApprovebutton();

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

	public void Verify_LLRenew_Retest_Check() {
		ConnecttoExcel(prop.getProperty("LLRenew_Retest"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			LL_Referencethrough_DLPage LL_Referencethrough_DL = new LL_Referencethrough_DLPage(driver);
			LL_Referencethrough_DL.Clickon_Submitbutton();
			CaptureDetails();
			Flows flows = new Flows(driver);
			try {
				flows.VerifyFlows();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (outcome.equalsIgnoreCase("N")) {
			LL_Referencethrough_DLPage LL_Referencethrough_DL = new LL_Referencethrough_DLPage(driver);
			LL_Referencethrough_DL.Clickon_Submitbutton();
			if (basepage.alertExist(driver)) {
				System.out.println(basepage.alertGetText(driver));
			} else {
				CaptureDetails();
				Flows flows = new Flows(driver);
				try {
					flows.VerifyFlows();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("There is no option");
		}

	}

	public void Verify_ll_aedl_sametime() {
		ConnecttoExcel(prop.getProperty("LLAEDLCheck"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			System.out.println("Inserting 510 transaction");
		} else {
			System.out.println("Inserting __ transaction");
		}
	}

	public void Verify_Allow_otherstate_ll() {
		ConnecttoExcel(prop.getProperty("Allowllforotherstate"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			System.out.println(
					"allow_otherstate_ll --> This check is not in use at Production.So there is no implementation for this check");
		} else if (outcome.equalsIgnoreCase("N")) {
			System.out.println(
					"allow_otherstate_ll --> This check is not in use at Production.So there is no implementation for this check");
		}
	}

	public void Verify_Allow_addr_change_at_dlserv_reqst() {
		ConnecttoExcel(prop.getProperty("Addrchange"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			System.out.println("Address Section Fields are editable.If you want to edit any changes you can edit");
		} else if (outcome.equalsIgnoreCase("N")) {
			System.out.println(
					"In Address Section House/Door/FlatNo,Street/Locality/Police Station and Location/Landmark fields are disable");
		}
	}

	public void Verify_coa_mand_other_rtos() {
		ConnecttoExcel(prop.getProperty("Applyingotherstate"), prop.getProperty("DataFile_State"));
		if (outcome.equalsIgnoreCase("Y")) {
			System.out.println("Selected State have Customization.Your Request is in progress");
			String State = getdata("State");
			NewLLRegistrtionPage.Set_State(prop.getProperty(State, "Default"));
			wait(1);
			if (basepage.alertExist(driver)) {
				System.out.println(alertGetText(driver));
			}
		} else if (outcome.equalsIgnoreCase("N")) {
			System.out.println("There is no customization setting.Processing your request");
		}

	}

}
