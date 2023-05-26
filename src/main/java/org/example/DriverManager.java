package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager extends Utils {
    public boolean SAUCE_LAB = false;
    MutableCapabilities sauceOptions = new MutableCapabilities();
    public String url = "https://oauth-kansodariya.arati-7eed3:4772143b-5750-47fc-9194-730fdf62bcb7@ondemand.eu-central-1.saucelabs.com/wd/hub";
    // public String browserName = "Chrome" ;
    String browserName = System.getProperty("browserName");
    public void openBrowser() {

    if (SAUCE_LAB) {
            System.out.println("Running in saucelab......... with browser" + browserName);
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(url), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    System.out.println(url);
                }
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(url), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    System.out.println(url);
                }
            } else if (browserName.equalsIgnoreCase("Edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    System.out.println(url);
                    driver = new RemoteWebDriver(new URL(url), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("locally run with browser" + browserName);
            if (browserName.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("Please type correct browser name");
            }
        }

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void closeBrowser() {
        driver.close();
    }
}