package steps_map;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;


public class Step_mapping {

	private static WebDriver driver;
	JavascriptExecutor js;
	
	@Given ("^Abrir o navegador$")
	public void abrirFirefox() {
		System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
		driver = new FirefoxDriver();
	    driver.get("http://www.juliodelima.com.br/taskit/");
	}
	
	// Passos Criar usuario
	
	@Given ("^Abrir tela de cadastro$")
	public void abrirTelaCadastro() {
		driver.findElement(By.id("signup")).click();
	}
	
	@Given ("^Cadastrar nome de usuario$")
	public void cadastrarNomeUsuario() {
		driver.findElement(By.name("name")).sendKeys("Nome de Usuario Java8");
	}
	
	@Given ("^Cadastrar login do usuario$")
	public void cadastrarLoginUsuario() {
		driver.findElement(By.name("login")).sendKeys("login_16@email.com");
	}
	
	@Given ("^Cadastrar senha do usuario$")
	public void cadastrarSenhaUsuario() {
		driver.findElement(By.name("password")).sendKeys("S3nh@");
	}
	
	@When ("^Finalizar cadastro do usuario$")
	public void finalizarCadastroUsuario() {
		driver.findElement(By.cssSelector("#signupbox .modal-action")).click();
	}	
		
	@Then ("^Confirmar cadastro com sucesso$")
	public void assertionCadastroSucesso() {
		try {
		    Thread.sleep(2000);
			assertThat(driver.findElement(By.cssSelector(".waves-light")).getText(), is("LET\'S ADD SOME TASKS!"));
			driver.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
			driver.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	// Passos Fazer login usuario
	
	@Given ("^Abrir tela de login$")
	public void abrirTelaLogin() {
		driver.findElement(By.linkText("Sign in")).click();
	}
	
	@Given ("^Preencher login de usuario$")
	public void preencherLoginUsuario() {
		driver.findElement(By.cssSelector(".row:nth-child(3) > .s6:nth-child(1) > .validate")).sendKeys("login_15@email.com");
	}
	
	@Given ("^Preencher senha do usuario$")
	public void preencherSenhaUsuario() {
		driver.findElement(By.cssSelector(".row:nth-child(3) > .input-field:nth-child(2) > .validate")).sendKeys("S3nh@");
	}
	
	@When ("^Clicar no botao signin$")
	public void clicarBotaoSignIn() {
	    driver.findElement(By.cssSelector("#signinbox .modal-action")).click();
	}
	
	@Then ("^Confirmar login com sucesso$")
	public void confirmarLoginSucesso() {

		try {
		    Thread.sleep(2000);
		    assertThat(driver.findElement(By.linkText("Logout")).getText(), is("Logout"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	}
	
	// Passos Visualizar listagem de Tarefas
	
    @Then ("^Abrir tela de tarefas$")
    public void abrirTelaTarefas() {
    	driver.findElement(By.cssSelector(".waves-light")).click();
    }
    
    // Passos para Criar Tarefa
    
    // 1o- Abrir a tela de listagem de tarefas acima
    
    @Given ("^Clicar no botão de nova tarefa$")
    public void clicarBotaoNovaTarefa() {
    	driver.findElement(By.cssSelector(".waves-light")).click();
    }
    
    @Given ("^Preencher titulo da tarefa$") 
    public void preencherTituloTarefa() {
    	driver.findElement(By.name("title")).sendKeys("Titulo da Tarefa");
    }
    
    @Given ("ˆSelecionar uma data limite$")
    public void selecionarDataLimite() {
    	js.executeScript("window.scrollTo(0,0)");
        {
          WebElement element = driver.findElement(By.cssSelector(".picker__holder"));
          Actions builder = new Actions(driver);
          builder.moveToElement(element).release().perform();
        }
        driver.findElement(By.cssSelector(".picker__today")).click();
        driver.findElement(By.cssSelector(".picker__close")).click();
    }
    
    @Given ("^Selecionar uma hora limite$")
    public void selecionarHoraLimite() {
    	driver.findElement(By.name("time")).click();
        driver.findElement(By.cssSelector(".clockpicker-tick:nth-child(21)")).click();
        driver.findElement(By.cssSelector(".clockpicker-minutes > .clockpicker-tick:nth-child(11)")).click();
        driver.findElement(By.cssSelector(".clockpicker .btn-flat:nth-child(3)")).click();
    }
    
    @Given ("^Preencher uma descricao da tarefa$")
    public void preencherDescricaoTarefa() {
    	driver.findElement(By.name("text")).sendKeys("Descrição da tarefa");
    }
    
    @Given ("^Informar a situacao da tarefa$")
    public void informarSituacaoTarefa() {
    	driver.findElement(By.name("done")).click();
    }
    
    @Then ("^Criar tarefa$")
    public void criarTarefa() {
    	driver.findElement(By.cssSelector(".modal-action")).click();
    }
    
}
