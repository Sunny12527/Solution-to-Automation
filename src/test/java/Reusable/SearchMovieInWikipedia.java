package Reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchMovieInWikipedia {
    public static void searchInWikki(WebDriver driver,String WikkiMovie)
    {
        WebElement SearchInWiki = driver.findElement(By.xpath("//input[@placeholder='Search Wikipedia']"));
        SearchInWiki.click();
        SearchInWiki.sendKeys(WikkiMovie);
        String var_xpath="//a[@title='"+WikkiMovie+"']";
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(var_xpath)));
        SearchInWiki.sendKeys(Keys.ARROW_DOWN);
        SearchInWiki.sendKeys(Keys.ENTER);
    }
}
