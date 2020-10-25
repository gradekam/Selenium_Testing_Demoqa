package test.demoqa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
       fullNameInput();
//       driver = new ChromeDriver();



   }

    private void fullNameInput() {
        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Jak Kowalski");
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

