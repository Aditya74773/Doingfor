package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

class ParallelTest {

    @Test
    public void launchBrowser() {

        // Get browser name from GitHub Actions
        String browser = System.getProperty("browser", "chrome");

        WebDriver driver;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Required for GitHub Actions / Linux CI
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);

        } else {

            FirefoxOptions options = new FirefoxOptions();

            // Run Firefox without UI
            options.addArguments("--headless");

            driver = new FirefoxDriver(options);
        }

        // Open website
        driver.get("https://www.google.com");

        // Print information
        System.out.println("Browser : " + browser);
        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL : " + driver.getCurrentUrl());

        // Close browser
        driver.quit();
    }
}