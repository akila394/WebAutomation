package test.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Planet {
    WebDriver driver;
    List<WebElement> planetElements;
    public Planet(WebDriver driver){
        this.driver = driver;

    }

    public List<WebElement> getplanetCards(){
        planetElements = driver.findElements(By.className("planet"));
        return planetElements;
    }

    public void clickExplore(String planetName)
    {
        for(WebElement planetcard: getplanetCards())
        {
            String name = planetcard.findElement(By.className("name")).getText();
            if (name.equalsIgnoreCase(planetName)){
                planetcard.findElement(By.tagName("button")).click();
            }
        }
        throw new NotFoundException();
    }



}
