package ru.gb.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseView {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Actions actions;

    public BaseView(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        this.actions = new Actions(webDriver);
        PageFactory.initElements(webDriver, this);
    }
}
