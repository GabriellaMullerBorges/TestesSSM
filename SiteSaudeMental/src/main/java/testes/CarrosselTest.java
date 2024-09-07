package testes;

import dsl.DSL;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import pages.CarrosselPage;

import static org.junit.Assert.assertEquals;

public class CarrosselTest extends DSL {

    private CarrosselPage carrosselPage;

    @Before
    public void setUp() {
        iniciarDriver();
        carrosselPage = new CarrosselPage(driver);
        carrosselPage.acessarPaginaCarrossel();
    }

    @After
    public void tearDown() {
        fecharDriver();
    }

    @Test
    public void testeCarrosselPesquisaClimatica() throws InterruptedException {
        carrosselPage.clicarBotaoCarrosselPesquisaClimatica();
        Thread.sleep(2000);  //Transição do carrossel
        String textoEsperado = "Pesquisa | Impacto Crise Climática RS";
        assertEquals(textoEsperado, carrosselPage.obterTextoCarrosselAtual("#slick-slide00"));
    }

    @Test
    public void testeCarrosselSetembroAmarelo() throws InterruptedException {
        carrosselPage.clicarBotaoCarrosselSetembroAmarelo();
        Thread.sleep(2000); 
        String textoEsperado = "SETEMBRO AMARELO SESI ";
        assertEquals(textoEsperado, carrosselPage.obterTextoCarrosselAtual("#slick-slide01"));
    }

    @Test
    public void testeCarrosselReferenciaSaudeMental() throws InterruptedException {
        carrosselPage.clicarBotaoCarrosselReferenciaSaudeMental();
        Thread.sleep(2000);  
        String textoEsperado = "Referência em Saúde Mental no Trabalho";
        assertEquals(textoEsperado, carrosselPage.obterTextoCarrosselAtual("#slick-slide02"));
    }

    @Test
    public void testeCarrosselInovacaoSaudeMental() throws InterruptedException {
        carrosselPage.clicarBotaoCarrosselInovacaoSaudeMental();
        Thread.sleep(2000);  
        String textoEsperado = "Inovação em Saúde Mental";
        assertEquals(textoEsperado, carrosselPage.obterTextoCarrosselAtual("#slick-slide03"));
    }
}
