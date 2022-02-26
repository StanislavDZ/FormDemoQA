package test.parametrizedtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParameterizedTestPagesWikiSelenide {

    @BeforeEach
    void precondition() {
        open("https://github.com/selenide/selenide/wiki");
    }
    @AfterEach
    void closerBrowser() {
        closeWebDriver();
    }
    @ValueSource(strings = {
            "Home",
            "Build script",
            "Custom conditions",
            "Do not use getters in tests",
            "How Selenide creates WebDriver",
            "How to run the browser in MobileEmulation mode",
            "Lazy loading",
            "Ports of Selenide",
            "Quick Start",
            "Safari",
            "Selenide Roadmap",
            "Selenide Roadmap 2020",
            "Selenide vs Selenium",
            "slf4j",
            "Snippets",
            "SoftAssertions"}
    )
    @ParameterizedTest(name = "Интерфейсная проверка меню Pages - Wiki (Git-Selenide) {13}")

    void checkPagesTest(String checkPages) {
        $("#wiki-pages-box").$(".js-wiki-more-pages-link").click();                                            //Разворачиваем список дополнительных меню
        $("#wiki-pages-box").shouldHave(text(checkPages)).$(byText(checkPages)).click();
        $("#wiki-wrapper").shouldHave(text(checkPages));
    }
}
