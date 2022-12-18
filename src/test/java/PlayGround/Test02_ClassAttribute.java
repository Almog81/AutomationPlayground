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

import java.sql.Driver;

public class Test02_ClassAttribute {
    private WebDriver driver;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/classattr");

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test02_ClassAttribute_MyTest(){
        String ex_test="Primary button pressed";
        driver.findElement(By.cssSelector(".btn-primary")).click();
        Alert alert=driver.switchTo().alert();
        String ac_test=alert.getText();
        alert.accept();

        System.out.println("Alert Text is: "+ac_test);
        System.out.println("Button Atteibute is: "+driver.findElement(By.cssSelector(".btn-primary")).getAttribute("class"));
        Assert.assertEquals(ac_test,ex_test);
    }



}
