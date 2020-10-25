package test.demoqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import test.demoqa.helpers.WaitHelpers;

public class ElementsTextBoxTest {

  private WebDriver driver;

   @Before
    public void setUp() throws Exception {
       openLinkAndMaximize();
   }

   @Test
   public void textBoxShouldAcceptStringAndSubmit() throws Exception {
       WaitHelpers.waitForVisibilityOfElementLocatedBy(By.cssSelector("[class='main-header']"), driver);
       stringInput("userName", "Jak Kowalski");
       stringInput("userEmail", "jan_kowalski@op.pl");
       stringInput("currentAddress", "ul. Miła 17 00-2019 Warszawa");
       stringInput("permanentAddress", "ul. Zła 69 66-666 Sosnowiec");
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,300)", "");
       button("submit");

   }

    private void stringInput(String id, String dataInput) {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(dataInput);
    }
    private void button(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.click();
    }




    private void openLinkAndMaximize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @After
    public void tearDown() {

       driver.close();
    }
}

