package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POMScreen {

    WebDriver driver;
    Actions actions;
    Wait wait;

    //Insert your elements here
    @FindBy(xpath = "dummyElementXpath")
    public WebElement dummyElement;

    //Constructor
    public POMScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 5);
    }
    //Code your steps here

}
