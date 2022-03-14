package test.lesson8qaguru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DNDTestTo8lesson {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void testDragNDrop() {
        open("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b")).$("header").shouldHave(text("B"));
        $("#column-b").$("header").shouldHave(text("A")); sleep(5000);
    }
}
//commit 1.1
//commit 2.2
//commit 3
