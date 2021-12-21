package org.junit;

import java.util.Date;

import org.baseclass.BaseClass;
import org.baseclass.PojoClass;

public class Task1 extends BaseClass {
	PojoClass p = new PojoClass();

	@BeforeClass
	public static void launchingBrowser() {
		launchChrome();
		winMax();
	}

	@AfterClass
	public static void ClosingChrome() {
		closeChrome();

	}

	@Before
	public void StartTime() {
		loadUrl("https://www.facebook.com/");
		Date d = new Date();
		System.out.println(d);
	}

	@After
	public void EndTime() {
		System.out.println(new Date());

	}

	@Test
	public void tc1() throws InterruptedException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals("Verify the Url", "https://www.facebook.com/", url);
		PojoClass p = new PojoClass();
		fill(p.getTxtUser(), "Greens");
		fill(p.getTxtPass(), "Greens@123");
		btnClick(p.getBtnLogin());
		Thread.sleep(2000);

	}

	@Test
	public void tc3() throws InterruptedException {
		PojoClass p = new PojoClass();
		fill(p.getTxtUser(), "Java");
		fill(p.getTxtPass(), "Java@123");
		btnClick(p.getBtnLogin());
		Thread.sleep(2000);
	}

	@Test
	public void tc2() throws InterruptedException {
		PojoClass p = new PojoClass();
		fill(p.getTxtUser(), "Python");
		fill(p.getTxtPass(), "Python@123");
		btnClick(p.getBtnLogin());
		Thread.sleep(2000);

	}
}
