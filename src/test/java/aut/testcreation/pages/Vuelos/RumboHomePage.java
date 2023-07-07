package aut.testcreation.pages.Vuelos;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class RumboHomePage extends SeleniumWrapper {

    private WebDriver driver;

    public RumboHomePage(WebDriver driver) {
        super(driver);
    }

    By locatorIda = By.xpath("//div[@class='d-1nwmwhy']");

    By locatorIdayVuelta = By.xpath("//div[@class='d-4mhg59']");
    By locatorMultidestino = By.xpath("//a[contains(text(),'Multidestino')]");

    By locatorIrAVuelo = By.xpath("//button[@aria-label='Buscar']");

    By locatorLimpiaOrigen = By.xpath("//div[@class='d-12g9g33']//div[1]//div[1]//div[1]//button[1]//*[name()='svg']");

    By locatorOrigen = By.xpath("//input[@aria-label='Origen']");

    By locatorDestino = By.xpath("//input[@aria-label='Destino']");

    By locatorSeleccionPasajero = By.xpath("//button[@class='d-1k0nsg5']");

    By locatorSeleccionClase = By.xpath("//span[contains(text(),'Cualquier clase')]");

    By locatorBusiness = By.xpath("//li[contains(text(),'Business')]");

    By locatorOpcionDia;

    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de entrada\")]");


    By locatorMetodoPago = By.xpath("//span[contains(text(),'American Express')]");

    By locatorDiaIda = By.xpath("//button[contains(text(),'19')]");

    By btnAumentarNroAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']//*[name()='svg']");

    By locatorNoCookies = By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']");


    //acciones del sitio

    public void irASoloIda() {
        click(esperarPorElemento(locatorIda));
    }
    public void irIdayVuelta() {
        click(esperarPorElemento(locatorIdayVuelta));
    }

    public void irSeleccionPasajero() {
        click(esperarPorElemento(locatorSeleccionPasajero));
    }

    public void irMultidestino() {
        click(esperarPorElemento(locatorMultidestino));
    }

    public void irAVuelo() {
        click(esperarPorElemento(locatorIrAVuelo));
    }

    public By crear_locator_dia(String number){
        return locatorOpcionDia = By.xpath("//button[contains(text(),"+ number+")]");
    }


    public void noCookies() {
        click(esperarPorElemento(locatorNoCookies));
    }


    public void limpiaOrigen() {
        click(esperarPorElemento(locatorLimpiaOrigen));
    }


    public void elegirOrigen() {
        click(esperarPorElemento(locatorOrigen));
    }

    private void annadirAdultos(int cantAdultos) {
        if(cantAdultos>2){
            for(int i=2;i<cantAdultos;i++) {
                click(esperarPorElemento(btnAumentarNroAdultos));
                esperarXSegundos(500);
            }
        }
    }

   public void irSeleccionClase(){

       click(esperarPorElemento(locatorSeleccionClase));
    }


    /*public void irClaseTurista() {
        click(esperarPorElemento(locatorTurista));
    }*/

    /*public void noCookies() {
        click(esperarPorElemento(locatorNoCookies));
    }*/

    public void navegarAlSitio() {
        navigateTo(BASE_URL_AUT);
    }

    public void preferenciasIdayVuelta(String origen, String destino,String diaPartida,
                                       String diaVuelta, int cantAdultos ) {


        esperarXSegundos(200);
        agregarTexto(esperarPorElemento(locatorOrigen), origen);
        esperarXSegundos(300);
        agregarTexto(esperarPorElemento(locatorDestino), destino);
        esperarXSegundos(300);
        click(esperarPorElemento(locatorFecha));
        click(crear_locator_dia(diaPartida));
        click(crear_locator_dia(diaVuelta));
        esperarXSegundos(500);
        annadirAdultos(cantAdultos);

    }

    public void preferenciasIdayVuelta2(String origen, String destino/*,String diaIda,
                                            String mesIda,String diaVuelta,String mesVuelta*/) {

        esperarXSegundos(200);
        agregarTexto(esperarPorElemento(locatorOrigen), origen);
        esperarXSegundos(300);
        agregarTexto(esperarPorElemento(locatorDestino), destino);
        esperarXSegundos(300);
        click(esperarPorElemento(locatorSeleccionClase));
        esperarXSegundos(300);
        click(esperarPorElemento(locatorBusiness));
        esperarXSegundos(300);
        click(esperarPorElemento(locatorMetodoPago));
        esperarXSegundos(300);

        /*agregarTexto(esperarPorElemento(locatorUsername),username);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorDia),dia);
        esperarXSegundos(500);

        seleccionarComboBoxPortextoVisible(locatorMes,mes);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorAnnio),annio);
        esperarXSegundos(500);

        click(buscarElementosWeb(locatorGeneros).get(genero));
        esperarXSegundos(500);

        click(buscarElementosWeb(locatorPreferencias).get(0));
        esperarXSegundos(500);

        click(buscarElementosWeb(locatorPreferencias).get(1));
        esperarXSegundos(500);

        click(esperarPorElemento(btnRegistrate));
        scrollingDownElement(esperarPorElemento(locatorCorreo));
        esperarXSegundos(1500);*/

    }



    public void preferenciasIda(String origen, String destino) {

        esperarXSegundos(200);
        agregarTexto(esperarPorElemento(locatorOrigen), origen);
        esperarXSegundos(300);
        agregarTexto(esperarPorElemento(locatorDestino), destino);
        esperarXSegundos(300);


    }
}