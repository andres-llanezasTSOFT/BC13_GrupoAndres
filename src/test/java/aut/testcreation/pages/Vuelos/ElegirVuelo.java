package aut.testcreation.pages.Vuelos;

import framework.engine.selenium.FixEncoding;
import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElegirVuelo extends SeleniumWrapper {
    public ElegirVuelo(WebDriver driver) {
        super(driver);
    }

    By locatorMasBarato = By.xpath("//h5[contains(text(), 'barato')]");

    By locatorElegirVuelo = By.xpath("//div[@class='trip-view__react with-badge']//div[@class='FullTripCard__SelectedPriceContainer-sc-z8znd4-4 cbaIot']");

    public void masBarato(){
        click(esperarPorElemento(locatorMasBarato));
    }

    public void elegirVuelo(){
        click(esperarPorElemento(locatorElegirVuelo));
    }
}
