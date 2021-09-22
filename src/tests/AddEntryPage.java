import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddEntryPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement header;

    @FindBy(xpath = "//*[@id='id_title']")
    private WebElement titleField;

    @FindBy(xpath = "//*[@id='id_slug']")
    private WebElement slugField;

    @FindBy(xpath = "//*[@id='id_text_markdown']")
    private WebElement textMarkdownField;

    @FindBy(xpath = "//*[@id='id_text']")
    private WebElement textField;

    @FindBy(xpath = "//input[@type = 'submit' and @value = 'Сохранить']")
    private WebElement saveButton;


    public AddEntryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkHeader() {
        Assert.assertEquals(header.getText(), "Добавить entry",
                "Header is absent");
    }

    public void enterTitle(String title) {
        titleField.sendKeys(title);
    }

    public void enterSlug(String slug) {
        slugField.sendKeys(slug);
    }

    public void enterTextMarkdown(String textMarkdown) {
        textMarkdownField.sendKeys(textMarkdown);
    }

    public void enterText(String text) {
        textField.sendKeys(text);
    }

    public void clickSaveButton() {
        saveButton.click();
    }
}
