package aut.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class BusquedaHotel extends SeleniumWrapper {

    public BusquedaHotel(WebDriver driver) {
        super(driver);
    }

    By locatorCiudad = By.xpath("//input[contains(@placeholder, \"quieres ir\")]");
    By locatorFecha = By.xpath("//button[contains(@aria-label, \"Fecha de entrada\")]");
    By locatorMesAnnoActual = By.className("//span[@class= \"d-tmbbn\"]");
    By btnMesPrevio = By.xpath("//button[contains(@aria-label, \"Previous\")]");
    By btnMesSiguiente = By.xpath("//button[contains(@aria-label, \"Next\")]");
    By locatorOpcionDia = By.xpath("//div[@aria-labelledby]//descendant-or-self::button");
    By locatorPersonas = By.xpath("//span[contains(text(), \"1 hu\")]");
    By btnAumentarNroAdultos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de adultos\") and @xpath =\"2\"]");
    By btnAnnadirNinnos = By.xpath("//button[contains(@aria-label, \"Aumentar el número de niños\")] //span[@xpath=\"2\"]");
    By btnBuscar = By.xpath("//button[@type='submit']");
    By locatorEdadNinnos = By.xpath("//ul//li[contains(.,\"Edad al viajar\")]");

    By annadirHabitacion = By.xpath("//button[contains(text(), \"Añadir\")]");

    public void buscarHotel(String ciudad, String mesAnno, String diaPartida, String diaVuelta,
                            String cantAdultos, int cantNinnos) {

        click(esperarPorElemento(locatorCiudad));
        agregarTexto(esperarPorElemento(locatorCiudad), ciudad);
        sendKeys(Keys.ENTER,locatorCiudad);
        click(esperarPorElemento(locatorFecha));
        esperarXSegundos(500);
        if (isDisplayed(locatorMesAnnoActual)) {
            seleccionarFechas(mesAnno, diaPartida, diaVuelta);
        }
        esperarXSegundos(500);
        seleccionarComboBoxPortextoVisible(locatorPersonas, cantAdultos);
        if (cantNinnos > 0) {
            int ninno = 0;
            while (ninno != cantNinnos) {
                annadirNinnosHabitacion("2 años");
                ninno++;
            }
        }
        esperarXSegundos(500);
        click(esperarPorElemento(btnAumentarNroAdultos));
        esperarXSegundos(500);
        esperarXSegundos(500);
        click(esperarPorElemento(btnBuscar));
    }

    public void seleccionarFechas(String fecha, String checkInDate, String checkOutDate) {

        click(esperarPorElemento(locatorFecha));

        while (true) {
            if (getText(locatorMesAnnoActual).equals(fecha)) {
                if (isEnabled(locatorOpcionDia)) {
                    click(seleccionarBotonPortextoVisible(locatorOpcionDia, checkInDate));
                    click(seleccionarBotonPortextoVisible(locatorOpcionDia, checkOutDate));
                }
            } else if (getText(locatorMesAnnoActual).compareTo(fecha) > 0) {
                click(btnMesPrevio);
            } else {
                click(btnMesSiguiente);
            }
        }



    }


    public void annadirNinnosHabitacion(String edadNinnos) {
        click(esperarPorElemento(btnAnnadirNinnos));
        esperarXSegundos(500);
        if (isDisplayed(locatorEdadNinnos)) {
            seleccionarComboBoxPortextoVisible(locatorEdadNinnos, edadNinnos);
            esperarXSegundos(500);
        }else{
            esperarXSegundos(500);
            click(esperarPorElemento(annadirHabitacion));
        }
    }


}
