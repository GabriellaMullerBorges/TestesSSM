package testes;

import dsl.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ComponentTest extends DSL {

    @Before
    public void setUp() {
        iniciarDriver();
    }

    @After
    public void tearDown() {
        fecharDriver();
    }

    @Test
    public void testeVideoPodeSerRodado() {
        WebDriverWait wait = new WebDriverWait(driver, 10);  
        
        try {
            driver.get("https://saudemental.sesirs.org.br/");

            // Tenta localizar o iframe 
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[src*='youtube.com/embed/PKRa3t97OI8']")));

            // Muda para o contexto do iframe
            driver.switchTo().frame(iframe);

            // Usa JavaScript para verificar se o vídeo pode ser reproduzido
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "return document.querySelector('video') !== null";
            Boolean isVideoPresent = (Boolean) js.executeScript(script);

            // Verifica se o vídeo está presente dentro do iframe
            assertTrue("O vídeo não está presente ou não pode ser reproduzido", isVideoPresent);

            // Tenta iniciar o vídeo via JavaScript
            js.executeScript("document.querySelector('video').play()");

            // Verifica se o vídeo está realmente reproduzindo
            script = "return document.querySelector('video').paused === false";
            Boolean isPlaying = (Boolean) js.executeScript(script);

            assertFalse("O vídeo não está sendo reproduzido", isPlaying);

        } finally {
            // Retorna ao contexto principal
            driver.switchTo().defaultContent();
        }
    }
}
