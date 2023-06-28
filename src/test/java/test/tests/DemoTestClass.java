package test.tests;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoTestClass {

    @Test
    public void testDemo() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.findElement(By.id("forename")).sendKeys("text");
        driver.findElement(By.id("submit")).click();


        //Click on the login button
        driver.findElement(By.id("loginButton")).click();

        //Click on click me down followed by click me up
        driver.findElement(By.xpath("//a[contains(text(),\"Click me down!\")]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),\"Click me up!\")]")).click();
        Thread.sleep(3000);


        driver.quit();

    }

    @Test
    public void testVerifyWebPlayground() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        WebElement playground = driver.findElement(By.xpath("//h1[contains(text(),\"Web Playground\" )]"));
        String actualtext = playground.getText();
        String expectedtext = "Web Playground";

        if(actualtext.equals(expectedtext)){
            Assertions.assertTrue(true);
        }
        else {
            Assertions.assertTrue(false);
        }

        Thread.sleep(3000);


        driver.quit();

    }
}
