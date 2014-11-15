package bu.met.cs.cs673.pm.pages;

import org.openqa.selenium.WebDriver;

public abstract class GerericPage {

	final WebDriver driver;

	public GerericPage(WebDriver driver) {
		this.driver = driver;

		// Check that we're on the right page.
		if (!getTitle().equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the " + getTitle()
					+ " page");
		}
	}

	public abstract String getTitle();

}
