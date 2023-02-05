package ru.gb.lesson_5.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeriesLuciferTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @Test
    void startOfAnySeries() {
        driver.get("https://lycifer.online/main");
        driver.findElement(By.xpath("//a[@data-id='3']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[.='3 сезон 13 серия']")));
        actions.scrollToElement(driver.findElement(By.xpath("//*[.='3 сезон 13 серия']")))
                .perform();
        driver.findElement(By.xpath("//*[.='3 сезон 13 серия']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("3-sezon-13-seriya"));
    }

    @Test
    void switchingBetweenSeasons() {
        driver.get("https://lycifer.online/3-sezon-13-seriya.html");
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Сезоны']")))
                .perform();
        driver.findElement(By.xpath("//a[.='6 сезон']")).click();

        actions.moveToElement(driver.findElement(By.xpath("//span[.='Сезоны']")))
                .perform();
        driver.findElement(By.xpath("//a[.='1 сезон']")).click();

        driver.findElement(By.xpath("//div[@class='swiper-wrapper']//*[@title='Смотреть Люцифер 2 сезон онлайн']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("2-sezon"));
    }

    @Test
    void theNextEpisode() {
        driver.get("https://lycifer.online/1-sezon-1-seriya1.html");
        driver.findElement(By.xpath("//*[@data-hash='subtitry']")).click();
        actions.scrollToElement(driver.findElement(By.xpath("//a[.='следующая']")))
                        .perform();
        driver.findElement(By.xpath("//a[.='следующая']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("1-sezon-2-seriya"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
