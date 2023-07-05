package framework.engine.selenium;

import framework.engine.utils.LoadProperties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;


import java.util.Properties;

public class SeleniumTestBase {

    private DriverFactory driverFactory;
    private WebDriver driver;
    static Properties properties;




  /*@BeforeEach
    public void preTests(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        rumbopage = new RumboHomePage(driver);
        elegirVuelo = new ElegirVuelo(rumbopage.getDriver());
        rumbopage.cargarUrl("https://www.rumbo.es/");
        rumbopage.maximizarBrowser();
    }
     */



  /* @AfterEach
    public void postTest(){
        driver.close();
    }

   */



    @BeforeAll
    public static void LoadProperties() {
        properties = LoadProperties.loadProperties();
    }

    @BeforeEach
    void webDriverSetup(){
        String browserName = properties.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.inicializarDriver(browserName);
    }


   @AfterEach
    void close(){
        driver.quit();
    }

}
