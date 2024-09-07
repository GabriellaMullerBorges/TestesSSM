package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import dsl.DSL;

public class NavigationPage extends DSL {

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acessa a página inicial
    public void acessarPaginaInicial() {
        abrirPagina("https://saudemental.sesirs.org.br/");
    }

    // Verificar se os links da navbar estão presentes
    public boolean verificarLinkSolucoes() {
        WebElement linkSolucoes = driver.findElement(By.linkText("Soluções"));
        return linkSolucoes != null;
    }

    public boolean verificarLinkMateriaisApoio() {
        WebElement linkMateriais = driver.findElement(By.linkText("Materiais de Apoio"));
        return linkMateriais != null;
    }

    public boolean verificarLinkInovacaoSaudeMental() {
        WebElement linkInovacao = driver.findElement(By.linkText("Inovação em Saúde Mental"));
        return linkInovacao != null;
    }

    public boolean verificarLinkContato() {
        WebElement linkContato = driver.findElement(By.linkText("Contato"));
        return linkContato != null;
    }

    public boolean verificarLinkBlog() {
        WebElement linkBlog = driver.findElement(By.linkText("Blog"));
        return linkBlog != null;
    }

    // Clica no botão "Quero Contratar"
    public void clicarBotaoQueroContratar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement botaoQueroContratar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.clickable-element.bubble-element.Button.baTaMaQaP0")));
        botaoQueroContratar.click();
    }

    // Troca para a nova aba aberta
    public void mudarParaNovaAba() {
        String abaPrincipal = driver.getWindowHandle();
        for (String aba : driver.getWindowHandles()) {
            if (!aba.equals(abaPrincipal)) {
                driver.switchTo().window(aba);
                break;
            }
        }
    }

    // Obtém a URL atual da página
    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }
}
