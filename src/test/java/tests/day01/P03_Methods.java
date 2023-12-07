package tests.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03_Methods {

     /*
      BeforeClass ile driver'i oluşturun ve class icinde static yapin
      Maximize edin ve 10 sn bekletin
      AfterClass ile kapatin.
      http://www.babayigit.net/testdocs adresine gidin
      1-arama kutusuna "12 Angry Men” yazip, cikan sonuc sayisini yazdirin
      2-arama kutusuna "Vizontele” yazip, cikan sonuc sayisini yazdirin
      3-arama kutusuna "Saving Private Ryan” yazip, cikan sonuc sayisini yazdirin
      4-arama kutusuna "3 idiots” yazip, cikan sonuc sayisini yazdirin

     */


    static WebDriver driver;
    WebElement searchBox;
    String filmName;
    @BeforeClass
    public static void setUp(){//Tum methodlardan once 1 kez calisir ve ayarlari yapar.

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown(){//Tum methodlardan sonra 1 kez calisir ve acilan herseyi kapatir.

        driver.quit();
    }

    @Before
    public void before(){//Her methoddan once calisir.

        driver.get("http://www.babayigit.net/testdocs");
        searchBox =driver.findElement(By.xpath("//input[@id='search']"));

    }

    @After
    public void after(){//Her methoddan sonra calisir.

        System.out.println(filmName+" sonuc sayisi: "+driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
        //her bir film icin bulunan sonuc yazisini locate ettik ve onun getText() ile sonuc yazisini aldik.

        System.out.println("Window handles: "+driver.getWindowHandle());
    }

    @Test
    public void test01(){
        //1-arama kutusuna "12 Angry Men” yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("12 Angry Men"+ Keys.ENTER);
        filmName="12 Angry Men";
        /*
        filmName="12 Angry Men";
        searchbox.sendKeys(filmName+" "+ Keys.ENTER);
         */
    }

    @Test
    public void test02(){
        // 2-arama kutusuna "Vizontele” yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("Vizontele"+Keys.ENTER);
        filmName="Vizontele";
    }

    @Test
    public void test03(){
        //3-arama kutusuna "Saving Private Ryan” yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("Saving Private Ryan"+Keys.ENTER);
        filmName="Saving Private Ryan";
    }

    @Test
    public void test04(){
        //4-arama kutusuna "3 idiots” yazip, cikan sonuc sayisini yazdirin
        searchBox.sendKeys("3 idiots"+Keys.ENTER);
        filmName="3 idiots";
    }

}
