package Day08;

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

public class C1_YoutubeAssertion {
/*
    1) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
            3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    Collapse
*/
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void titleDown(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[6]")).click();
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(expectedTitle.contains(actualTitle));
        Assert.assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void resimTesti(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[6]")).click();
        WebElement logo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
            }
    @Test
    public void aramaKutusu(){
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[6]")).click();


        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }
    @Test
    public void titleTesti(){
        //○ wrongTitleTest    => Sayfa basliginin “youtube” olmadigini dogrulayin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[6]")).click();
        String unexpectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.equals(unexpectedTitle));
    }
    }



