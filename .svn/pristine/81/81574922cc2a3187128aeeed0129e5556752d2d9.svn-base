package applicationPages;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FactoryUtilities extends BasePage {
	BasePage basepage = new BasePage();
	WebDriver driver;
	boolean stepstatus;
	String env;

	public FactoryUtilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void launchBrowser(String BrowserName) throws IOException {
		loaddata();
		switch (BrowserName.toLowerCase()) {
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("permissions.default.camera", 1);
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			driver = new FirefoxDriver(capabilities);
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				driver.get(prop.getProperty("SarathiCOV"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to SarathiCOV");
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				driver.get(prop.getProperty("SarathiProd"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to Sarathiprod");
			} else if (env.equalsIgnoreCase("CommonPortal")) {
				driver.get(prop.getProperty("CommonPortal"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to CommonPortal");
			} else {
				System.out.println("Application URL is not matched.Please try again");
			}
			break;
		}

		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
			ChromeOptions capability = new ChromeOptions();
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			capability.addArguments("use-fake-device-for-media-stream");
			capability.addArguments("use-fake-ui-for-media-stream");
			Map<String, Object> preferences = new Hashtable<String, Object>();
			capability.setExperimentalOption("prefs", preferences);
			preferences.put("plugins.always_open_pdf_externally", true);
			driver = new ChromeDriver(capability);
			String env = getdata("ApplicationEnvironment");
			if (env.equalsIgnoreCase("SarathiCOV")) {
				driver.get(prop.getProperty("SarathiCOV"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to SarathiCOV");
				StateSelection();
			} else if (env.equalsIgnoreCase("SarathiProd")) {
				driver.get(prop.getProperty("SarathiProd"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to Sarathiprod");
			} else if (env.equalsIgnoreCase("CommonPortal")) {
				driver.get(prop.getProperty("CommonPortal"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				System.out.println("Welcome to CommonPortal");
			}

			else {
				System.out.println("Application URL is not matched.Please try again");
			}

			break;
		}
		default: {
			System.out.println("Please select the correct browser");
		}
		}
	}

	public void StateSelection() throws IOException {
		loaddata();
		stcode = getdata("State");
		NewLLRegistrtionPage NewLLRegistrtionPage = new NewLLRegistrtionPage(driver);
		if (stcode.equalsIgnoreCase("AN")) {
			Selectstatename(prop.getProperty("AN"));
		} else if (stcode.equalsIgnoreCase("AP")) {
			Selectstatename(prop.getProperty("AP"));

		} else if (stcode.equalsIgnoreCase("AR")) {
			Selectstatename(prop.getProperty("AR"));

		} else if (stcode.equalsIgnoreCase("AS")) {
			Selectstatename(prop.getProperty("AS"));

		} else if (stcode.equalsIgnoreCase("BR")) {
			Selectstatename(prop.getProperty("BR"));

		} else if (stcode.equalsIgnoreCase("CG")) {
			Selectstatename(prop.getProperty("CG"));

		} else if (stcode.equalsIgnoreCase("CH")) {
			Selectstatename(prop.getProperty("CH"));

		} else if (stcode.equalsIgnoreCase("DD")) {
			Selectstatename(prop.getProperty("DD"));

		} else if (stcode.equalsIgnoreCase("DL")) {
			Selectstatename(prop.getProperty("DL"));

		} else if (stcode.equalsIgnoreCase("DN")) {
			Selectstatename(prop.getProperty("DN"));

		} else if (stcode.equalsIgnoreCase("GA")) {
			Selectstatename(prop.getProperty("GA"));

		} else if (stcode.equalsIgnoreCase("GJ")) {
			Selectstatename(prop.getProperty("GJ"));

		} else if (stcode.equalsIgnoreCase("HP")) {
			Selectstatename(prop.getProperty("HP"));

		} else if (stcode.equalsIgnoreCase("HR")) {
			Selectstatename(prop.getProperty("HR"));

		} else if (stcode.equalsIgnoreCase("JH")) {
			Selectstatename(prop.getProperty("JH"));

		} else if (stcode.equalsIgnoreCase("JK")) {
			Selectstatename(prop.getProperty("JK"));

		} else if (stcode.equalsIgnoreCase("KA")) {
			Selectstatename(prop.getProperty("KA"));

		} else if (stcode.equalsIgnoreCase("KL")) {
			Selectstatename(prop.getProperty("KL"));

		} else if (stcode.equalsIgnoreCase("LA")) {
			Selectstatename(prop.getProperty("LA"));

		} else if (stcode.equalsIgnoreCase("LD")) {
			Selectstatename(prop.getProperty("LD"));

		} else if (stcode.equalsIgnoreCase("MH")) {
			Selectstatename(prop.getProperty("MH"));

		} else if (stcode.equalsIgnoreCase("ML")) {
			Selectstatename(prop.getProperty("ML"));

		} else if (stcode.equalsIgnoreCase("MN")) {
			Selectstatename(prop.getProperty("MN"));

		} else if (stcode.equalsIgnoreCase("MP")) {
			Selectstatename(prop.getProperty("MP"));

		} else if (stcode.equalsIgnoreCase("MZ")) {
			Selectstatename(prop.getProperty("MZ"));

		} else if (stcode.equalsIgnoreCase("NL")) {
			Selectstatename(prop.getProperty("NL"));

		} else if (stcode.equalsIgnoreCase("OD")) {
			Selectstatename(prop.getProperty("OD"));

		} else if (stcode.equalsIgnoreCase("PB")) {
			Selectstatename(prop.getProperty("PB"));

		} else if (stcode.equalsIgnoreCase("PY")) {
			Selectstatename(prop.getProperty("PY"));

		} else if (stcode.equalsIgnoreCase("RJ")) {
			Selectstatename(prop.getProperty("RJ"));

		} else if (stcode.equalsIgnoreCase("SK")) {
			Selectstatename(prop.getProperty("SK"));

		} else if (stcode.equalsIgnoreCase("TN")) {
			Selectstatename(prop.getProperty("TN"));

		} else if (stcode.equalsIgnoreCase("TR")) {
			Selectstatename(prop.getProperty("TR"));

		} else if (stcode.equalsIgnoreCase("TS")) {
			Selectstatename(prop.getProperty("TS"));

		} else if (stcode.equalsIgnoreCase("UA")) {
			Selectstatename(prop.getProperty("UA"));

		} else if (stcode.equalsIgnoreCase("UK")) {
			Selectstatename(prop.getProperty("UK"));

		} else if (stcode.equalsIgnoreCase("UP")) {
			Selectstatename(prop.getProperty("UP"));

		} else if (stcode.equalsIgnoreCase("WB")) {
			Selectstatename(prop.getProperty("WB"));
		} else {
			System.out.println("Selected State is not available.Please check and Try Again.");
		}

	}

	public String Selectstatename(String Option) {
		WebElement State = driver.findElement(By.xpath("//select[@name='stName']"));
		Select state = new Select(State);
		state.selectByVisibleText(Option);
		return Option;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	WebElement Username;
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement Password;
	@FindBy(how = How.XPATH, using = "//input[@id='frmsubmt']")
	WebElement Next;
	@FindBy(how = How.XPATH, using = "//input[@name='logmode']")
	WebElement Captcha;
	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement submit;
	@FindBy(how = How.XPATH, using = "//input[@id='crd1']")
	WebElement Radio;
	@FindBy(how = How.XPATH, using = "//input[@value='Login']")
	WebElement login;

	public void setUserName(String Strusername) {
		stepstatus = basepage.setText(Username, Strusername);
		reportEvent(stepstatus, "Able to enter username", "Unable to enter username", driver, true);
	}

	public void setpassword(String Strpassword) {
		stepstatus = basepage.setText(Password, Strpassword);
		reportEvent(stepstatus, "Able to enter password", "Unable to enter password", driver, true);
	}

	public void ClickonNext() {
		stepstatus = basepage.clickElement(Next);
		reportEvent(stepstatus, "Able to click on Next BUtton", "Unable to click on Next Button", driver, true);
	}

	public void SetCaptcha() {
		stepstatus = basepage.setText(Captcha, "123456");
		reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha", driver, true);
	}

	public void Clickonsubmit() {
		stepstatus = basepage.clickElement(submit);
		if (basepage.alertExist(driver)) {
			acceptAlert(driver);
		} else {
			System.out.println("There is no Alert Present");
		}
		reportEvent(stepstatus, "Able to click on submit BUtton", "Unable to click on submit Button", driver, true);
	}

	public void ClickonRadio() {
		stepstatus = basepage.clickElement(Radio);
		reportEvent(stepstatus, "Able to click on Radio BUtton", "Unable to click on Radio Button", driver, true);
	}

	public void Clickonlogin() {
		stepstatus = basepage.clickElement(login);
		reportEvent(stepstatus, "Able to click on Radio BUtton", "Unable to click on Radio Button", driver, true);
	}
}
