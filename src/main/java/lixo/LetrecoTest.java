package lixo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.List;

public class LetrecoTest {


    WebDriver driver;

    private List<String> setLetraErradas(List<String> erradas) {
        List<String> error = new ArrayList<>();
        return erradas;
    }

    private List<String> getLetrasCorretas(List<WebElement> element) {
        List<String> letrasCertas = new ArrayList<>();
        List<String> letrasErradas = new ArrayList<>();

        for (WebElement elemento : element) {
            elemento.getText();
            String cor = elemento.getCssValue("background-color");
            String corhexa = Color.fromString(cor).asHex();

            if (corhexa.contains("#c79c2e")) {
                System.out.println(elemento.getText());
                letrasCertas.add(elemento.getText());
            } else {
                if (corhexa.contains("#943e3c")) {
                    LetrasErradas letrasErradas1 = new LetrasErradas();
                    letrasErradas.add(elemento.getText());
                    letrasErradas1.setLetras(letrasErradas);

                    setLetraErradas(letrasErradas);

                }
            }
        }
        return letrasCertas;
    }

    //    @Test()
    public void preencheLetreco() throws Exception {

        //driver = Conexao.setUp("chrome");

        List<WebElement> elements = new ArrayList<>();
        WebElement r = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/button[4]"));
        WebElement e = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/button[3]"));
        WebElement s = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/button[2]"));
        WebElement m = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/button[7]"));
        WebElement a = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/button[1]"));
        WebElement check = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/button[2]"));

        elements.add(r);
        elements.add(e);
        elements.add(s);
        elements.add(m);
        elements.add(a);

        String cr = r.getCssValue("background-color");
        String ce = e.getCssValue("background-color");
        String cs = s.getCssValue("background-color");
        String cm = m.getCssValue("background-color");
        String ca = a.getCssValue("background-color");

        String hr = Color.fromString(cr).asHex();
        String he = Color.fromString(ce).asHex();
        String hs = Color.fromString(cs).asHex();
        String hm = Color.fromString(cm).asHex();
        String ha = Color.fromString(ca).asHex();

        List<String> colors = new ArrayList<>();
        colors.add(hr);
        colors.add(he);
        colors.add(hs);
        colors.add(hm);
        colors.add(ha);

        r.click();
        e.click();
        s.click();
        m.click();
        a.click();
        check.click();

        driver.close();
    }
}
