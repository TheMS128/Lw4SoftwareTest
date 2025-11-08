package enums;

import lombok.Getter;

@Getter
public enum Locators {

    CART_BUTTONS("//a[@aria-label=\"Add to cart\"]"),
    KEEP_BROWSING_BUTTON("//button[@data-controller=\"modal-commander\"]"),
    ACCEPT_ALL_BUTTON("//button[text()=\"Accept all\"]"),
    SHOP_CART_BUTTON("//span/a[@id=\"cart-link-desktop\"]"),
    SHOPPING_CART_ENTITY("//article[@class=\"shopping-cart__entry\"]");

    private final String locator;

    Locators(String locator) {
        this.locator = locator;
    }
}
