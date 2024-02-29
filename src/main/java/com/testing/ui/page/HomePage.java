package com.testing.ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private static final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    private final Page page;
    private final Locator burgerMenu;
    private final Locator logoutButton;

    public HomePage(Page page) {
        this.page = page;
        this.burgerMenu = page.locator("#react-burger-menu-btn");
        this.logoutButton = page.locator("#logout_sidebar_link");
    }

    public HomePage navigate() {
        this.page.navigate(PAGE_URL);
        return this;
    }

    public HomePage clickBurgerMenu() {
        this.burgerMenu.click();
        return this;
    }

    public HomePage clickLogoutButton() {
        this.logoutButton.click();
        return this;
    }

    public Locator getBurgerMenu() {
        return this.burgerMenu;
    }
}
