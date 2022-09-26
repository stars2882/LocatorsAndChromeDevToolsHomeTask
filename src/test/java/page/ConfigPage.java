package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class ConfigPage {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
      chromedriver().setup();
    }

    @BeforeMethod()
    public void testsSetUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
     //   driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public YahooPage getYahooPage(){
        return new YahooPage(getDriver());
    }

    public ProtonPage getProtonPage(){
        return new ProtonPage(getDriver());
    }
}
