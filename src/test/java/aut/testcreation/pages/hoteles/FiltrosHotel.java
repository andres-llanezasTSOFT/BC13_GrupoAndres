package aut.testcreation.pages.hoteles;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class FiltrosHotel extends SeleniumWrapper {
    public FiltrosHotel(WebDriver driver) {
        super(driver);
    }
    By locatorFiltroPrecio = By.xpath("//div[@id='Pill-PriceContainer']");
    By btnRangoMínimo = By.xpath("//div[@data-type='left']");
    By btnRangoMaximo = By.xpath("//div[@data-type='right']");
    By btnAplicar = By.xpath("//div[contains(text(),\"Aplicar\")]");

    By locatorFiltroServicio = By.cssSelector("#Pill-FacilitiesContainer");
    By locatorServicio;


    By locatorFiltroValoracion = By.cssSelector("#Pill-RatingContainer");
    By locatorValoracion;

    By locatorFiltroEstrellas = By.cssSelector("#Pill-StarsContainer");
    By locatorEstrellas;


    By locatorFiltroRegimen = By.cssSelector("#Pill-MealContainer");
    By locatorRegimen;

    By btnPrecioHotel = By.xpath("//a/div[contains(text(),\"en total\")]");

    By locatorCantidadResultadosBusqueda = By.xpath("//div[contains(text(), 'resultados encontrados')]");

    By locatorMensajeSinResultados = By.xpath("//div[contains(text(),'No se encuentran resultados')]");


    By locatorDetalle;

//VER_____________________________________________________________________________________________________________



    public void filtro_precio(int valor1, int valor2){
        click(esperarPorElemento(locatorFiltroPrecio));
        esperarXSegundos(2000);
        drag_and_drop(btnRangoMínimo, valor1);
        esperarXSegundos(2000);
        drag_and_drop(btnRangoMaximo, valor2);
        click(btnAplicar);
        esperarXSegundos(2000);
    }
    public void filtro_servicios(String item){
        click(esperarPorElemento(locatorFiltroServicio));
        esperarXSegundos(5000);
        click(crear_locator_servicio(item));
        click(btnAplicar);
    }
    public void filtro_dos_servicios(String item1, String item2){
        click(esperarPorElemento(locatorFiltroServicio));
        esperarXSegundos(5000);
        click(crear_locator_servicio(item1));
        click(crear_locator_servicio(item2));
        click(btnAplicar);
    }

    public void filtro_valoracion(String value){
        click(esperarPorElemento(locatorFiltroValoracion));
        crear_locator_valoracion(value);
        click(btnAplicar);

    }

    public void filtro_estrellas(int  cantidad){
        click(esperarPorElemento(locatorFiltroEstrellas));
        click(crear_locator_estrellas(cantidad));
        click(btnAplicar);
    }
    public void filtro_regimen(String condicion){
        click(esperarPorElemento(locatorFiltroRegimen));
        click(crear_locator_regimen(condicion));
        click(btnAplicar);
    }

    public By crear_locator_regimen(String item){
        return locatorRegimen = By.xpath("//div[normalize-space()='"+item+"']");
    }
    public By crear_locator_servicio(String item){
        return locatorServicio = By.xpath("//div[contains(text(),'" + item +"')]");
    }

    public By crear_locator_detalle(String resultado){
        return By.xpath("//span[contains(text(),'" + resultado +"')]");
    }

    public By crear_locator_valoracion(String item){
        return locatorValoracion = By.xpath("//div[contains(text(),'" + item +"')]");
    }

    public By crear_locator_estrellas(int item){
        return locatorEstrellas = By.xpath("//li[contains(@id,'" + item +"')]");
    }

    public void seleccionar_primer_resultado() {
        super.seleccionar_primer_resultado(btnPrecioHotel);
    }

    public boolean verificar_detalle(String verificar){
        return findElement(crear_locator_detalle(verificar)).getText().equals(verificar);
    }

    public String ver_cantidad_resultados() {
        String value= getText(locatorCantidadResultadosBusqueda);
        return value;
    }

    public String mostrar_mensaje_sin_resultados(){return findElement(locatorMensajeSinResultados).getText();}
}
