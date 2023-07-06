package aut.testcreation.testcases;


import aut.testcreation.pages.Vuelos.RumboHomePage;
import aut.testcreation.pages.hoteles.AnnadirHuespedesHotel;
import aut.testcreation.pages.hoteles.BusquedaHotel;
import aut.testcreation.pages.hoteles.DetalleHotel;
import aut.testcreation.pages.hoteles.FiltrosHotel;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Test_Hotel extends SeleniumTestBase {
    private RumboHomePage rumbopage;
    private BusquedaHotel busquedaHotel;
    private FiltrosHotel filtrosHotel;
    private DetalleHotel detalleHotel;

    private AnnadirHuespedesHotel huespedesHotel;



    @BeforeEach
    public void inicializar_page() {
       rumbopage = new RumboHomePage(DriverFactory.getDriver());
       busquedaHotel = new BusquedaHotel(DriverFactory.getDriver());
       filtrosHotel = new FiltrosHotel(DriverFactory.getDriver());
       detalleHotel = new DetalleHotel(DriverFactory.getDriver());
       huespedesHotel = new AnnadirHuespedesHotel(DriverFactory.getDriver());
       rumbopage.cargarUrl("https://www.rumbo.es/");
       //rumbopage.validarCaptcha();
       rumbopage.esperarXSegundos(2000);
       rumbopage.noCookies();
   }

    @Test
    public void CP013_reserva_hotel_ingreso_datos_de_seleccion(){
        //rumbopage.irABusquedaHotel();
        busquedaHotel.buscarHotel("Buenos Aires", "16", "18", 3, 0);
        Assertions.assertTrue(busquedaHotel.getUrlTitle().contains("https://www.rumbo.es/s/hdp/search?datefrom"));
    }

    @Test
    public void CP014_reserva_hotel_filtro_precio(){
        //rumbopage.irABusquedaHotel();
        busquedaHotel.buscarHotel("Buenos Aires", "16", "18", 2, 0);
        int resultado1= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_precio("1200", "2000");
        int resultado2= filtrosHotel.ver_cantidad_resultados();
        Assertions.assertNotEquals(resultado1, resultado2);
    }
    @Test
    public void CP015_reserva_hotel_formulario_datos_personales(){
        //rumbopage.irABusquedaHotel();
        busquedaHotel.buscarHotel("Buenos Aires", "16", "18", 2, 0);
        filtrosHotel.seleccionar_primer_hotel();
        detalleHotel.elegir_solo_alojamiento();
        huespedesHotel.llenar_datos_personales("Carlos", "Dilorenzi", "carlos3@gmail.com", "España", "56748922");
        Assertions.assertEquals(4, huespedesHotel.cantidad_inputs_validos());
    }
    @Test
    public void CP016_reserva_hotel_filtro_valoracion(){
        //rumbopage.irABusquedaHotel();
        busquedaHotel.buscarHotel("Buenos Aires", "16", "18", 2, 0);
        filtrosHotel.filtro_valoracion("Solo adultos");
        filtrosHotel.filtro_valoracion("adaptado para niños");
        String ResultadoEsperado = "No se encuentran resultados";
        Assertions.assertEquals(filtrosHotel.mostrar_mensaje_sin_resultados(),ResultadoEsperado);
    }

    @Test
    public void CP017_reserva_hotel_limite_ninnos_por_habitacion(){
        //rumbopage.irABusquedaHotel();
        busquedaHotel.buscarHotel("Buenos Aires", "16", "18", 1, 6);
        Assertions.assertTrue(filtrosHotel.ver_detalle().contains("8 viajeros, 2 habitaciones") );
    }

    @Test
    public void CP018_reserva_hotel_filtros_multiples(){
        //rumbopage.irABusquedaHotel();
        busquedaHotel.buscarHotel("Buenos Aires", "16", "18", 2, 0);
        int resultado1= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_precio("1200", "2000");
        int resultado2= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_servicios_una_condicion("Wifi gratis");
        int resultado3= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_estrellas("3");
        int resultado4= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_regimen("desayuno");
        int resultado5= filtrosHotel.ver_cantidad_resultados();
        filtrosHotel.filtro_valoracion("Excelente");
        int resultado6= filtrosHotel.ver_cantidad_resultados();

        Assertions.assertTrue(resultado1 > resultado2 && resultado2 > resultado3 &&
                resultado3> resultado4 && resultado4 > resultado5 && resultado5 > resultado6);
    }
}
