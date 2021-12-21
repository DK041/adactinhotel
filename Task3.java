package org.junit;

import java.util.Date;

import org.baseclass.BaseClass;
import org.baseclass.PojoClass;
import org.openqa.selenium.By;

public class Task3 extends BaseClass {

	@BeforeClass
	public static void lauchBrowser() {
		launchChrome();
		winMax();
	}

	@AfterClass
	public static void closeBrowser() {
		closeBrowser();
	}

	@Before
	public void url() {
		loadUrl("https://www.toolsqa.com/selenium-training/#enroll-form");
		System.out.println(new Date());
	}

	@After
	public void endTime() {
		System.out.println(new Date());
	}

	@Test
	public void toolsQa() {
		String title = driver.getTitle();
		Assert.assertEquals("Check the Title", "Tools QA - Selenium Training", title);
		PojoClass p = new PojoClass();
		fill(p.getFirstName(), "Arun");
		fill(p.getLastName(), "Kumar");
		fill(p.getTxtUser(), "greenstech@gmail.com");
		fill(p.getMobile(), "9876543210");
		dropDown(driver.findElement(By.id("country")), "4");
		fill(p.getCity(), "Chennai");
		fill(p.getMessage(), "Framework");

	}
}