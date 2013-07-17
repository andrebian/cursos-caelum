package selenium;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteAutomatizado {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","/opt/selenium-resources/chromedriver"); 
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///home/andre/Desktop/form.html");
		
		NovoLeilaoPage leilao = new NovoLeilaoPage(driver);
		leilao.preenche("Filmadora teste", 250.00, "Andre", true);
		
	}
	
}
