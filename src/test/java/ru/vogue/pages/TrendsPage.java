package ru.vogue.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;
;
import static ru.consult.WebDriverUtils.getDriver;
import static ru.consult.WebDriverUtils.openPage;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class TrendsPage {

    @FindBy(xpath = "html/body/div[10]/div[4]/div/div[3]/a/h1")
    private WebElement trendsElement;

    @FindBy(xpath = "((.//div[contains(@class,'section collage') or contains(@class,'section snippet_books')])[1])/a/h2/parent::a")
    private WebElement articleOfTrends;

    public TrendsPage(){
        openPage("http://www.vogue.ru/fashion/trends/");
        PageFactory.initElements(getDriver(), this);
    }


    public void checkNewsPageIsOpened() {
        assertTrue(trendsElement.isDisplayed(), "News element is not displayed");
    }

    public TrendsArticlePage openTrendsArticlePage() {
        articleOfTrends.click();
        return new TrendsArticlePage();
    }


}
