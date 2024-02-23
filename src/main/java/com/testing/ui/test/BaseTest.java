package com.testing.ui.test;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.testing.ui.extension.ElapseExtension;
import com.testing.ui.extension.LifecycleExtension;
import com.testing.ui.extension.TestLoggerExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@ExtendWith({ElapseExtension.class, TestLoggerExtension.class})
public class BaseTest {
    BrowserContext browserContext;
    Page page;

    @RegisterExtension
    LifecycleExtension lifecycleExtension = new LifecycleExtension();

    @BeforeEach
    void beforeEachSetup() {
        browserContext = lifecycleExtension.getBrowserContext();
        page = browserContext.newPage();
    }
}
