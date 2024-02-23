package com.testing.ui.test;

import com.testing.ui.page.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("login")
public class LoginTest extends BaseTest {

    @Test
    void userShouldBeAbleToLoginWithValidCredentials() {
        new LoginPage(page)
                .navigate()
                .clickUsernameInput()
                .inputUsername("standard_user")
                .clickPasswordInput()
                .inputPassword("secret_sauce")
                .clickLoginButton();
    }

    @Test
    void userShouldNotBeAbleToLoginWithInvalidPassword() {
        new LoginPage(page)
                .navigate()
                .clickUsernameInput()
                .inputUsername("standard_user")
                .clickPasswordInput()
                .inputPassword("invalid")
                .clickLoginButton();
    }

    @Test
    void userShouldNotBeAbleToLoginWithInvalidEmail() {
        new LoginPage(page)
                .navigate()
                .clickUsernameInput()
                .inputUsername("invalid")
                .clickPasswordInput()
                .inputPassword("secret_sauce")
                .clickLoginButton();
    }

    @Test
    void userShouldNotBeAbleToLoginWithInvalidEmailAndPassword() {
        new LoginPage(page)
                .navigate()
                .clickUsernameInput()
                .inputUsername("invalid")
                .clickPasswordInput()
                .inputPassword("invalid")
                .clickLoginButton();
    }

    @Test
    void userShouldNotBeAbleToLoginWithBlankCredentials() {
        new LoginPage(page)
                .navigate()
                .clickLoginButton();
    }
}
