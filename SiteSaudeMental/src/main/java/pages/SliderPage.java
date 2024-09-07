package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPage {
    private WebDriver driver;
    private WebElement sliderHandle;
    private WebElement tooltip;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acessar página com o slider
    public void acessarPaginaSlider() {
        driver.get("https://saudemental.sesirs.org.br/");
    }

    // Mover slider para o valor
    public void moverSliderPorIncremento() throws InterruptedException {
        WebElement sliderHandle = driver.findElement(By.cssSelector(".ui-slider-handle"));
        Actions moveSlider = new Actions(driver);
        
        while (!getTooltipValue().equals("1.665")) {
            moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
            Thread.sleep(100);
        }
    }

    // Obter valor do tooltip
    public String getTooltipValue() {
        WebElement tooltip = driver.findElement(By.id("tooltip"));
        return tooltip.getText();
    }

    // Obter o valor do campo específico
    public String obterValorCampo(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector)).getText();
    }
    
    public void moverSliderParaValor(String valorEsperado) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Localiza o slider e o handle
        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-slider.ui-slider-horizontal")));
        sliderHandle = slider.findElement(By.cssSelector(".ui-slider-handle"));
        tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tooltip")));

        // Mover o slider
        Actions moveSlider = new Actions(driver);
        String valorTooltip = tooltip.getText();

        while (!valorTooltip.equals(valorEsperado)) {
            moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
            valorTooltip = tooltip.getText();
            Thread.sleep(100);  // Aguarda para garantir a atualização do tooltip
        }
    }

    // Obter o valor atual do slider
    public String obterValorSlider() {
        WebElement valorElemento = driver.findElement(By.cssSelector(".bubble-element.Text.baTaLqaR"));
        return valorElemento.getText();
    }
}
