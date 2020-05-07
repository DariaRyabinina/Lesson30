package org.DariaRyabinina.steps;

import io.cucumber.java.ru.*;
import org.DariaRyabinina.AutoRuPageLess28;
import org.DariaRyabinina.config.ConfigReader;
import org.DariaRyabinina.config.PropertiesConfigReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AutoRuStepsLess28 {
    private ConfigReader configReader = new PropertiesConfigReader();
    private AutoRuPageLess28 less28ObjAutoRu = new AutoRuPageLess28();
    public static final Logger LOGG = LoggerFactory.getLogger(SpbBankStepsLess25.class);

    @Дано("переход Авто.ру")
    public void goToAutoRuStep() {
        LOGG.info("Проверка, наличия поля Моих средств");
        open(configReader.getValue("auto.url"));
        getWebDriver().manage().window().maximize();
    }

    @И("закрыть рекламное окно")
    public void closeWindowStep() {

        less28ObjAutoRu.closewindow();
    }

    @Когда("проверка титула {string}")
    public void verifyTitleStep(String nameTitle) {
        LOGG.info("Проверка титула");

        Assert.assertTrue(less28ObjAutoRu.getTitle().contains(nameTitle), "Титул не содержит текст" + nameTitle);
    }

    @Тогда("сохранение количества объявлений производителя {string}")
    public void saveNamberMmanufStep(String nameManuf) {
        LOGG.info("Сохранение количество объявлений произвоителя");
        less28ObjAutoRu.saveNamberManuf(nameManuf);
    }

    @Допустим("перехода на страницу {string}")
    public void goToManufStep(String nameManuf) {
        LOGG.info("Переход на страницу Произвоителя");
        less28ObjAutoRu.goToManuf(nameManuf);
    }

    @Допустим("сравнение количества объявлений")
    public void compareNamberStep() {
        LOGG.info("Сравнение количествва объявлений");
        less28ObjAutoRu.compareNambe();
    }

    @Допустим("сохранение количества объявлений марки {string}")
    public void saveNamberModelStep(String nameModel) {
        LOGG.info("Сохранение количество объявлений марки");
        less28ObjAutoRu.saveNamberModel(nameModel);
    }

    @Допустим("переход на стараницу {string}")
    public void goToModelStep(String nameModel) {
        LOGG.info("Переход на страницу Марки");
        less28ObjAutoRu.goToModel(nameModel);
    }

}
