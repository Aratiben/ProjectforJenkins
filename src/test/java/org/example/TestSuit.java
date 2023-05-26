package org.example;

import org.testng.annotations.Test;

public class TestSuit extends BaseTest {
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationResultPage registrationResultPage = new RegistrationResultPage();

    @Test
    public void userShouldBeAleToRegisterSuccessfully() {
        homePage.clickOnRegisterButton();
        registrationPage.fillInRegisterDetails();
        registrationResultPage.userShouldSeeTheMessage();


    }

    @Test
    public void nonRegisteredUserCanNotVote() {
        homePage.clickOnVote();
    }
}
