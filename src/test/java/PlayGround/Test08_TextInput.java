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

public class Test08_TextInput {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/textinput");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test08_TextInput() {
        String ex_test = "Almog Noach";
        driver.findElement(By.id("newButtonName")).sendKeys("Almog Noach");
        driver.findElement(By.id("updatingButton")).click();

        String ac_test = driver.findElement(By.id("updatingButton")).getText();
        Assert.assertEquals(ac_test, ex_test);
        String textINP = driver.findElement(By.id("newButtonName")).getAttribute("value");
        System.out.println("Input Text is: " + textINP);
        System.out.println("Button Text is: " + ac_test);

    }

}
