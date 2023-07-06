package aut.testcreation.testcases;

import aut.testcreation.pages.ElegirVuelo;
import aut.testcreation.pages.RumboHomePage;
//import aut.testcreation.pages.RegisterPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.FixEncoding;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Vuelo extends SeleniumTestBase {

    private RumboHomePage rumbopage;

    private ElegirVuelo elegirVuelo;

    private WebDriver driver;

    WebDriverWait wait;



    @Test
    public void TC001_reserva_vuelo_ida_y_vuelta_ingreso_fecha(){

        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irIdayVuelta();
        rumbopage.preferenciasIdayVuelta("Barcelona (BCN)","Buenos Aires (EZE)");
        rumbopage.esperarXSegundos(300);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(8000);
        String resultadoEsperado= "Rumbo vuelos baratos Barcelona - Buenos Aires";
        Assertions.assertEquals(resultadoEsperado, rumbopage.getUrlTitle());

    }

        /*Assertions.assertEquals(FixEncoding.fix("Descubre más sobre nuestros criterios de " +
                "clasificación"), driver.findElement(By.xpath("//div[@class='InfoContainer__Message-sc-1banvxr-5 jihaWH']")).getText());*/

        /*String mensajeEsperado = "Descubre más sobre nuestros criterios de clasificación";
        WebElement resultadoActual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='InfoContainer__Message-sc-1banvxr-5 jihaWH']")));
        String mensajeActual = resultadoActual.getText();
        Assert.assertEquals(mensajeEsperado,mensajeActual);*/


    @Test
    public void TC002_reserva_vuelo_ida_ingreso_fecha(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irASoloIda();
        //rumbopage.fechaIda();
        //rumbopage.elegirFechaIda("septiembre 2023");
       // rumbopage.esperarXSegundos(300);
        rumbopage.preferenciasIda("Barcelona (BCN)","Buenos Aires (EZE)");
        rumbopage.esperarXSegundos(300);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(7000);
        String resultadoEsperado= "Rumbo vuelos baratos Barcelona - Buenos Aires";
        Assertions.assertEquals(resultadoEsperado, rumbopage.getUrlTitle());
        //Assertions.assertEquals(FixEncoding.fix("Descubre más sobre nuestros criterios de clasificación"),
                //driver.findElement(By.xpath("//div[@class='InfoContainer__Message-sc-1banvxr-5 jihaWH']")).getText());
    }


}
