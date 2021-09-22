import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='content']/form/div/input[4]")
    private WebElement okButton;

    public ConfirmPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void clickOkButton() {
        okButton.click();
    }
}
