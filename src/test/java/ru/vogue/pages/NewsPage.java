package ru.vogue.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

import static ru.consult.WebDriverUtils.getDriver;
import static ru.consult.WebDriverUtils.openPage;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class NewsPage {

    @FindBy(xpath = "html/body/div[10]/div[4]/div/div[3]/a/h1")
    private WebElement newsElement;

    @FindBy(xpath = "((.//div[contains(@class,'section collage') or contains(@class,'section snippet_books')])[1])/a/h2/parent::a")
    private WebElement articleOfNews;

    public NewsPage (){
        openPage("http://www.vogue.ru/fashion/news/");
        PageFactory.initElements(getDriver(), this);
    }

    public void checkNewsPageIsOpened() {
        assertTrue(newsElement.isDisplayed(), "News element is not displayed");
    }


    public NewsArticlePage openNewsArticlePage() {
        articleOfNews.click();
        return new NewsArticlePage();
    }
}
