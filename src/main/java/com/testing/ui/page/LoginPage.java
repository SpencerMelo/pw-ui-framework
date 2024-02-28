package com.testing.ui.page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;

    public LoginPage(Page page) {
        this.page = page;
        this.usernameInput = page.locator("#user-name");
        this.passwordInput = page.locator("#password");
        this.loginButton = page.locator("#login-button");
    }

    public LoginPage navigate() {
        page.navigate(PAGE_URL);
        return this;
    }

    public Locator getUsernameInput() {
        return this.usernameInput;
    }

    public LoginPage clickUsernameInput() {
        usernameInput.click();
        return this;
    }

    public LoginPage clickPasswordInput() {
        passwordInput.click();
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage inputUsername(String username) {
        usernameInput.fill(username);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordInput.fill(password);
        return this;
    }
}
