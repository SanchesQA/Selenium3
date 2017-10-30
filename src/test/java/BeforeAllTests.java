
import javafx.scene.control.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


public class BeforeAllTests {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\agrebenkina\\IdeaProjects\\geckodriver-v0.19.0-win64\\geckodriver.exe");
     //   DesiredCapabilities capability =  DesiredCapabilities.firefox();
     //   capability.setCapability("marionette", true);
      //  driver = new FirefoxDriver(capability);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://games.williamhill.com/#!/");



    }
    @Test
    public  void airbnbTest(){
        driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        WebElement promotionsTile;
        promotionsTile = driver.findElement(By.xpath("//a[@title='PROMOTIONS']"));
        promotionsTile.click();
        WebElement promoBlock;
        promoBlock = driver.findElement(By.cssSelector(".promotion-tiles-list"));
        SoftAssert s_ass = new SoftAssert();
        s_ass.assertEquals(true, promotionsTile.isSelected());
        System.out.println("Menu is Selected"+promotionsTile.isSelected());
        Assert.assertEquals(true, promoBlock.isDisplayed());
        s_ass.assertAll();





    }
   @AfterMethod
    public  void tearDown(){
        driver.quit();
    }

}
