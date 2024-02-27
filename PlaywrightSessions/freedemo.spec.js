import { test } from '@playwright/test';

test('test', async ({ page }) => {
  try {
    console.log('Navigating to the website...');
    await Promise.all([
      page.waitForNavigation({ waitUntil: 'domcontentloaded', timeout: 60000 }),
      page.goto('https://www.orangehrm.com/', { waitUntil: 'domcontentloaded', timeout: 60000 }),
    ]);
    console.log('Navigation complete.');

    console.log('Clicking "Book a Free Demo" button...');
    await page.waitForSelector('button[name="yourButtonName"]', { state: 'visible', timeout: 10000 });
    await page.click('button[name="yourButtonName"]');
    console.log('Button clicked.');

    console.log('Filling the form...');
    await page.waitForSelector('input[placeholder="Your Full Name*"]', { state: 'visible', timeout: 10000 });
    await page.click('input[placeholder="Your Full Name*"]');
    await page.fill('input[placeholder="Your Full Name*"]', 'sunil');

    // Repeat similar waitForSelector and fill actions for other form elements...

    console.log('Form filled. Clicking "Get a Free Demo" button...');
    await page.waitForSelector('button[name="yourButtonName"]', { state: 'visible', timeout: 10000 });
    await page.click('button[name="yourButtonName"]');
    console.log('Button clicked.');
  } catch (error) {
    console.error('An error occurred:', error);
    throw error; // Rethrow the error to mark the test as failed
  }
});
