package TestCase;

import java.io.IOException;

import org.testng.annotations.Test;

import Pageobject.BaseClass;

//@Listeners(TestCase.ListenerClass.class)
public class DashboardPageTestCase extends BaseClass {

	@Test(priority = 1)
	public void test01() throws IOException {
		loginpage1.enteremailid("superadmin@gmail.com");

		logger.info("Enter Email Address");
		loginpage1.enterpassword("Admin@123");
		logger.info("Enter Password");
		loginpage1.enterloginbutton();
		sleep(1000);
		logger.info("Click On Submit Button ");
		sleep(1000);
		Driver1.ClickTotalStudents();
		logger.info("Page Navigate To Student");
		sleep(1000);
		String url = driver.getCurrentUrl();

		sleep(1000);

		if (url.contains("https://24livehosts.com/rootyapplication/admin/studentt")) {
			logger.info("Test Case Pass " + url);

		} else {

			logger.info("Test Case fail " + url);

		}

	}

	@Test(priority = 2)

	public void test02() throws IOException {
		driver.navigate().to("https://24livehosts.com/rootyapplication/admin/dashboard");
		logger.info("Page Navigate To Dashboard Url\"");
		sleep(1500);
		Driver1.ClickTotalTeachers();
		logger.info("Page Navigate To Teacher");
		sleep(1500);
		String url = driver.getCurrentUrl();

		if (url.contains("https://24livehosts.com/rootyapplication/admin/teacherdd")) {

			logger.info("Test Case Pass " + url);
		} else {

			logger.info("Test Case fail " + url);
			//screenshort();

		}
	}

	@Test(priority = 3)
	public void test03() {
		driver.navigate().to("https://24livehosts.com/rootyapplication/admin/dashboard");
		logger.info("Page Navigate To Dashboard Url");
		Driver1.ClickTotalParents();
		logger.info("Page Navigate To Parent");
		sleep(1500);
		String url = driver.getCurrentUrl();
		sleep(1500);
		if (url.contains("https://24livehosts.com/rootyapplication/admin/parent")) {
			logger.info("Test Case Pass " + url);

		} else {

			logger.info("Test Case fail " + url);

		}
	}

	@Test(priority = 4)
	public void test04() {
		driver.navigate().to("https://24livehosts.com/rootyapplication/admin/dashboard");
		logger.info("Page Navigate To Dashboard Url");
		Driver1.ClickTotalSchools();
		logger.info("Page Navigate To School");
		sleep(1500);
		String url = driver.getCurrentUrl();
		sleep(1500);
		if (url.contains("https://24livehosts.com/rootyapplication/admin/school")) {
			logger.info("Test Case Pass " + url);

		} else {

			logger.info("Test Case fail " + url);
		}
	}
}
