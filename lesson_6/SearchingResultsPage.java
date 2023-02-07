package ru.gb.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchingResultsPage extends BaseView{
    public SearchingResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    // тыкаем на нужный элемент
    @FindBy(xpath = "//*[@class='mw-search-results']")
    private List<WebElement> resultList;

    private static final String choiceResultXpathLocator = "//*[.='Чит-лист по Web UI контролам от Игоря Любина']";

    public void choiceOfOption(String oneOfResult) {
        resultList.stream().filter(r -> r.getText().contains(oneOfResult)).findFirst().get()
                .findElement(By.xpath(choiceResultXpathLocator)).click();
    }
}
