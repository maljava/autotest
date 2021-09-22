import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ControlPanelPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id = 'content']/h1")
    private WebElement header;
    @FindBy(xpath = "//*[@id='module_2']/div/ul[1]/li[1]/ul/li[1]/a/span")
    private WebElement addButton;

    public ControlPanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkHeader() {
        Assert.assertEquals(header.getText(), "Панель управления",
                "Header is absent");

    }

    public void clickAddButton() {
        addButton.click();
    }
}
