package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(
                "file:///C:/Users/Aditya%20kumar/IdeaProjects/untitled2/register.html"
        );

        Thread.sleep(2000);
    }

    @Test
    public void testEmptyFields() throws InterruptedException {

        driver.findElement(By.id("registerBtn")).click();

        Thread.sleep(2000);

        String error =
                driver.findElement(By.id("nameError")).getText();

        Assert.assertEquals(error, "Name is required");

        System.out.println("Empty Fields Validation Passed");
    }

    @Test
    public void testInvalidEmail() throws InterruptedException {

        driver.findElement(By.id("name"))
                .sendKeys("John");



        driver.findElement(By.id("email"))
                .sendKeys("wrongemail");



        driver.findElement(By.id("password"))
                .sendKeys("Password123");

        Thread.sleep(2000);

        driver.findElement(By.id("registerBtn"))
                .click();

        Thread.sleep(2000);

        String error =
                driver.findElement(By.id("emailError")).getText();

        Assert.assertEquals(error, "Invalid email");

        System.out.println("Invalid Email Validation Passed");
    }

    @Test
    public void testWeakPassword() throws InterruptedException {

        driver.findElement(By.id("name"))
                .sendKeys("John");



        driver.findElement(By.id("email"))
                .sendKeys("john@gmail.com");



        driver.findElement(By.id("password"))
                .sendKeys("123");



        driver.findElement(By.id("registerBtn"))
                .click();

        Thread.sleep(2000);

        String error =
                driver.findElement(By.id("passwordError"))
                        .getText();

        Assert.assertEquals(error, "Password too weak");

        System.out.println("Weak Password Validation Passed");
    }

    @Test
    public void testSuccessfulRegistration() throws InterruptedException {

        driver.findElement(By.id("name"))
                .sendKeys("John");



        driver.findElement(By.id("email"))
                .sendKeys("john@gmail.com");



        driver.findElement(By.id("password"))
                .sendKeys("Password123");



        driver.findElement(By.id("registerBtn"))
                .click();

        Thread.sleep(2000);

        String success =
                driver.findElement(By.id("successMessage"))
                        .getText();

        Assert.assertEquals(
                success,
                "Registration Successful"
        );

        System.out.println("Registration Successful");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        if (driver != null) {
            driver.quit();
        }
    }
}