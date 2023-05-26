package org.example;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils{
    private final By _firstName = By.id("FirstName");
    private  final By _LastName = By.id("LastName");
    private final By _Email = By.name("Email");
    private final By _Password = By.id("Password");
    private final By _ConfirmPassword = By.id("ConfirmPassword");



    public void fillInRegisterDetails() {
        clickOnElement(By.className("ico-register"));
        typeText(_firstName,"Firstname");
        typeText(_LastName, "lastname");
        //type email address
        typeText(_Email,"testEmail"+timestamp()+"@gmail.com");
        //type password
        typeText(_Password, "Test1234");
        //confirm password
        typeText(_ConfirmPassword, "Test1234");
        //click on register
        clickOnElement(By.id("register-button"));

    }
}
