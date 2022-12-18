package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test05_AJAXData {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/ajax");
        wait=new WebDriverWait(driver,Duration.ofSeconds(20)); //הגדרת הזמן שצריך לחכות

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test05_LoadDelay() {
        String ex_test = "Data loaded with AJAX get request.";
        driver.findElement(By.cssSelector(".btn-primary")).click();

        //Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(15)); //הבדיקה הטיפשה
        //String ac_test=driver.findElement(By.cssSelector(".bg-success")).getText(); //הבדיקה הטיפשה

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bg-success"))); //מחכה עד שהוא מוצא את האלמנט

        String ac_test = driver.findElement(By.cssSelector(".bg-success")).getText();
        Assert.assertEquals(ac_test, ex_test);
        System.out.println("AJAX Text is: " + ac_test);

    }

}
