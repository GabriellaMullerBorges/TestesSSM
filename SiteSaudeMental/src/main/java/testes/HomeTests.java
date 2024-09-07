package testes;

import dsl.DSL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;

public class HomeTests extends DSL {

    private HomePage homePage;

    @Before
    public void setUp() {
        iniciarDriver();  
        homePage = new HomePage(driver);
    }

    @After
    public void tearDown() {
        fecharDriver(); 
    }

    @Test
    public void testeTituloPagina() {
        homePage.acessarPaginaInicial();
        Assert.assertEquals("Saúde Mental | Sesi/RS", homePage.obterTitulo());
    }

    @Test
    public void testeBotaoQueroContratarAbreNovaAba() {
        homePage.acessarPaginaInicial();
        homePage.clicarBotaoContratar();
        String janelaOriginal = driver.getWindowHandle();

        // Espera até que uma nova aba seja aberta e realiza a mudança
        for (String janela : driver.getWindowHandles()) {
            if (!janela.equals(janelaOriginal)) {
                driver.switchTo().window(janela);
                break;
            }
        }

        Assert.assertEquals("https://www.sesirs.org.br/entre-em-contato", driver.getCurrentUrl());
    }

    @Test
    public void testeClicarNoBotaoIcone() {
        homePage.acessarPaginaInicial();
        homePage.clicarBotaoLerMais();
        Assert.assertEquals("https://saudemental.sesirs.org.br/cases/assessoria-psicossocial-1694722814795x181524719199928100", driver.getCurrentUrl());
    }
}
