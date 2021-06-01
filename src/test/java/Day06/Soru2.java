package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Soru2 {
    public static void main(String[] args) {
                    /*
        1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10”
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
    //2. Signin buttonuna tiklayin
        WebElement sigButtonClik=driver.findElement(By.xpath("//*[@id='signin_button']"));
        sigButtonClik.click();
    //3. Login alanine “username” yazdirin
        WebElement loginYazma= driver.findElement(By.xpath("//*[@id='user_login']"));
        loginYazma.sendKeys("username");
    //4. Password alanine “password” yazdirin
         WebElement passwordYazma= driver.findElement(By.xpath("//*[@id='user_password']"));
         passwordYazma.sendKeys("password");
    //5. Sign in buttonuna tiklayin
         WebElement buttonClick=driver.findElement(By.xpath("//*[@name='submit']"));
         buttonClick.click();
    //uyariya tiklama
         WebElement uyari= driver.findElement(By.xpath("//*[@id='primary-button']"));
         uyari.click();
    //6. Pay Bills sayfasina gidin.
        WebElement onlineBankClik= driver.findElement(By.xpath("//*[@id='onlineBankingMenu']"));
        onlineBankClik.click();
        WebElement payBillsClick= driver.findElement(By.xpath("//*[@id='pay_bills_link']"));
        payBillsClick.click();
//7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountYazma= driver.findElement(By.xpath("//*[@name='amount']"));
        amountYazma.sendKeys("500");
// 8. tarih kismina “2020-09-10”
        WebElement tarihYazma= driver.findElement(By.xpath("//*[@id='sp_date']"));
        tarihYazma.sendKeys("2020-09-10");
//9. Pay buttonuna tiklayin
        WebElement payButtonClick= driver.findElement(By.xpath("//*[@id='pay_saved_payees']"));
        payButtonClick.click();
//  10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement mesajKontrol= driver.findElement(By.xpath("//*[@id='alert_content']"));
        if (mesajKontrol.equals("The payment was successfully submitted.")){
            System.out.println("Odemeniz Basariyla tamamlandi");
        }else {
            System.out.println("Tekrar deneyiniz Lutfen");
        }
        driver.close();







    }
}
