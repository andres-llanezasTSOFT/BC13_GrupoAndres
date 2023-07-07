package aut.testcreation.testcases;

import aut.testcreation.pages.Vuelos.ElegirServicio;
import aut.testcreation.pages.Vuelos.ElegirVuelo;
import aut.testcreation.pages.Vuelos.RegistroDatosUsuarios;
import aut.testcreation.pages.Vuelos.RumboHomePage;
//import aut.testcreation.pages.RegisterPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.FixEncoding;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test_Vuelo extends SeleniumTestBase {

    private RumboHomePage rumbopage;

    private ElegirVuelo elegirVuelo;

    private ElegirServicio elegirServicio;

    private RegistroDatosUsuarios registroUsuarios;

    private WebDriver driver;

    WebDriverWait wait;



    @Test
    public void TC001_reserva_vuelo_ida_y_vuelta_ingreso_fecha(){

        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irIdayVuelta();
        rumbopage.preferenciasIdayVuelta("Barcelona (BCN)","Buenos Aires (EZE)", "11", "17", 2);
        rumbopage.esperarXSegundos(300);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(8000);
        String resultadoEsperado= "Rumbo vuelos baratos Barcelona - Buenos Aires";
        Assertions.assertEquals(resultadoEsperado, rumbopage.getUrlTitle());

    }

    @Test
    public void TC002_reserva_vuelo_ida_ingreso_fecha(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irASoloIda();
        rumbopage.esperarXSegundos(300);
        rumbopage.preferenciasIda("Barcelona (BCN)","Buenos Aires (EZE)", "12", 3);
        rumbopage.esperarXSegundos(2300);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(7000);
        String resultadoEsperado= "Rumbo vuelos baratos Barcelona - Buenos Aires";
        Assertions.assertEquals(resultadoEsperado, rumbopage.getUrlTitle());
        /*String resultadoEsperado="Descubre más sobre nuestros criterios de clasificación";
        Assertions.assertEquals(FixEncoding.fix(resultadoEsperado), rumbopage.findElement(By.xpath(
                "//div[@class='InfoContainer__Message-sc-1banvxr-5 jihaWH']")).getText());*/

    }
    @Test
    public void TC003_reserva_vuelo_multidestino_campos_vacio_en_formulario_pasajero_principal(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irASoloIda();
        //rumbopage.fechaIda();
        //rumbopage.elegirFechaIda("septiembre 2023");
        // rumbopage.esperarXSegundos(300);
        //rumbopage.preferenciasIda("Barcelona (BCN)","Buenos Aires (EZE)","14", "17",3);
        rumbopage.esperarXSegundos(300);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(7000);
        String resultadoEsperado= "Rumbo vuelos baratos Barcelona - Buenos Aires";
        Assertions.assertEquals(resultadoEsperado, rumbopage.getUrlTitle());

    }

    @Test
    public void TC004_reserva_vuelo_ida_y_vuelta_campo_Nombre_de_usuario_vacio(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        elegirServicio = new ElegirServicio(DriverFactory.getDriver());
        registroUsuarios = new RegistroDatosUsuarios(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irIdayVuelta();
        rumbopage.preferenciasIdayVuelta("Barcelona (BCN)","Buenos Aires (EZE)", "13", "29", 1);
        rumbopage.esperarXSegundos(700);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(8000);
        elegirVuelo.masBarato();
        rumbopage.esperarXSegundos(3000);
        elegirVuelo.elegirVuelo();
        rumbopage.esperarXSegundos(3000);
        elegirServicio.servicioClassic();
        rumbopage.esperarXSegundos(3000);
        registroUsuarios.registroDatos("Castro", "5300");
        rumbopage.esperarXSegundos(3000);
        String resultadoEsperado="Introduce el nombre";
        Assertions.assertEquals(FixEncoding.fix(resultadoEsperado), rumbopage.findElement(By.xpath(
                "//span[contains(text(),'Introduce el nombre')]")).getText());


    }

    @Test
    public void TC005_reserva_vuelo_ida_y_vuelta_filtro_clase_y_metodo_de_pago_Fecha_de_nacimiento_no_valida(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        elegirServicio = new ElegirServicio(DriverFactory.getDriver());
        registroUsuarios = new RegistroDatosUsuarios(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irIdayVuelta();
        rumbopage.preferenciasIdayVuelta2("Barcelona (BCN)","Buenos Aires (EZE)", "10", "17", 1);
        rumbopage.esperarXSegundos(1000);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(5000);
        elegirVuelo.elegirVueloMejor();
        rumbopage.esperarXSegundos(3000);
        elegirServicio.servicioClassic();
        rumbopage.esperarXSegundos(3000);
        registroUsuarios.registroDatos("Mario", "Castro");
        rumbopage.esperarXSegundos(3000);
        String resultadoEsperado="Introduce la fecha de nacimiento (a partir de 12 años)";
        Assertions.assertEquals(FixEncoding.fix(resultadoEsperado), rumbopage.findElement(By.xpath(
                "//span[contains(text(), 'Introduce la fecha de nacimiento')]")).getText());

    }

    @Test
    public void TC006_reserva_vuelo_ida_filtro_clase_y_metodo_de_pago_campo_telefono_vacio(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        elegirServicio = new ElegirServicio(DriverFactory.getDriver());
        registroUsuarios = new RegistroDatosUsuarios(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irASoloIda();
        rumbopage.preferenciasIda("Barcelona (BCN)","Buenos Aires (EZE)", "16",1);
        rumbopage.esperarXSegundos(300);
        rumbopage.irAVuelo();
        rumbopage.esperarXSegundos(7000);
        elegirVuelo.elegirVuelo();
        rumbopage.esperarXSegundos(3000);
        elegirServicio.servicioClassic();
        rumbopage.esperarXSegundos(3000);
        registroUsuarios.registroDatos("Mario", "Castro");
        rumbopage.esperarXSegundos(3000);
        String resultadoEsperado="Introduce un número de teléfono válido";
        Assertions.assertEquals(FixEncoding.fix(resultadoEsperado), rumbopage.findElement(By.xpath(
                "//div[@data-testid='next-phone-input-group-errormessage']")).getText());

    }
}
