package tests.day01;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_Tab_Window {

    @Test @Ignore
    public void pencereTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wisequarter.com");
        // Yeni bir tarayıcı penceresi açmak
        driver.switchTo().newWindow(WindowType.WINDOW);

    }
    @Test
    public void sekmeTesti(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wisequarter.com");
        // Yeni bir sekme açmak
        //((JavascriptExecutor) driver).executeScript("window.open()");
        driver.switchTo().newWindow(WindowType.TAB);
    }

}
