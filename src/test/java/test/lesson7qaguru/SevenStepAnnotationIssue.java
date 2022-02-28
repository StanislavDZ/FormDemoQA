package test.lesson7qaguru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SevenStepAnnotationIssue {
    @Test
    void SevenStepAnnotationIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть главную страницу GitHub", () -> {
            open("https://github.com");
        });
        step("Заполнить поле Поиск данными", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("/StanislavDZ/FormDemoQA1");
        });
        step("Нажать кнопку Поиск", () -> {
            $(".header-search-input").submit();
        });
        step("Проверить, что на открывшейся странице есть кнопка Issues", () -> {
            $(By.partialLinkText("Issues")).should(Condition.exist);
        });
        closeWebDriver();
    }
}