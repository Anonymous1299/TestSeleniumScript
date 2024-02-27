package Playwrightsessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class PlaywrightBasics {

	public static void main(String[] args)throws InterruptedException {
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
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

	}
		
	}

}
