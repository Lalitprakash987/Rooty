package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;

import Pageobject.BaseClass;

public class LoginPageTestCase extends BaseClass {

	@Test(priority = 1)
	public void test01() throws IOException {
		ExtentTest test = reports.createTest("sign in with vaild email & invaild password")
				.assignAuthor("Lalit Fatehpuriya").assignCategory("Smoke Testing ")
				.assignDevice("chrome(Version 119.0.2151.44)");
		logger.info("sign in with vaild email & invaild password");
		loginpage1.enteremailid("superadmin@gmail.com");
		test.info("clicked on email id");

		test.log(test.getStatus(), MarkupHelper.createLabel("This will add item to the cart", ExtentColor.BLUE));
		test.log(Status.INFO,
				MarkupHelper.createLabel("*************** Using Labels ***************", ExtentColor.RED));
		test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 1", ExtentColor.BLUE));
		test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 2", ExtentColor.BLUE));
		test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 3", ExtentColor.BLUE));
		test.log(Status.INFO, MarkupHelper.createLabel("This is Test Logger 4", ExtentColor.BLUE));

		logger.info("clicked on email id");
		loginpage1.enterpassword("Queenqueenk1");
		test.info("clicked on password");
		logger.info("clicked on password");
		loginpage1.enterloginbutton();
		test.info("clicked on login button");
		logger.info("clicked on login button");
		sleep(1000);
		String title = driver
				.findElement(By.xpath("//strong[normalize-space()='These credentials do not match with our records.']"))
				.getText();
		if (title.equals("These credentials do not match with our records.")) {
			test.pass("Test Case Pass:-   " + title);
			logger.info("Test Case Pass");

		} else {
			test.fail("Test Case fail " + title);
			logger.info("Test Case fail ");
			// test.addScreenCaptureFromBase64String(base64);

		}
		loginpage1.clearemailid();
		test.info("clear emailid");
		logger.info("clear emailid");
		loginpage1.clearpassword();
		test.info("clear password");
		logger.info("clear password");

//		String title = driver
//				.findElement(By.xpath("//strong[normalize-space()='These credentials do not match with our records.']"))
//				.getText();
//		String Actualtext = "These credentials do not match with our records.";
//		Assert.assertEquals(Actualtext, title);
//		sleep(1000);
//		System.out.println("sign in with vaild email & invaild password");
//

	}

	private Media createLabel(String string, ExtentColor blue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test(priority = 2)
	public void test02() {
		ExtentTest test = reports.createTest("sign in with invaild email & vaild password")
				.assignAuthor("Lalit Fatehpuriya").assignCategory("Smoke Testing ")
				.assignDevice("chrome(Version 119.0.2151.44)");
		logger.info("sign in with invaild email & vaild password");
		loginpage1.enteremailid("dewv@pairroxz.com");
		test.info("clicked on email id");
		logger.info("clicked on email id");
		sleep(1000);
		loginpage1.enterpassword("Admin@123");
		test.info("clicked on password");
		logger.info("clicked on password");
		loginpage1.enterloginbutton();
		test.info("clicked on loginbutton");
		logger.info("clicked on loginbutton");
		sleep(1000);
		String title = driver.findElement(By.xpath("//h5[@class='card-title text-center pb-0 fs-4']")).getText();
		if (title.equals("Login to Your Account")) {
			test.pass("Test Case Pass:- ");
			logger.info("Test Case Pass");

		} else {
			test.fail("Test Case fail " + title);
			logger.info("Test Case fail ");
		}
		loginpage1.clearemailid();
		test.info("clear emailid");
		logger.info("clear emailid");
		loginpage1.clearpassword();
		test.info("clear password");
		logger.info("clear password");
		/*
		 * String title =
		 * driver.findElement(By.xpath("//h5[@class='card-title text-center pb-0 fs-4']"
		 * )).getText(); String Actualtext = "Login to Your Account";
		 * Assert.assertEquals(Actualtext, title); sleep(1000);
		 * System.out.println("sign in with invaild email & vaild password");
		 */
	}

	@Test(priority = 3)
	public void test03() throws IOException {
		ExtentTest test = reports.createTest("sign in with invaild email & invaild password")
				.assignAuthor("Lalit Fatehpuriya").assignCategory("Smoke Testing ")
				.assignDevice("chrome(Version 119.0.2151.44)");
		logger.info("sign in with invaild email & invaild password");
		loginpage1.enteremailid("dewv@pairroxz.com");
		test.info("clicked on email id");
		logger.info("clicked on email id");
		loginpage1.enterpassword("Queefnqueen1");
		test.info("clicked on password");
		logger.info("clicked on password");
		loginpage1.enterloginbutton();
		test.info("clicked on loginbutton");
		logger.info("clicked on loginbutton");
		sleep(1000);
		String title = driver.findElement(By.xpath("//h5[@class='card-title text-center pb-0 fs-4']")).getText();
		if (title.equals("Login to Your Account")) {
			test.pass("Test Case Pass ");

			logger.info("Test Case Pass");

		} else {
			test.fail("Test Case pass " + title);

			logger.info("Test Case fail " + title);

		}
		loginpage1.clearemailid();
		test.info("clear emailid");
		logger.info("clear emailid");
		loginpage1.clearpassword();
		test.info("clear password");
		logger.info("clear password");
	}

	@Test(priority = 4)
	public void test04() {
		ExtentTest test = reports.createTest("sign in with blank email or blank password")
				.assignAuthor("Lalit Fatehpuriya").assignCategory("Smoke Testing ")
				.assignDevice("chrome(Version 119.0.2151.44)");
		logger.info("sign in with blank email or blank password");
		loginpage1.enteremailid("");
		test.info("Empty email");
		logger.info("Empty email");
		loginpage1.enterpassword("");
		test.info("Empty password");
		logger.info("Empty password");
		loginpage1.enterloginbutton();

		test.info("clicked on loginbutton");
		logger.info("clicked on loginbutton");
		sleep(1000);
		String title = driver.findElement(By.xpath("//h5[@class='card-title text-center pb-0 fs-4']")).getText();
		if (title.equals("Login to Your Accountm")) {
			test.pass("Test Case Pass  ");

			logger.info("Test Case Pass");

		} else {
			test.fail("Test Case pass:- " + title);

			logger.info("Test Case fail " + title);

		}

	}

	@Test(priority = 5)
	public void test05() {
		ExtentTest test = reports.createTest("sign in with vaild email & vaild password")
				.assignAuthor("Lalit Fatehpuriya").assignCategory("Smoke Testing ")
				.assignDevice("chrome(Version 119.0.2151.44)");
		logger.info("sign in with vaild email & vaild password");
		loginpage1.enteremailid("superadmin@gmail.com");
		test.info("clicked on email id");
		logger.info("clicked on email id");
		loginpage1.enterpassword("Admin@123");
		test.info("clicked on password");

		logger.info("clicked on password");
		loginpage1.enterloginbutton();
		test.info("clicked on loginbutton");
		logger.info("clicked on loginbutton");
		sleep(1000);

		String title = driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
		if (title.equals("Dashboard")) {
			test.pass("Test Case Pass:-   " + title);
			logger.info("Test Case Pass ");

		} else {
			test.fail("Test Case fail " + title);
			logger.info("Test Case fail ");

		}

	}

}