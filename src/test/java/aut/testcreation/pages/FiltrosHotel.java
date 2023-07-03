package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FiltrosHotel extends SeleniumWrapper {
    public FiltrosHotel(WebDriver driver) {
        super(driver);
    }
    By locatorFiltroPrecio = By.xpath("//div[@id='Pill-PriceContainer']");
    By btnRangoMínimo = By.xpath("");
    By btnRangoMaximo = By.xpath("");
    By btnAplicarPrecio = By.xpath("");

    By locatorFiltroServicio = By.xpath("");
    By locatorServicio = By.xpath("");
    By btnAplicarServicios = By.xpath("");

    By locatorFiltroValoracion = By.xpath("");
    By locatorValoracion = By.xpath("");
    By btnAplicarValoracion = By.xpath("");

    By locatorFiltroEstrellas = By.xpath("");
    By locatorCantEstrellas = By.xpath("");
    By btnAplicarEstrellas = By.xpath("");

    By locatorFiltroRegimen = By.xpath("");
    By locatorRegimen = By.xpath("");
    By btnAplicarRegimen = By.xpath("");

    By btnPrecioHotel = By.xpath("");

    By locatorCantidadResultadosBusqueda = By.xpath("");

    By locatorMensajeSinResultados = By.xpath("");


    By locatorDetalle = By.xpath("//div[@role=\"button\"]//descendant::div[@xpath=\"3\"]");

//VER_____________________________________________________________________________________________________________

    private int extraer_int_de_String(By locator) {
        String resultado = findElement(locator).getText();
        StringBuilder sb = new StringBuilder();
        for (char c : resultado.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public void filtro_precio(String valor1, String valor2){
        click(esperarPorElemento(locatorFiltroPrecio));
        //mover btnRangoMinimo y btnRangoMaximo hasta que queden iguales a los valores pasados por string
        click(btnAplicarPrecio);
    }
    public void filtro_servicios_una_condicion(String item){
        click(esperarPorElemento(locatorFiltroServicio));
        click(seleccionarComboBoxPortextoVisible(locatorServicio,item));
        click(btnAplicarServicios);
    }
    public void filtro_servicios_dos_condiciones(String item1, String item2){
        click(esperarPorElemento(locatorFiltroServicio));
        click(seleccionarComboBoxPortextoVisible(locatorServicio,item1));
        click(seleccionarComboBoxPortextoVisible(locatorServicio,item2));
        click(btnAplicarServicios);
    }
    public void filtro_valoracion(String valor){
        click(esperarPorElemento(locatorFiltroValoracion));
        click(seleccionarComboBoxPortextoVisible(locatorValoracion,valor));
        click(btnAplicarValoracion);
    }
    public void filtro_estrellas(String cantidad){
        click(esperarPorElemento(locatorFiltroEstrellas));
        click(seleccionarComboBoxPortextoVisible(locatorCantEstrellas,cantidad));
        click(btnAplicarEstrellas);
    }
    public void filtro_regimen(String condicion){
        click(esperarPorElemento(locatorFiltroRegimen));
        click(seleccionarComboBoxPortextoVisible(locatorRegimen,condicion));
        click(btnAplicarRegimen);
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
