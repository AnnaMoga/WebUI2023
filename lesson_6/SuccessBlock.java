package ru.gb.lesson_6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class SuccessBlock extends BaseView {
    public SuccessBlock(WebDriver webDriver) {
        super(webDriver);
    }

    //ассерты :)

    public void checkName () {
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("BE_Web_UI_"));
    }
}
