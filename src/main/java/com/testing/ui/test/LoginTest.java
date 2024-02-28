package com.testing.ui.test;

import com.testing.ui.page.LoginPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Tag("login")
public class LoginTest extends BaseTest {

    @Test
    void userShouldBeAbleToLoginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage
                .navigate()
                .clickUsernameInput()
                .inputUsername("standard_user")
                .clickPasswordInput()
                .inputPassword("secret_sauce")
                .clickLoginButton();

        assertThat(loginPage.getUsernameInput()).isHidden();
    }

    @Test
    void userShouldNotBeAbleToLoginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(page);
        loginPage
                .navigate()
                .clickUsernameInput()
                .inputUsername("standard_user")
                .clickPasswordInput()
                .inputPassword("invalid")
                .clickLoginButton();

        assertThat(loginPage.getUsernameInput()).isVisible();
    }

    @Test
    void userShouldNotBeAbleToLoginWithInvalidEmail() {
        LoginPage loginPage = new LoginPage(page);
        loginPage
                .navigate()
                .clickUsernameInput()
                .inputUsername("invalid")
                .clickPasswordInput()
                .inputPassword("secret_sauce")
                .clickLoginButton();

        assertThat(loginPage.getUsernameInput()).isVisible();
    }

    @Test
    void userShouldNotBeAbleToLoginWithInvalidEmailAndPassword() {
        LoginPage loginPage = new LoginPage(page);
        loginPage
                .navigate()
                .clickUsernameInput()
                .inputUsername("invalid")
                .clickPasswordInput()
                .inputPassword("invalid")
                .clickLoginButton();

        assertThat(loginPage.getUsernameInput()).isVisible();
    }

    @Test
    void userShouldNotBeAbleToLoginWithBlankCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.navigate().clickLoginButton();

        assertThat(loginPage.getUsernameInput()).isVisible();
    }
}
