package Day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C5_RadioButtonTest {
    /*
    1. Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        https://www.facebook.com adresine gidin
        “Create an Account” button’una basin
        “radio buttons” elementlerini locate edin
        Secili degilse cinsiyet butonundan size uygun olani secin
             */
     WebDriver driver;

     @Before

      public void setup(){
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

      }

    @After
    public void tearDouwn() throws InterruptedException {
         Thread.sleep(3000);
         driver.close();

    }
    @Test
    public void test01(){
    // https://www.facebook.com adresine gidin
         driver.get("https://www.facebook.com");
    //gelen uyariyi kabul etmek
         driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _9o-t _4jy3 _4jy1 selected _51sy']")).click();
    // “Create an Account” button’una basin
    driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

    // “radio buttons” elementlerini locate edin
        WebElement radioButtonu=driver.findElement(By.xpath("(//*[@class='_58mt'])[2]"));
        if(!radioButtonu.isSelected()){
            radioButtonu.click();
        }


    }

}

