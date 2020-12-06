import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddToCartTest {
    @Test
    public void addedToCart(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://oz.by");
        driver.findElement(By.id("top-s")).sendKeys("10764941");
        driver.findElement(By.className("top-panel__search__btn")).click();
        WebElement addToCartButton = new WebDriverWait(driver, 10)
        .until(ExpectedConditions.presenceOfElementLocated(By.className("i-button__text")));
        addToCartButton.click();
        String resultValue = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/a"))).getText();
        Assert.assertEquals(resultValue, "Уже в корзине");
        driver.quit();
    }
}
