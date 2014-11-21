package bu.met.cs.cs673.pm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectListPage extends GerericPage {

	
	private By newProjectButton = By.id("newprojectBtn");
	
	//to be used in tests
	public static final By LIST_PROJECTS = By.id("list");
	
	//constructor 
	public ProjectListPage(WebDriver driver) {
		super(driver);
	}
	
	
	public NewProjectPage clickNewProject(){
		driver.findElement(newProjectButton).click();
		return new NewProjectPage(driver);
	}
	
	
	@Override
	public String getTitle() {
		return "Project List";
	}
	
	

}
