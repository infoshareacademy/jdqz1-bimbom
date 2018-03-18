package com.infoshare;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class FutrzakTest {

    private static final String PAGE_URL = "http://app.bimbom.jdqz1.is-academy.pl/";

    private WebDriver driver;

    private MyPages myPages;

    @Before
    public void setUp() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        String buildEnv = System.getProperty("buildEnv");
        // driver = new ChromeDriver();
        if(buildEnv.equals("CI")){
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), new DesiredCapabilities());
        }
        if(buildEnv.equals("DEV")){
            driver = new ChromeDriver();
        }

        //driver.manage().window().maximize();
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



