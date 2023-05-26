package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Utils{
public void clickOnRegisterButton() {
    //waitForClickable(By.xpath("//a[text()='Register']"),10);
    //
    // driver.findElement(By.xpath("//a[@class='ico-register']"));
    clickOnElement(By.xpath("//a[text()='Register']"));
}
public void clickOnVote(){
    driver.findElement(By.id("pollanswers-2")).click();
    driver.findElement(By.xpath("//button[@id='vote-poll-1']")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='poll-vote-error']")));
    String b = driver.findElement(By.xpath("//div[@class='poll-vote-error']")).getText();
    //String b= driver.findElement(By.xpath( "//div[@class='poll-vote-error']")).getText();

    System.out.println(b);
}
}

