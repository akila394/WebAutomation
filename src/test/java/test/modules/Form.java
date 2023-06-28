package test.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Form {
    WebDriver driver;

    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);


    }

    public void selectState() {
        driver.findElement(By.cssSelector("[class='v-select__selections']")).click();
        driver.findElements(By.cssSelector("[role='option']"));

        for(WebElement element : driver.findElements(By.cssSelector("[role='option']"))){
            if(element.getText().equalsIgnoreCase("Vic"))
            {
                element.click();
            }
        }
    }

    public void selectAgree() {

        driver.findElement(By.cssSelector("[class='v-input--selection-controls__ripple']")).click();
    }

    public void submit() {
        List<WebElement> element = driver.findElements(By.cssSelector("[class='v-btn__content']"));

        for(WebElement each: element){
            if(each.getText().equalsIgnoreCase("submit")){
                each.click();
            }
        }
    }
}
