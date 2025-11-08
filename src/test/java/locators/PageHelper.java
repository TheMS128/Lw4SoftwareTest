package locators;

import enums.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static enums.Locators.KEEP_BROWSING_BUTTON;

public class PageHelper {

    ChromeDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void getSiteUrl(String url) {
        driver.get(url);
    }

    public void quitSiteUrl() {
        driver.quit();
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void scrollOnTopAndClickElementToElement(WebElement element) {
        JavascriptExecutor js = driver;
        js.executeScript("window.scrollTo(0, 0);");
        js.executeScript("arguments[0].click();", element);
    }

    public List<WebElement> findElements(Locators locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator.getLocator())));
    }

    public WebElement findElement(Locators locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator.getLocator())));
    }

    public void clickCartElements(List<WebElement> clickableObjects) {
        clickableObjects.forEach(clickableObject -> {
            clickOnElement(clickableObject);
            clickOnElement(findElement(KEEP_BROWSING_BUTTON));
        });
    }
}
