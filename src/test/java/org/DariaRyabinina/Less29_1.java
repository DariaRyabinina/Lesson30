package org.DariaRyabinina;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.DariaRyabinina.config.ConfigReader;
import org.DariaRyabinina.config.PropertiesConfigReader;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature",
        glue = "org.DariaRyabinina.steps",
        tags = "@allTests"
)

public class Less29_1 extends AbstractTestNGCucumberTests {
    private ConfigReader configReader = new PropertiesConfigReader();

    @BeforeMethod
    public void initDriver() {


        Configuration.browser = configReader.getValue("browser");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
    }
}