package bu.met.cs.cs673.pm;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import bu.met.cs.cs673.pm.pages.NewProjectPage;
import bu.met.cs.cs673.pm.pages.ProjectListPage;

public class ProjectTest {

	String baseUrl = "http://localhost:8080/TestPresentation/";
	private WebDriver driver;

	@Test
	public void testListSucess() {
		driver = new FirefoxDriver();
		driver.get(baseUrl + "/html/home.html");

		// see if it is in the correct page
		new ProjectListPage(driver);

		Assert.assertTrue(driver.findElement(ProjectListPage.LIST_PROJECTS) != null);

		// Close the browser
		driver.quit();
	}

	@Test
	public void testNewProjectValidation() {
		driver = new FirefoxDriver();
		driver.get(baseUrl + "/html/home.html");

		// see if it is in the correct page
		new ProjectListPage(driver).clickNewProject().clickSubmitWithError();

		// Get error messages
		WebElement errorMsgName = driver
				.findElement(NewProjectPage.ERROR_MSG_NAME);
		WebElement errorMsgDesc = driver
				.findElement(NewProjectPage.ERROR_MSG_DESC);
		WebElement errorMsgStartDate = driver
				.findElement(NewProjectPage.ERROR_MSG_START_DATE);
		WebElement errorMsgEndDate = driver
				.findElement(NewProjectPage.ERROR_MSG_END_DATE);

		// Asserts Error messages
		Assert.assertTrue(errorMsgName.getText().equals(
				"Please, insert a name."));
		Assert.assertTrue(errorMsgDesc.getText().equals(
				"Please, insert a description."));
		Assert.assertTrue(errorMsgStartDate.getText().equals(
				"Please, insert a start date."));
		Assert.assertTrue(errorMsgEndDate.getText().equals(
				"Please, insert an end date."));

		// Close the browser
		 driver.quit();
	}

}
