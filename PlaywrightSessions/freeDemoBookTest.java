import { test } from '@playwright/test';
import org.testng.annotations.Test;

class OrangeHRMTest {

    @Test
    test('Free Demo Book', async ({ page }) => {
        await page.goto('https://www.orangehrm.com/');
        await page.getByRole('button', { name: 'Book a Free Demo' }).click();
        await page.click('input[placeholder="Your Full Name*"]');
        await page.fill('input[placeholder="Your Full Name*"]', 'Sunil');
        await page.click('input[placeholder="Business Email*"]');
        await page.fill('input[placeholder="Business Email*"]', 'Sunilkumarroul.skl@gmail.com');
        await page.click('input[placeholder="Company Name"]');
        await page.fill('input[placeholder="Company Name"]', 'Cavsys');
        await page.getByLabel('Country').selectOption('India');
        await page.click('input[placeholder="Phone Number*"]');
        await page.fill('input[placeholder="Phone Number*"]', '7978487756');
        await page.frameLocator('iframe[name="a-fnafbtzh4yho"]').getByLabel('I\'m not a robot').check();
        await page.click('button:has-text("Get a Free Demo")');
    }
}

export default OrangeHRMTest;