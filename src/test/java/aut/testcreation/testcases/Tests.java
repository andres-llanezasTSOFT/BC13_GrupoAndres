package aut.testcreation.testcases;


import aut.testcreation.pages.BusquedaHotel;
import aut.testcreation.pages.FiltrosHotel;
import aut.testcreation.pages.HomePage;
import aut.testcreation.pages.RegisterPage;
import framework.engine.selenium.FixEncoding;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {
    private HomePage homePage;
    private RegisterPage registerPage;
    private BusquedaHotel busquedaHotel;
    private FiltrosHotel filtrosHotel;
    private WebDriver driver;

    @BeforeEach
    public void preTests(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(homePage.getDriver());
        homePage.cargarUrl("https://open.spotify.com/?");
        homePage.maximizarBrowser();
    }

    @AfterEach
    public void postTest(){
        driver.close();
    }

    @Test
    public void CP001_formulario_incorrecto_mail_vacio(){
        homePage.irARegistrarse();
        registerPage.completarFormularioRegistro("","awedawseddasdas",
                "Domingo","30","Marzo","1990",0);
        Assertions.assertEquals(FixEncoding.fix("Es necesario que indiques tu correo electrónico."),
                registerPage.obtenerErrorMailVacio());
    }

    @Test
    public void CP013_reserva_hotel_ingreso_datos_de_seleccion(){
        homePage.irARegistrarse();
        busquedaHotel.buscarHotel("Buenos Aires", "Julio 2023", "16", "18", "2", 0);
        Assertions.assertTrue(busquedaHotel.getUrlTitle().contains("https://www.rumbo.es/s/hdp/search?datefrom"));
    }

    //HACER+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void CP014_reserva_hotel_filtro_precio(){
        homePage.irARegistrarse();
        busquedaHotel.buscarHotel("Buenos Aires", "Julio 2023", "16", "18", "2", 0);
        String resultado1= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_precio("1200", "2000");
        String resultado2= filtrosHotel.ver_cantidad_resultados();
        Assertions.assertNotEquals(resultado1, resultado2);
    }


    //HACER+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void CP016_reserva_hotel_filtro_valoracion(){
        homePage.irARegistrarse();
        busquedaHotel.buscarHotel("Buenos Aires", "Julio 2023", "16", "18", "2", 0);
        Assertions.assertTrue(busquedaHotel.getUrlTitle().contains("https://www.rumbo.es/s/hdp/search?datefrom"));
    }

    @Test
    public void CP017_reserva_hotel_limite_ninnos_por_habitacion(){
        homePage.irARegistrarse();
        busquedaHotel.buscarHotel("Buenos Aires", "Julio 2023", "16", "18", "1", 6);
        Assertions.assertTrue(filtrosHotel.ver_detalle().contains("8 viajeros, 2 habitaciones") );
    }


    //HACER+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    @Test
    public void CP018_reserva_hotel_filtros_multiples(){
        homePage.irARegistrarse();
        busquedaHotel.buscarHotel("Buenos Aires", "Julio 2023", "16", "18", "2", 0);
        String resultado1= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_precio("1200", "2000");
        String resultado2= filtrosHotel.ver_cantidad_resultados();
        Assertions.assertEquals(resultado1, resultado2);
    }
}
