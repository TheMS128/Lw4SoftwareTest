package steps;

import enums.Locators;
import io.qameta.allure.Step;
import locators.PageHelper;
import org.openqa.selenium.WebElement;

import java.util.List;

import static enums.Locators.*;

public class MainPageStep {

    PageHelper mainPageLocator = new PageHelper();

    @Step
    public void openSite(String url) {
        mainPageLocator.getSiteUrl(url);
        mainPageLocator.clickOnElement(
                mainPageLocator.findElement(ACCEPT_ALL_BUTTON)
        );
    }

    @Step
    public void closeSite() {
        mainPageLocator.quitSiteUrl();
    }

    @Step
    public int addAllElementAndClickAndTakeExpectedResultCartSize(Locators locator) {
        List<WebElement> elements = mainPageLocator.findElements(locator);
        mainPageLocator.clickCartElements(elements);
        return elements.size();
    }

    @Step
    public int getShoppingCartEntitySize() {
        WebElement cartButton = mainPageLocator.findElement(SHOP_CART_BUTTON);
        mainPageLocator.scrollOnTopAndClickElementToElement(cartButton);
        return mainPageLocator.findElements(SHOPPING_CART_ENTITY).size();
    }
}
