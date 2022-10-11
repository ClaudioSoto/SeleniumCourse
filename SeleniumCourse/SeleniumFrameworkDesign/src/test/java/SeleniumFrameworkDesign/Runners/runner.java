package SeleniumFrameworkDesign.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		tags = "", 
		features = {"src/test/java/features"}, 
		glue = {"stepDefinitions"},
		monochrome = true,
		plugin = {"html:target/cucumberReport.html","rerun:target/failed_scenarios.txt"})


public class runner extends AbstractTestNGCucumberTests{


}
