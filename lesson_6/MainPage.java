package ru.gb.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView{

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Нажать на кнопку "Войти"

    @FindBy(xpath = "//a[.='Войти']")
    private WebElement signInButton;

    public void clickSignInButton() {
        signInButton.click();
    }
}
