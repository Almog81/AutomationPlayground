package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test03_HiddenLayers {
    private WebDriver driver;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/hiddenlayers");

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test03_HiddenLayers(){
        String ex_test="Primary button pressed";
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
        //driver.findElement(By.id("greenButton")).click();
    }



}
