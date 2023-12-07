package tests.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class P04_FileUploaded extends TestBase {


    @Test
    public void fileUploadTest() throws FileNotFoundException {

        // 1)https://the-internet.herokuapp.com/upload adresine gidelim
        // 2)Bilgisayarımızdaki herhangi bir dosyayı buraya yükleyelim
        // 3)logo.png dosyasini yukleyin

        // 1)https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2)Bilgisayarımızdaki herhangi bir dosyayı buraya yükleyelim
        WebElement fichierElementi= driver.findElement(By.xpath("//input[@id='file-upload']"));
        //yukleyecegimiz yeri locate ettik.yani dosyayi nereye yukleyecegimizi gosterdik.


        // 3)logo.png dosyasini yukleyin
        String dosyaYolu="/Users/familleyilmaz/IdeaProjects/com.team127_JUnitPractice/src/test/java/tests/utilities/logo.png";
        fichierElementi.sendKeys(dosyaYolu);
        
        WebElement uploadElementi= driver.findElement(By.xpath("//input[@value='Upload']"));
        uploadElementi.click();

        WebElement fileUploadedElementi= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());








    }
}
