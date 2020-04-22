package org.DariaRuabinina.steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class Less25Steps {
    @Дано("Пользователь авторизуется в bspb")
    public void пользователь_авторизуется_в_bspb() {
        open("https://idemo.bspb.ru/");
    }


    @Дано("Входит на поле очищает и вставляет Логин/Пароль {string}")
    public void входит_на_поле_Логин_очищает_и_вставляет_Логин(String value) {
        SelenideElement loginFiled = $(byName("username"));
        loginFiled.clear();
        loginFiled.setValue(value);
    }

    @Когда("нажимает кнопку Войти")
    public void нажимает_кнопку_Войти() {
        $(byId("login-button")).click();
    }

    @Тогда("впереход на ЭФ Ввод кода")
    public void впереход_на_ЭФ_Ввод_кода() {
        SelenideElement addCode = $(byId("otp-code"));
        addCode.isDisplayed();
    }

    @Дано("Введение кода")
    public void введение_кода() {
        $(byId("otp-code")).setValue("0000");
    }

    @Когда("Нажать на кнопку Войти")
    public void нажать_на_кнопку_Войти() {
        $(byId("login-otp-button")).click();
    }

    @Тогда("Переход на ЭФ Welcome")
    public void Переход_на_ЭФ_Welcome() {
        $(byId("bank-overview")).isDisplayed();

    }

    @Когда("Нажать на кнопку Oбзор")
    public void нажать_на_кнопку_Oбзор() {
        $(byId("bank-overview")).click();
    }

    @Тогда("Переход на ЭФ Обзор")
    public void переход_на_ЭФ_Обзор() {
        Selenide.title().equals("Обзор -  Интернет банк - Банк Санкт-Петербург");

    }

    @Тогда("Название соответствует Обзор")
    public void название_соответствует_Обзор() {
        String namePage = $(byXpath("//@id[.='header-container']/following::h1[1]")).getText();
        namePage = namePage.replaceAll("[^(а-яёА-ЯЁ)]", "");
        namePage.equals("Обзор");
    }

    @Тогда("Название блока Финансовая свобода")
    public void название_блока_Финансовая_свобода() {
        $(byXpath("//@id[.='can-spend'][1]/following::span[1]")).shouldHave(text("Финансовая свобода"));
    }

    @Тогда("Проверка, сумма соответствует формату")
    public void проверка_сумма_соответствует_формату() {
        String sumMoney = $(byXpath("//span[@class='amount-holder']/span[@class='amount']")).getText().trim();
        boolean mach = sumMoney.matches("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.");
        Assert.assertTrue(mach);
    }

    @Когда("Перейти мышкой на поле Суммы")
    public void перейти_мышкой_на_поле_Суммы() {
        Actions action = new Actions(getWebDriver());
        action.moveToElement($(byXpath("//span[@class='amount-holder']/span[@class='amount']"))).build().perform();
    }

    @Тогда("Проверка, наличия поля Моих средств")
    public void проверка_наличия_поля_Моих_средств() {
        String myMoney = $(By.xpath("//small[@class='my-assets']")).getText();
        myMoney = myMoney.replaceAll("[^(а-яёА-ЯЁ), ]", "").trim();
        Assert.assertEquals(myMoney, "Моих средств");
    }

    @Тогда("Проверка, сумма моих средств соответствует формату")
    public void проверка_сумма_моих_средств_соответствует_формату() {
        String mySumMoney = $(By.xpath("//small[@class='my-assets']")).getText();
        mySumMoney = mySumMoney.replaceAll("Моих средств", "").trim();

        boolean mach = mySumMoney.matches("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{2}\\s.");
        Assert.assertTrue(mach);
    }

}
