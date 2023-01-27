package ru.gb.lesson_3.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

    public class Diary {
        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();
            driver.get("https://diary.ru/user/login");

            //driver.findElement(By.id("loginform-username")).sendKeys("AnnAnnAD");
            // driver.findElement(By.id("loginform-password")).sendKeys("OKRLnbQ0##");
            //driver.findElement(By.id("login_btn")).click();

            Cookie authCookie = new Cookie("_identity_", "a005127e213c29067c72e3c2da5e86c26cbeeb58f4ffd0dff2b7fb27b3eefd49a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3579274%2C%220VPJcR6rf3FK0h6eoKd4V0V_XcS_sioF%22%2C2592000%5D%22%3B%7D");
            driver.manage().addCookie(authCookie);

            driver.navigate().refresh();

            driver.findElement(By.id("writeThisDiary")).click();

            String postTitle = "title" + new Random().nextInt(100);
            driver.findElement(By.id("postTitle")).sendKeys(postTitle);

            driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
            driver.findElement(By.id("tinymce")).sendKeys("бла-бла-бла");

            driver.switchTo().parentFrame();
            driver.findElement(By.id("rewrite")).click();

            List<WebElement> titles =  driver.findElements(By.xpath("//a[@class='title']"));
            titles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();



            Thread.sleep(5000);
            driver.quit();
        }
    }
