package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Google {
    private WebDriver driver;

    private By email = By.id("input-email");
    private By password = By.id("input-password");
    private By loginButton = By.xpath("//input[@type='submit']");

    public Google(WebDriver driver){
        this.driver=driver;
    }

    public void enterEmail(String emails){
        driver.findElement(email).click();
        driver.findElement(email).sendKeys(emails);
    }
    public void enterPass(String pass){
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
}
