package com.infoshare;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

public class addFavouriteVet {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void addFavouriteVet() {
        driver.get("http://app.bimbom.jdqz1.is-academy.pl/vets");
        WebElement addFavouriteVet = driver.findElement(By.xpath("//div[@id='James']//div[@class='caption']//button[@type='button']"));

        Actions builder = new Actions(driver);
        builder.doubleClick(addFavouriteVet).build().perform();

        assertTrue("Cannot add favourite vet.", addFavouriteVet.isSelected());
    }

    @Test
    public void verifyListOfFavouriteVet() {
        driver.get("http://app.bimbom.jdqz1.is-academy.pl/vets");
        WebElement verifyListOfFavouriteVet = driver.findElement(By.xpath("///span[@class='glyphicon glyphicon-heart']']"));

        assertTrue("Favourite Vet not added.", verifyListOfFavouriteVet.isSelected());
    }
}

