package netflix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetflixPageObject {
    private WebDriver driver;

    @FindBy(xpath = "//h1")
    private WebElement netflixLogo;

    public NetflixPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return netflixLogo.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
