package AppHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.DriverFactory.DriverFactory;
import com.StoringLocalValues.ScenarioContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	public DriverFactory driverFactory;
	WebDriver driver;
	public String Browser;

	@Before(order = 0)
	public void DoNoThing() {
		Browser = ScenarioContext.get("Browser");
		if(Browser == null) {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver("chrome");
		}else {
			driverFactory = new DriverFactory();
			driver = driverFactory.init_driver(Browser);
		}
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
}
