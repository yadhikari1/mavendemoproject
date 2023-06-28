package scrnshotmavendemo001;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class screenshot001 {
	WebDriver driver;
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public  void main() {
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		try {
			String title = driver.getTitle();
			Thread.sleep(4000);
			Assert.assertEquals(title, "abcd");
		
			
		}catch(Throwable e) {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String destinationPath = "/Users/yogendra/eclipse-workspace/mavendemo001/screenshot/scrnshots.png";
			try {
				FileUtils.copyFile(screenshotFile, new File(destinationPath));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
          System.out.println("Screenshot saved to: " + destinationPath);
			e.printStackTrace();
			System.out.println("hello");
		}
		
		
//		// Take a screenshot
//        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        // Specify the destination path and file name
//        String destinationPath = "/Users/yogendra/eclipse-workspace/mavendemo001/screenshot/scrnshots.png";
//
//        // Copy the screenshot file to the destination
//        try {
//            FileUtils.copyFile(screenshotFile, new File(destinationPath));
//            System.out.println("Screenshot saved to: " + destinationPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
	
		
	}}
	
		
	
	
