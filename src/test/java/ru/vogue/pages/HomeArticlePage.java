package ru.vogue.pages;

import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertNotEquals;
import static ru.consult.WebDriverUtils.getDriver;
import static ru.consult.WebDriverUtils.openPage;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class HomeArticlePage {

    public HomeArticlePage() {
        openPage("http://www.vogue.ru/");             // линк другой должен быть. нечто, что подойдетдля любой хом артикл пэйдж
        PageFactory.initElements(getDriver(), this);
    }

    public void checkHomeArticlePageIsOpened() {
        assertNotEquals("http://www.vogue.ru/",getDriver().getCurrentUrl()); //а так можно?
    }
}
