export const projects = [
    {
        name: 'chromium',
        use: { ...require('@playwright/test').devices['Desktop Chrome'] },
    },
];
