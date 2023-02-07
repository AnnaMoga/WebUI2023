package ru.gb.lesson_6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikiSoftwareTest {
    static WebDriver webDriver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        webDriver = new ChromeDriver();
        webDriver.get("http://wiki.software-testing.ru/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0");

    }

    @Test
    void SoftwareTest() {
        new MainPage(webDriver).clickSignInButton();
        new LoginPage(webDriver).authorization("HannaM", "123456789");
        new NavigationBlock(webDriver).searchInfo();
        new  SearchingResultsPage(webDriver).choiceOfOption("Чит-лист по Web UI контролам от Игоря Любина");
        new SuccessBlock(webDriver).checkName();
    }

    @AfterAll
    static void tearDown() {
        webDriver.quit();
    }

}
