package teste;

import framework.BaseTest;
import framework.HelperMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HoverWaitTest extends BaseTest {
    @Test
    public void Hoverwaittest()
    {
        //21.09
        HelperMethods functions = new HelperMethods(driver);
        //hover pe un web element
        WebElement switchtoweb = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        functions.hoverWebelement(switchtoweb);// min aprox 51,52
        //Actions action = new Actions(driver);// min 51
        //action.moveToElement(switchtoweb).build().perform();
        //aplicare de wait explicit
        WebElement windowsWeb=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        new WebDriverWait(driver,2000).until(ExpectedConditions.visibilityOf(windowsWeb));// aplicare de web explicit pe un web element
        windowsWeb.click();
    }
}
