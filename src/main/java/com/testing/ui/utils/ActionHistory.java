package com.testing.ui.utils;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

public final class ActionHistory {
    private static final ThreadLocal<List<String>> actions = ThreadLocal.withInitial(ArrayList::new);

    private ActionHistory() {
    }

    public static void reset() {
        actions.set(new ArrayList<>());
    }

    public static void addAction(String action) {
        if (Strings.isBlank(action)) return;
        actions.get().add(action);
    }

    public static List<String> getActions() {
        return new ArrayList<>(actions.get());
    }
}
