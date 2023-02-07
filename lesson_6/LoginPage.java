package ru.gb.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Ввести логин/пароль, нажать на кнопку "Войти"

    @FindBy(id = "wpName1")
    private WebElement loginField;

    @FindBy(id = "wpPassword1")
    private WebElement passwordField;

    @FindBy(id = "wpLoginAttempt")
    private WebElement submitButton;

    public void authorization(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }
}
