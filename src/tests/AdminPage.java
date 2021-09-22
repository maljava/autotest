import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    private By XPATH_USERNAME_FIELD = By.xpath("//input[@id='id_username']");
    private By XPATH_PASSWORD_FIELD = By.xpath("//input[@id='id_password']");
    private By XPATH_ENTER_BUTTON = By.xpath("//input[@type = 'submit']");

    private WebDriver driver;

    public AdminPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterName(String name) {
        WebElement usernameField = driver.findElement(XPATH_USERNAME_FIELD);
        usernameField.sendKeys(name);
    }
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(XPATH_PASSWORD_FIELD);
        passwordField.sendKeys(password);
    }
    public void clickButton() {
        WebElement button = driver.findElement(XPATH_ENTER_BUTTON);
        button.click();
    }
}
