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
    By opcionFechas;
    By locatorCantidadPredefinida = By.xpath("//span[@class='d-32d0y']");
    By locatorBtnFechas = By.xpath("//label[normalize-space()='Fecha de ida']");
    By locatorBtnPasajero = By.xpath("//label[normalize-space()='Pasajero']");
    By locatorBtnBusqueda = By.xpath("//div[@class='d-17aesaf']//*[name()='svg']");
    By locatorBtnFechaIda = By.xpath("div.e19fnmvl0.d-1xhhbhy.e161saim2:nth-child(3) div.hub-container.mobile.e161saim0.d-1pw96xe.eg3h3jz0 div.hub-row.e5okb9y0.d-e6i29g.e1sskiuc0 div.hub-col-md-12.hub-col-12.hub-col.d-13azrip.e1i8mjyc0 div.e19fnmvl0.content-wrapper.d-bmfhe3.e1151aq91 div.d-11zj2b6.e19fnmvl0:nth-child(5) div.d-1hmt6x div.d-1k8j4hr div.tab-wrapper.d-14510di div.d-10vaxqn div.d-1k2a5w2 div.d-1j5hrwi div.d-1yt6u46 div.d-1ola07z section.d-9sbhfh div.d-gjiwyg div.d-fhbsai div.d-epxt6h div:nth-child(2) div.d-1pjk4ge > button.d-17itmhv:nth-child(30)");
    By locatorBtnFechaVuelta = By.xpath("div.e19fnmvl0.d-1xhhbhy.e161saim2:nth-child(3) div.hub-container.mobile.e161saim0.d-1pw96xe.eg3h3jz0 div.hub-row.e5okb9y0.d-e6i29g.e1sskiuc0 div.hub-col-md-12.hub-col-12.hub-col.d-13azrip.e1i8mjyc0 div.e19fnmvl0.content-wrapper.d-bmfhe3.e1151aq91 div.d-11zj2b6.e19fnmvl0:nth-child(5) div.d-1hmt6x div.d-1k8j4hr div.tab-wrapper.d-14510di div.d-10vaxqn div.d-1k2a5w2 div.d-1j5hrwi div.d-1yt6u46 div.d-1ola07z section.d-9sbhfh div.d-gjiwyg div.d-fhbsai div.d-epxt6h div:nth-child(2) div.d-1pjk4ge > button.d-3j64rz:nth-child(35)");

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
        //click(esperarPorElemento(locatorBtnFechas));
        click(esperarPorElemento(fechasIndices(indiceIda)));
        click(esperarPorElemento(fechasIndices(indieVuelta)));
        //click(esperarPorElemento(locatorBtnPasajero));
        click(esperarPorElemento(seleccionCantidadPasajero()));
        click(esperarPorElemento(locatorBtnBusqueda));
    }
    public void llenarCamposVacios_clickFechas(String origen, String destino){

        agregarTexto(esperarPorElemento(locatorOrigen),origen);
        agregarTexto(esperarPorElemento(locatorDestino),destino);
        click(esperarPorElemento(locatorBtnFechas));
        click(esperarPorElemento(locatorBtnFechaIda));
        click(esperarPorElemento(locatorBtnFechaVuelta));
        click(esperarPorElemento(locatorBtnPasajero));
        click(esperarPorElemento(seleccionCantidadPasajero()));
        click(esperarPorElemento(locatorBtnBusqueda));
    }






}
