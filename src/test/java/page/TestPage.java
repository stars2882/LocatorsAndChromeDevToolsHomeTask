package page;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestPage extends ConfigPage{
    private final static String EMAIL_YAHOO = "test_epam@yahoo.com";
    private final static String PASS_YAHOO = "101010AaBb";
    private final static String EMAIL_PROTON = "test.epam.task@proton.me";
    private final static String PASS_PROTON = "101010ab";
    private final static String SUBJECT = "Test massage";
    private final static String TEXT = "Hello test!";

    private static final String URL_YAHOO = "https://login.yahoo.com/?.intl=ua&.lang=uk-UA&src=ym&activity=ybar-mail&pspid=2023538075&done=https%3A%2F%2Fmail.yahoo.com%2Fd%3Fpspid%3D2023538075%26activity%3Dybar-mail&add=1";
    private static final String URL_PROTON = "https://mail.proton.me";


    @Test(priority = 1)
    public void loginAndSendMessageProton() {
        getDriver().get(URL_PROTON);
        getProtonPage().logInProton(EMAIL_PROTON, PASS_PROTON);
        getProtonPage().createMessage(EMAIL_YAHOO, SUBJECT, TEXT);
        Assert.assertTrue(getProtonPage().checkSendMessage(EMAIL_YAHOO));
    }

    @Test(priority = 2)
    public void checkIncomingMessage() {
        getDriver().get(URL_YAHOO);
        getYahooPage().loginInYahooMail(EMAIL_YAHOO, PASS_YAHOO);
        Assert.assertTrue(getYahooPage().checkInMail(EMAIL_PROTON));
    }

}
