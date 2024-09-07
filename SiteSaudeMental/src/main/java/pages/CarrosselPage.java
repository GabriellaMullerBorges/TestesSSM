package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dsl.DSL;

public class CarrosselPage extends DSL {

    public CarrosselPage(WebDriver driver) {
        this.driver = driver;
    }

    // Acessa a página inicial com o carrossel
    public void acessarPaginaCarrossel() {
        abrirPagina("https://saudemental.sesirs.org.br/");
    }

    // Clica no botão do carrossel "Pesquisa Climatica"
    public void clicarBotaoCarrosselPesquisaClimatica() {
        WebElement botaoCarrossel = esperarElemento(By.id("slick-slide-control00"));
        botaoCarrossel.click();
    }

    // Clica no botão do carrossel "Setembro Amarelo"
    public void clicarBotaoCarrosselSetembroAmarelo() {
        WebElement botaoCarrossel = esperarElemento(By.id("slick-slide-control01"));
        botaoCarrossel.click();
    }

    // Clica no botão do carrossel "Referência em Saúde Mental"
    public void clicarBotaoCarrosselReferenciaSaudeMental() {
        WebElement botaoCarrossel = esperarElemento(By.id("slick-slide-control02"));
        botaoCarrossel.click();
    }

    // Clica no botão do carrossel "Inovação em Saúde Mental"
    public void clicarBotaoCarrosselInovacaoSaudeMental() {
        WebElement botaoCarrossel = esperarElemento(By.id("slick-slide-control03"));
        botaoCarrossel.click();
    }

    // Obtém o texto do carrossel atual
    public String obterTextoCarrosselAtual(String slideId) {
        WebElement textoCarrossel = esperarElemento(By.cssSelector(slideId + " #banner-titulo"));
        return textoCarrossel.getText();
    }
}
