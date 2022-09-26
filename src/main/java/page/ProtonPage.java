package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProtonPage extends BasicPage {
    private final static String LOGIN = "//*[@id='username']";
    private final static String PASS = "//*[@id='password']";
    public final static String PROTON_EMAIL = "test.epam.task@proton.me";
    private final static String PROTON_PASS = "101010ab";
    private final static String BTN_NEW_MESSAGE = "//button[contains(text(),'New')]";
    private final static String FIELD_TO = "//input[@data-testid='composer:to'] ";
    private final static String FIELD_SUBJECT = "//input[@data-testid='composer:subject']";
    private final static String CHECK_OPEN_TAB_SEND = "//span[@data-testid='toolbar:sort-dropdown']";
    private final static String BTN_SEND = "//button[@data-testid='composer:send-button']";
    private final static String TAB_SEND = "//a[@data-testid='navigation-link:Sent']";


    public ProtonPage(WebDriver driver) {
        super(driver);
    }

    public void logInProton(String email, String pass) {
        waitVisibilityOfElement(10, By.xpath(LOGIN));
        driver.findElement(By.xpath(LOGIN)).sendKeys(email, Keys.ENTER);
        waitVisibilityOfElement(10, By.xpath(PASS));
        driver.findElement(By.xpath(PASS)).sendKeys(pass, Keys.ENTER);
    }

    public void createMessage(String emailTo, String subject, String text) {
        waitVisibilityOfElement(50, By.xpath(BTN_NEW_MESSAGE));
        driver.findElement(By.xpath(BTN_NEW_MESSAGE)).click();
        waitVisibilityOfElement(20, By.xpath(FIELD_TO));
        driver.findElement(By.xpath(FIELD_TO)).click();
        driver.findElement(By.xpath(FIELD_TO)).sendKeys(emailTo);
        driver.findElement(By.xpath(FIELD_SUBJECT)).sendKeys(subject);
        driver.findElement(By.xpath(FIELD_SUBJECT)).sendKeys(Keys.TAB, subject);
        driver.findElement(By.xpath(BTN_SEND)).click();
    }

    public boolean checkSendMessage(String emailTo) {
        driver.findElement(By.xpath(TAB_SEND)).click();
        waitVisibilityOfElement(10, By.xpath("//span[contains(text(),'Message sent')]"));
        return driver.findElement(By.xpath("//div//span[contains(text(),'" + emailTo + "')][1]")).isDisplayed();
    }

}
