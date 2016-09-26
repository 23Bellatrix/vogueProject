package ru.vogue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.consult.WebDriverUtils;
import ru.vogue.pages.HomeArticlePage;
import ru.vogue.pages.HomePage;
import ru.vogue.pages.NewsPage;
import ru.vogue.pages.TrendsPage;

import static ru.consult.WebDriverUtils.finishBrowser;
import static ru.consult.WebDriverUtils.startBrowser;

/**
 * Created by nti on 9/5/2016.
 */
public class HomePageTest {


    @BeforeMethod
    public void beforeMethod() {
        startBrowser();
    }

    @AfterMethod
    public void afterMethod() {
        finishBrowser();
    }

    @Test
    public void checkTheAvailabilityOfArticlesBlocksPerPage() {
        HomePage homePage = new HomePage();
        homePage.findArticlesBlocks();
    }

    @Test
    public void checkNext10Link() {
        HomePage homePage = new HomePage();
        homePage.openNewArticlesBlocksByNext10Link();
        homePage.checkAdditionOfArticlesBlocks();
    }


    @Test
    public void checkTheAvailabilityOfFooter() {
        HomePage homePage = new HomePage();
        homePage.findFooterAndCheckItsAvailability();

    }

    @Test
    // тут должна быть параметризация
    public void checkTheAvailabilityOfMagazinesLinks() {
        HomePage homePage = new HomePage();
        homePage.checkTheAvailabilityEveryMagazineLink();
    }

    @Test
    public void checkTheTransitionToTheMagazinePage() {
        HomePage homePage = new HomePage();
        homePage.openMagazinePageAndCheckOpening();
        // нужно ли создавать класс "страниц журнала" при такой проверке? (делать переход на страницу как NewsPage newsPage = homePage.chooseNewsItem();)
    }

    @Test
    public void checkTheTransitionToFacebookPage() { //тот же вопрос, что и выше
        HomePage homePage = new HomePage();
        Integer windowsQuantity = WebDriverUtils.getWindowsQuantity();
        homePage.openFacebookPage();
        Assert.assertTrue(windowsQuantity == WebDriverUtils.getWindowsQuantity() + 1);
    }

    @Test
    public void checkTheTransitionToArticlePage() {
        HomePage homePage = new HomePage();
        HomeArticlePage homeArticlePage = homePage.openArticlePage();
        homeArticlePage.checkHomeArticlePageIsOpened();
    }

    @Test
    public void checkTheAvailabilityOfMenuWhenScrollingDown() {
        HomePage homePage = new HomePage();
        homePage.checkMainMenuIsDisplayed();
        homePage.scrollDown();
        homePage.checkMainMenuIsDisplayed();
    }


    @Test
    public void checkTheAbilityOpenTheNewsPage() {
        HomePage homePage = new HomePage();
        homePage.findNewsItemFromMainMenu();
        NewsPage newsPage = homePage.chooseNewsItem();
        newsPage.checkNewsPageIsOpened();
    }

    @Test
    public void checkTheAbilityOpenTheTrendsPage() {
        HomePage homePage = new HomePage();
        homePage.findTrendsItemFromMainMenu();
        TrendsPage trendsPage = homePage.chooseTrendsItem();
        trendsPage.checkNewsPageIsOpened();

    }


}

