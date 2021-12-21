package org.junit;

import java.util.Date;

import org.baseclass.BaseClass;
import org.baseclass.PojoClass;


public class Task4 extends BaseClass {

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
		loadUrl("https://www.flipkart.com/account/login");
		System.out.println(new Date());
	}

	@After
	public void endTime() {
		System.out.println(new Date());
	}

	@Test
	public void flipkart() {
		String title = driver.getTitle();
		Assert.assertEquals("Check the Title", "Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com", title);
		PojoClass p = new PojoClass();
		p.getemail().sendKeys("Greens");
		p.getpassword().sendKeys("Greens@123");
		p.getsubmit().click();
	}
}