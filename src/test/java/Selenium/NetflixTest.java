package Selenium;

import io.qameta.allure.Allure;
import netflix.NetflixPageNavigator;
import netflix.NetflixPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class NetflixTest {
    private WebDriver driver;
    private NetflixPageObject netflixPageObject;
    private NetflixPageNavigator netflixPageNavigator;
    private String netflixUrl = "https://www.netflix.com";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\emanuel.ravarotto\\documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        netflixPageObject = new NetflixPageObject(driver);
        netflixPageNavigator = new NetflixPageNavigator(driver);
    }

    @Test
    public void navigateToNetflixPageAndPrintDetails() {
        netflixPageNavigator.navigateToNetflixPage(netflixUrl);
        netflixPageNavigator.maximizeScreen();
        String title = netflixPageObject.getTitle();
        String url = netflixPageObject.getCurrentUrl();
        System.out.println("Title: " + title);
        System.out.println("URL: " + url);
        printDetails(title, url);
    }

    private void printDetails(String title,String url) {
        Allure.addAttachment("Title", title);
        Allure.addAttachment("URL", url);
        byte[] screenshot = takeScreenshotAsBytes();
        Allure.addAttachment("Screenshot", "image/png", "png", Arrays.toString(screenshot));
    }

    private byte[] takeScreenshotAsBytes() {
        return new byte[0];
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

