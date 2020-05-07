package org.DariaRyabinina;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Less27ObjSber {
    public static final Logger LOGG = LoggerFactory.getLogger(Less27ObjSber.class);

    public void movementСursor(String nameMenu) {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement($(byXpath("//span[text()='" + nameMenu + "']"))).build().perform();
       }

    public void goToMenu(String nameMenu) {
        LOGG.info("Переход на меню " + $(byXpath("//a[@class='lg-menu__sub-link' and text()='" + nameMenu + "']")).waitUntil(Condition.visible, 3000).getText());
        $(byXpath("//a[@class='lg-menu__sub-link' and text()='" + nameMenu + "']")).waitUntil(Condition.visible, 5000).doubleClick();
    }

    public void goToMenuVklad(String nameMenu) {

        List<SelenideElement> listMenuVklad = $$(byCssSelector("li.tabs-container__tab"));
        listMenuVklad.get(1).doubleClick();

        $(byCssSelector(".cookie-warning__close")).waitUntil(Condition.visible, 3000).click();
    }

    public void visibleCheckBox(List<String> checkBoxList) {

        List<String> valueCheckBoxStr = new ArrayList<String>();

        Selenide.switchTo().frame("iFrameResizer0");
        List<SelenideElement> checkBox = $$(byCssSelector(".kitt-checkbox__text"));
        for (SelenideElement valueCheckBox : checkBox) {

            valueCheckBoxStr.add(valueCheckBox.getText());
        }

        if (!valueCheckBoxStr.containsAll(checkBoxList)) {
            Assert.fail("Чек боксы не совпадают");
        } else System.out.println("Чек боксы совпадают");
    }

    public boolean visibleVklad(List<String> VkladList) {

        List<SelenideElement> vklad = $$(byCssSelector("h3.offered-products__header"));
        List<String> valueVkladStr = new ArrayList<>();

        for (SelenideElement valueCheckBox : vklad) {
            valueVkladStr.add(valueCheckBox.getText());
        }

        if (!valueVkladStr.containsAll(VkladList)) {
           return false;
        } else {
            return true;
        }
    }

    public void visibleVkladDel(List<String> VkladListDel) {

        List<SelenideElement> vklad = $$(byCssSelector("h3.offered-products__header"));
        List<String> valuevkladStr = new ArrayList<>();
        for (SelenideElement valueCheckBox : vklad) {
            valuevkladStr.add(valueCheckBox.getText());
        }

        if (valuevkladStr.containsAll(VkladListDel)) {
            Assert.fail("Вклады не совпадают");
        } else {
            System.out.println("Вклады совпадают");
        }

    }


    public void enterCheckBox(List<String> entrChecBoxValue) {
        for (String entrbChecBox : entrChecBoxValue) {
            $(byXpath("//div[text()='" + entrbChecBox + "']/preceding-sibling::div")).waitUntil(Condition.visible, 3000).click();
        }
    }

    public void verefyValue() {
        $(byXpath("//div[@class='kit-col kit-col_xs_0 kit-col_md_6 kit-col_lg_0 kit-col_md-bottom_10 kit-col_md-top_0']//h2")).getText().equals("Вклад Управляй");
    }
}