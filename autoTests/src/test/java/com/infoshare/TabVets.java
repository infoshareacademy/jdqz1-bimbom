package com.infoshare;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TabVets {
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    /*@Test
    public void verifyButton() {
        driver.get("http://app.bimbom.jdqz1.is-academy.pl/");
        WebElement verifyButton = driver.findElement(By.xpath("//div[@class='navbar-collapse collapse']"));
        assertTrue("Button is not displayed", verifyButton.isDisplayed());*/


    @Test
    public void tabVets() {
        driver.get("http://app.bimbom.jdqz1.is-academy.pl/vets");
        WebElement openTabVets = driver.findElement(By.xpath("//input[@type='text']"));
        assertTrue("Tab Vets is not displayed.", openTabVets.isDisplayed());
    }

}