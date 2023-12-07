package tests.day02;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import tests.utilities.TestBase;

public class P01_SignUp extends TestBase {

    // 1-https://www.automationexercise.com/ adresine gidin
   // 2-Sign-up  butonuna basınız
   // 3-Üye Kayıt sayfasında "New User Signup!" yazısının göründüğünü doğrulayı
   // 4-üye kaydı işlemini başlatın
   // 5-Üye kayit formunu doldurun
   // 6-Üye kaydinin yapildiği mesajının göründğünü doğrulayın

    @Test
    public void aeSignUp(){


        // 1-https://www.automationexercise.com/ adresine gidin
       driver.get("https://www.automationexercise.com/");


        // 2-Sign-up  butonuna basınız
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();


     // 3-Üye Kayıt sayfasında "New User Signup!" yazısının göründüğünü doğrulayın
        WebElement newUserYaziElementi= driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        String expectedIcerik="New User Signup!";
        String actualIcerik=newUserYaziElementi.getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);


        // 4-üye kaydı işlemini başlatın
        Faker faker=new Faker();//oncelikle Faker class'indan bir obje uretilmeli.
        String fakerIsim=faker.name().firstName();
        String fakerSoyisim=faker.name().lastName();
        WebElement nameElementi= driver.findElement(By.xpath("//input[@*='signup-name']"));
        nameElementi.sendKeys(fakerIsim + " "+fakerSoyisim);

        String fakerEmail=faker.internet().emailAddress();
        WebElement emailElementi= driver.findElement(By.xpath("//input[@*='signup-email']"));
        emailElementi.sendKeys(fakerEmail);

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();


        // 5-Üye kayit formunu doldurun
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();//title Mrs.

        String fakerPassword=faker.internet().password();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(fakerPassword);//faker password gonderildi

        WebElement days= driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select selectDay=new Select(days);
        selectDay.selectByValue("13");


        WebElement month= driver.findElement(By.xpath("//select[@id='months']"));
        Select selectMonth=new Select(month);
        selectMonth.selectByValue("1");


        WebElement years= driver.findElement(By.xpath("//select[@data-qa='years']"));
        Select selectYears=new Select(years);
        selectYears.selectByValue("2000");

        driver.findElement(By.xpath("//*[text()='Sign up for our newsletter!']")).click();
        driver.findElement(By.xpath("//*[text()='Receive special offers from our partners!']")).click();

        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(fakerIsim);
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys(fakerSoyisim);

        WebElement companyElementi=driver.findElement(By.xpath("//input[@id='company']"));
        companyElementi.sendKeys("Canada");

        String fakerAdres=faker.address().streetAddress();
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(fakerAdres);

        WebElement country= driver.findElement(By.xpath("//select[@id='country']"));
        Select selectCountry=new Select(country);
        selectCountry.selectByValue("Canada");

        String fakerState=faker.address().state();
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys(fakerState);

        String fakerCity=faker.address().city();
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys(fakerCity);

        String fakerZipcode=faker.address().zipCode();
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys(fakerZipcode);

        String fakerMobilenumber=faker.phoneNumber().phoneNumber();
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys(fakerMobilenumber + Keys.PAGE_DOWN);
        //Keys.PAGE_DOWN kullandik cunku sayfa gorunmezse WebElement bulunamayabiliyor.

       driver.findElement(By.xpath("//*[text()='Create Account']")).click();


     // 6-Üye kaydinin yapildiği mesajının göründğünü doğrulayın
     WebElement sonucYaziElementi=driver.findElement(By.xpath("//*[text()='Account Created!']"));
     Assert.assertTrue(sonucYaziElementi.isDisplayed());//1.YOL //elementin görünmesine bakarak

     String expectedResult="ACCOUNT CREATED!";
     String actualResult=sonucYaziElementi.getText();
     Assert.assertEquals(expectedResult,actualResult);//beklenen ile gerceklesenin aynı olup olmadığına bakar



    }
}
