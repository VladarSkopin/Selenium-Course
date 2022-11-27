import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class Main {

    @Test
    public void testGoogleSearch() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.google.com/");
        driver.navigate().to("https://www.google.com/"); // THE SAME RESULT

        String window1 = driver.getWindowHandle(); // get window ID
        System.out.println(window1);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("weather Moscow");
        searchBox.submit();

        Thread.sleep(5000);

        driver.quit();

    }

    @Test
    public void testGoogleSearch2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get("https://selenium.dev");

        Thread.sleep(3000);

        driver.switchTo().window(tabs.get(0));

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("pounds to kilograms");
        searchBox.submit();

        Thread.sleep(5000);

        driver.quit();
    }
}

