package com.infoshare;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class CzyJestButtonZaloguj{
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void login() {
        driver.get("http://app.bimbom.jdqz1.is-academy.pl/");


/*ponizszy test do clicka, wykomentowany ze wzgledu na brak mozliwosci automatycznego logowania - ochorna facebooka
           WebElement buttonZalogujClick = driver.findElement(By.xpath("//button[@class=('kep-login-facebook small')]"));

            buttonZalogujClick.click();

*/


            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement zalogujButton = driver.findElement(By.xpath("//button[@class=('kep-login-facebook small')]"));

            assertTrue("Zaloguj button is not visible", zalogujButton.isDisplayed());

       }

    }


