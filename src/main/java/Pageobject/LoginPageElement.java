package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageElement {

	private WebDriver driver;

	@FindBy(xpath = "//input[@id='email']")
	WebElement emailidinput;

	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordinput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginbutton;

	public LoginPageElement(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enteremailid(String ji) {
		emailidinput.sendKeys(ji);

	}

	public void enterpassword(String password) {
		passwordinput.sendKeys(password);

	}

	public void enterloginbutton() {
		loginbutton.click();

	}

	public void clearemailid() {
		emailidinput.clear();

	}

	public void clearpassword() {
		passwordinput.clear();

	}

}
