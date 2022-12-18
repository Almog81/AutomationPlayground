package PlayGround;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.linkText;

public class Test04_LoadDelay {
    public static WebDriver driver;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/");

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test04_LoadDelay(){
        String ex_test="Button Appearing After Delay";
        String Home=driver.getCurrentUrl();
        driver.findElement(By.linkText("Load Delay")).click();
        String Now=driver.getCurrentUrl();
        String RNow=test_URL(Home,Now);

        String ac_test=driver.findElement(By.cssSelector(".btn-primary")).getText();
        Assert.assertEquals(ac_test,ex_test);
        System.out.println("Button Text is: "+ac_test);
        Assert.assertEquals(ac_test,ex_test);
    }
    public static String test_URL(String Home,String Now){
        String RNow = Now;
        if (Home.equals(RNow)) {
            Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
            RNow=test_URL(Home,driver.getCurrentUrl());
        } else {
            return RNow;
        }
        return RNow;

    }



}
