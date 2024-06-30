package ru.practikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RestorePasswordPageObject {
    private final WebDriver driver;

    public RestorePasswordPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private final By restorePasswordPageLoginButton = By.xpath("//a[.='Войти']");

    public void clickRestorePasswordPageLoginButton(){
        WebElement element = driver.findElement(restorePasswordPageLoginButton);
        element.click();
    }
}
