package framework;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public FileInputStream file;
    public static Properties property;
   // comentariu pentru GITHUB
    // a doua modificare
    //folosire @Before
    @Before
    public void Setup() throws IOException {

    //SETAM DRIVERUL DE CHROME
        System.setProperty("webdriver.chrome.driver","E:\\2019\\Automation\\chromedriver.exe");
        //intiliaizarea variabilei driver cu browserul dorit, pe care sa il folosim
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");// se poate accesa orice site, doar trebuie specificat link-ul

        //facem browser-ul mare

        driver.manage().window().maximize();

        loadfileproperties();

        // declarare wait implicit
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    // folosire @After
   /* @After
    public void end(){
        driver.quit();

    }*/

   public void loadfileproperties() throws IOException {
       property = new Properties();
       try {
           file = new FileInputStream("E:\\2019\\CURSAUT\\Proiecte\\Curs 3\\src\\test\\resources\\inputdata\\Inputdata.properties");//min 1:15unhandled exceptionb
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
       property.load(file);

   }

   // metoda care returneaza valoarea dintrun property file pe baza unei chei
    public static String returnvalue(String key)
    {
        return property.getProperty(key);// min 1:18
    }


}
