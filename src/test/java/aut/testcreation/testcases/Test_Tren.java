package aut.testcreation.testcases;

import aut.testcreation.pages.Trenes.*;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.Assert;
import org.junit.jupiter.api.*;


public class Test_Tren extends SeleniumTestBase {

    private FechasDisponibles fechasDisponibles;
    private HomePageTrenes homePageTrenes;
    private IngresoFechas ingresoFechas;
    private IngresoFechasIguales ingresoFechasIguales;
    private ModificacionPasajeros modificacionPasajeros;
    private SeleccionFechas seleccionFechas;





    @BeforeEach
    public void inicializandoTest(){
        homePageTrenes = new HomePageTrenes(DriverFactory.getDriver());
        //fechasDisponibles = new FechasDisponibles(homePageTrenes.getDriver());
        ingresoFechas = new IngresoFechas(homePageTrenes.getDriver());
        ingresoFechasIguales = new IngresoFechasIguales(homePageTrenes.getDriver());
        modificacionPasajeros = new ModificacionPasajeros(homePageTrenes.getDriver());
        seleccionFechas = new SeleccionFechas(homePageTrenes.getDriver());

        homePageTrenes.cargarUrl("https://www.rumbo.es/");
        homePageTrenes.validarCaptcha();
        homePageTrenes.noCookies();
        homePageTrenes.irATrenes();
    }


    @Test
    public void TC007_reserva_tren_idaYVuelta_ingresoFechas(){

        ingresoFechas.llenarCamposVacios("Madrid", "Barcelona", "10", "15");
        Assertions.assertEquals("Pagina de Trenes",homePageTrenes.getUrlTitle() );
    }

    @Test
    public void TC008_reserva_tren_seleccionFecha(){
<<<<<<< HEAD

        seleccionFechas.llenarCamposVacios("Almeria", "Madrid", "20", "25");
        Assert.assertEquals("Rumbo vuelos baratos Almería - Madrid", homePageTrenes.getDriver().getTitle());
=======
        fechasDisponibles.llenarCamposVacios_clickFechas("Almería", "Madrid", "20", "25");
        Assert.assertEquals("rumbo.es", homePageTrenes.getDriver().getTitle());
>>>>>>> 06c00ff3cabffed4740b1ac82d94be92ae21c998

    }

    @Test
    public void TC009_reserva_tren_ingresoFechasIguales(){

        ingresoFechasIguales.fechasIguales("Barcelona", "Granada", "10", "20");
        String resultado = "elija una fecha diferente";
        Assertions.assertEquals(resultado, homePageTrenes.getDriver().getTitle());

    }

    @Test
    public void TC010_reserva_tren_modiciacionPasajeros(){

        modificacionPasajeros.modificarPasajeros( "Madrid" , "Barcelona","10", "15");
        Assertions.assertEquals("Bienvenidos a vuelos baratos Madrid - Barcelona", homePageTrenes.getDriver().getTitle());
    }





    @AfterEach
    public void cerrandoTest(){
        homePageTrenes.getDriver().close();
    }

}
