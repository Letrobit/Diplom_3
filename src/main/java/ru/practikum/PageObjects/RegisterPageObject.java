package ru.practikum.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum.API.register.GenerateUser;

import static java.time.Duration.ofSeconds;

public class RegisterPageObject {
    private final WebDriver driver;
    private final By registerPageRegisterButton = By.xpath("//button[.='Зарегистрироваться']");
    private final By registerPageNameField = By.xpath(".//label[.='Имя']/parent::div/input");
    private final By registerPageEmailField = By.xpath(".//label[.='Email']/parent::div/input");
    private final By registerPagePasswordField = By.xpath(".//label[.='Пароль']/parent::div/input");
    private final By incorrectPasswordError = By.xpath("//p[@class='input__error text_type_main-default']");
    private final By loginButtonRegisterPage = By.xpath("//a[.='Войти']");

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterRegisterData(GenerateUser generateUser) {

        WebElement nameInput = driver.findElement(registerPageNameField);
        nameInput.sendKeys(generateUser.getName());

        WebElement emailInput = driver.findElement(registerPageEmailField);
        emailInput.sendKeys(generateUser.getEmail());

        WebElement passwordInput = driver.findElement(registerPagePasswordField);
        passwordInput.sendKeys(generateUser.getPassword());

        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(registerPageRegisterButton));
    }

    public void clickRegisterButtonRegisterPage() {
        WebElement element = driver.findElement(registerPageRegisterButton);
        element.click();
    }
    public boolean checkIfPasswordErrorIsVisible(){
        WebElement emailInput = driver.findElement(registerPageEmailField);
        emailInput.click();
        WebElement element = driver.findElement(incorrectPasswordError);
        return element.isDisplayed();
    }
    public void clickLoginButtonRegisterPage() {
        WebElement element = driver.findElement(loginButtonRegisterPage);
        element.click();
    }
}
