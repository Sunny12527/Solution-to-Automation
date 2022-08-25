package Reusable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchMovieInImdb {
    public static void searchInImdb(WebDriver driver, String movieName)
    {
        WebElement search_movieName = driver.findElement(By.xpath("//input[@placeholder='Search IMDb']"));
        search_movieName.click();
        search_movieName.sendKeys(movieName);
        search_movieName.sendKeys(Keys.ARROW_DOWN);
        search_movieName.sendKeys(Keys.ENTER);
    }
}
