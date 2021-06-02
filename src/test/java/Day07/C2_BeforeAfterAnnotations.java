package Day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C2_BeforeAfterAnnotations {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Setup Calisti");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("Teardouwn calisti");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("http://amazon.com");
        System.out.println("Birinci method calisti");
       }
    @Test
    public void test02() throws InterruptedException {
        driver.get("http://samanyoluhaber.com");
        System.out.println("ikinci method calisti");

    }
    @Test @Ignore
    public void test03() throws InterruptedException {
        driver.get("http://fanatik.com.tr");
        System.out.println("ucuncu method calisti");

    }



}
