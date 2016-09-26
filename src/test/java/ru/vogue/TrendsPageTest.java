package ru.vogue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.vogue.pages.TrendsArticlePage;
import ru.vogue.pages.TrendsPage;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static ru.consult.WebDriverUtils.*;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class TrendsPageTest {

    @BeforeMethod
    public void beforeMethod() {
        startBrowser();
    }

    @AfterMethod
    public void afterMethod() {
        finishBrowser();
    }


    @Test
    public void checkTheTransitionToSomeTrendsArticlePage() {
        TrendsPage trendsPage = new TrendsPage();
        TrendsArticlePage trendsArticlePage = trendsPage.openTrendsArticlePage();
        trendsArticlePage.checkTrendsArticlePageIsOpened();
    }

    @Test
    public void checkTheAbilityOfOpeningArticleGallery() {
        TrendsPage trendsPage = new TrendsPage();
        TrendsArticlePage trendsArticlePage = trendsPage.openTrendsArticlePage();
        trendsArticlePage.checkTrendsArticlePageIsOpened();         //самая малость дубляж кода, но мы, таки, имеем проблему с универсальным урлом для TrendsArticlePage
        trendsArticlePage.proceedToGallery();
        assertTrue(trendsArticlePage.isGalleryOpened(), "Gallery is not opened"); //там урл меняется. Надо ли создавать отдельный класс страницу? Хотя выглядит как поп-ап
    }

    @Test
    public void checkTheAbilityReviewingAllArticleGalleryImages() {
        TrendsPage trendsPage = new TrendsPage();
        TrendsArticlePage trendsArticlePage = trendsPage.openTrendsArticlePage();
        trendsArticlePage.checkTrendsArticlePageIsOpened();
        trendsArticlePage.proceedToGallery();
        assertTrue(trendsArticlePage.isGalleryOpened(), "Gallery is not opened");   // дубляж кода, но мы, опять, имеем проблему с универсальным урлом
        trendsArticlePage.getTheAmountOfImages();
        trendsArticlePage.getCurrentImageUrl();
        String firstImageUrl = trendsArticlePage.getCurrentImageUrl();
        List<String> urls = new ArrayList<String>();

        urls.add(firstImageUrl);

        int imagesCount = trendsArticlePage.getTheAmountOfImages();

        for (int i = 1; i < imagesCount; i++) {
            trendsArticlePage.goToNextImage();
            String nextImgUrl = trendsArticlePage.getCurrentImageUrl();
            assertFalse(urls.contains(nextImgUrl));
            urls.add(nextImgUrl);
        }
        trendsArticlePage.goToNextImage();
        String nextImgUrl = trendsArticlePage.getCurrentImageUrl();
        assertEquals(firstImageUrl, nextImgUrl);
    }


    @Test
    public void checkTheAbilityClosingArticleGalleryImages() {
        TrendsPage trendsPage = new TrendsPage();
        TrendsArticlePage trendsArticlePage = trendsPage.openTrendsArticlePage();
        trendsArticlePage.checkTrendsArticlePageIsOpened();
        trendsArticlePage.proceedToGallery();
        assertTrue(trendsArticlePage.isGalleryOpened(), "Gallery is not opened");
        trendsArticlePage.closeGallery();
        assertFalse("Gallery is not closed",trendsArticlePage.isGalleryOpened());
    }

     /*  @Test
    public void checkTheAbilityPostingComment (){
        driver.get("http://www.vogue.ru/fashion/trends/");
        WebElement articleOfTrends = driver.findElement(By.xpath("((.//div[contains(@class,'section collage') or contains(@class,'section snippet_books')])[1])/a/h2/parent::a"));
        articleOfTrends.click();
        assertNotEquals("http://www.vogue.ru/fashion/trends/",driver.getCurrentUrl());
        WebElement iframe = driver.findElement(By.xpath("((.//div[contains(@class,'block_comment')])[1])//iframe"));
        String commentsIframeName =  iframe.getAttribute("name");
        driver.switchTo().frame(commentsIframeName);
        WebElement commentField = driver.findElement(By.xpath("((.//div[contains(@class,'UFIInputContainer')])[1])//textarea")); //локатор для поля комментариев
        commentField.sendKeys("I like this site");
        WebElement logInToPostButton = driver.findElement(By.xpath("")); //локатор для кнопки "пост"
        String currentWindow = driver.getWindowHandle();
        logInToPostButton.click();
        String facebookLoginWindow =  driver.getWindowHandle();
     //   assertTrue(currentWindow + 2 == facebookLoginWindow);
        driver.switchTo().window(facebookLoginWindow);
        WebElement loginField = driver.findElement(By.xpath(""));//локатор для поля логина в новом окне логина на фейсбук
        loginField.sendKeys("23luna.lovegood@gmail.com");
        WebElement passField = driver.findElement(By.xpath("")); //локатор для поля пароля в новом окне логина на фейсбук
        passField.sendKeys("1qa2ws3ed4rf5tg");
        WebElement enterButton = driver.findElement(By.xpath("")); //окатор для кнопки "вход" в новом окне логина на фейсбук
        enterButton.click();
        driver.switchTo().window(currentWindow);
        logInToPostButton.click();
        //найти как-то добавившийся коммент и проверить что его текст совпадает с текстом который был написан "I like this site"
    }

    @Test


    public void checkTheAbilityChoosingOptionsFromSortByElement () {
        driver.get("http://www.vogue.ru/fashion/trends/");
        WebElement sortByDropDown = driver.findElement(By.xpath(""));//локатор элемента sort by
        sortByDropDown.click();
        WebElement oldestOption = driver.findElement(By.xpath("")); //локатор опции oldest
        oldestOption.click();
    } */
}
