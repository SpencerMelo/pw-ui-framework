package com.testing.ui.extension;

import com.testing.ui.constants.ContextKeys;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class ElapseExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    public ElapseExtension() {
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        getStore(extensionContext).put(ContextKeys.START_TIME, System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        long endTime = System.currentTimeMillis();
        getStore(extensionContext).put(ContextKeys.END_TIME, endTime);
        long startTime = getStore(extensionContext).get(ContextKeys.START_TIME, Long.class);
        long elapseTime = (endTime - startTime) / 1000;
        getStore(extensionContext).put(ContextKeys.ELAPSE_TIME, elapseTime);
    }

    private ExtensionContext.Store getStore(ExtensionContext extensionContext) {
        return extensionContext.getStore(ExtensionContext.Namespace.create(extensionContext.getRequiredTestMethod()));
    }
}
