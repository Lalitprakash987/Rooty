package TestCase;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Pageobject.LoginPageElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportClass {
	public ExtentSparkReporter htmlReporter;
	public ExtentReports reports;
	public ExtentReports reports1;
	public ExtentTest test;
	public static WebDriver driver;
	public static Logger logger;
	protected static LoginPageElement loginpage1;

	@BeforeTest
	public void startReport() {

		htmlReporter = new ExtentSparkReporter("AutomationExtentReport.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		// add environment details
		reports.setSystemInfo("Organization", "W3care Technologies Pvt. Ltd.");
		reports.setSystemInfo("Host Name", "LocalHost");
		reports.setSystemInfo("System", "windows");
		reports.setSystemInfo("OS", "Windows10 Pro");
		reports.setSystemInfo("Browser", "Chrome(Version 118.0.5993.118 (Official Build) (64-bit))");
		reports.setSystemInfo("Domain", "Engineering (IT - Software)");
		reports.setSystemInfo("Employee", "Lalit Fatehpuriya");

		// for configuration to change look and feel
		htmlReporter.config().setDocumentTitle("Rooty Bugs Report"); // Title of the report
		htmlReporter.config().setReportName("Automation Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')' ");

		// ExtentTest test1 = extentreports.createTest("Test01")

		// for Log Levels
		reports.createTest("LogLevels").info("info")

				.pass("Test case pass").warning("warning fro test case").skip("Test caseskip").fail("Test case fail");

		// for Screenshot
		reports.createTest("ScreenCapture").addScreenCaptureFromPath("reports.png")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("reports.png").build());
		// For device
		reports.createTest("Devices").assignDevice("Chrome", "Opera", "Firefox", "Microsoft edge");
		// .pass("Version 119.0.2151.44 (Official build) (64-bit)")
		// .fail("Version 119.0.2151.44 (Official build) (64-bit)")
		// .skip("Version 119.0.2151.44 (Official build) (64-bit)");

		// For author information
		reports.createTest("Authors").assignAuthor("Lalit Fatehpuriya", "Lalit mahajan", "Karan sharma");

		// .assignCategory("Smoke Testing", "sainity Testing ").assignDevice("Chrome
		// Browser", "opera")
		// .pass("This test 'Authors' was assigned by a special kind of author tag.");

		// for category
		reports.createTest("Tags").assignCategory("Smoke", "Sainty", "Regression")
				.pass("The test 'Tags' was assigned by the tag <span class='badge badge-primary'>MyTag</span>");

		// for exception
		reports.createTest("Exception! <i class='fa fa-frown-o'></i>")
				.fail(new RuntimeException("A runtime exception occurred!"));

		//
		/*
		 * reports.endTest(); test.log(LogStatus.PASS, "Test Passed");
		 * test.log(LogStatus.FAIL, "Test Failed"); test.log(LogStatus.SKIP,
		 * "Test Skipped"); test.log(LogStatus.INFO, "Test Info");
		 */


//		reports.endTest();
//		test.log(LogStatus.PASS,"Test Passed");
//		test.log(LogStatus.FAIL,"Test Failed");
//		test.log(LogStatus.SKIP,"Test Skipped");
//		test.log(LogStatus.INFO,"Test Info");
//









	}

	@AfterTest
	public void endReport() throws IOException {
		// for create new fresh report and delete all previous data of report
		reports.flush();
		// to direct open report on browser(is se open test case run hone ke baad direct
		// run ho jayegi )
		Desktop.getDesktop().browse(new File("AutomationExtentReport.html").toURI());

	}

	@Test
	public void Test001() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		test.getStatus();
		driver.quit();
	}

}
