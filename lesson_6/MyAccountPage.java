package ru.gb.lesson_6;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BaseView {
    public NavigationBlock navigationBlock;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
        navigationBlock = new NavigationBlock(webDriver);
    }
}
