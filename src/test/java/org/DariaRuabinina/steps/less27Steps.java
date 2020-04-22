package org.DariaRuabinina.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;
import org.DariaRyabinina.Less27Obj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class less27Steps {
    public static final Logger LOGG = LoggerFactory.getLogger(less27Steps.class);

    @Допустим("выполнен переход на https: www_sberbank")
    public void go_to_https_www_sberbank() {
        open("https://www.sberbank.ru/");
        getWebDriver().manage().window().maximize();


    }

    @Допустим("проверка названия титула {string}")
    public void verify_Title(String nameTitle) {
        Less27Obj less27Obj = new Less27Obj();
        boolean a = less27Obj.getTitle(nameTitle);
        System.out.println(a);
        if (!a) {
            Assert.fail();
        }
    }

    @Допустим("выполнен переход на вкладку {string}")
    public void go_to_(String nameMenu) {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.movement_cursor(nameMenu);
        less27Obj.goToMenu("Вклады");
    }

    @Допустим("выполнен переход на меню {string}")
    public void go_to_menu_Vklad(String nameMenu) {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.go_to_menu_vklad(nameMenu);

    }

    @Допустим("проверка отображения чек-боксов")
    public void verify_Check_box(List<String> checkBoxList) {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.visibleCheckBox(checkBoxList);

    }

    @Допустим("проверка чек-бокса «Онлайн»")
    public void selected_Online() {
        boolean selectedOnline = $(byXpath("//div[text()='Онлайн']/preceding-sibling::input")).isSelected();
        Assert.assertTrue(selectedOnline);
    }

    @Допустим("проверка отражения вкладов")
    public void verefy_Vklad(List<String> vkladList) {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.visibleVklad(vkladList);

    }


    @Допустим("установка чек-боксов")
    public void enter_Check_Box(List<String> entrChecBoxValue) {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.enterCheckBox(entrChecBoxValue);


    }

    @Допустим("проверка отображения вкладов Отсутствуют")
    public void verefy_vklad_del(List<String> vkladListDel) {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.visibleVkladDel(vkladListDel);
    }

    @Допустим("нажать кнопку Подробнее")
    public void entr_button() {
        $(byXpath("//span[text()='Подробнее']")).click();
    }

    @Допустим("проверка надписи Вклад Управляй.")
    public void проверка_надписи_Вклад_Управляй() {
        Less27Obj less27Obj = new Less27Obj();
        less27Obj.verefyValue();
    }

    @Допустим("переключение на новое окно")
    public void swich_to_window() {
        Selenide.switchTo().window(1);
    }
}


