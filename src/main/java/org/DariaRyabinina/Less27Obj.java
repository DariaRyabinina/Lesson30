package org.DariaRyabinina;

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


public class Less27Obj {
    public static final Logger LOGG = LoggerFactory.getLogger(Less27Obj.class);

    public boolean getTitle(String nameTitle) {
        System.out.println( Selenide.title() + "  |  " +nameTitle);
        return Selenide.title().equals(nameTitle);
    }

    public void movement_cursor(String nameMenu) {
        Actions actions = new Actions(getWebDriver());
        LOGG.info($(byXpath("//span[text()='" + nameMenu + "']")).getText());
        actions.moveToElement($(byXpath("//span[text()='" + nameMenu + "']"))).build().perform();

    }

    public void goToMenu(String nameMenu) {
        LOGG.info($(byXpath("//a[@class='lg-menu__sub-link' and text()='" + nameMenu + "']")).getText());
        $(byXpath("//a[@class='lg-menu__sub-link' and text()='" + nameMenu + "']")).doubleClick();
    }

    public void go_to_menu_vklad(String nameMenu) {

        List<SelenideElement> listMenuVklad = $$(byCssSelector("li.tabs-container__tab"));
        listMenuVklad.get(1).doubleClick();

        $(byCssSelector(".cookie-warning__close")).click();
    }

    public void visibleCheckBox(List<String> checkBoxList) {

        List<String> valueCheckBoxStr = new ArrayList<String>();

        Selenide.switchTo().frame("iFrameResizer0");
        List<SelenideElement> checkBox = $$(byCssSelector(".kitt-checkbox__text"));
        System.out.println(checkBox.size());
        for (SelenideElement valueCheckBox : checkBox) {
            System.out.println(valueCheckBox.getText());
            valueCheckBoxStr.add(valueCheckBox.getText());
        }

        if (!valueCheckBoxStr.containsAll(checkBoxList)) {
            Assert.fail("Чек боксы не совпадают");
        } else System.out.println("Чек боксы совпадают");
    }

    public void visibleVklad(List<String> VkladList) {
        System.out.println("---------------------");
        List<SelenideElement> vklad = $$(byCssSelector("h3.offered-products__header"));
        List<String> valuevkladStr = new ArrayList<>();
        System.out.println(vklad.size());
        for (SelenideElement valueCheckBox : vklad) {
            System.out.println(valueCheckBox.getText());
            valuevkladStr.add(valueCheckBox.getText());
        }

        if (!valuevkladStr.containsAll(VkladList)) {
            Assert.fail("Вклады не совпадают");
        } else {
            System.out.println("Вклады совпадают");
        }

    }

    public void visibleVkladDel(List<String> VkladListDel) {
        System.out.println("---------------------2");
        List<SelenideElement> vklad = $$(byCssSelector("h3.offered-products__header"));
        List<String> valuevkladStr = new ArrayList<>();
        for (SelenideElement valueCheckBox : vklad) {
            System.out.println(valueCheckBox.getText());
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
            $(byXpath("//div[text()='" + entrbChecBox + "']/preceding-sibling::div")).click();
        }
    }

    public void verefyValue() {
        $(byXpath("//div[@class='kit-col kit-col_xs_0 kit-col_md_6 kit-col_lg_0 kit-col_md-bottom_10 kit-col_md-top_0']//h2")).getText().equals("Вклад Управляй");
    }
}