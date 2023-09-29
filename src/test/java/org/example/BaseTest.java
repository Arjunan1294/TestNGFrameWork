package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    DriverFactory driverFactory;
    WebDriver driver;
    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome") String browserName){
        driverFactory = new DriverFactory();
        driver =  driverFactory.initDriver(browserName);
        DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        System.out.println(driver.getCurrentUrl());
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }


}
