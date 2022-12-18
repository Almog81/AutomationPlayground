package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test07_Click {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/click");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test07_Click() {
        String ex_test = "btn btn-success";
        driver.findElement(By.id("badButton")).click();
        driver.findElement(By.cssSelector(".btn-success")).click();

        String ac_test = driver.findElement(By.id("badButton")).getAttribute("class");
        Assert.assertEquals(ac_test, ex_test);
        System.out.println("Button Attribute is: " + ac_test);

        //דרך שניה
        driver.get("http://uitestingplayground.com/click");
        Actions actions= new Actions(driver);
        WebElement Button = driver.findElement(By.id("badButton"));
        actions.moveToElement(Button).click().build().perform();

        String Attribute = driver.findElement(By.id("badButton")).getAttribute("class");
        Assert.assertEquals(Attribute, ex_test);
        System.out.println("Button Attribute is: " + ac_test);


    }

}
