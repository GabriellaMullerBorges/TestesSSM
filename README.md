# Projeto de Automação de Testes do site de Sáude Mental SESI/RS

Este projeto foi desenvolvido em **Java** para automatizar testes de interface gráfica (GUI) de um sistema web utilizando **Selenium WebDriver**, **JUnit** para a estrutura de testes, e o padrão Page Object Model (POM) para organizar as interações com a interface do usuário.

O objetivo deste projeto é verificar a funcionalidade de componentes como carrossel, slider, vídeos, além de realizar outras verificações em uma aplicação web hospedada em saudemental.sesirs.org.br.

## Tecnologias Utilizadas
* Java 8 ou superior
* Selenium WebDriver
* JUnit 4
* Page Object Model (POM)
* ChromeDriver

## Estrutura do Projeto
O projeto segue uma estrutura organizada em três principais pacotes:

* DSL: Contém a classe DSL (Domain-Specific Language), que encapsula interações comuns com o Selenium, como a inicialização do WebDriver, navegação, e manipulação de elementos na página.
* Pages: Contém as classes que seguem o padrão Page Object Model (POM). Cada página mapeia os elementos e as interações com componentes específicos da interface da aplicação.
* Testes: Contém as classes de testes que utilizam as páginas criadas no pacote pages para realizar os testes funcionais e de interface, garantindo a separação clara entre o código de teste e a lógica de interação com a interface.

### Principais Classes
1. **DSL** (dsl/DSL.java)
A classe DSL contém métodos utilitários para inicialização do WebDriver, fechamento do driver, abertura de páginas e manipulação de elementos. Ela encapsula interações comuns com o Selenium para facilitar o uso em diferentes classes de teste.

#### Principais métodos:

* iniciarDriver(): Inicia o WebDriver utilizando o ChromeDriver.
* fecharDriver(): Fecha o WebDriver após a execução dos testes.
* abrirPagina(String url): Abre uma página no navegador utilizando a URL fornecida.
* moverSliderParaValor(WebElement sliderHandle, WebElement tooltip, String valorEsperado): Move um slider até que o valor desejado seja atingido.
* esperarElemento(By localizador): Espera até que o elemento localizado esteja presente na página.
  
2. **SliderPage** (pages/SliderPage.java)
Essa classe encapsula a interação com o componente slider da página web. Ela contém métodos para acessar a página com o slider, mover o slider até valores específicos e verificar os valores presentes no tooltip.

#### Principais métodos:

* acessarPaginaSlider(): Acessa a página contendo o slider.
* moverSliderPorIncremento(): Move o slider de forma incremental até o valor esperado.
* moverSliderParaValor(String valorEsperado): Move o slider até o valor desejado no tooltip.
* getTooltipValue(): Obtém o valor do tooltip do slider.
* obterValorCampo(String cssSelector): Obtém o texto de um elemento utilizando o seletor CSS.

3. **CarrosselPage** (pages/CarrosselPage.java)
Essa classe mapeia as interações com o componente de carrossel da página web. Ela contém métodos que clicam em diferentes slides do carrossel e retornam o texto dos slides ativos.

#### Principais métodos:

* acessarPaginaCarrossel(): Acessa a página com o carrossel.
* clicarBotaoCarrosselPesquisaClimatica(): Clica no botão do slide "Pesquisa Climatica".
* clicarBotaoCarrosselSetembroAmarelo(): Clica no botão do slide "Setembro Amarelo".
* clicarBotaoCarrosselReferenciaSaudeMental(): Clica no botão do slide "Referência em Saúde Mental".
* clicarBotaoCarrosselInovacaoSaudeMental(): Clica no botão do slide "Inovação em Saúde Mental".
* obterTextoCarrosselAtual(): Obtém o texto do slide atual do carrossel.
  
4. **ComponentsPage** (pages/ComponentsPage.java)
Essa classe interage com componentes adicionais, como vídeos presentes na página web. Ela permite verificar se o vídeo pode ser reproduzido e simula a interação com o mesmo.

#### Principais métodos:

* acessarVideo(): Acessa o vídeo presente no iframe e muda o contexto para o iframe do vídeo.
* videoPodeSerTocado(): Verifica se o vídeo pode ser tocado.
* tocarVideo(): Inicia a reprodução do vídeo através de JavaScript.
  
5. **Classes de Teste** (testes)
As classes de teste utilizam as páginas do projeto para validar o comportamento esperado da aplicação. Elas são organizadas de acordo com o componente da interface que está sendo testado.

* CarrosselTest: Testa a navegação entre diferentes slides do carrossel.
* SliderTest: Testa o comportamento do slider, incluindo a movimentação e os valores exibidos no tooltip.
* ComponentTest: Testa se o vídeo presente no iframe da página pode ser reproduzido corretamente.
  
## Instalação e Configuração

1. Clonar o Repositório
  `git clone https://github.com/seu-usuario/seu-repositorio.git`

3. Configurar o Ambiente
Certifique-se de que você tenha o Java 8 ou superior instalado em sua máquina, além do ChromeDriver. Você pode baixar o ChromeDriver a partir do site oficial.

4. Configurar o Caminho do ChromeDriver
Na classe DSL, o caminho para o ChromeDriver é configurado através do seguinte código:

`System.setProperty("webdriver.chrome.driver", "C:\\caminho\\para\\chromedriver.exe");`

Altere o caminho para o local onde o ChromeDriver está instalado em sua máquina.

4. Executar os Testes
Depois de configurar o ambiente e ajustar o caminho do ChromeDriver, você pode executar os testes utilizando uma IDE como IntelliJ IDEA ou Eclipse, ou diretamente pela linha de comando utilizando Maven ou Gradle.

Para executar os testes na linha de comando com Maven:

`mvn test`

## Estrutura de Pasta
```
src
├── main
│   ├── java
│   │   ├── dsl
│   │   │   └── DSL.java
│   │   └── pages
│   │       ├── CarrosselPage.java
│   │       ├── SliderPage.java
│   │       └── ComponentsPage.java
├── test
│   ├── java
│   │   └── testes
│   │       ├── CarrosselTest.java
│   │       ├── SliderTest.java
│   │       └── ComponentTest.java
```

### Boas Práticas
* Reutilização de Código: A classe DSL foi criada para centralizar métodos comuns que interagem com o Selenium, como inicializar e fechar o driver, esperar por elementos e mover sliders. Isso evita duplicação de código nos testes.

* Page Object Model: Todas as interações específicas da página estão encapsuladas em classes de página separadas, como CarrosselPage e SliderPage. Isso facilita a manutenção do código, já que qualquer alteração na interface de usuário pode ser atualizada em uma única classe de página sem modificar diretamente os testes.

* Separação de Responsabilidades: O código de interação com a interface do usuário está separado do código de testes. Isso garante que as classes de teste sejam focadas em verificar a lógica e as funcionalidades, enquanto as classes de página gerenciam as interações com a interface.

## Conclusão
Este projeto foi estruturado para ser facilmente extensível e modular. Utilizando o padrão Page Object Model e a abstração fornecida pela classe DSL, os testes são mais fáceis de manter, ler e expandir à medida que a aplicação cresce.
