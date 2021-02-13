package applicationPages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OnlineTest extends BasePage {
	BasePage basepage = new BasePage();

	WebDriver driver;
	boolean stepstatus;

	public OnlineTest(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelementss
	@FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav']/li[3]/a")
	WebElement Stall;

	public void Clickon_Stall() {
		stepstatus = basepage.clickElement(Stall);
		reportEvent(stepstatus, "Able to click on Stall", "Unable to click on Stall", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()='PICK  CANDIDATE FOR LL TEST']")
	WebElement PickCandidate;

	public void Clickon_PickCandidate_for_LLTest() {
		stepstatus = basepage.clickElement(PickCandidate);
		reportEvent(stepstatus, "Able to click on PickCandidate for LL Test",
				"Unable to click on PickCandidate for LL Test", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement AppNo;

	public void Enter_ApplicationNumber() {
		stepstatus = basepage.SetTextAndTAB(AppNo, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to enter AppNo", "Unable to enter AppNo", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Submit']")
	WebElement Sub;

	public void Clickon_Submit() {
		stepstatus = basepage.clickElement(Sub);
		reportEvent(stepstatus, "Able to click on Submit", "Unable to click on Submit", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//input[@value='Confirm']")
	WebElement Confirm;

	public void Clickon_Confirm() {
		stepstatus = basepage.clickElement(Confirm);
		reportEvent(stepstatus, "Able to click on Confirm", "Unable to click on Confirm", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//div[@id='DisplayReult']/div[2]/div[2]")
	WebElement PinNumber;

	public String DisplayPinNumber() {
		pinnumber = PinNumber.getText();
		System.out.println("Pin Number is: " + pinnumber.trim());
		System.out.println("Pin length" + pinnumber.trim().length());
		return pinnumber.trim();
	}

	@FindBy(how = How.XPATH, using = "//a[text()='DISPLAY LL TEST PASSWORD']")
	WebElement DisplayLLTestPassword;

	public void Clickon_DisplayLLTestPassword() {
		stepstatus = basepage.clickElement(DisplayLLTestPassword);
		reportEvent(stepstatus, "Able to click on DisplayLLTestPassword for LL Test",
				"Unable to click on DisplayLLTestPassword for LL Test", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//div[normalize-space(text())='LL Test Password']/following::div[1]")
	WebElement LLTestPassword;

	String password;

	public String LLTestPassword() {
		password = LLTestPassword.getText();
		System.out.println("LLTest Password is: " + password.trim());
		return password.trim();
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;
	@FindBy(how = How.XPATH, using = "//select[@name='stName']")
	WebElement Selectstatename;

	public void Clickon_Logout() throws IOException {
		stepstatus = basepage.clickElement(Logout);
		wait(2);
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
		NewLLRegistrtionPage NewLLRegistrtionPage = new NewLLRegistrtionPage(driver);
		NewLLRegistrtionPage.Selectstatename(prop.getProperty(getdata("State")));
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Learner Licence ']")
	WebElement LearnerLicence;

	public void Mouserhoveron_LearnerLicence() {
		stepstatus = basepage.mouseHover(LearnerLicence, driver);
		reportEvent(stepstatus, "Able to do Mousehover action on Learner Licence",
				"Unable to do Mousehover action on Leaner Licence", driver, true);
	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Learner Licence ']/following::a[text()='Online LLTest(STALL)']")
	WebElement OnlineLLTest;

	public void Clickon_OnlineLLTest() {
		stepstatus = basepage.clickElement(OnlineLLTest);
		reportEvent(stepstatus, "Able to click on OnlineLLTest", "Unable to click on OnlineLLTest", driver, true);
	}

	public void navigatetonewwindow() throws IOException {
		String env = getdata("ApplicationEnvironment");
		//System.out.println(env);
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			navigate(driver, prop.getProperty("Stall_Staging"));
		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			navigate(driver, prop.getProperty("Stall_Prod"));
		} else {
			System.out.println("URL is not matched.Please try again");
		}

		driver.findElement(By.xpath("//input[@name='llappln']")).sendKeys(getdata("ApplicationNo"));
		driver.findElement(By.xpath("//input[@name='llappln']")).sendKeys(Keys.TAB);
		code = getdata("RTOCode");
		System.out.println("Code we got is: " + code);
	
		ConnecttoExcelforS4customrto(prop.getProperty("Verifyappchecks"), prop.getProperty("DataFile_s4customrto"));
		if (outcome.equalsIgnoreCase("A")) {

			env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				loaddata();
				Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				loaddata();
				Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
			} else {
				System.out.println("Log URL is not matched.Please try again");
			}

		} else if (outcome.equalsIgnoreCase("N")) {
			if (driver.getPageSource().contains("Date of Birth")) {
				driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(getdata("DateofBirth"));
				driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Keys.ESCAPE);
			} else {
				System.out.println("Date of Birth field is not available for the State");
			}
			driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys(password.trim());
			driver.findElement(By.xpath("(//input)[@value='Login'][1]")).click();
			wait(1);
		//	driver.findElement(By.xpath("(//input)[@value='PROCEED']")).click();
		} else if (outcome.equalsIgnoreCase("S")) {
			if (driver.getPageSource().contains("Date of Birth")) {
				driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(getdata("DateofBirth"));
				driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(Keys.ESCAPE);
			} else {
				System.out.println("Date of Birth field is not available for the State");
			}
			env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				loaddata();
				Getlogotp(prop.getProperty("SarathiCOVeKYCLogURL"));
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				loaddata();
				Getlogotp(prop.getProperty("SarathiprodeKYCLogURL"));
			} else {
				System.out.println("Log URL is not matched.Please try again");
			}

		} else if (outcome.equalsIgnoreCase("P")) {

		} else {
			System.out.println("Please Check values");
		}

	}

	public String Getlogotp(String url) throws IOException {
		// wait(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("Generated OTP random code:")) {
					if (strCurrentLine.contains("Generated OTP random code:")) {
						// System.out.println(strCurrentLine.substring(177,184).trim());
						getotp = strCurrentLine.substring(88, 94).trim();
						// System.out.println(getotp);
					}
					count++;
				} else {
					// System.out.println("#######################Pleasae Check OTP
					// Section###########################");
				}
			}
			// System.out.println(count);
			System.out.println(getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@name='sarathiOtp']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@name='sarathiOtp']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@value='Authenticate With Sarathi OTP']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

	@FindBy(how = How.XPATH, using = "//select[@name='language']")
	WebElement Language;
	@FindBy(how = How.XPATH, using = "//input[@name='disclaimer']")
	WebElement Check;
	@FindBy(how = How.XPATH, using = "//input[@id='subm']")
	WebElement proceedbutton;

	public void SelectLanguageandPin() throws IOException {
		stepstatus = basepage.setOptionInSelectBox(Language, "ENGLISH");
		WebElement ele = driver.findElement(By.xpath("//input[@name='otp']"));

		if (ele.getAttribute("value").isEmpty()) {
			driver.findElement(By.xpath("//input[@name='otp']")).sendKeys(pinnumber.substring(2).trim());
			driver.findElement(By.xpath("//input[@name='disclaimer']")).click();
			JsclickElement(proceedbutton, driver);
		} else {
			driver.findElement(By.xpath("//input[@name='disclaimer']")).click();
			JsclickElement(proceedbutton, driver);
		}

		// driver.findElement(By.xpath("//input[@id='subm']")).click();
		String env = getdata("ApplicationEnvironment");
		if (env.equalsIgnoreCase("SarathiCOV")) {
			loaddata();
			String ExamStatus = getdata("TestResult");
			if (ExamStatus.equalsIgnoreCase("PASS")) {
				System.out.println("Selected Result as PASS");

				GetAnswerfortheQuestion(prop.getProperty("SarathiCOVeKYCLogURL"));

			} else if (ExamStatus.equalsIgnoreCase("FAIL")) {
				System.out.println("Selected Result as FAIL");
				TestFailureCase(prop.getProperty("SarathiCOVeKYCLogURL"));
			} else if (ExamStatus.equalsIgnoreCase("EXEMPT")) {
				System.out.println("Selected Result as EXEMPT");
			} else if (ExamStatus.equalsIgnoreCase("PossibleCases")) {
				System.out.println("Selected Possible Cases");
				PossibleCases(prop.getProperty("SarathiCOVeKYCLogURL"));
			}

		} else if (env.equalsIgnoreCase("SarathiProd")) {
			loaddata();
			String ExamStatus = getdata("TestResult");
			if (ExamStatus.equalsIgnoreCase("PASS")) {
				System.out.println("Selected Result as PASS");
				GetAnswerfortheQuestion(prop.getProperty("SarathiprodeKYCLogURL"));
			} else if (ExamStatus.equalsIgnoreCase("FAIL")) {
				System.out.println("Selected Result as FAIL");
				TestFailureCase(prop.getProperty("SarathiprodeKYCLogURL"));
			} else if (ExamStatus.equalsIgnoreCase("EXEMPT")) {
				System.out.println("Selectrd Result as EXEMPT");
			} else if (ExamStatus.equalsIgnoreCase("PossibleCases")) {
				System.out.println("Selected Possible Cases");
				PossibleCases(prop.getProperty("SarathiprodeKYCLogURL"));
			}

		} else {
			System.out.println("Log URL is not matched.Please try again");
		}

	}

	@FindBy(how = How.XPATH, using = "(//h3)[1]")
	WebElement headertitle;

	public String GetAnswerfortheQuestion(String url) throws IOException {
		// wait(1);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		String[] result = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {
					if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {

						int indx = strCurrentLine.indexOf("[");
						result = strCurrentLine.substring(indx).split(",");

					}
					count++;
				} else {
					// System.out.println("#######################Pleasae Check OTP
					// Section###########################");
				}
			}

			driver.switchTo().window(tabs.get(0));
			outerloop: for (String qns : result) {
				if (driver.getPageSource().contains("This Learner Licence Approved Successfully.") == false) {
					// System.out.println("Questions: " + qns);
					String re = qns.replace("[", "");
					question = re.replace("]", "");
					System.out.println("Question Number is: " + question.trim());
					ConnecttoExcelforStallExamAnswer(prop.getProperty("Ansbank"), prop.getProperty("DataFile_Stall"));
					switch (Integer.valueOf(outcome)) {
					case 1:

						try {

							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									NewLLNumber = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(NewLLNumber.substring(23).trim());
									setdata("LLNumber", NewLLNumber.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {
								driver.findElement(By.xpath("//input[@value='1']")).click();
								driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {

							System.out.println("Case 1 Exception");
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					case 2:
						try {

							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(LicTxt.substring(23).trim());
									setdata("LLNumber", LicTxt.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {
								driver.findElement(By.xpath("//input[@value='2']")).click();
								driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {
							System.out.println("Case 2 Exception");
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					case 3:
						try {
							if (driver.getPageSource().contains("LL Stall Exam Result") == true) {
								if (driver.findElement(By.xpath("(//h3)[4]")).isDisplayed() == true) {
									String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
									System.out.println(LicTxt.substring(23).trim());
									setdata("LLNumber", LicTxt.substring(23).trim());
									break outerloop;
								} else {
									System.out.println("There is no Test at approval check");
									break outerloop;
								}

							} else {
								driver.findElement(By.xpath("//input[@value='3']")).click();
								driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
								wait(2);
								break;
							}

						} catch (NoSuchElementException e) {
							System.out.println("Case 3 Exception");
							break outerloop;
							// String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
							// System.out.println(LicTxt.substring(23).trim());
							// setdata("LLNumber", LicTxt.substring(23).trim());
							// break;
						} catch (StaleElementReferenceException e) {
							System.out.println("Stale Element Ref");
						}

					default:
						System.out.println("No Option available to Select");
						break;

					}
				} else {
					System.out.println("Else block Statement");
					String LicTxt = driver.findElement(By.xpath("(//h3)[4]")).getText();
					System.out.println(LicTxt.substring(23).trim());
					setdata("LLNumber", LicTxt.substring(23).trim());
				}

			}
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outcome;
	}

	public String TestFailureCase(String url) throws IOException {
		wait(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		String[] result = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {
					if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {

						int indx = strCurrentLine.indexOf("[");
						result = strCurrentLine.substring(indx).split(",");

						count++;
					} else {
						// System.out.println("#######################Pleasae Check OTP
						// Section###########################");
					}
				}

			}
			driver.switchTo().window(tabs.get(0));
			for (String qns : result) {
				// System.out.println("Questions: " + qns);
				String re = qns.replace("[", "");
				question = re.replace("]", "");
				System.out.println("Question Number is: " + question.trim());
				ConnecttoExcelforStallExamAnswer(prop.getProperty("Ansbank"), prop.getProperty("DataFile_Stall"));
				switch (Integer.valueOf(outcome)) {
				case 1:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				case 2:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					// driver.switchTo().window(tabs.get(1));
					// driver.navigate().refresh();
					break;
				case 3:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				case 4:
					driver.findElement(By.xpath("//input[@value='1']")).click();
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;

				default:
					System.out.println("No Option available to Select");
					break;

				}

			}
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outcome;
	}

	public String PossibleCases(String url) throws IOException {
		wait(3);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)); // switches to new tab
		driver.get(url);
		// driver.navigate().refresh();
		String output = driver.findElement(By.cssSelector("body")).getText();
		File DestFile = new File(".\\logfile.txt");
		PrintWriter writer = new PrintWriter(DestFile);
		writer.print("");
		writer.close();
		FileUtils.writeStringToFile(DestFile, output);
		String FILENAME = ".\\logfile.txt";
		String getotp = null;
		String[] result = null;
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {
					if (strCurrentLine.contains("question list from db------->>>>>>>>>>")) {

						int indx = strCurrentLine.indexOf("[");
						result = strCurrentLine.substring(indx).split(",");

						count++;
					} else {
						// System.out.println("#######################Pleasae Check OTP
						// Section###########################");
					}
				}

			}
			driver.switchTo().window(tabs.get(0));
			for (String qns : result) {
				// System.out.println("Questions: " + qns);
				String re = qns.replace("[", "");
				question = re.replace("]", "");
				System.out.println("Question Number is: " + question.trim());
				ConnecttoExcelforStallExamAnswer(prop.getProperty("Ansbank"), prop.getProperty("DataFile_Stall"));
				switch (Integer.valueOf(outcome)) {
				case 1:
					driver.findElement(By.xpath("//input[@value='1']")).click(); // Right Answer With Confirm button
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				case 2:
					driver.findElement(By.xpath("//input[@value='2']")).click(); // Right Answer Without Confirm button
					wait(2);
					break;
				case 3:
					driver.findElement(By.xpath("//input[@value='1']")).click(); // Wrong Answer with Confirm button
					driver.findElement(By.xpath("//input[@name='confirmbut']")).click();
					wait(2);
					break;
				default:
					System.out.println("No Option available to Select");
					break;

				}

			}
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return outcome;
	}

}
