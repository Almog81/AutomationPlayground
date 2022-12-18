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

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class Test18_ShadowDOM {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void StartSession (){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/shadowdom"); // באתר משום מה העתקה לא עובדת לכן שמתי את הכתובת של השרת שלי
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //דומה לבדיקה הקודמת גם פה זה מחכה חכם עד שהאלמט נמצא

    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

    @Test
    public void test01_ShadowDOM() {
        //String ex_test = "Subject";
        WebElement SDOM =driver.findElement(By.xpath("//div[@class='container']/guid-generator")); //div[@class='container']/guid-generator#shadow-root/button[@class='button-generate']

        WebElement Generate = SDOM.getShadowRoot().findElement(By.id("buttonGenerate"));
        WebElement Copy =SDOM.getShadowRoot().findElement(By.id("buttonCopy"));
        WebElement edit = SDOM.getShadowRoot().findElement(By.id("editField"));

        Generate.click();
        Copy.click();
        Clipboard Bord = Toolkit.getDefaultToolkit().getSystemClipboard();


        String ex_test = edit.getAttribute("value");

        String ac_test = null;
        try {
            ac_test = Bord.getData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //new Clipboard(ac_test);

        Assert.assertEquals(ac_test, ex_test);
        System.out.println("The Text is: " + ac_test);

        String input = "Almog81";
        edit.clear();
        edit.sendKeys(input);
        Copy.click();
        String otput = null;
        try {
            otput = Bord.getData(DataFlavor.stringFlavor).toString();
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(input,otput);
        System.out.println("The Text is: " + otput);

    }

}
