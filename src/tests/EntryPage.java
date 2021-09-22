import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EntryPage {
    private WebDriver driver;
    private String XPATH_TITLE_STRING = "//table[@id = 'result_list']//th/a[text()='%s']";
    private String XPATH_CHECKBOX = "//table[@id = 'result_list']//th/a[text()='%s']/../..//input[@name='_selected_action']";

    @FindBy(xpath = "//*[@id='changelist-form']/div[2]/label/select")
    private WebElement actionBox;

    @FindBy(xpath = "//*[@id='changelist-form']/div[2]/button")
    private WebElement executeButton;


    public EntryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private WebElement getTitleElement(String title) {
        return driver.findElement(By.xpath(String.format(XPATH_TITLE_STRING, title)));
    }

    public void checkTitleExist(String title) {
        Assert.assertTrue(getTitleElement(title).isDisplayed());
    }

    public void clickCheckBoxElement(String title) {
        driver.findElement(By.xpath(String.format(XPATH_CHECKBOX, title))).click();
    }

    public void selectDeleteOption() {
        new Select(actionBox).selectByIndex(1);
    }

    public void clickExecuteButton() {
        executeButton.click();
    }
}
