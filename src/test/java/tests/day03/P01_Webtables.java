package tests.day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class P01_Webtables extends TestBase {


    /*
    //1."https://testotomasyonu.com/webtables" adresine gidin
    //2.Web table tum body’sini yazdirin
    //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
    //4.Web table’daki satir sayisinin 5 oldugunu test edin
    //5.Tum satirlari yazdirin
    //6. Web table’daki sutun sayisinin 4 olduğunu test edin
    //7. 3.sutunu yazdirin
    //8. Tablodaki basliklari yazdirin
    //9. 4.satirdaki category degerinin "Furniture" oldugunu test edin
    */

     /*
     @FixMethodOrder özelliği, JUnit 4.x sürümünde test metodlarının
     belirli bir sıra içinde çalıştırılmasını sağlamak için kullanılıyordu.
     Ancak, bu özellik bazı sorunlara neden olabiliyordu ve genellikle tavsiye edilmiyordu.
     Bu sorunlar arasında testlerin bağımsızlığını zedeleme,
     kodun bakımını zorlaştırma ve test sıralamasının belirli koşullara bağlı olarak değişmesi yer alıyordu.
     JUnit 5, bu sorunları ele almak ve daha esnek bir test çerçevesi sunmak amacıyla tasarlandı.
     Bu nedenle, JUnit 5'te @FixMethodOrder özelliği standart olarak bulunmamaktadır.
     Bunun yerine, testlerin bağımsız olması ve belirli bir sırayla çalıştırılmaması önerilmektedir.
     Eğer test sırasının belirli bir şekilde olmasına ihtiyaç duyuyorsanız,
     JUnit 5'de @TestMethodOrder ve @Order annotasyonlarını kullanabilirsiniz,
     ancak bu kullanımı dikkatlice değerlendirmeniz ve
     testlerinizi mümkünse bağımsız hale getirmeniz daha iyi olacaktır.(F.ZEYBEK 2023)
     */

    @Test
    public void webTablesTest(){

        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table Header ve tum body’sini yazdirin
        WebElement tableHeader=driver.findElement(By.xpath("//table/thead"));
        System.out.println("Tablonun Header Değerleri\n"+tableHeader.getText());
        WebElement tableBody= driver.findElement(By.xpath("//table/tbody"));
        System.out.println("Tablonun Body Değerleri\n"+tableBody.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedIcerik="Comfortable Gaming Chair";
        String actualIcerik=tableBody.getText();

        assertTrue(actualIcerik.contains(expectedIcerik));
        System.out.println("Tabloda \'"+expectedIcerik+"\' olduğu görüldü\n");

        //4.Web table’daki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirElementleri=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=5;
        int actualSatirSayisi=satirElementleri.size();

        assertEquals(expectedSatirSayisi,actualSatirSayisi);
        System.out.println("Tablo satır sayısının "+expectedSatirSayisi+" olduğu görüldü\n");

        //5.Tum satirlari yazdirin

        for (int i = 0; i < satirElementleri.size(); i++) {
            System.out.println(i+1+".Satır Elemanları:\n"+satirElementleri.get(i).getText()+"\n");
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> baslikelementleri=driver.findElements(By.xpath("//thead/tr/th"));
        int expectedSutunSayisi=4;
        int actualSutunSayisi= baslikelementleri.size();


        assertEquals(expectedSutunSayisi,actualSutunSayisi);
        System.out.println("Sütun sayısının "+expectedSutunSayisi+" olduğu görüldü");

        //7.  3.sutunu yazdirin
        List<WebElement> ucuncuSutunElemanlari=driver.findElements(By.xpath("//td[3]"));
        for (int i = 0; i < ucuncuSutunElemanlari.size(); i++) {
            System.out.println(i+1+".Satır 3. Sütun Elemanı: "+ucuncuSutunElemanlari.get(i).getText()+"\n");

        }

        //8. Tablodaki basliklari yazdirin
        List<WebElement> baslikElementleri=driver.findElements(By.xpath("//thead/tr/th"));
        System.out.println("Başlık Elemenleri:");
        for (int i = 0; i < baslikelementleri.size(); i++) {
            System.out.println(i+1+".Eleman: "+baslikElementleri.get(i).getText());
        }


        //9. 4.satirdaki category degerinin "Furniture" oldugunu test edin
        System.out.println("\n"+hucreDegeriniGetir(4,2));
        System.out.println("");
        String expectedCell="Furniture";
        String actualCell=hucreDegeriniGetir(4,2);

        assertEquals(expectedCell,actualCell);
        System.out.println("İstenen hücredeki degerin "+expectedCell+" olduğu görüldü");

        }

    public String hucreDegeriniGetir(int Satir, int Sutun) {
        //   //tbody/tr[4]/td[2]
        String xpathAddres="//tbody/tr["+Satir+"]/td["+Sutun+"]";
        WebElement selectElement= driver.findElement(By.xpath(xpathAddres));
        return selectElement.getText();
    }




}

