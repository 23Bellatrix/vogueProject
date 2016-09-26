package ru.vogue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.vogue.pages.NewsArticlePage;
import ru.vogue.pages.NewsPage;

import static ru.consult.WebDriverUtils.finishBrowser;
import static ru.consult.WebDriverUtils.startBrowser;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class NewsPageTest {
    @BeforeMethod
    public void beforeMethod (){
        startBrowser();
    }

    @AfterMethod
    public void afterMethod (){
        finishBrowser();
    }

    @Test
    public void checkTheTransitionToSomeNewsArticlePage () {
        NewsPage newsPage = new NewsPage();
        NewsArticlePage newsArticlePage = newsPage.openNewsArticlePage();
        newsArticlePage.checkNewsArticlePageIsOpened();
    }
}
