package org.DariaRuabinina.steps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.DariaRyabinina.Less28Obj;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Less28Steps {


    @Допустим("переход Авто.ру")
    public void go_to_auto_ru() {
        open("https://www.auto.ru/");
        getWebDriver().manage().window().maximize();
    }

    @И("закрыть рекламное окно")
    public void close_Window() {
        Less28Obj less28Obj = new Less28Obj();
        less28Obj.closewindow();
    }

    @Когда("проверка титула {string}")
    public void verify_title(String nameTitle) {
        Less28Obj less28Obj = new Less28Obj();
        System.out.println(less28Obj.getTitle());
        Assert.assertTrue(less28Obj.getTitle().contains(nameTitle), "Титул содержит текст");
    }

    @Тогда("сохранение количества объявлений производителя {string}")
    public void save_namber_manuf(String nameManuf) {
        Less28Obj less28Obj = new Less28Obj();
        less28Obj.saveNamberManuf(nameManuf);
    }


    @Допустим("перехода на страницу {string}")
    public void go_to_Manuf(String nameManuf) {
        Less28Obj less28Obj = new Less28Obj();
        less28Obj.goToManuf(nameManuf);
    }

    @Допустим("сравнение количества объявлений")
    public void compare_namber() {
        Less28Obj less28Obj = new Less28Obj();
        less28Obj.compareNambe();
    }

    @Допустим("сохранение количества объявлений марки {string}")
    public void save_namber_model(String nameModel) {
        Less28Obj less28Obj = new Less28Obj();
        less28Obj.saveNamberModel(nameModel);
    }

    @Допустим("переход на стараницу {string}")
    public void go_to_Model(String nameModel) {
        Less28Obj less28Obj = new Less28Obj();
        less28Obj.goToModel(nameModel);
    }

}


