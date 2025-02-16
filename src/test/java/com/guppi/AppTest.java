package com.guppi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class AppTest {
    // Create a Logger instance for this class
    private static final Logger logger = LogManager.getLogger(AppTest.class);

    public static void main(String[] args) {
        // Set WebDriver path
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920x1080");
        WebDriver driver = new ChromeDriver(options);

        // Instantiate WebDriver (e.g., ChromeDriver)
        // WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        /*FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options); */


        try {
            // Log an info message
            logger.info("Starting the test execution.");

            // Open the website
            driver.get("https://automationexercise.com/");
            logger.info("Opened URL: " + driver.getTitle());
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            // Locate and interact with elements
            WebElement loginButton = driver.findElement(By.xpath("//ul/li[4]/a"));
            loginButton.click();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));
            logger.info("Clicked on the Signup button.");

            // Additional interactions
            WebElement usernameField = driver.findElement(By.xpath("//form/input[2][@name='name']"));
            usernameField.sendKeys("helloworld@123.com");
            logger.info("Entered email");

            WebElement passwordField = driver.findElement(By.xpath("//form/input[3][@name='email']"));
            passwordField.sendKeys("password123");
            logger.info("Entered password.");

            WebElement signUpButton= driver.findElement(By.xpath("//div[3]/div/form/button"));
            signUpButton.click();
            logger.info(" Signup button clicked");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8));

            // Perform assertions or further steps
            // Assume test passes, log the success
            logger.info("Test passed successfully.");
        } catch (Exception e) {
            // Log errors
            logger.error("Test failed with error: ", e);
        } finally {
            // Close the browser
            driver.quit();
            logger.info("Browser closed.");
        }
    }
}
