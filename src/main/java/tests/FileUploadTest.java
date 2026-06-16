package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadTest {

    @Test
    public void uploadFile() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/upload");

        driver.findElement(By.id("file-upload"))
                .sendKeys("C:\\Users\\Aditya kumar\\Desktop\\Aadii.pdf");

        driver.findElement(By.id("file-submit")).click();

        System.out.println(
                driver.findElement(By.tagName("h3")).getText());

        driver.quit();
    }
}