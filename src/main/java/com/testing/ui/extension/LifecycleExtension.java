package com.testing.ui.extension;

import com.microsoft.playwright.*;
import com.testing.ui.driver.BrowserFactory;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.nio.file.Paths;
import java.time.LocalDateTime;

public class LifecycleExtension implements BeforeEachCallback, AfterEachCallback {
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;

    public BrowserContext getBrowserContext() {
        return this.browserContext;
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        playwright = Playwright.create();
        browser = BrowserFactory.getBrowser(playwright);
        browserContext = browser.newContext();
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        String testMethod = extensionContext.getRequiredTestMethod().getName();

        browserContext.pages().forEach(page -> {
            takeScreenshot(page, testMethod);
            page.close();
        });

        browser.contexts().forEach(BrowserContext::close);
        browser.close();
        playwright.close();
    }

    private void takeScreenshot(Page page, String testName) {
        String screenshot = System.getProperty("screenshot");
        String browser = System.getProperty("browser");

        if (Boolean.parseBoolean(screenshot)) {
            String path = testName + "_" + browser + "_" + LocalDateTime.now().withNano(0) + ".png";
            path = path.replaceAll("[:\\-]", "");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)));
        }
    }
}
