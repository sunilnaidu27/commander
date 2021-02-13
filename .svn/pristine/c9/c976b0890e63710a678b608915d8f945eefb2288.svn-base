package applicationPages;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginRTO extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;

	public LoginRTO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement Username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@id='logmode']")
	WebElement Captcha;

	@FindBy(how = How.XPATH, using = "//input[@id='frmsubmt']")
	WebElement Next;

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement Singin;

	// related methods to perform operation on webelements
	public void setUserName(String Strusername) {
		stepstatus = basepage.setText(Username, Strusername);
		// reportEvent(stepstatus, "Able to enter username", "Unable to enter username",
		// driver);
	}

	public void setpassword(String Strpassword) {
		stepstatus = basepage.setText(Password, Strpassword);
		// reportEvent(stepstatus, "Able to enter password", "Unable to enter password",
		// driver);
		if (driver.getPageSource().contains("Next")) {
			ClickonNext();
			// SetCaptcha();
			JFrame Dialog = new JFrame();
			String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
			driver.findElement(By.xpath("//input[@id='logmode']")).sendKeys(name);
		} else {
			SetCaptcha();
		}

	}

	@FindBy(how = How.XPATH, using = "//div[@id='servervalid']/span")
	WebElement ifalreadySingin;

	public void ClickonLogin() {
		stepstatus = basepage.clickElement(Singin);
		if (isDisplayed(ifalreadySingin) == true) {
			stepstatus = basepage.clickElement(Singin);
		}

		//VerifyRTOSelection();
	}

	public void SetCaptcha() {
		stepstatus = basepage.setText(Captcha, "123456");

		// reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha",
		// driver, true);
	}

	public void ClickonNext() {
		stepstatus = basepage.clickElement(Next);
		// reportEvent(stepstatus, "Able to click on Next BUtton", "Unable to click on
		// Next Button", driver, true);
	}

	public void VerifyRTOSelection() {
		if (driver.getPageSource().contains("User RTO Login")) {
			code = getdata("RTOCode");
			// List<WebElement> apprtolst =
			// driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[2]"));
			// int lstsize = apprtolst.size();
			List<WebElement> camplst = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[5]"));
			int camplstsize = camplst.size();

			for (int i = 0; i < camplstsize; i++) {

				String text = driver
						.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[5]"))
						.getText();
				if (text.equalsIgnoreCase("--------")) {
					System.out.println("Camp Details Matched");
					String rtotxt = driver.findElement(By.xpath(
							"//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[5]/preceding-sibling::td[3]"))
							.getText();
					if (rtotxt.equalsIgnoreCase(code)) {
						System.out.println("RTO Code Matched");
						driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
								+ "]/td[5]/preceding-sibling::td[4]/input")).click();
						break;
					}

				}

			}

			// driver.findElement(By.xpath("//input[@id='crd3']")).click();
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		} else {
			System.out.println("There is no RTO Selection");
		}
	}

}
