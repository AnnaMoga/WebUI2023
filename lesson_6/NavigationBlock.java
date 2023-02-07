package ru.gb.lesson_6;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBlock extends BaseView {
    public NavigationBlock(WebDriver webDriver) {
        super(webDriver);
    }

    //В поле "Поиск" ввести то, что нужно найти :)

    @FindBy(id = "searchInput")
    private WebElement searchField;

    @FindBy(id = "mw-searchButton")
    private WebElement searchButton;

    public void searchInfo() {
        searchField.click();
        searchField.sendKeys("чит-лист");
        searchButton.click();
    }
}
