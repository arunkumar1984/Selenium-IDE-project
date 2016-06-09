package com.sqa.av;

import static org.testng.Assert.*;

import java.util.concurrent.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

/**
 * EBaySeleniumTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 * 
 * @author Venkatraman, Arunkumar
 * @version 1.0.0
 * @since 1.0
 *
 */
public class EBaySeleniumTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * @throws Exception
	 */
	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		this.driver = new FirefoxDriver();
		this.baseUrl = "http://www.ebay.com/";
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * @throws Exception
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		this.driver.quit();
		String verificationErrorString = this.verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testEBaySelenium() throws Exception {
		this.driver.get(this.baseUrl + "/");
		this.driver.findElement(By.linkText("Sign in")).click();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[4]/span[2]/input"))
				.sendKeys("arunkumar.venkatraman@gmail.com");
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).clear();
		this.driver.findElement(By.xpath("//div[@id='pri_signin']/div[5]/span[2]/input")).sendKeys("Unfourg1ven@");
		this.driver.findElement(By.id("sgnBt")).click();
		this.driver.findElement(By.id("gh-ac")).click();
		this.driver.findElement(By.id("gh-ac")).clear();
		this.driver.findElement(By.id("gh-ac")).sendKeys("Horizon 1% Plain Asep (3 x 6 pack)");
		this.driver.findElement(By.id("gh-btn")).click();
		this.driver.findElement(By.cssSelector("a.vip.visited")).click();
		this.driver.findElement(By.id("qtyTextBox")).click();
		this.driver.findElement(By.id("qtyTextBox")).clear();
		this.driver.findElement(By.id("qtyTextBox")).sendKeys("3");
		this.driver.findElement(By.id("isCartBtn_btn")).click();
		this.driver.findElement(By.linkText("Remove")).click();
		this.driver.findElement(By.id("gh-shop-a")).click();
		this.driver.findElement(By.cssSelector("b.gh-eb-arw.gh-sprRetina")).click();
		this.driver.findElement(By.linkText("Sign out")).click();
		this.driver.findElement(By.id("gh-logo")).click();
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = this.driver.switchTo().alert();
			String alertText = alert.getText();
			if (this.acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			this.acceptNextAlert = true;
		}
	}

	private boolean isAlertPresent() {
		try {
			this.driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
