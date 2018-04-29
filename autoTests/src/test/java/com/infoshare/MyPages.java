package com.infoshare;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyPages {
    //login
    @FindBy(css = "button.kep-login-facebook.small")
    private WebElement buttonZaloguj;

    //gabinety tag
    @FindBy(css = "a[href='/offices']")
    private WebElement buttonGabinety;

    @FindBy(css = "div.col-md-10.col-xs-12")
    private WebElement gabinetSzczekus;

    @FindBy(css = "span.list-group-item")
    private WebElement mariaMerryVet;

    //weterynarze tag
    @FindBy(css = "a[href='/vets']")
    private WebElement buttonWeterynarze;

    @FindBy(css = "span.single-list-element.list-group-item")
    private WebElement buttonKlakier;

    @FindBy(css = "span.list-group-item")
    private WebElement buttonJamesSutherland;

    //weterynarze add to favourite
    @FindBy(css = "#James > div > button")
    private WebElement buttonFavourite;

    @FindBy(css = "span.glyphicon.glyphicon-heart")
    private WebElement buttonFavourite1;

    //assertTrue

    @FindBy(css = "#James")
    private WebElement visibleVetData;


    public void login() {

        buttonZaloguj.click();
    }

    public void gabinetyTag() {
        buttonGabinety.click();
        gabinetSzczekus.click();
        mariaMerryVet.click();
    }

    public void weterynarzeTag() {
        buttonWeterynarze.click();
        buttonKlakier.click();
        buttonJamesSutherland.click();
    }

    public void weterynarzeAddToFavourite() {
        buttonWeterynarze.click();
        buttonFavourite.click();
        buttonFavourite1.click();
    }

    public boolean isAddedFavouriteVet() {
        return visibleVetData.isEnabled();
    }
}
