package com.saulleyva.automation.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test; 



public class LoginTest {
	
	@Test
	public void abrirNavegador() { 

		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		
		String tituloObtenido = driver.getTitle();
		String tituloEsperado = "Swag Labs";
		
		Assert.assertEquals(tituloObtenido, tituloEsperado);
		driver.navigate().to("https://www.selenium.dev/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
		driver.quit();
	} 
	
	@Test
	public void localizarElementoPorId() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement usuario = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		usuario.sendKeys("standard_user");
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("user-name")).clear();
		driver.quit();	
	}
	@Test
	public void localizarElementoPorName() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.name("user-name")).sendKeys("error_user");
		driver.quit();
		
	}
	
	@Test
	public void  localizarElementoPorClassName() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.className("input_error")).sendKeys("locked_out_user");
		driver.quit();
	}
	
	@Test
	public void localizarElementoPorTagName() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.tagName("input")).sendKeys("performance_glitch_user");
		driver.quit();
	}
	@Test
	public void localizarElementoPorLinkText() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.linkText("Visit Conference Website for more information!")).click();
		driver.quit();
	}
	@Test
	public void localizarElementoPorPartialLinkText() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.findElement(By.partialLinkText("Visit Conference Website for")).click();
		driver.quit();
	}
	@Test
	public void localizarElementoPorCssSelector() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.cssSelector("#user-name")).sendKeys("problem_user");
		driver.quit();
		
	}
	@Test
	public void localizarElementosPorXpath() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("visual_user");
		//documentar como sacar el xpath
		driver.quit();
	}
	@Test
	public void enviarMetodoSubmit() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).submit();
		driver.quit();
		
	}
	@Test
	public void obtenerTitulo() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		System.out.println(driver.findElement(By.className("login_logo")).getText());
		driver.quit();
		
	}
	@Test
	public void getAtribute() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		String valor = driver.findElement(By.id("user-name")).getAttribute("placeholder");
		System.out.println("El valor de getAttribute es: " + valor);
		driver.quit();
		
		}
	@Test
	public void compararConAssertEquals() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		String tituloEsperado = "Swag Labs";
		String tituloObtenido = driver.getTitle();
		Assert.assertEquals(tituloEsperado, tituloObtenido);
		System.out.println("El título esperado es "+tituloEsperado);
		System.out.println("El título obtenido es "+tituloObtenido);
		driver.quit();
	}
	@Test
	public void assertCondicionalVerdadera() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"), "No fue posible iniciar sesión.");
		System.out.println(driver.getCurrentUrl().contains("saucedemo"));
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}
	@Test
	public void assertConticionalFalsa() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		Assert.assertFalse(driver.getCurrentUrl().contains("ddddddddddddddd"), "El título es correcto");
		driver.quit();
	}
	@Test
	public void automatizarLoginIngreso() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.quit();
	}
	@Test
	public void validarTitulo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		String tituloPrincipal = driver.getTitle();
		String tituloParaComparar = "Swag Labs";
		Assert.assertEquals(tituloPrincipal, tituloParaComparar);
		System.out.println("Este es el título actual: "+tituloPrincipal);
		driver.quit();
		
		}
	@Test	
	public void agregarProducto() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
		carrito.click();
		driver.quit();
		
	}
	@Test
	public void eliminarProducto() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
		carrito.click();
		WebElement eliminar = wait.until(ExpectedConditions.elementToBeClickable(By.id("remove-sauce-labs-backpack")));
		eliminar.click();
		driver.quit();
	}
	@Test
	public void carritoDeCompras() {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement compras = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
		compras.click();
		WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
		carrito.click();
		driver.quit();
		
	}
	@Test
	public void checkOutCarrito() {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement compras = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
		compras.click();
		WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
		carrito.click();
		WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
		checkOut.click();
		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("first-name")));
		firstName.sendKeys("primer nombre");
		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.id("last-name")));
		lastName.sendKeys("mis apellidos");
		WebElement zipCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("postal-code")));
		zipCode.sendKeys("123456");
		driver.findElement(By.id("continue")).click();
		driver.quit();
	}
	@Test
	public void finalizarCompra() {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement compras = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
		compras.click();
		WebElement carrito = wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
		carrito.click();
		WebElement checkOut = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
		checkOut.click();
		WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("first-name")));
		firstName.sendKeys("uno");
		WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.id("last-name")));
		lastName.sendKeys("segundo");
		WebElement zipCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("postal-code")));
		zipCode.sendKeys("66666");
		driver.findElement(By.id("continue")).click();
		WebElement finalizarCompra = wait.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
		finalizarCompra.click();
		driver.quit();
		
	}
}