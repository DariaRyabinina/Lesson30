package org.DariaRuabinina;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature",
        glue = "org.DariaRyabinina.steps",
        tags = "@less25"
)

public class Less29_1 extends AbstractTestNGCucumberTests {
    @BeforeMethod
    public void initDriver() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}