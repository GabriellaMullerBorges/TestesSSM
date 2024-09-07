import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;

import java.util.Set;

import org.junit.Assert;

public class TesteFormulario {
	//TESTES NÃO REFATORIADOS APENAS PARA GUIA, IGNORAR
	@Test 
    public void testeTitle() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://saudemental.sesirs.org.br/");
		Assert.assertEquals("Saúde Mental | Sesi/RS", driver.getTitle());
		driver.quit();
}
 
@Test
	    public void testeCarrosselPesquisaClimatica() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        try {
	 
	            driver.get("https://saudemental.sesirs.org.br/");
   
	            WebElement botaoCarrossel = driver.findElement(By.id("slick-slide-control00")); 
	            botaoCarrossel.click();

	            Thread.sleep(2000); 

	            WebElement textoCarrossel = driver.findElement(By.cssSelector("#slick-slide00 #banner-titulo")); 
	            String textoEsperado = "Pesquisa | Impacto Crise Climática RS";
	            Assert.assertEquals(textoEsperado, textoCarrossel.getText());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	  driver.quit();
	        }
	    }

	    @Test
	    public void testeCarrosselSetembroAmarelo() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        try {
	            
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement botaoCarrossel = driver.findElement(By.id("slick-slide-control01")); 
	            botaoCarrossel.click();
	          
	            Thread.sleep(2000); 

	            WebElement textoCarrossel = driver.findElement(By.cssSelector("#slick-slide01 #banner-titulo")); 
	            String textoEsperado = "SETEMBRO AMARELO SESI ";
	            Assert.assertEquals(textoEsperado, textoCarrossel.getText());

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	  driver.quit();
	        }
	    }
	    
	    @Test
	    public void testeCarrosselReferenciaSaudeMental() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        try {
	           
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement botaoCarrossel = driver.findElement(By.id("slick-slide-control02")); 
	            botaoCarrossel.click();

	            Thread.sleep(2000);

	            WebElement textoCarrossel = driver.findElement(By.cssSelector("#slick-slide02 #banner-titulo")); 
	            String textoEsperado = "Referência em Saúde Mental no Trabalho";
	            Assert.assertEquals(textoEsperado, textoCarrossel.getText());

	        } finally {
	        	  driver.quit();
	        }
	    }

	    @Test
	    public void testeCarrosselInovacaoSaudeMental() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        try {
	           
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement botaoCarrossel = driver.findElement(By.id("slick-slide-control03")); 
	            botaoCarrossel.click();

	            Thread.sleep(2000); 

	            WebElement textoCarrossel = driver.findElement(By.cssSelector("#slick-slide03 #banner-titulo")); 
	            String textoEsperado = "Inovação em Saúde Mental";
	            Assert.assertEquals(textoEsperado, textoCarrossel.getText());

	        } finally {
	            driver.quit();
	        }
	    }
	    
	    @Test
	    public void testeLinksNavbar() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        try {
	           
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement divLinks = driver.findElement(By.cssSelector(".bubble-element.Group.baTaLaRaU0"));
	          
	            WebElement linkSolucoes = divLinks.findElement(By.linkText("Soluções"));
	            WebElement linkMateriais = divLinks.findElement(By.linkText("Materiais de Apoio"));
	            WebElement linkInovacao = divLinks.findElement(By.linkText("Inovação em Saúde Mental"));
	            WebElement linkContato = divLinks.findElement(By.linkText("Contato"));
	            WebElement linkBlog = divLinks.findElement(By.linkText("Blog"));

	            Assert.assertNotNull(linkSolucoes);
	            Assert.assertNotNull(linkMateriais);
	            Assert.assertNotNull(linkInovacao);
	            Assert.assertNotNull(linkContato);
	            Assert.assertNotNull(linkBlog);

	        } finally {
	            driver.quit();
	        }
	    }
	    

	    @Test
	    public void testeVideoPodeSerRodado() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 10);  
	        try {
	            
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe[src*='youtube.com/embed/PKRa3t97OI8']")));

	            driver.switchTo().frame(iframe);

	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            String script = "return document.querySelector('video') !== null";
	            Boolean isVideoPresent = (Boolean) js.executeScript(script);

	            Assert.assertTrue("O vídeo não está presente ou não pode ser reproduzido", isVideoPresent);

	            js.executeScript("document.querySelector('video').play()");

	            script = "return document.querySelector('video').paused === false";
	            Boolean isPlaying = (Boolean) js.executeScript(script);

	            Assert.assertFalse("O vídeo não está sendo reproduzido", isPlaying);

	        } finally {
	            driver.switchTo().defaultContent();
	            driver.quit();
	        }
	    }
	    
	    @Test
	    public void testeBotaoQueroContratarAbreNovaAba() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 10);  //
	        try {
	          
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement botaoQueroContratar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.clickable-element.bubble-element.Button.baTaMaQaP0")));

	            String janelaOriginal = driver.getWindowHandle();

	            botaoQueroContratar.click();

	            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

	            Set<String> janelas = driver.getWindowHandles();

	            for (String janela : janelas) {
	                if (!janela.equals(janelaOriginal)) {
	                    driver.switchTo().window(janela);
	                    break;
	                }
	            }

	            String urlEsperada = "https://www.sesirs.org.br/entre-em-contato";
	            String urlAtual = driver.getCurrentUrl();
	            System.out.println(urlAtual);
	            Assert.assertEquals("A URL da nova aba/janela não está correta", urlEsperada, urlAtual);

	        } finally {
	           
	            driver.quit();
	        }
	    }

 @Test
	    public void testeSliderVerificaPosicaoLeft() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 10);  
	        try {
	           
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-slider.ui-slider-horizontal")));
	            WebElement sliderHandle = slider.findElement(By.cssSelector(".ui-slider-handle"));
	            WebElement tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tooltip")));

	            String initialLeft = sliderHandle.getAttribute("style");
	            Assert.assertTrue("O valor de 'left' deveria ser 0% ou calc(0% + algo)", initialLeft.contains("0%"));

	            
	            String valorInicial = tooltip.getText();
	            Assert.assertEquals("O valor do tooltip deveria ser 0", "0", valorInicial);

	            
	            int sliderWidth = slider.getSize().getWidth();

	            Actions moveSlider = new Actions(driver);
	            moveSlider.clickAndHold(sliderHandle).moveByOffset(sliderWidth, 0).release().perform(); 
	            
	            String finalLeft = sliderHandle.getAttribute("style");
	            Assert.assertTrue("O valor de 'left' deveria ser calc(100% - algo)", finalLeft.contains("100%"));

	            String valorFinal = tooltip.getText();
	            Assert.assertEquals("O valor do tooltip deveria ser 5000", "5.000", valorFinal);

	        } finally {
	            driver.quit();
	        }
	    }


	 @Test
	    public void testeTooltip1665VerificaValor() {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 10);  
	        try {
	            
	            driver.get("https://saudemental.sesirs.org.br/");

	            WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-slider.ui-slider-horizontal")));
	            WebElement sliderHandle = slider.findElement(By.cssSelector(".ui-slider-handle"));
	            WebElement tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tooltip")));

	            Actions moveSlider = new Actions(driver);
	            String valorTooltip = tooltip.getText();

	               while (!valorTooltip.equals("1.665")) {
	               moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
	               
	                valorTooltip = tooltip.getText();
	                
	                Thread.sleep(100);  
	                
	                if (valorTooltip.equals("1.665")) {
	                    break; 
	                }
	            }
	            Assert.assertEquals("O valor do tooltip deveria ser 1.665", "1.665", valorTooltip);

	            
	            WebElement valorElemento = driver.findElement(By.cssSelector(".bubble-element.Text.baTaLqaR"));

	            String valorEsperado = "869.130,00";
	            String valorAtual = valorElemento.getText();
	            Assert.assertEquals("O valor do elemento deveria ser 869.130,00", valorEsperado, valorAtual);

	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } finally {
	            driver.quit();
	        }
	    }

 @Test
	 public void testeTooltip1665ValidaValor83() {
	     System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     WebDriverWait wait = new WebDriverWait(driver, 10); 
	     try {
	         driver.get("https://saudemental.sesirs.org.br/");

	         WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-slider.ui-slider-horizontal")));
	         WebElement sliderHandle = slider.findElement(By.cssSelector(".ui-slider-handle"));
	         WebElement tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tooltip")));

	         Actions moveSlider = new Actions(driver);
	         String valorTooltip = tooltip.getText();

	         while (!valorTooltip.equals("1.665")) {
	             moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
	             valorTooltip = tooltip.getText();
	             Thread.sleep(100);  
	         }

	         Assert.assertEquals("O valor do tooltip deveria ser 1.665", "1.665", valorTooltip);

	         WebElement valorElemento = driver.findElement(By.cssSelector(".bubble-element.Text.baTaLpaZ"));
	         
	         String valorEsperado = "83";
	         String valorAtual = valorElemento.getText();
	         Assert.assertEquals("O valor do elemento deveria ser 83", valorEsperado, valorAtual);

	     } catch (InterruptedException e) {
	         e.printStackTrace();
	     } finally {
	         driver.quit();
	     }
	 }

@Test
	public void testeTooltip1665ValidaValor2081() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 10);  
	    try {
	       
	        driver.get("https://saudemental.sesirs.org.br/");

	        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-slider.ui-slider-horizontal")));
	        WebElement sliderHandle = slider.findElement(By.cssSelector(".ui-slider-handle"));
	        WebElement tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tooltip")));

	        Actions moveSlider = new Actions(driver);
	        String valorTooltip = tooltip.getText();

	        while (!valorTooltip.equals("1.665")) {
	            moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
	            valorTooltip = tooltip.getText();
	            Thread.sleep(100);  
	        }

	        Assert.assertEquals("O valor do tooltip deveria ser 1.665", "1.665", valorTooltip);

	        WebElement valorElemento = driver.findElement(By.cssSelector(".bubble-element.Text.baTaLpm"));

	        String valorEsperado = "2081";
	        String valorAtual = valorElemento.getText();
	        Assert.assertEquals("O valor do elemento deveria ser 2081", valorEsperado, valorAtual);

	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } finally {
	        driver.quit();
	    }
	}

	@Test
	public void testeTooltip1665ValidaValor1249() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    WebDriverWait wait = new WebDriverWait(driver, 10);  
	    try {
	        driver.get("https://saudemental.sesirs.org.br/");

	        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ui-slider.ui-slider-horizontal")));
	        WebElement sliderHandle = slider.findElement(By.cssSelector(".ui-slider-handle"));
	        WebElement tooltip = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tooltip")));

	        Actions moveSlider = new Actions(driver);
	        String valorTooltip = tooltip.getText();

	        while (!valorTooltip.equals("1.665")) {
	            moveSlider.clickAndHold(sliderHandle).moveByOffset(1, 0).release().perform();
	            valorTooltip = tooltip.getText();
	            Thread.sleep(100); 
	        }

	        Assert.assertEquals("O valor do tooltip deveria ser 1.665", "1.665", valorTooltip);

	        WebElement valorElemento = driver.findElement(By.cssSelector(".bubble-element.Text.baTaLps"));

	        String valorEsperado = "1249";
	        String valorAtual = valorElemento.getText();
	        Assert.assertEquals("O valor do elemento deveria ser 1249", valorEsperado, valorAtual);

	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } finally {
	        driver.quit();
	    }
	}

@Test
    public void testeBotaoAbreNovaAba() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);  
        try {
            driver.get("https://saudemental.sesirs.org.br/");

            WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".clickable-element.bubble-element.Button.baTaLkaV2")));

            String abaPrincipal = driver.getWindowHandle();

            botao.click();

            Set<String> abas = driver.getWindowHandles();

            Assert.assertTrue("Uma nova aba deve ser aberta", abas.size() > 1);

            for (String aba : abas) {
                if (!aba.equals(abaPrincipal)) {
                    driver.switchTo().window(aba);
                    break;
                }
            }

            String urlEsperada = "https://www.sesirs.org.br/entre-em-contato";
            String urlAtual = driver.getCurrentUrl();
            Assert.assertEquals("A URL da nova aba deve ser a página de contato", urlEsperada, urlAtual);

        } finally {
             driver.quit();
        }
    }


@Test
    public void testeClicarNoBotaoIcone() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gabim\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        try {
            driver.get("https://saudemental.sesirs.org.br/");

            WebElement lerMaisIconButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.bubble-element.Icon.baTaLaSaJ0")));

            lerMaisIconButton.click();

            wait.until(ExpectedConditions.urlToBe("https://saudemental.sesirs.org.br/cases/assessoria-psicossocial-1694722814795x181524719199928100"));

            String urlEsperada = "https://saudemental.sesirs.org.br/cases/assessoria-psicossocial-1694722814795x181524719199928100";
            String urlAtual = driver.getCurrentUrl();
            Assert.assertEquals("A URL da página redirecionada deve ser a esperada", urlEsperada, urlAtual);

        } finally {
            driver.quit();
        }
    }
}

