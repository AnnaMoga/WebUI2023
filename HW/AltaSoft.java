package ru.gb.lesson_3.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AltaSoft {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.alta.ru/tamdoc/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.findElement(By.xpath("//*[@class='yaSearchField full-width']")).click();
        webDriver.findElement(By.xpath("//*[@class='yaSearchField full-width']")).sendKeys("Постановление №312");
        webDriver.findElement(By.xpath("//*[@class='btn btn-blue full-width']")).click();
        webDriver.findElement(By.xpath("//*[@href='https://www.alta.ru/tamdoc/22ps0312/']")).click();

        Thread.sleep(5000);
        webDriver.quit();
    }
}
