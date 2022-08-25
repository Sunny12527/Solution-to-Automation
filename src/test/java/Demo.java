import Reusable.DateFormat;
import Reusable.RemoveCharacter;
import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;

import static Reusable.SearchMovieInImdb.searchInImdb;
import static Reusable.SearchMovieInWikipedia.searchInWikki;
public class Demo {
    static WebDriver driver;
    //enter FulL movie name to be searched
    static String searchMovie="Pushpa: The Rise";

    public static void main(String[] args) throws ParseException {


        //Open ChromeBrowser,maximize and navigate to specified url

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");

        //call searchInImdb method to search movie in IMDB
        searchInImdb(driver,searchMovie);

        //Extract ReleaseDate,Country of origin in IMDB
        String Releasedate1=driver.findElement(By.xpath("(//a[text()='Release date'])/following::li[1]")).getText();
        String CountryOfOrigin=driver.findElement(By.xpath("//span[text()='Country of origin']/following::li[1]")).getText();
        String Releasedate2=RemoveCharacter.RemoveStringText(Releasedate1);

        String Releasedate= DateFormat.StringToDateFormat(Releasedate2);


        //displaying ReleaseDate,Country from IMDB
        System.out.println(Releasedate);
        System.out.println(CountryOfOrigin);

        //Open other window and navigate to wikipedia url
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        //called searchInWiki method and get release date ,country origin from wikipedia
        searchInWikki(driver,searchMovie);

        String ReleaseDate_Wiki=driver.findElement(By.xpath("//div[text()='Release date']/following::li[1]")).getText();
        String CountryInWiki=driver.findElement(By.xpath("//th[text()='Country']/following::td[1]")).getText();



        //displaying ReleaseDate,Country from Wikepedia
        System.out.println(ReleaseDate_Wiki);
        System.out.println(CountryInWiki);

        //verifying Releasedate
        boolean d=Releasedate.equals(ReleaseDate_Wiki);
        Assert.isTrue(d,"ReleaseDate of"+" "+searchMovie+" not matches in IMDB and Wikipedia");

        //verifying Country of origin

        boolean c=CountryInWiki.equals(CountryOfOrigin);
        Assert.isTrue(c,"CountryOfOrigin of"+" "+searchMovie+"not matches in IMDB and Wikipedia");

        System.out.println("Both ReleaseDate and Country Origin in IMDB and Wikipedia matches");
        driver.quit();
    }

}
