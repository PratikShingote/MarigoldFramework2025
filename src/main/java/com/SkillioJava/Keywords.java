package com.SkillioJava;

import static propertiesUtility.PropertiesUtil.envDataFilePath;
import static propertiesUtility.PropertiesUtil.getPropertyFileData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {
	public static RemoteWebDriver driver = null;
	public static FluentWait<WebDriver> wait = null;

	public void launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.out.println("You have entered invalid browser name, so by default opening chrome browser");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		wait = new FluentWait(Keywords.driver);
		wait.withTimeout(Duration.ofSeconds(90));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
	}

	public String getCurrentTimeDate() {
		// Get the current date and time
		LocalDateTime localTImeDate = LocalDateTime.now();
		// Define the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");// 2025_03_28_11_34_34
		// Format the current date and time
		String formattedNow = localTImeDate.format(formatter);// 2025_03_28_11_34_34
		// Print the formatted date and time
		System.out.println(formattedNow);
		return formattedNow;
	}
//using interface
//	public void launchURL() {
//		driver.get(TestData.appURL);
//	}

	public void launchURL() throws IOException {
		driver.get(getPropertyFileData(envDataFilePath, "appURLQA"));

	}

	public void waitElementToBePresent(String xpath) {
		// wait = new FluentWait(driver);
		// wait.withMessage("Element is not present in maximum time");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void waitElementToBePresent(String locatorType, String locatorVlaue) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("css")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("className")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorVlaue)));
		} else if (locatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorVlaue)));
		} else {
			System.err.println("Provide valid locator type!!!!");
		}
	}

	public void waitElementToBeClickable(String xpath) {
		// wait = new FluentWait(driver);
		// wait.withMessage("Element is not clickable in maximum time");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void enterText(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);

	}

	public void enterText(String locatorType, String locatorValue, String text) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("className")) {
			driver.findElement(By.className(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			driver.findElement(By.tagName(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			driver.findElement(By.linkText(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).sendKeys(text);
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).sendKeys(text);
		} else {
			System.err.println("Provide valid locator type!!!!");
		}
	}

	public void performClick(String xpath) {
		driver.findElement(By.xpath(xpath)).click(); // don't gives ("xpath") it throws exception nosuchelement
	}

	public String getActualText(String xpath) {

		String actualText = driver.findElement(By.xpath(xpath)).getText();
		return actualText;
	}

	public String getActualText(String locatorType, String locatorValue) {

		String actualText = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			actualText = driver.findElement(By.xpath(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("css")) {
			actualText = driver.findElement(By.cssSelector(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("className")) {
			actualText = driver.findElement(By.className(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			actualText = driver.findElement(By.tagName(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			actualText = driver.findElement(By.linkText(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			actualText = driver.findElement(By.partialLinkText(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("name")) {
			actualText = driver.findElement(By.name(locatorValue)).getText();
		} else if (locatorType.equalsIgnoreCase("id")) {
			actualText = driver.findElement(By.id(locatorValue)).getText();
		} else {
			System.err.println("Provide valid locator type!!!!");
		}
		return actualText;
	}

	/**
	 * 
	 * @param actual
	 * @param expected
	 */
	public void assertText(String actual, String expected) {
		Assert.assertEquals(actual, expected, "actual is not matched with expected");

	}

	/**
	 * This method is used to click on element depends on locator strategies Generic
	 * Method
	 * 
	 * @param locatorName  {@code linkText, name, cssSelector, xpath, partialLinkText, tagName, id, className}
	 * @param locatorValue {@code locatorValue}
	 */
	public void locatorStrat(String locatorName, String locatorValue) {
		if (locatorName.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("className")) {
			driver.findElement(By.className(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("linkText")) {
			driver.findElement(By.linkText(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("partialLinkText")) {
			driver.findElement(By.partialLinkText(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("name")) {
			driver.findElement(By.name(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("tagName")) {
			driver.findElement(By.tagName(locatorValue)).click();
		} else if (locatorName.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else {
			System.err.println("Invalid locator Strategy");
		}
	}

	public void clicklUsingJavaScript(String css) {

		String cssValue = "\"" + css + "\"";

		driver.executeScript("document.querySelector(" + cssValue + ").click()");
	}

	public void takeScreenshot() throws IOException {
		Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(400)).takeScreenshot(driver);
		BufferedImage img = src.getImage();
		ImageIO.write(img, "png", new File("src/ScreenShots/" + getCurrentTimeDate() + "_screenShotUsingAshot.png"));
	}
}
