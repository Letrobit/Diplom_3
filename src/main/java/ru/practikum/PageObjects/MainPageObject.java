package ru.practikum.PageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPageObject {
    private final WebDriver driver;
    private final By mainPageLoginInAccountButton = By.xpath("//button[.='Войти в аккаунт']");
    private final By loginPageRegisterButton = By.xpath("//a[.='Зарегистрироваться']");
    private final By lichniyKabinetButton = By.xpath("//a[@class='AppHeader_header__link__3D_hX'][.='Личный Кабинет']");
    @Getter
    private final By lichniyKabinetText = By.xpath("//p[@class='Account_text__fZAIn text text_type_main-default']");
    private final By createOrderButton = By.xpath("//button[.='Оформить заказ']");

    //Блок конструктор бургера
    private final By constructorBlock = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']");
    private final By sauceSubdivisionButton = By.xpath("//div[.='Соусы']");
    private final By fillingsSubdivisionButton = By.xpath("//div[.='Начинки']");
    private final By bunsSubdivisionButton = By.xpath("//div[.='Булки']");
    private final By currentlyOpenConstructorTab = By.xpath("//div[contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By bunsTabOpenLocator = By.xpath("//div[@style='display: flex;']/div[1][contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By sauceTabOpenLocator = By.xpath("//div[@style='display: flex;']/div[2][contains(@class, 'tab_tab_type_current__2BEPc')]");
    private final By fillingTabOpenLocator = By.xpath("//div[@style='display: flex;']/div[3][contains(@class, 'tab_tab_type_current__2BEPc')]");

    public MainPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement element = driver.findElement(mainPageLoginInAccountButton);
        element.click();
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(loginPageRegisterButton));
    }

    public boolean LoginButtonIsVisible() {
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(mainPageLoginInAccountButton));
        WebElement element = driver.findElement(mainPageLoginInAccountButton);
        return element.isDisplayed();
    }

    public void lichniyKabinetClick() {
        WebElement element = driver.findElement(lichniyKabinetButton);
        element.click();
        new WebDriverWait(driver, ofSeconds(2));
    }

    public boolean createOrderButtonIsVisible() {
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(createOrderButton));
        WebElement element = driver.findElement(createOrderButton);
        return element.isDisplayed();
    }

    public boolean constructorBlockIsVisible() {
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(constructorBlock));
        WebElement element = driver.findElement(constructorBlock);
        return element.isDisplayed();
    }

    public void fillingsSubdivisionButtonClick() {
        WebElement element = driver.findElement(fillingsSubdivisionButton);
        element.click();
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.attributeContains(currentlyOpenConstructorTab, "class","tab_tab_type_current__2BEPc"));
    }

    public void sauceSubdivisionButtonClick() {
        WebElement element = driver.findElement(sauceSubdivisionButton);
        element.click();
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.attributeContains(currentlyOpenConstructorTab, "class","tab_tab_type_current__2BEPc"));
    }

    public void bunsSubdivisionButtonClick() {
        WebElement element = driver.findElement(bunsSubdivisionButton);
        element.click();
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.attributeContains(currentlyOpenConstructorTab, "class","tab_tab_type_current__2BEPc"));
    }

    public boolean checkIfCurrentTabIsBuns(){
        WebElement element = driver.findElement(bunsTabOpenLocator);
        return  element.getText().equals("Булки");
    }
    public boolean checkIfCurrentTabIsSauce(){
        WebElement element = driver.findElement(sauceTabOpenLocator);
        return  element.getText().equals("Соусы");
    }
    public boolean checkIfCurrentTabIsFilling(){
        WebElement element = driver.findElement(fillingTabOpenLocator);
        return  element.getText().equals("Начинки");
    }
}
