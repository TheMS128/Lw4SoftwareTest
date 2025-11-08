package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import steps.MainPageStep;

import static enums.Locators.CART_BUTTONS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SeleniumTests {
    MainPageStep mainPageStep = new MainPageStep();

    @BeforeEach
    void setUp() {
        mainPageStep.openSite("https://themeforest.net/category/site-templates/retail/shopping?term=demo");
    }

    @Test
    void repeatedTest() {
        int expectedSize = mainPageStep.addAllElementAndClickAndTakeExpectedResultCartSize(CART_BUTTONS);
        int actualSize = mainPageStep.getShoppingCartEntitySize();

        assertThat(expectedSize).isEqualTo(actualSize);
    }

    @AfterEach
    void tearDown() {
        mainPageStep.closeSite();
    }
}