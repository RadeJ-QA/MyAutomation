package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));

        String url = "https://the-internet.herokuapp.com/login";
        driver.manage().window().maximize();
        driver.get(url);

        WebElement username = driver.findElement(By.cssSelector("#username"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement  button = driver.findElement(By.cssSelector(".radius"));


        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        button.click();

        WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        System.out.println(successMessage.getText());




    }

}
