import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProceedToCheckout {
    private  WebDriver driver;
    @Before
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test");
    }
    @Test
    public void proceedToCheckout() {

        driver.findElement(By.cssSelector("a.skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title*='Log']")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("sebastian.rgs@hotmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("IronMaiden1");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("A TALE OF TWO CITIES");
        driver.findElement(By.cssSelector("button.search-button")).click();
        driver.findElement(By.cssSelector("#product-collection-image-448")).click();
        driver.findElement(By.cssSelector("label[for='links_20']")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button > span > span")).click();
        WebElement helloMessage = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-right-layout > div > div.col-main > div.page-title"));
        Assert.assertTrue(helloMessage.isDisplayed());
        String message = helloMessage.getText();
        Assert.assertEquals("CHECKOUT",message);
    }
    @After
    public void close() {
        driver.close();
    }
}
