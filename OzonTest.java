package ru.gb.lesson_5.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OzonTest {
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
        driver.get("https://www.ozon.by/");
    }

    @Test
    void findLipstickTon5() {
        driver.findElement(By.xpath("//*[@placeholder='Искать на Ozon']")).click();
        driver.findElement(By.xpath("//*[@placeholder='Искать на Ozon']")).sendKeys("lovely H2O");
        driver.findElement(By.xpath("//button[@aria-label='Поиск']")).click();

        driver.findElement(By.xpath("//span[.='LOVELY Блеск для губ GLOSS H2O тон 5']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("h2o-ton-5"));
    }

    @Test
    void findThroughCatalog() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-widget='catalogMenu']")));
        driver.findElement(By.xpath("//*[@data-widget='catalogMenu']")).click();
        actions.moveToElement(driver.findElement(By.xpath("//span[.='Спорт и отдых']")))
                        .perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Йога и пилатес']")));
        driver.findElement(By.xpath("//a[.='Йога и пилатес']")).click();
        actions.scrollToElement(driver.findElement(By.xpath("//span[.='Доска с гвоздями Садху 10 мм']")))
                        .perform();
        driver.findElement(By.xpath("//span[.='Доска с гвоздями Садху 10 мм']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("gvozdyami-sadhu-10-mm"));
    }

    @Test
    void ozonJob() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-widget='footer']//div//div")));
        actions.scrollToElement(driver.findElement(By.xpath("//*[@data-widget='footer']//div//div")))
                .perform();

        driver.findElement(By.xpath("//span[.='IT']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='close']")));
        driver.findElement(By.xpath("//div[@class='close']")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("it"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
