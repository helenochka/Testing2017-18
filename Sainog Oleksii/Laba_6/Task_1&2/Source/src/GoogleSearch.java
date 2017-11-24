import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

abstract class GoogleSearch {
     static List<String> searching(String request, int strart, int end){
        if (strart >= end || strart < 0 || end < 1) return new ArrayList<>();
        String exePath = "c:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
        String startURL = "https://www.google.com.ua";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        List<String> webElements = new ArrayList<>();

        String XPath_search_string_Google = "//*[@id=\"lst-ib\"]";
        try {
            driver.get(startURL);
            driver.findElement(By.xpath(XPath_search_string_Google)).sendKeys(request + " \n");

            WebElement nextPage = driver.findElement(By.id("pnnext"));
            for (int i =0; i < end; i++)
                if (nextPage.isDisplayed() && i >= strart) {
                    for (WebElement iter : driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/h3/a")))
                        webElements.add(iter.getText());
                    nextPage.click();
                }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            driver.close();
        }
        return webElements;
    }
}
