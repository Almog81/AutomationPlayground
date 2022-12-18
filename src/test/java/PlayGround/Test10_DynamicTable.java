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

public class Test10_DynamicTable {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com/DynamicTable");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test10_DynamicTable() {
        String ex_test = driver.findElement(By.cssSelector(".bg-warning")).getText();
        //איך לפצל סטרינג
        String ex_split = ex_test.split(":")[1].substring(1);
        System.out.println(ex_split);

        int x = 0;
        int Y = 0;
        String result = "0";
        //מציאת העמודות והתאים
        List<WebElement> columns = driver.findElements(By.xpath("//span[@role='columnheader']"));
        List<WebElement> Cell = driver.findElements(By.xpath("//span[@role='cell']"));

        for (int i=0; i < columns.size(); i++){
            String CPU = columns.get(i).getText();
            if (CPU.equals("CPU")) {
                x=i;
                break;
            }
        }
        for (int i=0; i < Cell.size(); i++){
            String Contant = Cell.get(i).getText();
            if (Contant.equals("Chrome")) {
                Y = i+x;
                result = Cell.get(Y).getText();
                break;
            }
        }
        //בדיקה של הערכים בנפרד
        Assert.assertEquals(result, ex_split);


        String ac_test = "Chrome CPU: " + result;
        System.out.println(ac_test);
        System.out.println(ex_test);
        System.out.println("X = " + x);
        System.out.println("y = " + Y);

        Assert.assertEquals(ac_test, ex_test);
        //System.out.println("Button Text is: " + ac_test);



    }

}
