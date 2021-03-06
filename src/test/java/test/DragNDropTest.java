package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

    public class DragNDropTest {

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
