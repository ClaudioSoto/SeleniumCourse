package SeleniumFrameworkDesign.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/java/features"}, glue = {"stepDefinitions"},
plugin = {})


public class runner extends AbstractTestNGCucumberTests{


}
