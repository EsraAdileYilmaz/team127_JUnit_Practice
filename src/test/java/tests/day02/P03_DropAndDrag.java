package tests.day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.utilities.TestBase;

public class P03_DropAndDrag extends TestBase {

    //1- https://demoqa.com/droppable adresine gidelim
    //2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
    //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin


    @Test
    public void test01(){

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
        WebElement dragmeElementi= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drophereElementi= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragmeElementi,drophereElementi).perform();

        //3- "Drop here" yazisi yerine "Dropped!" oldugunu test edin
        WebElement droppedElementi= driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualYaziElementi=droppedElementi.getText();
        String expectedYaziElementi="Dropped!";
        Assert.assertEquals(expectedYaziElementi,actualYaziElementi);





    }
}
