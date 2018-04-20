package com.infoshare.tests;

import com.infoshare.pages.MyPages;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.beans.Statement;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertTrue;


public class FutrzakTest {

    private static final String PAGE_URL = "http://app.bimbom.jdqz1.is-academy.pl";

    private static WebDriver driver;

    private MyPages myPages;


    public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);

        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(ScrFile, DestFile);
    }


    @Rule
    public final TestRule watchman = new TestWatcher() {


        @Override
        protected void failed(Throwable e, Description description) {
            try {
                takeSnapShot(driver, "src/target/file.png");
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    };


    @BeforeClass
    public static void setUp() throws MalformedURLException {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        String buildEnv = System.getProperty("buildEnv");
        // driver = new ChromeDriver();
        if (buildEnv.equals("CI")) {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), new DesiredCapabilities());
        }
        if (buildEnv.equals("DEV")) {
            driver = new ChromeDriver();
        }

    }

    @Before
    public void setbefore(){myPages = PageFactory.initElements(driver, MyPages.class);
        driver.get(PAGE_URL);}

    @Test
    public void loginTest() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.kep-login-facebook.small")));
        myPages.login();
    }

    @Test
    public void gabinetyTag() {
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

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}



