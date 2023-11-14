package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageElement extends BaseClass {
	private WebDriver driver1;

	@FindBy(xpath = "//h5[normalize-space()='Total Students']")
	WebElement TotalStudents;

	@FindBy(xpath = "//h5[normalize-space()='Total Teachers']")
	WebElement TotalTeachers;

	@FindBy(xpath = "//h5[normalize-space()='Total Parents']")
	WebElement TotalParents;

	@FindBy(xpath = "//h5[normalize-space()='Total Schools']")
	WebElement TotalSchools;

	public DashboardPageElement(WebDriver driver) {
		this.driver1 = driver;
		PageFactory.initElements(driver1, this);
	}

	public void ClickTotalStudents() {
		TotalStudents.click();

	}

	public void ClickTotalTeachers() {
		TotalTeachers.click();

	}

	public void ClickTotalParents() {
		TotalParents.click();

	}

	public void ClickTotalSchools() {
		TotalSchools.click();

	}

}
