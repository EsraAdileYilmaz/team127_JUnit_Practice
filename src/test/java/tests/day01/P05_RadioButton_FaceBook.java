package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05_RadioButton_FaceBook {
    /*
    Gerekli yapiyi olusturun ve asagidaki gorevi tamamlayin.
    1)Verilen web sayfasina gidin.https://www.facebook.com
    2)Cookies'i kabul edin
    3)Create an account buton'una basin.
    4)Radio button elementlerini locate edin ve size uygun olani secin
    5)Sectiginiz radio button'un secili,otekilerin secili olmadigini test edin

     */

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void teardown(){
       // driver.quit();
    }

    @Test
    public void test01(){
        //1)Verilen web sayfasina gidin.https://www.facebook.com
        driver.get("https://www.facebook.com");

        //2)Cookies'i kabul edin
        driver.findElement(By.xpath("//button[@title='Autoriser tous les cookies']"));


        //3)Create an account buton'una basin.
        driver.findElement(By.xpath("//button[@*='accept_button']")).click();

        // 4)Radio button elementlerini locate edin ve size uygun olani secin
       /* WebElement nameButton= driver.findElement(By.xpath("//input[@id='u_b_b_jA']"));
        WebElement surnameButton= driver.findElement(By.xpath("//input[@id='u_b_d_i/']"));
        WebElement telButton=driver.findElement(By.xpath("//input[@id='u_b_g_mE']"));
        WebElement sifreButton= driver.findElement(By.xpath("//input[@id='password_step_input']"));
        WebElement dayDropdown= driver.findElement(By.xpath("//select[@id='day']"));
        WebElement monthDropdown=driver.findElement(By.xpath("//select[@id='month']"));
        WebElement yearDropdown=driver.findElement(By.xpath("//select[@id='year']"));
        WebElement femaleButton=driver.findElement(By.xpath("//input[@id='u_b_4_06']"));
        femaleButton.click();
        WebElement maleButton=driver.findElement(By.xpath("//input[@id='u_b_5_J8']"));
        WebElement choseButton=driver.findElement(By.xpath("//input[@id='u_b_6_c3']"));*/

        WebElement emailBox= driver.findElement(By.xpath("//input[@id='email']"));
        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='pass']"));

      // 5)Sectiginiz radio button'un secili,otekilerin secili olmadigini test edin




    }
}
