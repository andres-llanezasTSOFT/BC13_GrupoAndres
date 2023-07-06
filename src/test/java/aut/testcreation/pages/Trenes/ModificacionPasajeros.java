package aut.testcreation.pages.Trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModificacionPasajeros extends SeleniumWrapper {

    By locatorOrigen = By.xpath("//input[@placeholder='Origen']");
    By locatorDestino = By.xpath("//input[@placeholder='Destino']");
    By locatorBtnFechas = By.xpath("//label[normalize-space()='Fecha de ida']");
    By locatorBtnBusqueda = By.xpath("//button[contains(@aria-label,'Buscar')]");
    By opcionFechas;
    By locatorCantidadPredefinida = By.xpath("//span[contains(text(),'1 pasajero')]");
    By locatorBtnPasajero = By.xpath("//label[text()='Pasajero']");
    By locatorCantidadPasajeros;
    By locatorBtnIconModificar = By.xpath("//span[@class='search-summary__section-icon search-summary__search-icon icon icon-edit']");
    By locatorPagina2 = By.xpath("//button[@aria-label='Buscar']");

    public ModificacionPasajeros(WebDriver driver) {
        super(driver);
    }

    public By cantidadPasajero(String cantidad){
        if(locatorCantidadPasajeros == By.xpath("//span[text()='1']")){
            locatorCantidadPasajeros = By.xpath("//span[text()="+cantidad+"]");
        }

        return locatorCantidadPasajeros;
    }

    public void modificarPasajeros(String ida, String vuelta, String pasajero, String pasajero2){

        click(esperarPorElemento(locatorOrigen));
        click(esperarPorElemento(locatorOrigen));
        click(esperarPorElemento(locatorDestino));
        click(esperarPorElemento(locatorDestino));
        click(esperarPorElemento(locatorBtnFechas));
        click(esperarPorElemento(fechasIndices(ida)));
        click(esperarPorElemento(fechasIndices(vuelta)));
        click(esperarPorElemento(locatorBtnPasajero));
        click(esperarPorElemento(cantidadPasajero(pasajero)));
        click(esperarPorElemento(locatorBtnBusqueda));
        click(esperarPorElemento(locatorBtnIconModificar));
        click(esperarPorElemento(cantidadPasajero(pasajero2)));
        click(esperarPorElemento(locatorPagina2));


    }


    public By fechasIndices(String numero){
        return opcionFechas = By.xpath("//button[contains(text(),"+numero+")]");
    }
    public By seleccionCantidadPasajero(){
        if(locatorCantidadPredefinida == By.xpath("//span[contains(text(),'2 pasajero')]")){
            locatorCantidadPredefinida = By.xpath("//span[contains(text(),'1 pasajero')]");
        }else{
            locatorCantidadPredefinida = By.xpath("//span[contains(text(),'1 pasajero')]");
        }
        return locatorCantidadPredefinida;
    }




}
