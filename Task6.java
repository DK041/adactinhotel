package org.junit;

import java.io.IOException;
import java.util.Date;

import org.baseclass.BaseClass;
import org.baseclass.PojoClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Task6 extends BaseClass {

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
		loadUrl("http://www.adactin.com/HotelApp/");
		System.out.println(new Date());
	}

	@After
	public void endTime() {
		System.out.println(new Date());
	}

	@Test
	public void HotelBooking() throws IOException, InterruptedException {
	
		PojoClass p = new PojoClass();

		fill(p.getUsername(),"blablabla");
		fill(p.getTxtPassword(), "password");
		btnClick(p.getSubmit());
		driver.findElement(By.id("location"));
		driver.findElement(By.xpath("//option[@value='Brisbane']")).click();
		driver.findElement(By.id("hotels"));
		driver.findElement(By.xpath("//option[@value='Hotel Cornice']")).click();
		driver.findElement(By.id("room_type"));
		driver.findElement(By.xpath("//option[@value='Deluxe']")).click();
		driver.findElement(By.id("room_nos"));
		driver.findElement(By.xpath("//option[@value='1']")).click();
		driver.findElement(By.id("Submit")).click();

		Thread.sleep(3000);
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
		WebElement firstName = driver.findElement(By.id("first_name"));
		fill(firstName, "Greens");
		WebElement lastName = driver.findElement(By.id("last_name"));
		fill(lastName, "Technology");
		WebElement address = driver.findElement(By.id("address"));
		fill(address, "Chennai");
		WebElement ccNum = driver.findElement(By.id("cc_num"));
		fill(ccNum, "1234567891234567");
		driver.findElement(By.id("cc_type"));
		driver.findElement(By.xpath("//option[@value='VISA']")).click();
		driver.findElement(By.id("cc_exp_month"));
		driver.findElement(By.xpath("//option[@value='3']")).click();
		driver.findElement(By.id("cc_exp_year"));
		driver.findElement(By.xpath("//option[@value='2022']")).click();
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		fill(cvv, "123");
		driver.findElement(By.id("book_now")).click();
		
		Thread.sleep(5000);
		String attribute = driver.findElement(By.id("order_no")).getAttribute("value");
		System.out.println(attribute);
	}
}