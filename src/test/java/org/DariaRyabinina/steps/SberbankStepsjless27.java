package org.DariaRyabinina.steps;

import com.codeborne.selenide.Selenide;

import io.cucumber.java.ru.Допустим;
import org.DariaRyabinina.SberankPageLess27;
import org.DariaRyabinina.config.ConfigReader;
import org.DariaRyabinina.config.PropertiesConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class SberbankStepsjless27 {
    public static final Logger LOGG = LoggerFactory.getLogger(SberbankStepsjless27.class);
    private ConfigReader configReader = new PropertiesConfigReader();
    protected SberankPageLess27 less27ObjSber = new SberankPageLess27();

    @Допустим("выполнен переход на https: www_sberbank")
    public void goToHttpsWwwSberbank() {
        open(configReader.getValue("sber.url"));
        getWebDriver().manage().window().maximize();


    }

    @Допустим("проверка названия титула {string}")
    public void verifyTitle(String nameTitle) {
        LOGG.info("Титул страницы {}", Selenide.title());
        Assert.assertEquals(Selenide.title(), nameTitle, "Титул не содержит наименования \"Сбербанк\"");
    }


    @Допустим("выполнен переход на вкладку {string}")
    public void goTo1(String nameMenu) {
        less27ObjSber.movCursor(nameMenu);
        less27ObjSber.goToMenu("Вклады");
        LOGG.info("Выполнен переход на вкладку {}", nameMenu);
    }

    @Допустим("выполнен переход на меню \"Подобрать вклад\"")
    public void goToMenuVklad1() {
        less27ObjSber.openMenuVklad();
        LOGG.info("Выполнен переход на меню \"Подобрать вклад\"");

    }

    @Допустим("проверка отображения чек-боксов")
    public void verifyCheckBox1(List<String> checkBoxList) {
        less27ObjSber.visibleCheckBox(checkBoxList);

    }

    @Допустим("проверка чек-бокса «Онлайн»")
    public void selectedOnline1() {
        boolean selectedOnline = $(byXpath("//div[text()='Онлайн']/preceding-sibling::input")).isSelected();
        Assert.assertTrue(selectedOnline, "Чек бокс \"Онлайн\" не отмечен");
    }

    @Допустим("проверка отражения вкладов")
    public void verefyVklad1(List<String> vkladList) {
        if (less27ObjSber.checkVisibleVklad(vkladList)) {
            LOGG.info("Вклад совпадает");
        } else {
            LOGG.info("Вклад не совпадает");
        }
    }

    @Допустим("установка чек-боксов")
    public void enterCheckBox1(List<String> entrChecBoxValue) {
        less27ObjSber.enterCheckBox(entrChecBoxValue);

    }

    @Допустим("проверка отображения вкладов Отсутствуют")
    public void verefyVkladDel1(List<String> vkladListDel) {
        less27ObjSber.visibleVkladDel(vkladListDel);
    }

    @Допустим("нажать кнопку Подробнее")
    public void entrButton() {
        $(byXpath("//span[text()='Подробнее']")).click();

    }

    @Допустим("проверка надписи Вклад Управляй.")
    public void verefyValue1() {
        less27ObjSber.verefyValue();
    }

    @Допустим("переключение на новое окно")
    public void swichToWindow1() {
        Selenide.switchTo().window(1);

    }
}
