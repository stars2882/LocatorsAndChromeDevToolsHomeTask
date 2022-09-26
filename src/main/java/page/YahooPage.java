package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YahooPage extends BasicPage{
    private final static String FIELD_LOGIN = "//*[@id='login-username']";
    private final static String FIELD_PASS = "//*[@id='login-passwd']";

    public YahooPage(WebDriver driver) {
        super(driver);
    }

    public void loginInYahooMail(String email, String pass){
        waitVisibilityOfElement(10, By.xpath(FIELD_LOGIN));
        driver.findElement(By.xpath(FIELD_LOGIN)).sendKeys(email, Keys.ENTER);
        waitVisibilityOfElement(90, By.xpath(FIELD_PASS));
        driver.findElement(By.xpath(FIELD_PASS)).sendKeys(pass, Keys.ENTER);
    }


    public boolean checkInMail(String mail){
        waitVisibilityOfElement(20, By.xpath("//div[@data-test-id='senders']//span[@title='"+mail+"']"));
        return driver.findElement(By.xpath("//div[@data-test-id='senders']//span[@title='"+mail+"']")).isDisplayed();
    }

}
