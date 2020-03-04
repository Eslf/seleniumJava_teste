# seleniumJava_teste

Configuração de ambiente

- Nesta seção serão informados os locais que haverá a necessidade de verificar alguns diretórios, 
antes dos testes serem realizados.

Ao clonar o repositório, abra o arquivo "pom.xml" e procure pela seguinte seção:

	 <dependency>
		   <groupId>com.sun</groupId>
		   <artifactId>tools</artifactId>
		   <version>1.5</version>
		   <scope>system</scope>
		   <systemPath>XXXX</systemPath>
	  </dependency>
  
  Onde está o "XXXX",substitua pelo local do arquivo "com.sun.tools.jar" em seu computador.
  
Procure pelo arquivo "Step_mapping.java", localizado em src/test/java/steps_map e encontre a seção:
	
	@Given ("^Abrir o navegador$")
	public void abrirFirefox() {
		System.setProperty("webdriver.firefox.driver", "FIREFOX_PATH");
		driver = new FirefoxDriver();
	    driver.get("http://www.juliodelima.com.br/taskit/");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	}

  Onde possui "FIREFOX_PATH", substitua pelo diretório onde se encontra o arquivo de driver do 
  Mozilla Firefox ("Gekodriver").
  
  Execução de Testes
  
  Para executar o "Desafio WebSite", encontre o arquivo "Step_execution.java" localizado em src/test/java/steps_running 
  e clique com o botão direito do mouse. No menu, vá até "Run as" e selecione a opção "JUnit Test".
  
  Para executar o "Desafio WebService", encontre o arquivo "TestWebService.java" localizado em src/main/java/com.test.ws 
  e clique com o botão direito do mouse. No menu, vá até "Run as" e selecione a opção "Java Application".
  
  
