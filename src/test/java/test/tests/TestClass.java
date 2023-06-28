package test.tests;

import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.modules.Form;

import java.time.Duration;
import java.util.List;

public class TestClass {

    private WebDriver driver;

    @BeforeEach
    public void setup()
    {
        setBrowser();
        driver.get("https://d18u5zoaatmpxx.cloudfront.net/#/");
        driver.manage().window().maximize();
    }

    @Test
    public void submitForenameTest() throws InterruptedException {
        //given

        //when
        driver.findElement(By.id("forename")).sendKeys("text");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);

        //then

        WebElement forenamesubmittext =driver.findElement(By.xpath("//div[contains(text(),\"Hello text\")]"));
        String actualtext = "Hello text";
        String expectedtext = forenamesubmittext.getText();
        Assertions.assertEquals(actualtext,expectedtext);
    }

    @Test
    public void loginButtonTest() throws InterruptedException {
        //given

        //when
        driver.findElement(By.id("loginButton")).click();

        //then

    }

    @Test
    public void fillFormtest()  {
        //Given

        //When

        driver.findElement(By.cssSelector("a[aria-label='forms']")).click();
        Form form = new Form(driver);
        form.enterName("Akila");
        form.enterEmail("Akila@gmail.com");

        form.selectState();
        form.selectAgree();
        form.submit();

        //Then
//        By ByPopupMessage = By.className("popup message");
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
//                ExpectedConditions.visibilityOfElementLocated(ByPopupMessage));
//
//        //Assertions.assertEquals("Thanks for your feedback", textElement);
        //Thread.sleep(3000);

        Assertions.assertEquals("Thanks for your feedback Akila Herath",
                driver.findElement(By.cssSelector("[class='snackbar popup-message mr-auto']")).getText());
    }

    @Test
    public void planetsTest()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();

        List<WebElement> planetNames = driver.findElements(By.cssSelector("h2[class='name headline primary--text']"));
        List<WebElement> planets = driver.findElements(By.cssSelector("[class='v-btn__content']"));


        for(WebElement planet: planets ){
            for(WebElement planetName : planetNames){
                if(planet.getText().equalsIgnoreCase("Explore")){
                    if(planetName.getText().equalsIgnoreCase("Earth")){
                        planet.click();
                        break;
                    }

                }
            }

        }
    }

    @Test
//    public void loginButtonTest() throws InterruptedException {
//        //given
//
//        //when
//        driver.findElement(By.id("loginButton")).click();
//
//        //then
//
//    }



    @AfterEach
    public void tearDown()
    {
        driver.quit();
    }
    private void setBrowser()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }



}
