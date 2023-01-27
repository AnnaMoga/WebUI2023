package ru.gb.lesson_3.HW.CRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Random;

public class EnvyboxCRM_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://envybox.io/");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        webDriver.findElement(By.xpath("//*[@class='btn_room login_button']")).click();
        webDriver.findElement(By.xpath("//*[@name='email']")).sendKeys("vrednaya.lisa@bk.ru");
        webDriver.findElement(By.xpath("//*[@name='password']")).sendKeys("mguuv");
        webDriver.findElement(By.xpath("//*[@class='enter_btn_form log-in-submit']")).click();

        webDriver.findElement(By.xpath("//*[@class='btn btn-raised btn-success sendOnNewPagePay']")).click();
        webDriver.findElement(By.xpath("//*[@class='form-control pay-input']")).click();

        String sum = "sum" + new Random().nextInt(10000000);
        webDriver.findElement(By.xpath("//*[@class='form-control pay-input']")).sendKeys(sum);

        webDriver.findElement(By.xpath("//*[@class='btn btn-primary btn-raised pull-right']")).click();

        Thread.sleep(5000);
        webDriver.quit();

    }
}
