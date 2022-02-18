package test;


import com.codeborne.selenide.Configuration;

import java.io.File;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstJunitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FormRun() {
        // Открываем страничку формы:
        open("automation-practice-form");

        //Заполняем форму регистрационными данными:
        $("#firstName").setValue("Stanislav");
        $("#lastName").setValue("Zaychenko");
        $("#userEmail").setValue("Ashestodust@yandex.ru");
        $(byText("Male")).click(); //заметка на будущее, попробовать через Xpath
        //$("#gender-radio-1").click();
        $("#userNumber").setValue("9147851961");
        $("#dateOfBirthInput").sendKeys( Keys.CONTROL,"a");
        $("#dateOfBirthInput").sendKeys( "13 apr 1987", Keys.ENTER);
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#subjectsInput").setValue("Ar").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/pic.png"));
        $("#currentAddress").setValue("Taxes, BestCh.St 17");
        $("#submit").scrollTo();
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        //Проверяем заполнение формы
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Stanislav Zaychenko"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Ashestodust@yandex.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9147851961"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("13 April,1987"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Computer Science, Arts"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports, Reading, Music"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("pic.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Taxes, BestCh.St 17"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        $(byText("Close")).click();
    }
}

