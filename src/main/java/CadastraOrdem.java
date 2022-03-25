import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.io.BufferedReader;

import java.io.FileReader;


public class CadastraOrdem {

    WebDriver driver;

    public void espera(Long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fazLogin() throws Exception {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ng_flow_input_email\"]"));

        String user = JOptionPane.showInputDialog("Usuário", null);
        String password = JOptionPane.showInputDialog("Senha", null);

        element.sendKeys(user);

        WebElement pass = driver.findElement(By.xpath("//*[@id=\"ng_flow_input_pass\"]"));
        pass.sendKeys(password);

        driver.findElement(By.xpath("/html/body/main/section/div[2]/form/div[3]/div[2]/button")).click();
        espera(2000L);

    }

    private WebElement getElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    private void enviaOrdem(String data, String tipo, String ativo, String preco, String quantidade) {

        espera(1500L);

        getElementByXpath("//*[@id=\"input-data\"]").click();
        getElementByXpath("//*[@id=\"input-data\"]").clear();
        getElementByXpath("//*[@id=\"input-data\"]").sendKeys(data);

        //quant
        getElementByXpath("//*[@id=\"input-quantidade\"]").sendKeys(quantidade);

        //price
        getElementByXpath("//*[@id=\"modal-cadastro-ordem\"]/div/div/div[2]/form/div[2]/div[3]/div/input").sendKeys(preco);

        getElementByXpath("//*[@id=\"modal-cadastro-ordem\"]/div/div/div[2]/form/div[1]/div/div/div/div/input").sendKeys(ativo);
        espera(4000L);

        getElementByXpath("//*[@id=\"modal-cadastro-ordem\"]/div/div/div[2]/form/div[1]/div/div/div/div/input").sendKeys(Keys.ENTER);
        espera(4000L);

        //save order
        getElementByXpath("//*[@id=\"modal-cadastro-ordem\"]/div/div/div[3]/button[3]").click();
        espera(3000L);

        getElementByXpath("//*[@id=\"modal-cadastro-ordem\"]/div/div/div[3]/button[2]").click();

    }

    @Before
    public void set() throws Exception {
        driver = Conexao.setUp("chrome");
        fazLogin();
        getElementByXpath("/html/body/div[2]/div/div/div/div[1]/div[1]/div/div/div[3]/div/div/button[2]").click();
    }

    @Test
    public void buffer(){

        try (BufferedReader br = new BufferedReader(new FileReader("PATH CSV"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(";");
                String data = columns[0];
                String tipo = columns[1];
                String cod = columns[2];
                String quant = columns[3];
                String preco = columns[4];
                enviaOrdem(data, tipo, cod, preco, quant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
