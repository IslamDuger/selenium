package Day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C6_BestBuyAssertions {
    /*
   1) Bir class oluşturun: BestBuyAssertions
   2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
       ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
       ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
       ○ logoTest => BestBuy logosunun görüntülendigini test edin
       ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @After
    public void tearDouwn() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01() {
        //Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        driver.get("https://www.bestbuy.com/");
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String expectTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(expectTitle));
    }

    @Test
    public void test02(){
    //○ logoTest => BestBuy logosunun görüntülendigini test edin
        driver.get("https://www.bestbuy.com/");
        WebElement actuellogo=driver.findElement(By.xpath("(//*[@class='logo'])[1]"));

        Assert.assertTrue(actuellogo.isDisplayed());
    }
    @Test
    public void linkGoruntulenme(){
     // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        driver.get("https://www.bestbuy.com/");
        WebElement fransizcaLink= driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(fransizcaLink.isDisplayed());
    }




}
