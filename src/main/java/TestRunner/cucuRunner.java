package TestRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/cucufeatures/datadriven.feature" }, glue = {
		"stepDefinitions" }, tags = "@smoke or @sanity" ,//, and ,not can be used
		plugin = { "pretty" }
		//dryRun = true,
		//publish = true
)
public class cucuRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
