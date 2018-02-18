package com.infoshare;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TabVetsNewVisit {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void TabVetsNewVisit() {
        /*driver.get("http://app.bimbom.jdqz1.is-academy.pl/vets");
        WebElement tabVetsListOfVets = driver.findElement(By.xpath("//span[@class='glyphicon glyphicon-th-list']']"));
        assertTrue("Tab Vets is not displayed.", tabVetsListOfVets.isDisplayed());*/
    }
}
