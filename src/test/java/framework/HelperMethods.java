package framework;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// 21.09.2019 crearea unor metode generale care pot fi aplicate
public class HelperMethods {

    WebDriver driver;

    public HelperMethods(WebDriver driver)
    {
        this.driver = driver;
    }

    // metoda generala pentru completarea unui webelement cu un text

    public HelperMethods completareWebelement(WebElement element, String value)
    {
        element.sendKeys(value);
        return this;// min 21
    }
// metoda generala selectare webelement duopa valoare

    public HelperMethods selectareWebelementvaloare(WebElement element, String value)
    {
        Select select = new Select(element);
        select.selectByValue(value);
        return this;
    }

    // metoda hover

    public HelperMethods hoverWebelement(WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        return this;
    }

    // metoda validare titlu

    public HelperMethods validareTitle(String expected)
    {
        if(expected.length()>0)
        {String actual = driver.getTitle();
            Assert.assertEquals(expected,actual);
        }
        return this;

    }
}
