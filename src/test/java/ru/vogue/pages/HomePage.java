package ru.vogue.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.testng.Assert.assertTrue;

import static ru.consult.WebDriverUtils.getDriver;
import static ru.consult.WebDriverUtils.openPage;
import static ru.consult.WebDriverUtils.saveScreenshot;

/**
 * Created by Lenovo on 24.09.2016.
 */
public class HomePage {

    @FindBys(@FindBy(xpath = ".//div[contains(@class,'section collage') or contains(@class,'section snippet_books')]"))
    private List <WebElement> blocksOfArticles;

    @FindBy (xpath = ".//*[@id='more']/span[1]")
    private WebElement next10Link;

    @FindBy (xpath = "html/body/div[10]/footer/div[1]")
    private WebElement footer;

    @FindBy(css = "a[href*=‘tatler.ru’]")
    private WebElement tatlerLink;

    @FindBy(xpath = "html/body/div[10]/div[4]/div/div[24]/div[7]/div[1]/a[1]")
    private WebElement facebookIcon;

    @FindBy(xpath = "((.//div[contains(@class,'section collage') or contains(@class,'section snippet_books')])[1])/a/h2/parent::a")
    private WebElement articleTitle;

    @FindBy(xpath = "html/body/div[10]/div[4]/div/div[2]")
    private WebElement mainMenu;

    @FindBy(xpath = "html/body/div[10]/div[4]/div/div[2]/ul/li[1]/a")
    private WebElement fashionButtonOfMainManu;

    @FindBy(xpath = "html/body/div[10]/div[4]/div/div[2]/ul/li[1]/div/div[1]/ul/li[1]/a")
    private WebElement newsItem;

    @FindBy(xpath = ".//div[contains(@class,'item active')]/img")
    private WebElement trendsItem;

    public HomePage (){
        openPage("http://www.vogue.ru/");
        PageFactory.initElements(getDriver(), this);
        saveScreenshot();
    }

    public void findArticlesBlocks(){
        assertTrue(blocksOfArticles.size()== 14, "Quantity of articles are 14");
    }

    public void openNewArticlesBlocksByNext10Link(){
        next10Link.click();
    }

    public void checkAdditionOfArticlesBlocks() {
        assertTrue(blocksOfArticles.size()== 28, "Quantity of articles are not 28");
        //assertEquals(blocksOfArticles.size(), 28, "Quantity of articles are not 28");
    }


    public void findFooterAndCheckItsAvailability() {
        assertTrue(footer.isDisplayed(), "Main menu does not display");
    }

    public void checkTheAvailabilityEveryMagazineLink() {
        String [] array = new String [9];
        array [0]= "http://www.vogue.ru/";
        array [1]= "http://gq.ru/";
        array [2]= "http://tatler.ru/";
        array [3]= "http://glamour.ru/";
        array [4]= "http://admagazine.ru/";
        array [5]= "http://www.gq.ru/style/";
        array [6]= "http://cntraveller.ru/";
        array [7]= "http://www.allure.ru/";
        array [8]= "http://www.cntfair.com";

        for (int i=0; i<array.length; i++){
            String url = array[i];
            assertTrue(getDriver().findElements(By.xpath(".//a[contains(@href,'"+url+"')]")).size()>1 );
        }
    }


    public void openMagazinePageAndCheckOpening() {    // нужно ли создавать класс "страниц журнала" при такой проверке? (делать переход на страницу)
        tatlerLink.click();
        assertTrue(getDriver().getWindowHandles().size()> 1);

        /*  driver.get("http://www.vogue.ru/");
        WebElement tatlerLink = driver.findElement(By.cssSelector("a[href*=‘tatler.ru’]"));
        int currentTabs = driver.getWindowHandles().size();
        tatlerLink.click();
        int afterClick =  driver.getWindowHandles().size();
        assertTrue(currentTabs + 1 == afterClick); */
    }


    public void openFacebookPage() {
        facebookIcon.click();
    }




    public HomeArticlePage openArticlePage() {
        articleTitle.click();
        return new HomeArticlePage();
    }


    public void checkMainMenuIsDisplayed() {
        assertTrue(mainMenu.isDisplayed(), "Main menu does not display");
    }

    public void scrollDown() {

        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,2000);");
    }

    public void findNewsItemFromMainMenu(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(fashionButtonOfMainManu).build().perform();
    }

    public NewsPage chooseNewsItem() {
        newsItem.click();
        return new NewsPage();
    }


    public void findTrendsItemFromMainMenu() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(fashionButtonOfMainManu).build().perform();
    }


    public TrendsPage chooseTrendsItem() {
        trendsItem.click();
        return new TrendsPage();
    }
}
