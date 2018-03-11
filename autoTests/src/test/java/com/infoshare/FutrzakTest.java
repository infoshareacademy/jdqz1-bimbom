package com.infoshare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class FutrzakTest {

    private static final String PAGE_URL = "http://app.bimbom.jdqz1.is-academy.pl/";

    private WebDriver driver;

    private MyPages myPages;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/tomaszn/IdeaProjects/jdqz1-bimbom/autoTests/src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        myPages = PageFactory.initElements(driver, MyPages.class);
        driver.get(PAGE_URL);

    }

    @Test
    public void loginTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.kep-login-facebook.small")));
        myPages.login();
    }

    @Test
    public void gabinetyTag(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/offices']")));
        myPages.gabinetyTag();
    }

    @Test
    public void weterynarzeTag() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/vets']")));
        myPages.weterynarzeTag();
    }

    @Test
    public void markFavoriteVet() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/vets']")));
        myPages.weterynarzeAddToFavourite();

        assertTrue("Favourite is not added", myPages.isAddedFavouriteVet());
    }

   @After
   public void tearDown() {
        driver.close();
    }}



