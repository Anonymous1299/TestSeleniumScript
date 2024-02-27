package Playwrightsessions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class PlaywrightMainClass {
    private static ExtentReports extent = exmanagerclass.createInstance("test-output/ExtentReport.html");
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void performPlaywrightActions() throws InterruptedException {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            try {
                ExtentTest extentTest = extent.createTest("performPlaywrightActions");
                test.set(extentTest);

                page.navigate("https://www.orangehrm.com/");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Book a Free Demo")).click();
                page.getByPlaceholder("Your Full Name*").click();
                page.getByPlaceholder("Your Full Name*").fill("sunil");
                page.getByPlaceholder("Business Email*").click();
                page.getByPlaceholder("Business Email*").fill("sunil@gmail.com");
                page.getByPlaceholder("Company Name").click();
                page.getByPlaceholder("Company Name").fill("cavs");
                page.getByLabel("Country").selectOption("India");
                page.getByPlaceholder("Phone Number*").click();
                page.getByPlaceholder("Phone Number*").fill("7978487756");
                page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Get a Free Demo")).click();

                // Log test status
                test.get().log(Status.PASS, "Test passed successfully");
            } catch (Exception e) {
                // Log test failure
                test.get().log(Status.FAIL, "Test failed with exception: " + e.getMessage());
            }
        }
    }

    public static void flushReport() {
        extent.flush();
    }
}