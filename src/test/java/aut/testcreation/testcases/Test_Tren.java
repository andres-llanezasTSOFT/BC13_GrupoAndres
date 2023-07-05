package aut.testcreation.testcases;

import aut.testcreation.pages.Trenes.FechasDisponibles;
import aut.testcreation.pages.Trenes.HomePageTrenes;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class Test_Tren extends SeleniumTestBase {

    private FechasDisponibles fechasDisponibles;
    private HomePageTrenes homePageTrenes;

    @BeforeEach
    public void inicializandoTest(){
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        fechasDisponibles = new FechasDisponibles(homePageTrenes.getDriver());
        homePageTrenes.navegarAlSitio();
        homePageTrenes.irATrenes();
    }


    @Test
    public void TC007_reserva_tren_idaYVuelta_fechasDisponibles(){
        homePageTrenes.irATrenes();
        fechasDisponibles.llenarCamposVacios("Madrid", "Barcelona", "10", "15");

    }
    @AfterEach
    public void cerrandoTest(){
        homePageTrenes.getDriver().close();
    }

}
