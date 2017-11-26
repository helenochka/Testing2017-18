import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


abstract class GoogleSearch {
     static Map searching(String request, String company, int strart, int end){
        if ((strart >= end && end != 1) || strart <= 0 || end < 1) return null;
        String exePath = "c:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";
        String startURL = "https://www.google.com.ua";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        Map res = new HashMap();

        String XPath_search_string_Google = "//*[@id=\"lst-ib\"]";
        try {
            driver.get(startURL);
            driver.findElement(By.xpath(XPath_search_string_Google)).sendKeys(request + " \n");

            WebElement nextPage = driver.findElement(By.id("pnnext"));
            int i = 1;
            while (nextPage.isDisplayed() && (i < end || end == 1)){
                if (nextPage.isDisplayed() && i >= strart) {
                    for (WebElement iter : driver.findElements(By.xpath("//*[@id=\"rso\"]/div/div/div/div/div/h3/a")))
                        if (iter.getText().toUpperCase().contains(company.toUpperCase())){
                            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                            res.put(i, screenshot);
                            return res;
                        }
                    nextPage.click();
                }
                i++;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            driver.close();
        }
        return null;
    }
}
