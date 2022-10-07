package DesignPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePageObject {
	
	public WebDriver driver;
	
	//fields
	@FindBy(xpath = "//input[@name='name']")
	WebElement nameField;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='exampleInputPassword1']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='exampleCheck1']")
	WebElement checkBoxIceCream;
	
	@FindBy(xpath = "//select[@id='exampleFormControlSelect1']")
	WebElement genderSelect;
	
	@FindBy(xpath = "//input[@id='inlineRadio1']")
	WebElement studentRadioButton;
	
	@FindBy(xpath = "//input[@name='bday']")
	WebElement calendarInput;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//strong[contains(text(),'Success!')]")
	WebElement alertMessage;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setName(String name) {
		nameField.sendKeys(name);
	}
	
	public void setEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickIceCreamCheckBox() {
		checkBoxIceCream.click();
	}
	
	public void selectGender(String gender) {
		Select select = new Select(genderSelect);
		select.selectByVisibleText(gender);
	}
	
	public void clickEmploymentStatusStudent() {
		studentRadioButton.click();
	}
	
	public void inputDate(String day, String month, String year) {
		Actions action = new Actions(driver);
		action.click(calendarInput).sendKeys(day).sendKeys(month).sendKeys(year).build().perform();
	}
	
	public void submitForm() {
		submitButton.click();
	}
	
	public String getSubmitAlertText() {
		return alertMessage.getText();
	}

}
