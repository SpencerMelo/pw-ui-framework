package com.testing.ui.extension;

import com.testing.ui.constants.Color;
import com.testing.ui.constants.ContextKeys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestLoggerExtension implements TestWatcher {
    private static final Logger LOGGER = LogManager.getLogger(TestLoggerExtension.class);
    private static final String DEFAULT_LOG =
            "[" + Color.YELLOW + "TEST" + Color.DEFAULT + "] " + "[{}] {}, Elapse time: {} second(s)";

    public TestLoggerExtension() {
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String result = Color.LIGHT_GREEN + "PASSED" + Color.DEFAULT;
        String methodName = context.getRequiredTestMethod().getName();
        long elapseTime = getStore(context).getOrDefault(ContextKeys.ELAPSE_TIME, Long.class, 0L);
        LOGGER.info(DEFAULT_LOG, result, methodName, elapseTime);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String result = Color.RED + "FAILED" + Color.DEFAULT;
        String methodName = context.getRequiredTestMethod().getName();
        long elapseTime = getStore(context).getOrDefault(ContextKeys.ELAPSE_TIME, Long.class, 0L);
        LOGGER.info(DEFAULT_LOG, result, methodName, elapseTime);
    }

    private ExtensionContext.Store getStore(ExtensionContext extensionContext) {
        return extensionContext.getStore(ExtensionContext.Namespace.create(extensionContext.getRequiredTestMethod()));
    }
}
