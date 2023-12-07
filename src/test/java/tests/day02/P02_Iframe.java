package tests.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

public class P02_Iframe extends TestBase {

    @Test
    public void IframeTest(){

    // 1) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");


    // 2) "An IFrame containing…." textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeElementi= driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(anIframeElementi.isEnabled());
        System.out.println(anIframeElementi.getText());


    // 3) Text Box'a "Merhaba Dunya!" yazin.
     WebElement iframeelementi= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
     driver.switchTo().frame(iframeelementi);
     WebElement textBoxElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
     textBoxElementi.clear();
     textBoxElementi.sendKeys("Merhaba Dunya!");


    // 4) TextBox'in altinda bulunan "Elemental Selenium" link textinin gorunur oldugunu dogrulayin
    //    ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement eSeleniumElementi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(eSeleniumElementi.isDisplayed());












    }
}
