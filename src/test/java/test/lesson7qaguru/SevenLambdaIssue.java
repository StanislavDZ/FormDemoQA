package test.lesson7qaguru;

import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
        import static com.codeborne.selenide.Selenide.$;
        import static com.codeborne.selenide.Selenide.open;
        import static io.qameta.allure.Allure.step;

        public class SevenLambdaIssue {

        private static final String URL = "/StanislavDZ/FormDemoQA1";

        @Test
        void SevenLambdaIssue(){

        step("Open home page", () -> {
        open("https://github.com");
        });
        step("Ищем репозиторий через Гит-поиск" + URL, () -> {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(URL + Keys.ENTER);
        });
        step("Opening the repository " + URL, () -> {
        $(By.linkText("StanislavDZ/FormDemoQA1")).click();
        });
        step("Проверяем наличие меню Issue", () -> {
        $("#issues-tab").should(text("issues"));
        });

        }
        }