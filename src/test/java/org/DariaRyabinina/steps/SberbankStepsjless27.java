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
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class SberbankStepsjless27 {
    public static final Logger LOGG = LoggerFactory.getLogger(SberbankStepsjless27.class);
    private ConfigReader configReader = new PropertiesConfigReader();
    protected SberankPageLess27 SberbankPageless27 = new SberankPageLess27();

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
        SberbankPageless27.movCursor(nameMenu);
        SberbankPageless27.goToMenu("Вклады");
        LOGG.info("Выполнен переход на вкладку {}", nameMenu);
    }

    @Допустим("выполнен переход на меню \"Подобрать вклад\"")
    public void goToMenuVklad1() {
        SberbankPageless27.openMenuVklad();
        LOGG.info("Выполнен переход на меню \"Подобрать вклад\"");

    }

    @Допустим("проверка отображения чек-боксов")
    public void verifyCheckBox1(List<String> checkBoxList) {
        SberbankPageless27.visibleCheckBox(checkBoxList);

    }

    @Допустим("проверка чек-бокса «Онлайн»")
    public void selectedOnline1() {
        boolean selectedOnline = $(byXpath("//div[text()='Онлайн']/preceding-sibling::input")).isSelected();
        Assert.assertTrue(selectedOnline, "Чек бокс \"Онлайн\" не отмечен");
    }

    @Допустим("проверка отражения вкладов")
    public void verefyVklad1(List<String> vkladList) {
        if (SberbankPageless27.checkVisibleVklad(vkladList)) {
            LOGG.info("Вклад совпадает");
        } else {
            LOGG.info("Вклад не совпадает");
        }
    }

    @Допустим("установка чек-боксов")
    public void enterCheckBox1(List<String> entrChecBoxValue) {
        SberbankPageless27.enterCheckBox(entrChecBoxValue);

    }

    @Допустим("проверка отображения вкладов Отсутствуют")
    public void verefyVkladDel1(List<String> vkladListDel) {
        SberbankPageless27.visibleVkladDel(vkladListDel);
    }

    @Допустим("нажать кнопку Подробнее")
    public void entrButton() {
        $(byXpath("//span[text()='Подробнее']")).click();

    }

    @Допустим("проверка надписи {string}")
    public void verefyValue1(String vkladName) {
        Assert.assertTrue(SberbankPageless27.getVkladByName(vkladName),"Вклад не соотвтетствует ожидаемому");
    }

    @Допустим("переключение на новое окно")
    public void swichToWindow1() throws InterruptedException {
        switchTo().window(1);
        Thread.sleep(5000);


    }
}
