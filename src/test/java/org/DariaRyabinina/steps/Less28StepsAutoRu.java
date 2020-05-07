package org.DariaRyabinina.steps;

import io.cucumber.java.ru.*;
import org.DariaRyabinina.Less28ObjAutoRu;
import org.DariaRyabinina.config.ConfigReader;
import org.DariaRyabinina.config.PropertiesConfigReader;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Less28StepsAutoRu {
    private ConfigReader configReader = new PropertiesConfigReader();
    private Less28ObjAutoRu less28ObjAutoRu = new Less28ObjAutoRu();


    @Дано("переход Авто.ру")
    public void goToAutoRuStep() {
        open(configReader.getValue("auto.url"));
        getWebDriver().manage().window().maximize();
    }

    @И("закрыть рекламное окно")
    public void closeWindowStep() {
        less28ObjAutoRu.closewindow();
    }

    @Когда("проверка титула {string}")
    public void verifyTitleStep(String nameTitle) {

        System.out.println(less28ObjAutoRu.getTitle());
        Assert.assertTrue(less28ObjAutoRu.getTitle().contains(nameTitle), "Титул не содержит текст"+nameTitle);
    }

    @Тогда("сохранение количества объявлений производителя {string}")
    public void saveNamberMmanufStep(String nameManuf) {

        less28ObjAutoRu.saveNamberManuf(nameManuf);
    }

    @Допустим("перехода на страницу {string}")
    public void goToManufStep(String nameManuf) {

        less28ObjAutoRu.goToManuf(nameManuf);
    }

    @Допустим("сравнение количества объявлений")
    public void compareNamberStep() {

        less28ObjAutoRu.compareNambe();
    }

    @Допустим("сохранение количества объявлений марки {string}")
    public void saveNamberModelStep(String nameModel) {

        less28ObjAutoRu.saveNamberModel(nameModel);
    }

    @Допустим("переход на стараницу {string}")
    public void goToModelStep(String nameModel) {

        less28ObjAutoRu.goToModel(nameModel);
    }

}
