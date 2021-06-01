package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class soru {
    public static void main(String[] args) {
     /*
     1-Test01 isimli bir class olusturun
2- https://www.walmart.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5- Sayfa basliginin “Save” ifadesi icerdigini control edin
6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
7- URL in walmart.com icerdigini control edin
8-”Nutella” icin arama yapiniz
9- Kac sonuc bulundugunu yaziniz
10-Sayfayi kapatin
      */
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://walmart.com");
        driver.navigate().refresh();
        String sayfaBasligi=driver.getTitle();
        if(sayfaBasligi.contains("Save")){
            System.out.println("sayfa basligi Save iceriyor");
        }else{
            System.out.println("Icermiyor");
        }
        if(sayfaBasligi.equals("“Walmart.com | Save Money.Live Better”")){
            System.out.println("Sayfa title esit");
        }else{
            System.out.println("Sayfanin title farkli");
        }
        String urlBasligi=driver.getCurrentUrl();
        if(urlBasligi.contains("walmart.com")){
            System.out.println("Url testi ayni");
        }else{
            System.out.println("Url testi farkli");
        }
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@id='global-search-input']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@class='result-summary-container']"));
        System.out.print(aramaSonucu.getText());

        driver.close();




    }
}
