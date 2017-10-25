
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAllTests {

    @BeforeClass
    public static void setUp() throws InterruptedException{
      //  System.setProperties("webdriver.gecko.driver", "C:\\Users\\agrebenkina\\IdeaProjects\\geckodriver-v0.19.0-win64\\geckodriver.exe");
        DesiredCapabilities capability =  DesiredCapabilities.firefox();
        capability.setCapability("marionette", true);
        WebDriver driver = new FirefoxDriver(capability);
        driver.get("http://toolsqa.com/selenium-webdriver/how-to-use-geckodriver/");
        Thread.sleep(1000);
        driver.quit();

    }
    @Test
    public static void someTest(){

    }
}
