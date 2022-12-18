package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test17_OverlappedElement {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/overlapped");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test09_Scrollbars() {
        String ex_test = "Subject";
        WebElement ID =driver.findElement(By.id("id"));
        WebElement Name =driver.findElement(By.id("name"));
        WebElement Subject = driver.findElement(By.id("subject"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", ID);
        ID.sendKeys("80514058");

        js.executeScript("arguments[0].scrollIntoView(true);", Name);
        Name.sendKeys("Almog Noach");

        js.executeScript("arguments[0].scrollIntoView(true);", Subject);
        Subject.sendKeys("Same One");

        String ac_test = Subject.getAccessibleName();
        Assert.assertEquals(ac_test, ex_test);
        System.out.println("The Text is: " + ac_test);

    }

}
