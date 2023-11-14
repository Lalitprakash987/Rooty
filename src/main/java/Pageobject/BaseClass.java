package Pageobject;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.lang.System.Logger;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.util.Cast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected static LoginPageElement loginpage1;
	protected static DashboardPageElement Driver1;
	public static WebDriver driver;
	public static Logger logger;
	public ExtentSparkReporter htmlReporter;
	public ExtentReports reports;
	public static String test;

	@BeforeClass
	public void setUp() throws AWTException {
		// WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		logger = LogManager.getLogger(BaseClass.class);
		PropertyConfigurator.configure("Log4j.properties");
		driver.get("https://www.google.com/");
		logger.info("Open Google Url");
		driver.manage().window().maximize();
		driver.get("https://24livehosts.com/rootyapplication/");
		logger.info("Open Rooty Home Page");
		driver.get("https://24livehosts.com/rootyapplication/login");
		logger.info("Open Rooty Login Page");
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		loginpage1 = new LoginPageElement(driver);
		Driver1 = new DashboardPageElement(driver);

	}

	@AfterClass
	public void tearDown() throws IOException {

		driver.quit();
	}

	@BeforeTest
	public void test() {
		htmlReporter = new ExtentSparkReporter("AutomationExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Rooty Bugs Report"); // Title of the report
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");
		

	
	}

	@AfterTest
	public void test1() throws IOException {
		reports.flush();
		Desktop.getDesktop().browse(new File("AutomationExtentReport.html").toURI());
	}
public  String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot)driver;
	String destination = System.getProperty("user.dir")+ "/FailedTestsScreenshots/" + screenshotName + dateName +".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
			
	
	
	return destination;
	
}
//	public void screenshort() throws IOException {
//
//		// screenshot of full page
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		File trg = new File("C:\\Users\\Administrator\\eclipse-workspace\\Rooty\\Screenshots\\fullpage.png");
//		FileUtils.copyFile(src, trg);

		// copy image file to destination

		// screenshot of section/portion of page // WebElement section =
//	  driver.findElement(By.xpath("")); // File src =
//	  section.getScreenshotAs(OutputType.FILE); // File trg = new //
//	  File("C:\\Users\\Administrator\\eclipse-workspace\\Rooty\\screenshot"); //
//	  FileUtils.copyFile(src, trg); // screenshot of element of page (has same
//	  approche using of section of page)

	

//	public static String CaptureScreen(WebDriver driver) throws IOException {
//		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		File Destinationfile = new File(
//				"C:\\Users\\Administrator\\eclipse-workspace\\Rooty\\src" + System.currentTimeMillis() + ".png");
//		String absolutepath_screen = Destinationfile.getAbsolutePath();
//		FileUtils.copyDirectory(srcfile, Destinationfile);
//		return absolutepath_screen;
//
//	}

	
	
	
	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
