package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    @Test
    public void launchBrowser() {

        String browser =
                System.getProperty("browser", "chrome");

        WebDriver driver;

        if(browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments("--headless=new");

            driver = new ChromeDriver(options);

        } else {

            FirefoxOptions options =
                    new FirefoxOptions();

            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
        }

        driver.get("https://www.google.com");

        System.out.println(
                browser + " Title : "
                        + driver.getTitle());

        driver.quit();
    }
}