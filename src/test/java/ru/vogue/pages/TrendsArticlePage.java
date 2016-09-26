package ru.vogue.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;

import static ru.consult.WebDriverUtils.getDriver;
import static ru.consult.WebDriverUtils.openPage;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class TrendsArticlePage {

    @FindBy(xpath = "(.//a[contains(@class,'pic start-fullscreen')])[1]")
    private WebElement galleryImage;

    @FindBy(xpath = ".//div[contains(@class,'playSlideShow')]")
    private WebElement slideShow;

    @FindBy(xpath = ".//span[contains(@class,'amount')]")
    private WebElement amountElement;

    @FindBy(xpath = ".//div[contains(@class,'button navigation next')]")
    private WebElement buttonNext;

    @FindBy(xpath = ".//div[contains(@class,'item active')]/img")
    private WebElement currentImage;

    @FindBy(xpath = ".//div[contains(@class,'item active')]/img")
    private WebElement nextImage;

    @FindBy(xpath = ".//div[contains(@class, 'button close')]")
    WebElement closeGalleryButton;

    public TrendsArticlePage(){
       // openPage("http://www.vogue.ru/fashion/trends/"); // тут должен быть другой урл, унивексальный для каждой статьи
        PageFactory.initElements(getDriver(), this);
    }

    public void checkTrendsArticlePageIsOpened() {
        assertNotEquals("http://www.vogue.ru/fashion/trends/",getDriver().getCurrentUrl()); //а можно ли так делать?
    }

    public void proceedToGallery() {
        galleryImage.click();
    }

    public boolean isGalleryOpened() {   //там урл меняется. Надо ли создавать отдельный класс страницу? Хотя выглядит как поп-ап
        return  slideShow.isDisplayed();
    }

    public int getTheAmountOfImages() {
        String stringedAmount = amountElement.getText();
        Integer imagesCount = Integer.valueOf(stringedAmount);
        return imagesCount ;
    }

    public String getCurrentImageUrl() {
        String currentImageUrl = currentImage.getAttribute("src");
        return currentImageUrl;
    }

    public void goToNextImage(){
        buttonNext.click();
    }
    public void closeGallery(){
        closeGalleryButton.click();
    }

}
