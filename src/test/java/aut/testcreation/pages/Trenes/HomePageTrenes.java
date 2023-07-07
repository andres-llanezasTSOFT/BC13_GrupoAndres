package aut.testcreation.pages.Trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class HomePageTrenes extends SeleniumWrapper {


    public HomePageTrenes(WebDriver driver) {
        super(driver);
    }

    By locatorPaginaTrenes = By.xpath("//a[@title='Trenes'][normalize-space()='Trenes']");
    By locatorBtnNoCookies = By.xpath("//button[contains(text(),'Rechazar todo')]");
    By locatorCaptchaExiste = By.xpath("//h2[contains(text(),'Comprobando']");

    By btnCheckCaptcha = By.xpath("//input[@type=\"checkbox\"]");

    public void irATrenes() {click(esperarPorElemento(locatorPaginaTrenes));}

    public void noCookies() {
        if (isDisplayed(locatorBtnNoCookies)) {
            click(esperarPorElemento(locatorBtnNoCookies));
        }
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

}

