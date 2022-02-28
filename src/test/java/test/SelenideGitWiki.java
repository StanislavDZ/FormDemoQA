package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideGitWiki {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void checkSoftAssertion() {
        open("/");                                                                                             //Открыть Github
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();                          //Осуществить поиск selenide и перейти на страницу поиска
        $$(".repo-list li").first().$("a").click();                                                            //Открываем первую ссылку в списке по запросу Selenide
        $("#repository-container-header").shouldHave(text("Wiki"));                                            //Проверяем наличие Wiki на странице
        $("#wiki-tab").click();                                                                                //Перейдите в раздел Wiki проекта
        $("#wiki-pages-box").$(".js-wiki-more-pages-link").click();                                            //Разворачиваем список дополнительных меню
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).$(byText("SoftAssertions")).click();           //Проверяем наличие SoftAssertions и сразу переходим на страницу
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));                               //Проверяем наличие примера JUnit5
    }
}
