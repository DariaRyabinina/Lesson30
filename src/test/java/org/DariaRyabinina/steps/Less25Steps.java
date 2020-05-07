package org.DariaRyabinina.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.DariaRyabinina.Less28ObjAutoRu;
import org.DariaRyabinina.config.ConfigReader;
import org.DariaRyabinina.config.PropertiesConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Less25Steps {
    private ConfigReader configReader = new PropertiesConfigReader();
    private static final String formatManey = "\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.";
    public static final Logger LOGG = LoggerFactory.getLogger(Less28ObjAutoRu.class);

    @Дано("Пользователь авторизуется в bspb")
    public void openBspbSteps() {
        LOGG.info("Пользователь авторизуется в bspb");
        open(configReader.getValue("bspb.url"));
    }


    @Дано("Входит на поле очищает и вставляет Логин/Пароль {string}")
    public void addLoginPasswordSteps(String value) {
        SelenideElement loginFiled = $(byName("username"));
        loginFiled.clear();
        loginFiled.setValue(configReader.getValue(value));
    }

    @Когда("нажимает кнопку Войти")
    public void pushEnterButtonSteps() {
        $(byId("login-button")).click();
    }

    @Тогда("впереход на ЭФ Ввод кода")
    public void goToEnterCodeForm() {
        LOGG.info("Пользователь выполняет впереход на ЭФ Ввод кода");
        SelenideElement addCode = $(byId("otp-code"));
        addCode.isDisplayed();
    }

    @Дано("Введение кода")
    public void enterCode() {
        LOGG.info("Пользователь вводит код");
        $(byId("otp-code")).setValue("0000");
    }

    @Когда("Нажать на кнопку Войти")
    public void pushEnterButtonCodeSteps() {
        $(byId("login-otp-button")).click();
    }

    @Тогда("Переход на ЭФ Welcome")
    public void goToWelcome() {
        LOGG.info("Пользователь выполнил переход на ЭФ Welcome");
        $(byId("bank-overview")).isDisplayed();

    }

    @Когда("Нажать на кнопку Oбзор")
    public void pushEnterButtonReview() {
        LOGG.info("Пользователь нажимает кнопку Oбзор");
        $(byId("bank-overview")).click();
    }

    @Тогда("Переход на ЭФ Обзор")
    public void goToReview() {
        LOGG.info("Пользователь выполнил переход на ЭФ Обзор -  Интернет банк - Банк Санкт-Петербург");
        Selenide.title().equals("Обзор -  Интернет банк - Банк Санкт-Петербург");

    }

    @Тогда("Название соответствует Обзор")
    public void verifiReview() {
        String namePage = $(byXpath("//@id[.='header-container']/following::h1[1]")).getText();
        namePage = namePage.replaceAll("[^(а-яёА-ЯЁ)]", "");
        namePage.equals("Обзор");
    }

    @Тогда("Название блока Финансовая свобода")
    public void verefiTitleFinFreedom() {
        LOGG.info("Анализ поля Финансовая свобода");
       $(byXpath("//@id[.='can-spend'][1]/following::span[1]")).shouldHave(text("Финансовая свобода"));
    }

    @Тогда("Проверка, сумма соответствует формату")
    public void verifiSumFormat() {
        LOGG.info("Проверка, сумма соответствует формату");
        String sumMoney = $(byXpath("//span[@class='amount-holder']/span[@class='amount']")).getText().trim();
        boolean mach = sumMoney.matches(formatManey);
        Assert.assertTrue(mach, "Формат не совпадает");
    }

    @Когда("Перейти мышкой на поле Суммы")
    public void goToSum() {
        LOGG.info("Пользователь наводит мышкой на поле Суммы");
        Actions action = new Actions(getWebDriver());
        action.moveToElement($(byXpath("//span[@class='amount-holder']/span[@class='amount']"))).build().perform();
    }

    @Тогда("Проверка, наличия поля Моих средств")
    public void verifiMyMoney() {
        LOGG.info("Проверка, наличия поля Моих средств");
        String myMoney = $(By.xpath("//small[@class='my-assets']")).waitUntil(Condition.visible, 5000).getText();
        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        Assert.assertEquals(myMoney, "Моих средств", "Поле называется не \"Моих средств\"");
    }

    @Тогда("Проверка, сумма моих средств соответствует формату")
    public void verifiMyMoneyFormat() {
        LOGG.info("Проверка, сумма моих средств соответствует формату");
        String mySumMoney = $(By.xpath("//small[@class='my-assets']")).getText();
        mySumMoney = mySumMoney.replaceAll("Моих средств", "").trim();

        boolean mach = mySumMoney.matches(formatManey);
        Assert.assertTrue(mach, "Формат не совпадает");
    }

}
