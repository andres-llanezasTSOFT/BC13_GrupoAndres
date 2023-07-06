package aut.testcreation.pages.Vuelos;

import framework.engine.selenium.SeleniumTestBase;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistroDatosUsuarios extends SeleniumWrapper {
    public RegistroDatosUsuarios(WebDriver driver) {
        super(driver);
    }

    By locatorNombre = By.xpath("//input[@name='name']");

    By locatorApellido = By.xpath("//input[@name='surname']");

    By locatorMail = By.xpath("//input[@id='lmn_login_widget_modal__email-input']");







    public void registroDatos(String nombre, String apellido, String mail){


        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorNombre),nombre);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorApellido),apellido);
        esperarXSegundos(500);
        agregarTexto(esperarPorElemento(locatorMail),mail);
        esperarXSegundos(500);
       /* agregarTexto(esperarPorElemento(locatorPassword),contrasena);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorUsername),username);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorDia),dia);
        esperarXSegundos(500);

        seleccionarComboBoxPortextoVisible(locatorMes,mes);
        esperarXSegundos(500);

        agregarTexto(esperarPorElemento(locatorAnnio),annio);
        esperarXSegundos(500);

        clickear(buscarElementosWeb(locatorGenenos).get(genero));
        esperarXSegundos(500);

        clickear(buscarElementosWeb(locatorPreferencias).get(0));
        esperarXSegundos(500);

        clickear(buscarElementosWeb(locatorPreferencias).get(1));
        esperarXSegundos(500);

        clickear(esperarPorElemento(btnRegistrate));
        scrollingDownElement(esperarPorElemento(locatorCorreo));
        esperarXSegundos(1500);*/

    }
}
