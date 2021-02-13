package applicationPages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewDLSlotBookingPage extends BasePage {

	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public NewDLSlotBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// define webelements
	@FindBy(how = How.XPATH, using = "//span[1][text()='Apply Online']")
	WebElement Applyonline;
	@FindBy(how = How.XPATH, using = "//a[text()='Application Status']")
	WebElement Applicationstatus;
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;
	@FindBy(how = How.XPATH, using = "//button[@id='applViewStages_0']")
	WebElement Proceed;
	@FindBy(how = How.XPATH, using = "//input[@class='chk']")
	WebElement SelectCOVCheckbox;
	@FindBy(how = How.XPATH, using = "//button[@id='prcdbook']")
	WebElement Proceedbook;
	@FindBy(how = How.XPATH, using = "//button[@id='slotbtn']")
	WebElement Bookslot;
	@FindBy(how = How.XPATH, using = "//button[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbook;
	@FindBy(how = How.XPATH, using = "//input[@id='home']")
	WebElement Home;
	@FindBy(how = How.XPATH, using = "//input[@value='DL SLOT BOOK']")
	WebElement Clickradio;
	@FindBy(how = How.XPATH, using = "//input[@value='LL/DL SERVICES SLOT BOOK']")
	WebElement ClickradioDLService;
	@FindBy(how = How.XPATH, using = "//input[@id='slotcnfrmbtn']")
	WebElement Confirm_slotbookDLService;

	public void Clickon_Confirm_slotbooking() {
		stepstatus = basepage.clickElement(Confirm_slotbookDLService);
		wait(2);
		// stepstatus = basepage.navigate(driver,
		// "https://sarathicov.nic.in:8443/sarathiservice/applViewStages.do");
		// driver.findElement(By.xpath("//input[@name='applNum']")).sendKeys(getdata("NewDLApplicationno"));
		// driver.findElement(By.xpath("//input[@name='dateOfBirth']")).sendKeys(getdata("DateofBirth"));
		// driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}

	@FindBy(how = How.XPATH, using = "//input[@name='HOME']")
	WebElement HOMEbutton;

	public void Clickon_HOMEbutton() {
		stepstatus = basepage.clickElement(HOMEbutton);
		reportEvent(stepstatus, "Able to click HOMEbutton", "Unable to  click HOMEbutton", driver, true);
	}

	public void Clickon_ProceedforDLServices() throws IOException {
		if (basepage.clickElement(ClickradioDLService)) {
			stepstatus = basepage.clickElement(Proceed);
			String PageTitle = driver.getTitle();
			System.out.println(PageTitle);
			if (PageTitle.equalsIgnoreCase("Sending SMS")) {
				loaddata();
				GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlotatDlService();

			} else {
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlotatDlService();
			}

		}
	}

	@FindBy(how = How.XPATH, using = "//input[@value='  PROCEED TO BOOK  ']")
	WebElement ProceedtoBookSlotatDlService;

	public void Clickon_ProceedtoBookSlotatDlService() {
		stepstatus = basepage.clickElement(ProceedtoBookSlotatDlService);
		reportEvent(stepstatus, "Able to click ProceedtoBookSlot button", "Unable to click ProceedtoBookSlot button",
				driver, true);

	}

	public void Booking_SlotforDLServices() {
		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		WebElement TotalGreenColorDates;
		String Datestext;
		List<WebElement> Timeslots;
		int timeslots;
		WebElement eletimeslot;
		String timeslottxt;
		WebElement seatslabel;
		String seatstxt;
		if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();
			Timeslots = driver.findElements(
					By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(
						By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1
								+ "+" + j + "]/td[2]/label"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1
									+ "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
				}
			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[@class='table table-bordered table-striped']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int j = 0; j < timeslots; j++) {
							eletimeslot = Timeslots.get(j);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath(
									"//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1
											+ "+" + j + "]/td[2]/label"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
								driver.findElement(By.xpath(
										"//table[@class='table table-bordered table-striped']//following-sibling::tr["
												+ 1 + "+" + j + "]/td[2]/input"))
										.click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}

				} else {
					System.out.println("Processing your Slot booking");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				GreenColorDates.get(i).click();
				Timeslots = driver.findElements(
						By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr/td[1]"));
				timeslots = Timeslots.size();
				System.out.println(timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(
							By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr[" + 1
									+ "+" + j + "]/td[2]/label"));
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
						driver.findElement(
								By.xpath("//table[@class='table table-bordered table-striped']//following-sibling::tr["
										+ 1 + "+" + j + "]/td[2]/input"))
								.click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					}

				}

			}

		}
	}

	// Related methods to perform operation on webelements
	public void Clickon_Applyonline() {
		stepstatus = basepage.clickElement(Applyonline);
		reportEvent(stepstatus, "Able to click Apply online Link", "Unable to click Apply online Link", driver, true);
	}

	public void Clickon_Application_Status_Link() {
		stepstatus = basepage.clickElement(Applicationstatus);
		reportEvent(stepstatus, "Able to click on Applicationstatus Link", "Unable to cclick on Applicationstatus Link",
				driver, true);
	}

	public void Set_Application_Number(String value) {
		stepstatus = basepage.setText(Application_Number, value);
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver,
				true);
	}

	public void Set_DateofBirth(String value) {
		stepstatus = basepage.setText(DateofBirth, value);
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver, true);
	}

	public void Clickon_Submit_Button() {
		stepstatus = basepage.clickElement(Submit);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver, true);
	}

	public void Do_ScrollDown() {
		stepstatus = basepage.scrooldown(driver);
		reportEvent(stepstatus, "Able to do Scrolldown", "Unable to do Scrolldown", driver, true);
	}

	public void Clickon_Proceed_Button() throws IOException {
		if (basepage.clickElement(Clickradio)) {
			stepstatus = basepage.clickElement(Proceed);
			String PageTitle = driver.getTitle();
			System.out.println(PageTitle);
			if (PageTitle.equalsIgnoreCase("Sending SMS")) {
				String env = getdata("ApplicationEnvironment");
				if (env.equalsIgnoreCase("SarathiCOV")) {
					loaddata();
					GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
				} else if (env.equalsIgnoreCase("SarathiProd")) {
					loaddata();
					GetSecutiryCode(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
				} else {
					System.out.println("Log URL is not matched.Please try again");
				}
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlot_Button();

			} else {
				Clickon_Selectcov();
				Clickon_ProceedtoBookSlot_Button();
			}

		}
	}

	@FindBy(how = How.XPATH, using = "//button[@id='prcdbook']")
	WebElement ProceedtoBookSlot;

	public void Clickon_ProceedtoBookSlot_Button() {
		stepstatus = basepage.clickElement(ProceedtoBookSlot);
		reportEvent(stepstatus, "Able to click ProceedtoBookSlot button", "Unable to click ProceedtoBookSlot button",
				driver, true);

	}

	public String GetSecutiryCode(String url) throws IOException {
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
		try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
			String strCurrentLine;
			int count = 0;
			while ((strCurrentLine = br.readLine()) != null) {
				if (strCurrentLine.contains("One Time Password is")) {
					if (strCurrentLine.contains("One Time Password is")) {
						getotp = strCurrentLine.substring(93, 99).trim();
						// System.out.println(getotp);
					}
					count++;
				} else {
					System.out.println("#######################Pleasae Check OTP Section###########################");
				}
			}
			// System.out.println(count);
			System.out.println(getotp);
			driver.switchTo().window(tabs.get(0));
			driver.findElement(By.xpath("//input[@id='securityForm_smsCode']")).sendKeys(getotp);
			driver.findElement(By.xpath("//input[@id='securityForm_smsCode']")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("//input[@id='securityForm__submitSecurityCode']")).click();
			driver.switchTo().window(tabs.get(1)).close();
			driver.switchTo().window(tabs.get(0));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return getotp;
	}

	public void Clickon_Selectcov() {
		// stepstatus = basepage.clickElement(SelectCOVCheckbox);
		List<WebElement> Allchecks = driver.findElements(By.xpath("//input[@class='chk']"));
		int size = Allchecks.size();
		System.out.println("Total Checkbox Availble to click" + size);
		for (WebElement cks : Allchecks) {
			setCheckBox(cks, "ON");
		}

		// reportEvent(stepstatus, "Able to click SelectCOVCheckbox", "Unable to click
		// SelectCOVCheckbox", driver, true);
	}

	public void Clickon_Proceedbook() {
		stepstatus = basepage.clickElement(Proceedbook);
		reportEvent(stepstatus, "Able to click Proceedbook", "Unable to click Proceedbook", driver, true);
	}

	public void Create_RandomDate() {
		stepstatus = basepage.Random_Datepicker(driver);
		reportEvent(stepstatus, "Able to click Randomdate", "Unable to  click Randomdate", driver, true);
	}

	public void Clickon_Slotbookingbutton(String ObjectXpath, String ObjectXpath1) {
		stepstatus = basepage.Slot_booking(driver, ObjectXpath, ObjectXpath1);
		reportEvent(stepstatus, "Able to do slotbooking", "Unable to do slotbooking", driver, true);
	}

	public void Clickon_Bookslotbutton() {
		stepstatus = basepage.clickElement(Bookslot);
		reportEvent(stepstatus, "Able to click Bookslotbutton", "Unable to  click Bookslotbutton", driver, true);
	}

	public void Clickon_Confirm_slotbookingbutton() throws IOException {
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
		if (PageTitle.equalsIgnoreCase("Sending SMS")) {
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				loaddata();
				GetSecutiryCode(prop.getProperty("SarathiCOVSlotsSecurityCodeLogURL"));
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				loaddata();
				GetSecutiryCode(prop.getProperty("SarathiprodSlotsSecurityCodeLogURL"));
			} else {
				System.out.println("Log URL is not matched.Please try again");
			}
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(2);
		} else {
			stepstatus = basepage.clickElement(Confirm_slotbook);
			wait(2);
		}

	}

	@FindBy(how = How.XPATH, using = "//input[@name='NEXT']")
	WebElement Next;

	public void Clickon_Next() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click Next", "Unable to  click Next", driver, true);
	}

	public void Booking_Slot() {
		List<WebElement> GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
		int TotalAvailbleGreenColorDates = GreenColorDates.size();
		System.out.println("Available Dates: " + TotalAvailbleGreenColorDates);
		WebElement TotalGreenColorDates;
		String Datestext;
		List<WebElement> Timeslots;
		int timeslots;
		WebElement eletimeslot;
		String timeslottxt;
		WebElement seatslabel;
		String seatstxt;
		if (TotalAvailbleGreenColorDates == 1) {
			System.out.println("Last Working day of the month");
			WebElement lstdaymnth = driver.findElement(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
			String textlstday = lstdaymnth.getText();
			System.out.println("Last Working day of the month is: " + textlstday);
			lstdaymnth.click();
			Timeslots = driver.findElements(By.xpath(
					"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
			timeslots = Timeslots.size();
			System.out.println(timeslots);

			loop: for (int j = 0; j < timeslots; j++) {
				eletimeslot = Timeslots.get(j);
				timeslottxt = eletimeslot.getText();
				seatslabel = driver.findElement(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr[" + 1
								+ "+" + j + "]/td[2]/span"));
				seatstxt = seatslabel.getText();
				if (!seatstxt.equalsIgnoreCase("0")) {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
									+ 1 + "+" + j + "]/td[2]/input"))
							.click();

					break loop;
				} else {
					System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
				}

			}
			try {
				boolean verifybtnenabled = driver.findElement(By.xpath("//button[@id='slotbtn']")).isEnabled();
				if (verifybtnenabled == false) {
					outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
						GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
						TotalGreenColorDates = GreenColorDates.get(i);
						Datestext = TotalGreenColorDates.getText();
						System.out.println(Datestext);
						GreenColorDates.get(i).click();
						Timeslots = driver.findElements(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
						timeslots = Timeslots.size();
						System.out.println(timeslots);

						for (int j = 0; j < timeslots; j++) {
							eletimeslot = Timeslots.get(j);
							timeslottxt = eletimeslot.getText();
							seatslabel = driver.findElement(By.xpath(
									"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
											+ 1 + "+" + j + "]/td[2]/span"));
							seatstxt = seatslabel.getText();
							if (!seatstxt.equalsIgnoreCase("0")) {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
								driver.findElement(By.xpath(
										"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
												+ 1 + "+" + j + "]/td[2]/input"))
										.click();

								break outerloop;
							} else {
								System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
							}

						}

					}

				} else {
					System.out.println("Processing your Slot booking");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			outerloop: for (int i = 0; i < TotalAvailbleGreenColorDates; i++) {
				GreenColorDates = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']/a"));
				TotalGreenColorDates = GreenColorDates.get(i);
				Datestext = TotalGreenColorDates.getText();
				System.out.println(Datestext);
				GreenColorDates.get(i).click();
				Timeslots = driver.findElements(By.xpath(
						"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr/td[1]"));
				timeslots = Timeslots.size();
				System.out.println(timeslots);

				for (int j = 0; j < timeslots; j++) {
					eletimeslot = Timeslots.get(j);
					timeslottxt = eletimeslot.getText();
					seatslabel = driver.findElement(By.xpath(
							"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
									+ 1 + "+" + j + "]/td[2]/span"));
					seatstxt = seatslabel.getText();
					if (!seatstxt.equalsIgnoreCase("0")) {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
						driver.findElement(By.xpath(
								"//table[@class='table table-bordered table-striped table-hover']//following-sibling::tr["
										+ 1 + "+" + j + "]/td[2]/input"))
								.click();

						break outerloop;
					} else {
						System.out.println(timeslottxt + " Availble Seats is: " + seatstxt);
					}

				}

			}

		}
	}

}
