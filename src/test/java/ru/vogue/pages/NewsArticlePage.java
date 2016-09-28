package ru.vogue.pages;

import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertNotEquals;
import static ru.consult.WebDriverUtils.getDriver;
import static ru.consult.WebDriverUtils.openPage;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class NewsArticlePage {

    public NewsArticlePage (){
    //    openPage("http://www.vogue.ru/fashion/news/"); // тут должен быть другой урл, унивексальный для каждой статьи
        PageFactory.initElements(getDriver(), this);
    }

    public void checkNewsArticlePageIsOpened() {
        assertNotEquals("http://www.vogue.ru/fashion/news/",getDriver().getCurrentUrl()); //а можно ли так делать?
    }
}
