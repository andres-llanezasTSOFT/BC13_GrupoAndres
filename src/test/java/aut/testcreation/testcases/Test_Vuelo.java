package aut.testcreation.testcases;

import aut.testcreation.pages.ElegirVuelo;
import aut.testcreation.pages.HomePage;
import aut.testcreation.pages.RegisterPage;
import aut.testcreation.pages.RumboHomePage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.FixEncoding;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_Vuelo extends SeleniumTestBase {

    private RumboHomePage rumbopage;

    private ElegirVuelo elegirVuelo;




    @Test
    public void TC001_reserva_vuelo_ida_y_vuelta_ingreso_fecha(){
        rumbopage = new RumboHomePage(DriverFactory.getDriver());
        elegirVuelo = new ElegirVuelo(DriverFactory.getDriver());
        rumbopage.navegarAlSitio();
        rumbopage.noCookies();
        rumbopage.irIdayVuelta();
        rumbopage.preferencias("Barcelona (BCN)","Buenos Aires (EZE)");
        rumbopage.esperarXSegundos(300);
        rumbopage.irAVuelo();

    }


}
