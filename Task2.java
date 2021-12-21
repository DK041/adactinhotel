package org.junit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;

public class Task2 extends BaseClass {

	@BeforeClass
	public static void lauchBrowser() {
		launchChrome();
		winMax();
	
	}

	@AfterClass
	public static void closeBrowser() {
		System.out.println("success");
	}

	@Before
	public void url() {
		loadUrl("https://www.redbus.in/");
		System.out.println(new Date());
	}

	@After
	public void endTime() {
		System.out.println(new Date());
	}

	@Test
	public void redbus() throws InterruptedException, AWTException{
		String url = driver.getCurrentUrl();
		Assert.assertEquals("https://www.redbus.in/", url);
		driver.findElement(By.id("signin-block")).click();
		driver.findElement(By.id("hc")).click();
		Thread.sleep(4000);
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']")).click();
		driver.findElement(By.id("mobileNoInp")).sendKeys("9876543210");
		Thread.sleep(5000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id("otp-container")).click();
	}


}
