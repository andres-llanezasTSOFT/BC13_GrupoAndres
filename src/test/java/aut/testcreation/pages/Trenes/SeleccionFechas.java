package aut.testcreation.pages.Trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleccionFechas extends SeleniumWrapper {

    By locatorOrigen = By.xpath("//input[@placeholder='Origen']");
    By locatorValueOrigen = By.xpath("//input[@aria-label='Origen' and @value='Almería'] ");
    By locatorValueDestino = By.xpath("//input[@aria-label='Destino' and @value='Madrid'] ");
    By locatorDestino = By.xpath("//input[@placeholder='Destino']");
    By opcionFechas;
    By locatorCantidadPredefinida = By.xpath("//span[contains(text(),'1 pasajero')]");
    By locatorBtnFechas = By.xpath("//label[normalize-space()='Fecha de ida']");
    By locatorBtnPasajero = By.xpath("//label[normalize-space()='Pasajero']");
    By locatorBtnBusqueda = By.xpath("//button[contains(@aria-label,'Buscar')]");

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
    public void llenarCamposVacios(String origen, String destino, String indiceIda, String indieVuelta){

        agregarTexto(esperarPorElemento(locatorOrigen),origen);
        click(esperarPorElemento(locatorDestino));
        agregarTexto(esperarPorElemento(locatorDestino),destino);
        click(esperarPorElemento(locatorBtnFechas));
        click(esperarPorElemento(fechasIndices(indiceIda)));
        click(esperarPorElemento(fechasIndices(indieVuelta)));
        click(esperarPorElemento(locatorBtnPasajero));
        click(esperarPorElemento(seleccionCantidadPasajero()));
        click(esperarPorElemento(locatorBtnBusqueda));
    }

    public SeleccionFechas(WebDriver driver) {
        super(driver);
    }

}
