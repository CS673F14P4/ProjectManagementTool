package bu.met.cs.cs673.pm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends GerericPage {

	private By nameInput = By.id("name");
	private By descriptionInput = By.id("description");
	private By startDateInput = By.id("startDate");
	private By endDateInput = By.id("endDate");

	private By submitButton = By.id("submitbtn");
	
	//to be used in tests
	public static final By ERROR_MSG_NAME = By.id("errorMsgName");
	public static final By ERROR_MSG_DESC= By.id("errorMsgDesc");
	public static final By ERROR_MSG_START_DATE = By.id("errorMsgStartDate");
	public static final By ERROR_MSG_END_DATE= By.id("errorMsgEndDate");

	// constructor
	public NewProjectPage(WebDriver driver) {
		super(driver);
	}

	public NewProjectPage fillOut(String name, String description,
			String startDate, String endDate) {

		driver.findElement(nameInput).sendKeys(name);
		driver.findElement(descriptionInput).sendKeys(description);
		driver.findElement(startDateInput).sendKeys(startDate);
		driver.findElement(endDateInput).sendKeys(endDate);
		
		return new NewProjectPage(driver);
	}
	
	public NewProjectPage clickSubmitWithError(){
		
		driver.findElement(submitButton).click();
		
		return new NewProjectPage(driver);
	}

	@Override
	public String getTitle() {
		return "New Project";
	}

}
