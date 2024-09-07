package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    // Construtor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Acessar página inicial
    public void acessarPaginaInicial() {
        driver.get("https://saudemental.sesirs.org.br/");
    }

    // Obter título da página
    public String obterTitulo() {
        return driver.getTitle();
    }

    // Clicar no botão 'Quero Contratar'
    public void clicarBotaoContratar() {
        driver.findElement(By.cssSelector("button.clickable-element.bubble-element.Button.baTaMaQaP0")).click();
    }

    // Clicar no botão com ícone 'Ler mais Cases'
    public void clicarBotaoLerMais() {
        driver.findElement(By.cssSelector("button.bubble-element.Icon.baTaLaSaJ0")).click();
    }
}
