package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dsl.DSL;

public class ComponentsPage extends DSL {

    public ComponentsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void acessarVideo() {
        // Usa a função esperarElemento da DSL para garantir que o iframe está presente
        WebElement iframe = esperarElemento(By.cssSelector("iframe[src*='youtube.com/embed/PKRa3t97OI8']"));
        driver.switchTo().frame(iframe); // Mudança de contexto para o iframe
    }

    public boolean videoPodeSerTocado() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.querySelector('video') !== null";
        return (Boolean) js.executeScript(script); // Verifica se o vídeo está presente
    }

    public void tocarVideo() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('video').play()"); // Inicia a reprodução do vídeo
    }

    public boolean videoEstaTocando() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.querySelector('video').paused === false";
        return (Boolean) js.executeScript(script); // Verifica se o vídeo está realmente tocando
    }
}
