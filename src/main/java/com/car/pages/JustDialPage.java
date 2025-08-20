package com.car.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JustDialPage {
    WebDriver driver;

    public JustDialPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[normalize-space()='Maybe Later']")
    WebElement maybelater;
    @FindBy(xpath = "//span[@role=\"button\" and @aria-label=\"Close Banner\"]")
    WebElement popup;

    @FindBy(xpath = "//input[@id='main-auto']" )
    WebElement search;

    @FindBy(xpath = "//*[@id=\"comHead\"]/div/div[2]/div/div[2]/search/div/div[3]/div")
    WebElement searchCar;

    @FindBy(xpath = "//button[.//span[text()='Top Rated']]")
    WebElement toprated;


    public void clickMayBe(){
        maybelater.click();
    }

    public void closePopup(){
        popup.click();
    }

    public  void setSearch(String Search){
        search.sendKeys(Search);
    }

    public  void click(){
        searchCar.click();
    }

    public void clickTopRated(){
        toprated.click();
    }

}
