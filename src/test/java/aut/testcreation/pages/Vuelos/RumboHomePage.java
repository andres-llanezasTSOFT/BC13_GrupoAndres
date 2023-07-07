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

    By locatorPersonas = By.xpath("//label[contains(text(),\"Pasajero\")]");


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

    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de ida\")]");


    By locatorMetodoPago = By.xpath("//div[@class='d-17oxpj9']//div//div[@class='d-ad9l2y']//*[name()='svg']");

    By locatorDiners = By.xpath("//li[contains(text(),'Diners')]");

    By locatorAmerican = By.xpath("//li[contains(text(),'American Express')]");

    By locatorDiaIda = By.xpath("//button[contains(text(),'19')]");

    By locatorIrAHotel = By.xpath("//ul/li/div/a[@title='Hoteles']");

    By locatorCaptchaExiste = By.xpath("//h2[contains(text(),'Comprobando']");

    By btnAumentarNroAdultos = By.xpath("//button[@aria-label='Aumentar el número de adultos']");

    By locatorNoCookies = By.xpath("//button[@class='iubenda-cs-reject-btn iubenda-cs-btn-primary']");


    //acciones del sitio

    By btnCheckCaptcha = By.xpath("//input[@type=\"checkbox\"]");


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

    public void irABusquedaHotel() {
        click((esperarPorElemento(locatorIrAHotel)));
    }

    public void validarCaptcha () {
        esperarXSegundos(800);
        if (isDisplayed(locatorCaptchaExiste)) {
            esperarXSegundos(7000);
            if(isEnabled(btnCheckCaptcha)){
                click(esperarPorElemento(btnCheckCaptcha));
            }
        }

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
        if(cantAdultos>=2){
            for(int i=2;i<=cantAdultos ;i++) {
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

    public void ir_a_personas(){
        click(esperarPorElemento(locatorPersonas));
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
        ir_a_personas();
        esperarXSegundos(500);
    }

    public void preferenciasIdayVuelta2(String origen, String destino, String diaPartida,
                                        String diaVuelta, int cantAdultos) {

        esperarXSegundos(200);
        agregarTexto(esperarPorElemento(locatorOrigen), origen);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorDestino), destino);
        esperarXSegundos(500);
        click(esperarPorElemento(locatorSeleccionClase));
        esperarXSegundos(500);
        click(esperarPorElemento(locatorBusiness));
        esperarXSegundos(500);
        click(esperarPorElemento(locatorMetodoPago));
        click(esperarPorElemento(locatorMetodoPago));
        esperarXSegundos(1700);
        click(esperarPorElemento(locatorDiners));
        esperarXSegundos(700);
        click(esperarPorElemento(locatorFecha));
        click(crear_locator_dia(diaPartida));
        click(crear_locator_dia(diaVuelta));
        esperarXSegundos(700);
        annadirAdultos(cantAdultos);
        esperarXSegundos(700);
        ir_a_personas();
        esperarXSegundos(500);


    }



    public void preferenciasIda(String origen, String destino,String diaPartida,
                                int cantAdultos) {

        esperarXSegundos(200);
        agregarTexto(esperarPorElemento(locatorOrigen), origen);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorDestino), destino);
        esperarXSegundos(500);
        click(esperarPorElemento(locatorSeleccionClase));
        esperarXSegundos(500);
        click(esperarPorElemento(locatorBusiness));
        esperarXSegundos(500);
        click(esperarPorElemento(locatorMetodoPago));
        click(esperarPorElemento(locatorMetodoPago));
        esperarXSegundos(1700);
        click(esperarPorElemento(locatorAmerican));
        esperarXSegundos(500);
        click(esperarPorElemento(locatorFecha));
        click(crear_locator_dia(diaPartida));
        esperarXSegundos(2000);
        annadirAdultos(cantAdultos);
        ir_a_personas();
        esperarXSegundos(500);

    }
}