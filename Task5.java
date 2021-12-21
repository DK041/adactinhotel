package org.junit;

import java.io.IOException;
import java.util.Date;

import org.baseclass.BaseClass;
import org.baseclass.PojoClass;
import org.openqa.selenium.By;

public class Task5 extends BaseClass {

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
	public void toolsQa() throws IOException {
		String title = driver.getTitle();
		Assert.assertEquals("Check the Title", "Tools QA - Selenium Training", title);
		PojoClass p = new PojoClass();

		fill(p.getFirstName(), getData(0, 0));
		fill(p.getLastName(), getData(0, 1));
		fill(p.getTxtUser(), getData(0, 2));
		fill(p.getMobile(), getData(0, 3));
		dropDown(driver.findElement(By.id("country")), "4");
		fill(p.getCity(), getData(0, 5));
		fill(p.getMessage(), getData(0, 6));

	}
}