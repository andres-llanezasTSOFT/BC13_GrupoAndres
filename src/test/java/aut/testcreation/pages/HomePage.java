package aut.testcreation.pages;


import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SeleniumWrapper {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Centralizar los localizadores
    By locatorRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");

    //acciones del sitio
    public void irARegistrarse(){
        click(esperarPorElemento(locatorRegistrarte));
    }
}
