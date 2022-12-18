package PlayGround;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Test13_Visibility {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/visibility");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }

    @AfterClass
    public void CloseSession() {
        driver.quit();
    }

    @Test
    public void test13_ButtonVisibility() {
        String ex_test = "";
        String ac_test = "";
        System.out.println("Hi All!");
        Assert.assertEquals(ac_test, ex_test);

        WebElement Hide = driver.findElement(By.id("hideButton"));


        String XpathButton = "//button[@type=\"button\"]";

        List<WebElement> ButtonsV = driver.findElements(By.xpath("//button[@type=\"button\"]"));
        String[] ButtonsVID = new String[ButtonsV.size()];
        for (int i = 0; i < ButtonsV.size(); i++) {
            ButtonsVID[i] = ButtonsV.get(i).getAttribute("id");
            System.out.println(i + ". " + ButtonsVID[i]);
            }

        Hide.click();

        List<WebElement> NonButtons = driver.findElements(By.xpath("//button[@type=\"button\"]"));
        String[] NonButtonsID = new String[NonButtons.size()];
        for (int i = 0; i < NonButtons.size(); i++) {
            NonButtonsID[i] = NonButtons.get(i).getAttribute("id");
            System.out.println(i + ". " + NonButtonsID[i]);
            }

        int B = 1;

        for (int i = 1; i < ButtonsV.size(); i++, B++) {

            if (ButtonsVID[i].equals(NonButtonsID[B])) {
                System.out.println(ButtonsVID[i] + " fond but not visible");

            } else {
                System.out.println(ButtonsVID[i] + " not found");
                B = B-1;

            }

        }
        System.out.println("");
        System.out.println("list of Buttons That display:");
        for (int i = 3; i < ButtonsV.size(); i++ ){
            Boolean Vis = ButtonsV.get(i).isDisplayed();
            if (Vis.equals(true)){
                System.out.println(ButtonsVID[i] + " is displayed");
            } else {
                System.out.println(ButtonsVID[i] + " is NOT displayed");
            }
        }


    }
}