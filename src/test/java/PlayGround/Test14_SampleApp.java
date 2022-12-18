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

public class Test14_SampleApp {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/SampleApp");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }

    @AfterClass
    public void CloseSession() {
        driver.quit();
    }

    @Test
    public void test01_Login() {
        System.out.println("Hi All!");

        String UserName = "Almog81";
        String Password = "pwd";

        //Log In
        System.out.println("Log In Test");
        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(UserName);
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(Password);
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();


        String ex_test = "Welcome, " + UserName + "!";
        String ac_test = driver.findElement(By.id("loginstatus")).getText();

        Assert.assertEquals(ac_test, ex_test);
        System.out.println("The Expected Text is: " + ex_test);
        System.out.println("The Actual Text is: " + ac_test);

    }
        @Test
        public void test02_Logout() {
            System.out.println("Log Out Test");

            String ButtonText = driver.findElement(By.cssSelector(".btn.btn-primary")).getText();
            Assert.assertEquals(ButtonText, "Log Out");
            driver.findElement(By.cssSelector(".btn.btn-primary")).click();

            String ex_test = "User logged out.";
            String ac_test = driver.findElement(By.id("loginstatus")).getText();

            Assert.assertEquals(ac_test, ex_test);
            System.out.println(ac_test);
        }

    @Test
    public void test03_LogInFalier() {
        //Log In - Falier
        System.out.println("Log In failer Test");
        String UserName = "Almog81";
        String Password = "Stam1234";

        driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys(UserName);
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(Password);
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        String ex_test = "Invalid username/password";
        String ac_test = driver.findElement(By.id("loginstatus")).getText();

        Assert.assertEquals(ac_test, ex_test);
        System.out.println(ac_test);

    }
}