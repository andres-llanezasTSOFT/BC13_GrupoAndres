package aut.testcreation.testcases;

import aut.testcreation.pages.Trenes.FechasDisponibles;
import aut.testcreation.pages.Trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.Assert;
import org.junit.jupiter.api.*;

public class Test_Tren extends SeleniumTestBase {

    private FechasDisponibles fechasDisponibles;
    private HomePageTrenes homePageTrenes;

    @BeforeEach
    public void inicializandoTest(){
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        fechasDisponibles = new FechasDisponibles(homePageTrenes.getDriver());
        homePageTrenes.cargarUrl("https://www.rumbo.es/");
        //homePageTrenes.esperarXSegundos(2000);
        homePageTrenes.validarCaptcha();
        //homePageTrenes.esperarXSegundos(2000);
        homePageTrenes.noCookies();
        homePageTrenes.irATrenes();
    }


    @Test
    public void TC007_reserva_tren_idaYVuelta_ingresoFechas(){

        fechasDisponibles.llenarCamposVacios("Madrid", "Barcelona", "10", "15");

    }

    @Test
    public void TC008_reserva_tren_seleccionFecha(){

        fechasDisponibles.llenarCamposVacios_clickFechas("Almeria", "Madrid", "20", "25");
        Assert.assertEquals("Rumbo vuelos baratos Almería - Madrid", homePageTrenes.getDriver().getTitle());

    }

    @Test
    public void TC009_reserva_tren_ingresoFechasIguales(){

        fechasDisponibles.fechasIguales("Barcelona", "Granada", "10", "20");
        String resultado = "elija una fecha diferente";

    }

    @AfterEach
    public void cerrandoTest(){
        homePageTrenes.getDriver().close();
    }

}
