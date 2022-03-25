import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conexao {


    public static WebDriver driver;


    public static WebDriver setUp(String navegador) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (navegador.contains("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://portal.meusdividendos.com/login");
        } else {
            System.out.println("Connection was failed");
        }


        return driver;
    }


    public static void main(String[]args) throws Exception {
        setUp("chrome");
    }
}
