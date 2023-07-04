package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiltrosHotel extends SeleniumWrapper {
    public FiltrosHotel(WebDriver driver) {
        super(driver);
    }
    By locatorFiltroPrecio = By.xpath("//div[@id='Pill-PriceContainer']");
    By btnRangoMínimo = By.xpath("//div[@data-type='left']");
    By btnRangoMaximo = By.xpath("//div[@data-type='right']");
    By btnAplicar = By.xpath("//div[contains(text(),\"Aplicar\")]");

    By locatorFiltroServicio = By.cssSelector("#Pill-FacilitiesContainer");
    By locatorServicio = By.cssSelector("#lb_list_accomodation_facilities");


    By locatorFiltroValoracion = By.cssSelector("#Pill-RatingContainer");
    By locatorValoracion = By.xpath("//li[contains(@id, \"exp_elem_rating\")]");


    By locatorFiltroEstrellas = By.cssSelector("#Pill-StarsContainer");
    By locatorCantEstrellas = By.xpath("");


    By locatorFiltroRegimen = By.xpath("#Pill-MealContainer");
    By locatorRegimen = By.xpath("");

    By btnPrecioHotel = By.xpath("//iframe[@id='google_ads_top_frame']");

    By locatorCantidadResultadosBusqueda = By.xpath("");

    By locatorMensajeSinResultados = By.xpath("");


    By locatorDetalle = By.xpath("//div[@role=\"button\"]//descendant::div[@xpath=\"3\"]");

//VER_____________________________________________________________________________________________________________



    public void filtro_precio(String valor1, String valor2){
        click(esperarPorElemento(locatorFiltroPrecio));
        //mover btnRangoMinimo y btnRangoMaximo hasta que queden iguales a los valores pasados por string
        click(btnAplicar);
    }
    public void filtro_servicios_una_condicion(String item){
        click(esperarPorElemento(locatorFiltroServicio));
        seleccionarComboBoxPortextoVisible(locatorServicio,item);
        click(btnAplicar);
    }
    public void filtro_servicios_dos_condiciones(String item1, String item2){
        click(esperarPorElemento(locatorFiltroServicio));
        seleccionarComboBoxPortextoVisible(locatorServicio,item1);
        seleccionarComboBoxPortextoVisible(locatorServicio,item2);
        click(btnAplicar);
    }
    public void filtro_valoracion(String valor){
        esperarPorElemento(locatorFiltroValoracion);
        seleccionarComboBoxPortextoVisible(locatorValoracion,valor);
        click(btnAplicar);
    }
    public void filtro_estrellas(String cantidad){
        click(esperarPorElemento(locatorFiltroEstrellas));
        seleccionarComboBoxPortextoVisible(locatorCantEstrellas,cantidad);
        click(btnAplicar);
    }
    public void filtro_regimen(String condicion){
        click(esperarPorElemento(locatorFiltroRegimen));
        seleccionarComboBoxPortextoVisible(locatorRegimen,condicion);
        click(btnAplicar);
    }


    public void seleccionar_primer_hotel(){
        click(esperarPorElemento(btnPrecioHotel));
    }

    public String ver_detalle(){return findElement(locatorDetalle).getText();}

    public int ver_cantidad_resultados() {
        int value = extraer_int_de_String(locatorCantidadResultadosBusqueda);
        return value;
    }

    public String mostrar_mensaje_sin_resultados(){return findElement(locatorMensajeSinResultados).getText();}
}
