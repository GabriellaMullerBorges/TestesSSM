package testes;

import dsl.DSL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import pages.SliderPage;

public class SliderTest extends DSL {

    private SliderPage sliderPage;

    @Before
    public void setUp() {
        iniciarDriver(); 
        sliderPage = new SliderPage(driver); 
    }

    @After
    public void tearDown() {
        fecharDriver(); 
    }

    @Test
    public void testeSliderVerificaPosicaoLeft() throws InterruptedException {
        sliderPage.acessarPaginaSlider();
        sliderPage.moverSliderPorIncremento();
        
        String valorTooltip = sliderPage.getTooltipValue();
        Assert.assertEquals("1.665", valorTooltip);
        
        String valorCampo = sliderPage.obterValorCampo(".bubble-element.Text.baTaLqaR");
        Assert.assertEquals("869.130,00", valorCampo);
    }

    @Test
    public void testeTooltipVerificaValor83() throws InterruptedException {
        sliderPage.acessarPaginaSlider();
        sliderPage.moverSliderPorIncremento();
        
        Assert.assertEquals("1.665", sliderPage.getTooltipValue());
        Assert.assertEquals("83", sliderPage.obterValorCampo(".bubble-element.Text.baTaLpaZ"));
    }

    @Test
    public void testeTooltipVerificaValor2081() throws InterruptedException {
        sliderPage.acessarPaginaSlider();
        sliderPage.moverSliderPorIncremento();
        
        Assert.assertEquals("1.665", sliderPage.getTooltipValue());
        Assert.assertEquals("2081", sliderPage.obterValorCampo(".bubble-element.Text.baTaLpm"));
    }

    @Test
    public void testeTooltipVerificaValor1249() throws InterruptedException {
        sliderPage.acessarPaginaSlider();
        sliderPage.moverSliderPorIncremento();
        
        Assert.assertEquals("1.665", sliderPage.getTooltipValue());
        Assert.assertEquals("1249", sliderPage.obterValorCampo(".bubble-element.Text.baTaLps"));
    }

    @Test
    public void testeTooltip1665VerificaValor() throws InterruptedException {
        sliderPage.acessarPaginaSlider();
        
        sliderPage.moverSliderParaValor("1.665");
        
        String valorEsperado = "869.130,00";
        Assert.assertEquals(valorEsperado, sliderPage.obterValorSlider());
    }
}
