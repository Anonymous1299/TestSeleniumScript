package Playwrightsessions;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;

public class PlaywrightTestNGClass {

    @Test
    public void testPlaywrightActions() throws InterruptedException {
        PlaywrightMainClass playwrightMainClass = new PlaywrightMainClass();
        playwrightMainClass.performPlaywrightActions();
    }

    @AfterSuite
    public void afterSuite() {
        PlaywrightMainClass.flushReport();
    }
}