package com.SkillioProject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TraditionalLoginPageTestCases {

	public static String getCurrentTimeDate() {
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

	@Test
	public void toVerifySuccessfullLogin() throws IOException {
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualDashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		String expectedDashboardText = "Dashboard";
		Assert.assertEquals(actualDashboardText, expectedDashboardText, "User is not successfully login");
		
		Screenshot src = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(400)).takeScreenshot(driver);
		BufferedImage img = src.getImage();
		ImageIO.write(img, "png", new File("src/ScreenShots/" +getCurrentTimeDate() + "_screenShotUsingAshot.png"));
		driver.quit();
	}
}
