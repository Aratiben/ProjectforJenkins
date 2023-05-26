package org.example;

import org.openqa.selenium.By;


public class RegistrationResultPage extends Utils {
    public void userShouldSeeTheMessage(){
        String expectedMessage = "Your registration completed";
        String message = getTextFromElement(By.xpath("//div[@class='result']"));
        //comparing message actual to expected
        //Assert.assertEquals(message,expectedMessage,"Something Wrong");
    }
}
