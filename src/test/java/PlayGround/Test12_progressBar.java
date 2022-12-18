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

public class Test12_progressBar {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/progressbar");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }

    @AfterClass
    public void CloseSession() {
        driver.quit();
    }

    @Test
    public void test12_progressBAR() {
        String ex_test = "75%";

        driver.findElement(By.id("startButton")).click();

        String Now = driver.findElement(By.id("progressBar")).getText();
        String ac_test = test_BAR(Now);
        String result = driver.findElement(By.id("result")).getText();


        System.out.println(ac_test);
        System.out.println(ex_test);
        System.out.println(result);
        Assert.assertEquals(ac_test, ex_test);

    }

    public static String test_BAR(String Now) {
        String RNow = Now;
        if (RNow.equals("75%")) {
            driver.findElement(By.id("stopButton")).click();
        } else {
            //Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(1));
            RNow = test_BAR(driver.findElement(By.id("progressBar")).getText());
        }
        return RNow;

    }
}
