package com.testing.ui.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public final class BrowserFactory {

    public static Browser getBrowser(Playwright driver) {
        String browser = System.getProperty("browser");

        return switch (browser) {
            case "firefox" -> driver.firefox().launch(getLaunchOptions());
            case "safari" -> driver.webkit().launch(getLaunchOptions());
            case null, default -> driver.chromium().launch(getLaunchOptions());
        };
    }

    private static BrowserType.LaunchOptions getLaunchOptions() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        String headless = System.getProperty("headless");
        launchOptions.setHeadless(headless == null || Boolean.parseBoolean(headless));

        return launchOptions;
    }
}
