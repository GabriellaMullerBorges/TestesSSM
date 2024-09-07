package testes;

import dsl.DSL;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import pages.NavigationPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationTest extends DSL {

    private NavigationPage navigationPage;

    @Before
    public void setUp() {
        iniciarDriver();
        navigationPage = new NavigationPage(driver);
    }

    @After
    public void tearDown() {
        fecharDriver();
    }

    @Test
    public void testeLinksNavbar() {
        navigationPage.acessarPaginaInicial();
        assertTrue(navigationPage.verificarLinkSolucoes());
        assertTrue(navigationPage.verificarLinkMateriaisApoio());
        assertTrue(navigationPage.verificarLinkInovacaoSaudeMental());
        assertTrue(navigationPage.verificarLinkContato());
        assertTrue(navigationPage.verificarLinkBlog());
    }

    @Test
    public void testeBotaoAbreNovaAba() {
        navigationPage.acessarPaginaInicial();
        navigationPage.clicarBotaoQueroContratar();
        navigationPage.mudarParaNovaAba();
        assertEquals("https://www.sesirs.org.br/entre-em-contato", navigationPage.obterUrlAtual());
    }
}
