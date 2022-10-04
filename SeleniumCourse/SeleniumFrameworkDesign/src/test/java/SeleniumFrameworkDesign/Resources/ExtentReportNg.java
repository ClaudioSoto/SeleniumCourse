package SeleniumFrameworkDesign.Resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportNg {

	/* FOR EXENT REPORTS*/
	@BeforeTest
	public static ExtentReports getReportObject() {
		//to configure the report 
		String reportsPath = System.getProperty("user.dir") + "\\test-output\\customReport.html";
		ExtentHtmlReporter esr = new ExtentHtmlReporter(reportsPath);
		esr.config().setReportName("Selenium Framework design automation");
		esr.config().setDocumentTitle("Test Results");

		//to generate the report
		ExtentReports report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Tester", "claudio soto");
		
		return report;
	}

}
