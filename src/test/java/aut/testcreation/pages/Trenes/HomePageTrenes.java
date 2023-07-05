package aut.testcreation.pages.Trenes;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static framework.engine.utils.Constants.BASE_URL_AUT;

public class HomePageTrenes extends SeleniumWrapper {


    public HomePageTrenes(WebDriver driver) {
        super(driver);
    }

    By locatorPaginaTrenes = By.xpath("//div[@class='d-1ytebqy e10w470p3']//a[@title='Trenes'][normalize-space()='Trenes']");
    By locatorBtnNoCookies = By.xpath("//button[contains(@class,'iubenda-cs-reject-btn iubenda-cs-btn-primary')]");
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



/*[16:41] Andrés Llanezas

        esto para usar dentro del metodo:click(esperarPorElemento(locatorFecha));

        click(crear_locator_dia(diaPartida));

        click(crear_locator_dia(diaVuelta));

        [16:41] Andrés Llanezas

public By crear_locator_dia(String number){

        return locatorOpcionDia = By.xpath("//button[contains(text(),"+ number+")]");

        }

        [16:42] Andrés Llanezas

        y con los Bys declarar: By locatorDia;*/
