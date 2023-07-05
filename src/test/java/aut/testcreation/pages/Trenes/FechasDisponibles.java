package aut.testcreation.pages.Trenes;

import framework.engine.selenium.SeleniumTestBase;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class FechasDisponibles extends SeleniumWrapper {

    By locatorOrigen = By.xpath("//input[@id=':Rmhl6lalaqlql2mm:']");
    By locatorDestino = By.xpath("//input[@id=':Rqhl6lalaqlql2mm:']");
    By locatorBtnDestino = By.xpath("//li[@id=':Rqhl6lalaqlql2mm:-option-0']");
    By opcionFechas;
    By locatorCantidadPredefinida = By.xpath("//span[@class='d-32d0y']");
    By locatorBtnFechas = By.xpath("//label[normalize-space()='Fecha de ida']");
    By locatorBtnPasajero = By.xpath("//label[normalize-space()='Pasajero']");
    By locatorBtnBusqueda = By.xpath("//div[@class='d-17aesaf']//*[name()='svg']");
    By locatorBtnFechaIda = By.cssSelector(".d-iwstwh");
    By locatorBtnFechaVuelta = By.cssSelector(".d-3j64rz");

    public FechasDisponibles(WebDriver driver) {
        super(driver);
    }
    public By fechasIndices(String numero){
        return opcionFechas = By.xpath("//button[text(),"+numero+"]");
    }
    public By seleccionCantidadPasajero(){
        if(locatorCantidadPredefinida == By.xpath("//span[@class='d-32d0y']")){
            locatorCantidadPredefinida = By.xpath("//*[name()='path' and contains(@d,'M19 13H5V1')]");
        }else{
            locatorCantidadPredefinida = By.xpath("//*[name()='path' and contains(@d,'M19 13H13V')]");
        }
        return locatorCantidadPredefinida;
    }


    public void llenarCamposVacios(String origen, String destino, String indiceIda, String indieVuelta){

        agregarTexto(esperarPorElemento(locatorOrigen),origen);
        agregarTexto(esperarPorElemento(locatorDestino),destino);
        click(esperarPorElemento(locatorBtnFechas));
        click(esperarPorElemento(fechasIndices(indiceIda)));
        click(esperarPorElemento(fechasIndices(indieVuelta)));
        click(esperarPorElemento(locatorBtnPasajero));
        click(esperarPorElemento(seleccionCantidadPasajero()));
        click(esperarPorElemento(locatorBtnBusqueda));
    }
    public void llenarCamposVacios_clickFechas(String origen, String destino){

        click(esperarPorElemento(locatorOrigen));
        esperarXSegundos(2000);
       agregarTexto(esperarPorElemento(locatorOrigen),origen);
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorDestino));
       esperarXSegundos(2000);
       agregarTexto(esperarPorElemento(locatorDestino),destino);
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorBtnDestino));
       esperarXSegundos(2000);
        //click(esperarPorElemento(locatorBtnFechas));
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorBtnFechaIda));
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorBtnFechaVuelta));
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorBtnPasajero));
       esperarXSegundos(2000);
       click(esperarPorElemento(seleccionCantidadPasajero()));
       esperarXSegundos(2000);
       click(esperarPorElemento(locatorBtnBusqueda));

    }






}
