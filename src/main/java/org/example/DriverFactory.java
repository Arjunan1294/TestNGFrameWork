package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();


    public static WebDriver initDriver(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
           // WebDriverManager.chromedriver().setup();
            tldriver.set(new ChromeDriver());
        } else if (browserName.equalsIgnoreCase("firefox")) {
           // WebDriverManager.firefoxdriver().setup();
            tldriver.set(new FirefoxDriver());
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return getDriver();
    }

    public static synchronized WebDriver getDriver(){
        return tldriver.get();
    }
}