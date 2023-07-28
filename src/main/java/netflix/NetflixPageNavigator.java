package netflix;

import org.openqa.selenium.WebDriver;

public class NetflixPageNavigator {
    private WebDriver driver;

    public NetflixPageNavigator(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeScreen() {
        driver.manage().window().maximize();
    }

    public void navigateToNetflixPage(String url) {
        driver.get(url);
    }
}
