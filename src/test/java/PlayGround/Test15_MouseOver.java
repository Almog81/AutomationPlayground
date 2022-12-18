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

public class Test15_MouseOver {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/mouseover");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test01_MouseOver() {
        String ex_test = "2";
        WebElement ClickMe1 = driver.findElement(By.cssSelector(".text-primary"));


        Actions actions= new Actions(driver);
        actions.moveToElement(ClickMe1).click().click().build().perform();
        WebElement ClickMe2 = driver.findElement(By.cssSelector(".text-warning"));


        String ac_test = driver.findElement(By.cssSelector(".badge-light")).getText();
        Assert.assertEquals(ac_test, ex_test);
        System.out.println("Numbers of Clicks is: " + ac_test);
        String TextMe =  ClickMe2.getAttribute("title");
        Assert.assertEquals(TextMe, "Active Link");
        System.out.println("Text Attribute is: " + TextMe);
        // איך להפורך סטרינג לאינט
        int test = Integer.parseInt(ac_test);
        Assert.assertEquals(test, 2);


    }

}
