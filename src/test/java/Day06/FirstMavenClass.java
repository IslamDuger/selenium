package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {
    public static void main(String[] args) {
     /*
           Class Work Amazon Search Test
        1- https://www.amazon.com/ sayfasina gidelim
        2- arama kutusunu locate edelim
        3- “Samsung headphones” ile arama yapalim
        4- Bulunan sonuc sayisini yazdiralim
        5- Ilk urunu tiklayalim
        6- geri giderek arama  Sayfadaki tum basliklari yazdiralim
*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones");
        aramaKutusu.submit();
        WebElement aramaSayisi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(aramaSayisi.getText());
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        driver.navigate().back();
        List<WebElement> headers = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        for (WebElement w : headers) {
            System.out.println(w.getText());
        }

        driver.quit();
    }
}
