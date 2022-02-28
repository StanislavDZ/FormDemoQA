package test.lesson7qaguru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class SevenListenerSelenideIssue {

    @Test
    void SevenListenerSelenideIssue(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        //Открыть Гитхаб
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("/StanislavDZ/FormDemoQA1");
        $(".header-search-input").submit();
        $(By.linkText("StanislavDZ/FormDemoQA1")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("Issues")).should(Condition.exist);

        closeWebDriver();

    }
}