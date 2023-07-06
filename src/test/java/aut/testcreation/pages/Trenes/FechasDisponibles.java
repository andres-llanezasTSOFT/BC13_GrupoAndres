package aut.testcreation.pages.Trenes;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FechasDisponibles extends SeleniumWrapper {

    By locatorOrigen = By.xpath("//input[@placeholder='Origen']");
    By locatorValueOrigen = By.xpath("//input[@aria-label='Origen' and @value='Almería'] ");
    By locatorValueDestino = By.xpath("//input[@aria-label='Destino' and @value='Madrid'] ");
    By locatorDestino = By.xpath("//input[@placeholder='Destino']");
    By opcionFechas;
    By locatorCantidadPredefinida = By.xpath("//span[contains(text(),'1 pasajero')]");
    By locatorBtnFechas = By.xpath("//label[normalize-space()='Fecha de ida']");
    By locatorBtnPasajero = By.xpath("//label[normalize-space()='Pasajero']");
    By locatorBtnBusqueda = By.xpath("//button[contains(@aria-label,'Buscar')]");//"d-pgjwjt"

    public FechasDisponibles(WebDriver driver) {
        super(driver);
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
    public void llenarCamposVacios_clickFechas(String origen, String destino, String ida, String vuelta){

        click(esperarPorElemento(locatorOrigen));
        esperarXSegundos(2000);
       agregarTexto(esperarPorElemento(locatorOrigen),origen);
       esperarXSegundos(2000);
        click(esperarPorElemento(locatorDestino));
       agregarTexto(esperarPorElemento(locatorDestino),destino);
       esperarXSegundos(2000);
        click(esperarPorElemento(locatorBtnFechas));
       esperarXSegundos(2000);
       click(esperarPorElemento(fechasIndices(ida)));
       esperarXSegundos(2000);
       click(esperarPorElemento(fechasIndices(vuelta)));
       click(esperarPorElemento(locatorBtnPasajero));
       esperarXSegundos(2000);
       click(esperarPorElemento(seleccionCantidadPasajero()));
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorBtnBusqueda));

    }

    public void fechasIguales(String origen, String destino, String ida, String vuelta){

        click(esperarPorElemento(locatorOrigen));
        agregarTexto(esperarPorElemento(locatorOrigen),origen);
        click(esperarPorElemento(locatorDestino));
        agregarTexto(esperarPorElemento(locatorDestino),destino);
        click(esperarPorElemento(locatorBtnFechas));
        click(esperarPorElemento(fechasIndices(ida)));
        click(esperarPorElemento(fechasIndices(vuelta)));
        click(esperarPorElemento(locatorBtnPasajero));
        click(esperarPorElemento(locatorBtnBusqueda));
    }






}
