package Playwrightsessions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class exmanagerclass {
    private static ExtentReports extent;

    public static ExtentReports createInstance(String reportPath) {
        if (extent == null) {
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setDocumentTitle("Test Automation Report");
            htmlReporter.config().setReportName("Test Automation Results");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        return extent;
    }
}