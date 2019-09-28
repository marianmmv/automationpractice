package teste;

import framework.BaseTest;
import framework.HelperMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register_test extends BaseTest {

    // declarare variabila de tip webdriver
        //public WebDriver driver;
        @Test
        public void test()
        {
            // delcarare obiect de tip helperMethods

            HelperMethods functions = new HelperMethods(driver);

            //SETAM DRIVERUL DE CHROME
           // System.setProperty("webdriver.chrome.driver","E:\\2019\\Automation\\chromedriver.exe");
            //intiliaizarea variabilei driver cu browserul dorit, pe care sa il folosim
            /*driver = new ChromeDriver();
            driver.get("http://demo.automationtesting.in/Register.html");// se poate accesa orice site, doar trebuie specificat link-ul

            //facem browser-ul mare

            driver.manage().window().maximize();*/

            // validare pagina de register 1:48 h min

            //String expectedRegistervalue = "Register";
            String expectedRegistervalue = BaseTest.returnvalue("registertitle");
            functions.validareTitle(expectedRegistervalue);

            //String actualRegistervalue = driver.getTitle();
            //Assert.assertEquals(expectedRegistervalue,actualRegistervalue);



            // automatizare flow

            // completam campul de first name
//MIN 57
            WebElement firstnameWeb = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

            //String firstnameValue = "Marian";
            String firstnameValue = BaseTest.returnvalue("firstname");
            functions.completareWebelement(firstnameWeb,firstnameValue);// aceiasi chestie pentru last name
            // trebuie unite 01.01 min
            //firstnameWeb.sendKeys(firstnameValue); // send keys completeaza o valuare pe un web element.

            //click pe gen

            WebElement genderWeb = driver.findElement(By.xpath("//input[@value='Male']"));

            genderWeb.click();

            //click pe hobby
            // by xpath WebElement hobbyWeb = driver.findElement(By.xpath("//input[@id='checkbox1']"));
            //by id

            WebElement hobbyWeb = driver.findElement(By.id("checkbox1"));

            // selectare skills

            WebElement skillsWeb = driver.findElement(By.id("Skills"));

            String skillsValue = "C";
            Select skillsSelect = new Select(skillsWeb);// parametrii specifici 1:26

            skillsSelect.selectByVisibleText(skillsValue);
            hobbyWeb.click();

            //selectare year

            WebElement yearWeb = driver.findElement(By.id("yearbox"));
            String yearValue = "2000";

            functions.selectareWebelementvaloare(yearWeb,yearValue);

            //Select yearSelect = new Select(yearWeb);

            //yearSelect.selectByValue(yearValue);

            // validare mesaj Date of birth

            WebElement dateofbirthWebmessage = driver.findElement(By.xpath("//label[contains(text(),'Birth')]"));// atributi xpatul
            String expectedMessage = "Date Of Birth";
            String actualMessage = dateofbirthWebmessage.getText();//atribuim textul pe care min 14
            Assert.assertEquals("Valorile nu sunt corecte",expectedMessage,actualMessage);

            // inchide fereastra

            //driver.quit();

            //hover pe un web element
            WebElement switchtoweb = driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
            //Actions action = new Actions(driver);// min 51
            //action.moveToElement(switchtoweb).build().perform();

            functions.hoverWebelement(switchtoweb);

            //aplicare de wait explicit
            WebElement windowsWeb=driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
            new WebDriverWait(driver,2000).until(ExpectedConditions.visibilityOf(windowsWeb));// aplicare de web explicit pe un web element
            windowsWeb.click();

            // validare pagina windows
            String expectedWindowsvalue = "Frames & windows";
            String actualWindowsvalue = driver.getTitle();
            Assert.assertEquals(expectedWindowsvalue,actualWindowsvalue);

        }

}
