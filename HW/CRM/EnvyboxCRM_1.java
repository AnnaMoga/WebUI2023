package ru.gb.lesson_3.HW.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class EnvyboxCRM_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://envybox.io/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.findElement(By.xpath("//*[@class='btn_room login_button']")).click();
        webDriver.findElement(By.xpath("//*[@name='email']")).sendKeys("vrednaya.lisa@bk.ru");
        webDriver.findElement(By.xpath("//*[@name='password']")).sendKeys("mguuv");
        webDriver.findElement(By.xpath("//*[@class='enter_btn_form log-in-submit']")).click();

        webDriver.findElement(By.xpath("//i[@class='md md-view-list']")).click();

        List<WebElement> titles = webDriver.findElements(By.xpath("//*[@class='news-header']"));
        webDriver.findElement(By.xpath("//*[@href='/news/1532/']")).click();

        Thread.sleep(5000);
        webDriver.quit();
    }
}
