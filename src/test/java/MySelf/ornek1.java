package MySelf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ornek1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        When user "www.google.com"
        Search for "parcelain teapot"
        And print how many related result display on Google.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://google.com");
        WebElement kabul = driver.findElement(By.id("L2AGLb"));
        kabul.click();
        //(//span[@dir='auto'])[1]
        Thread.sleep(3000);
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));

        //search for "parcelain teapot".
        //way1.We can type then press Enter.Keys.Enter to press enter

        aramaKutusu.sendKeys("porcelain teapot"+ Keys.ENTER);
        //way2.
       // aramaKutusu.sendKeys("porcelain teapot");
        // aramaKutusu.submit();

        Thread.sleep(3000);
        WebElement aramaSonucu= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(aramaSonucu.getText());

        driver.quit();
    }
}
