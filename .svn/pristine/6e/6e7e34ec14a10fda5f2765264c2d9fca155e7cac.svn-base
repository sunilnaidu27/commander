package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ApplicationStatusPage extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public ApplicationStatusPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()=' Application Status']")
	WebElement Application_Status;
	@FindBy(how = How.XPATH, using = "//input[@name='applNum']")
	WebElement Application_Number;
	@FindBy(how = How.XPATH, using = "//input[@name='dateOfBirth']")
	WebElement DateofBirth;
	@FindBy(how = How.XPATH, using = "//input[@id='submit']")
	WebElement Submit;

	public void Clickon_Application_Status() {
		stepstatus = basepage.clickElement(Application_Status);
		reportEvent(stepstatus, "Able to click Application_Status", "Unable to click Application_Status", driver);
	}

	public void Set_Application_Number() {
		stepstatus = basepage.setText(Application_Number, getdata("ApplicationNo"));
		reportEvent(stepstatus, "Able to Enter Application Number ", "Unable to Enter Application Number", driver);
	}

	public void Set_DateofBirth() {
		stepstatus = basepage.SetTextAndTAB(DateofBirth, getdata("DateofBirth"));
		reportEvent(stepstatus, "Able to Enter Date of Birth ", "Unable to Enter Date of Birth", driver);
	}

	public void Clickon_Submit_Button() {
		stepstatus = basepage.clickElement(Submit);
		wait(1);
		scrooldown(driver);
		reportEvent(stepstatus, "Able to click submit button", "Unable to click submit button", driver);
	}

}
