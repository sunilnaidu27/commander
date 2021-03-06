package testScripts;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import applicationPages.DLModule;
import applicationPages.FactoryUtilities;
import frameworkLibrary.BaseClass;

public class Services extends BaseClass {
	WebDriver currentdriver;
	DLModule dl;
	FactoryUtilities Utility;

	@BeforeMethod
	public void before() throws IOException {
		System.out.println("Before Method");
	}

	
	@Test(invocationCount = 1)
	public void DLServices() throws IOException, ClassNotFoundException, SQLException, InterruptedException {

		dl = new DLModule(currentdriver);
		dl.StartAPP();
		dl.selectState();
		dl.Validate_Service();
		
	}
	

	@AfterMethod
	public void after() {
		System.out.println("After Method");
		//quitdriver(currentdriver);
	}

}
