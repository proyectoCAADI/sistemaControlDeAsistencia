
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaInicioSesionIT {

    private static WebDriver driver = null;
    
    public PruebaInicioSesionIT() {
    }
    
    @BeforeClass
    public static void inicializarDriver() {
        System.setProperty("webdriver.chrome.driver", "C://Users//ltino//Desktop//chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();
    }
    
    @AfterClass
    public static void liquidarDriver() {
        driver.quit();
    }

    @Test
    public void comprobarInicioSesion() {
        driver.get("http://localhost:8080/CaadiMigrate/");
        
        WebElement textInicioSesion = driver.findElement(By.id("formulario:j_idt36"));
        textInicioSesion.sendKeys("143424");
        
        WebElement btnInicioSesion = driver.findElement(By.id("formulario:j_idt38"));
        btnInicioSesion.click();
        
        WebElement btnConfirmar = driver.findElement(By.id("j_idt20"));
        btnConfirmar.click();        
        
        WebElement btnConfirmar2 = driver.findElement(By.id("j_idt23"));
        btnConfirmar2.click();
    }
    
}
