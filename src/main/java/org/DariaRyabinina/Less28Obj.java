package org.DariaRyabinina;

import com.codeborne.selenide.Selenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class Less28Obj {

    public static String namberАnnoun;
    public static final Logger LOGG = LoggerFactory.getLogger(Less28Obj.class);


    public String getTitle() {
        return Selenide.title();
    }

    public void saveNamberManuf(String nameManuf) {
        namberАnnoun = $(byXpath("//div[text()='" + nameManuf + "']/following-sibling::div")).getText();
        LOGG.info("Сохраненное количество объявлений производителя {} - {}", nameManuf, namberАnnoun);

    }

    public void closewindow() {
        if ($(byXpath("//html/body/div[3]//div[1]//a[2]/span")).isDisplayed()) {
            $(byXpath("//html/body/div[3]//div[1]//a[2]/span")).click();
        } else {
            System.out.println("Рекламное окно отсутствует");
        }
    }

    public void goToManuf(String nameManuf) {
        $(byXpath("//div[text()='" + nameManuf + "']//parent::a")).click();
        LOGG.info("Переход на форму производителя {}", nameManuf);

    }

    public void compareNambe() {
        String namberOnButton = ($(byCssSelector("span.ButtonWithLoader__content")).getText()).replaceAll("[^(0-9)]", "");
        LOGG.info("Сравнение количества объявлений {} - {}", namberOnButton, namberАnnoun);
        Assert.assertEquals(namberOnButton, namberАnnoun);

    }

    public void saveNamberModel(String nameModel) {
        namberАnnoun = $(byXpath("//*[@id=\"popularMMM\"]//div[a='" + nameModel + "']/div")).getText();
        LOGG.info("Сохраненное количество объявлений модели {} - {}", nameModel, namberАnnoun);
    }

    public void goToModel(String nameModel) {
        $(byXpath("//a[text()='" + nameModel + "']")).click();
        LOGG.info("Переход на форму марки {}", nameModel);
    }

}