import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class MyTests {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void myTest() {
        SoftAssert softAssert = new SoftAssert();


        driver.get("http://igorakintev.ru/admin");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.enterName("selenium");
        adminPage.enterPassword("super_password");
        adminPage.clickButton();

        ControlPanelPage controlPanelPage = new ControlPanelPage(driver);
        controlPanelPage.checkHeader();
        controlPanelPage.clickAddButton();

        AddEntryPage addEntryPage = new AddEntryPage(driver);
        addEntryPage.checkHeader();

        String randomTitle = getRandomString(20);
        addEntryPage.enterTitle(randomTitle);
        addEntryPage.enterSlug(getRandomString(20));
        addEntryPage.enterTextMarkdown(getRandomString(20));
        addEntryPage.enterText(getRandomString(20));
        addEntryPage.clickSaveButton();

        softAssert.assertEquals(driver.getCurrentUrl(), "http://igorakintev.ru/blog/", "URL is wrong");
        EntryPage entryPage = new EntryPage(driver);
        entryPage.checkTitleExist(randomTitle);
        entryPage.clickCheckBoxElement(randomTitle);
        entryPage.selectDeleteOption();
        entryPage.clickExecuteButton();

        ConfirmPage confirmPage = new ConfirmPage(driver);
        confirmPage.clickOkButton();

        softAssert.assertAll();

    }

    @AfterTest
    public void close() {
        driver.close();
    }

    private String getRandomString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


}
