package test.tests;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.modules.Form;
import test.modules.Planet;

import java.time.Duration;
import java.util.List;

public class TestClass {

    private WebDriver driver;
    private WebElement webelement;

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

        Assertions.assertEquals("Thanks for your feedback Akila Herath",
                driver.findElement(By.cssSelector("[class='snackbar popup-message mr-auto']")).getText());
    }

    @Test
    public void planetsTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();

        List<WebElement> planetNames = driver.findElements(By.cssSelector("h2[class='name headline primary--text']"));



//        for(WebElement planet: planets ) {




        }


    @Test
    public void neptuneTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();

        var planetcards = driver.findElements(By.className("planet"));

        for(WebElement planetcard: planetcards)
        {
            String name = planetcard.findElement(By.className("name")).getText();
            if (name.equalsIgnoreCase("Earth")){
                planetcard.findElement(By.tagName("button")).click();
            }
        }

        Thread.sleep(2000);
    }

    @Test
    public void neptuneTest2()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
        Planet planet = new Planet(driver);
        planet.clickExplore("Earth");
        Assertions.assertEquals("Exploring Earth", driver.findElement(
                By.cssSelector("[class*='popup-message']")).getText());
    }

    @Test
    public void clickonDistanceTest()
    {
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();

        List<WebElement> planetList = driver.findElements(By.className("planet"));

        for(WebElement planet : planetList){

        }


    }

    @Test
    public void findingDistanceTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.cssSelector("[aria-label='planets']")).click();
        var planetcards = driver.findElements(By.className("planet"));

        for(WebElement plantcard: planetcards){
            String distance= plantcard.findElement(By.className("distance")).getText();
            //System.out.println(distance);
            if(distance.equalsIgnoreCase("2,871,000,000 km")){
                plantcard.findElement(By.className("v-btn__content")).click();
            }

            //WebElement popupMessage= driver.findElement(By.cssSelector("[class*='popup-message']"));
           // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='popup-message']"))).getText();

//            Assertions.assertEquals("Exploring Uranus",
//                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='popup-message']"))));
        }
        }



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
