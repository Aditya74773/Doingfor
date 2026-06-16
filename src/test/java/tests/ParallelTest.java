package tests;

// Selenium imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// TestNG imports
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

    // Get browser value from testng.xml
    @Parameters("browser")
    @Test
    public void launchBrowser(String browser) {

        // Create WebDriver reference
        WebDriver driver;

        // Open browser based on parameter value
        if (browser.equalsIgnoreCase("chrome")) {

            // Open Chrome
            driver = new ChromeDriver();

        } else {

            // Open Firefox
            driver = new FirefoxDriver();
        }

        // Open Google website
        driver.get("https://www.google.com");

        // Print browser name
        System.out.println("Browser Name : " + browser);

        // Print page title
        System.out.println("Page Title : " + driver.getTitle());

        // Print current URL
        System.out.println("Current URL : " + driver.getCurrentUrl());

        // Close browser
        driver.quit();
    }
}