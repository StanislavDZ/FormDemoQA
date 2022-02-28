package test.lesson6qaguru;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParamPagesWikiSelenide {

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
    @ParameterizedTest(name = "Interface check Pages - Wiki (Git-Selenide) \"{0}\"")
    void checkPagesTest(String checkPages) {
        $("#wiki-pages-box").$(".js-wiki-more-pages-link").click();                                            //Разворачиваем список дополнительных меню
        $("#wiki-pages-box").shouldHave(text(checkPages)).$(byText(checkPages)).click();
        $("#wiki-wrapper").shouldHave(text(checkPages));
    }

    @CsvSource(value = {
            "Home | Chapters",
            "Build script | Gradle",
            "Custom conditions | Moving",
            "Do not use getters in tests | The good",
            "How Selenide creates WebDriver | How to get WebDriver",
            "How to run the browser in MobileEmulation mode | Implement a WebDriverProvider:",
            "Lazy loading | What is lazy loading?",
            "Ports of Selenide | There are several ports of Selenide created by our friends:",
            "Quick Start | For Gradle users:",
            "Safari | Setup",
            "Selenide Roadmap | Preface",
            "Selenide Roadmap 2020 | Preface",
            "Selenide vs Selenium | Keynote",
            "slf4j | Easy solution:",
            "Snippets | Concise API",
            "SoftAssertions | How to soft assert using Selenide"
    },
            delimiter = '|'
    )

    @ParameterizedTest(name = "Interface check Pages Wiki (Git-Selenide) Includes \"{0}\"")
    void compliteCheckPagesTest(String checkPages, String checkIncludes) {
        $("#wiki-pages-box").$(".js-wiki-more-pages-link").click();                                            //Разворачиваем список дополнительных меню
        $("#wiki-pages-box").shouldHave(text(checkPages)).$(byText(checkPages)).click();
        $("#wiki-wrapper").shouldHave(text(checkPages)).shouldHave(text(checkIncludes));

    }

    static Stream<Arguments> mixedArgumensInterfaceCheck() {
        return Stream.of(
                Arguments.of("Home", "Chapters"),
                Arguments.of("Build script", "Gradle"),
                Arguments.of("Custom conditions", "Moving"),
                Arguments.of("Do not use getters in tests", "The good"));
    }

    @MethodSource(value = "mixedArgumensInterfaceCheck")
    @ParameterizedTest(name = "Interface check Pages  Wiki (Git-Selenide) Includes \"{0}\"")
    void mixedArgumensInterfaceCheck(String firstArg, String secondArg) {
        System.out.println("Title:" + firstArg + "Includes:" + secondArg);
        sleep(5000);
    }

}
