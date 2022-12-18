package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test06_ClientSideDelay {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/clientdelay");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test06_ClientSideDelay() {
        String ex_test = "Data calculated on the client side.";
        driver.findElement(By.cssSelector(".btn-primary")).click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bg-success"))); // haiמחכה עד שהוא מוצא את האלמנט

        String ac_test = driver.findElement(By.cssSelector(".bg-success")).getText();
        Assert.assertEquals(ac_test, ex_test);
        System.out.println("AJAX Text is: " + ac_test);

    }

}
