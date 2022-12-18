package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

public class Test01_DynamicID {
    private WebDriver driver;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/dynamicid");

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test01_DynamicID(){
        String ex_test="Button with Dynamic ID";
        //לתפוס את האלמט לםי CSS
        //String ac_test=driver.findElement(By.cssSelector(".btn.btn-primary")).getText();

        //לתפוס את האלמט לפי XPATH
        String ac_test=driver.findElement(By.xpath("//div[@class='container']/Button")).getText();
        System.out.println("Button Text is: "+ac_test);
        Assert.assertEquals(ac_test,ex_test);
    }



}
