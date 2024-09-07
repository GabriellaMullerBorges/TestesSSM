package dsl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class DSL {

    protected WebDriver driver;

    // Iniciar o driver do navegador
    public void iniciarDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    // Fechar o driver do navegador
    public void fecharDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Abrir uma página
    public void abrirPagina(String url) {
        driver.get(url);
    }

    // Mover o slider até alcançar o valor desejado no tooltip
    public void moverSliderParaValor(WebElement sliderHandle, WebElement tooltip, String valorEsperado) throws InterruptedException {
        Actions moveSlider = new Actions(driver);
        String valorTooltip = tooltip.getText();

        while (!valorTooltip.equals(valorEsperado)) {
            moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
            valorTooltip = tooltip.getText();
            Thread.sleep(100);  // Tempo para garantir que o valor do tooltip seja atualizado

            // Verifica se já alcançou o valor esperado
            if (valorTooltip.equals(valorEsperado)) {
                break;
            }
        }
    }

    // Verificar se o texto do elemento é igual ao valor esperado
    public void verificarTextoElemento(String seletorCss, String valorEsperado) {
        WebElement elemento = driver.findElement(By.cssSelector(seletorCss));
        String valorAtual = elemento.getText();
        Assert.assertEquals("O valor do elemento não é o esperado", valorEsperado, valorAtual);
    }

    // Esperar até que um elemento esteja presente
    public WebElement esperarElemento(By localizador) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }
}
