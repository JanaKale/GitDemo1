package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "C:\\Users\\Shree\\MyFramework\\src\\test\\resources\\cucufeatures" }, glue = {
		"stepDefinitions" }, tags = "@smoke or @regression", // and ,not can be used
		plugin = { "pretty" }

)
public class cucuRunner extends AbstractTestNGCucumberTests {
	/*@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}*/

}
