package junit;


import com.codeborne.selenide.Configuration;

import java.io.File;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SecondJunitTest {

    //Заводим переменную с типом RegistrationPage, зыы то же что AS
    RegistrationPage rp = new RegistrationPage();


    //выносим тестовые данные
    String firstName = "Stanislav";
    String lastName = "Zaychenko";
    String userEmail = "Ashestodust@yandex.ru";
    String genterWrapper = "Male";
    String userNumber = "9147851961";
    //String day = "13";
    //String month = "April";
    //String year = "1987";
    String date;
    String subj1 = "Computer Science";
    String subj2 = "Arts";
    String hobbie = "Reading"; //вернуть массив на место! переделать проверку после изучения доп материалов
    File foto = new File("src/test/resources/pic.png");
    String userAdress = "Taxes, BestCh.St 17";
    String userState = "NCR";
    String userCity = "Delhi";
    String subimtForm = "Submit";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void FormRun() {
        // Открываем страничку формы:
        rp.openPage()
                    .setFirstName(firstName) //Заполняем форму регистрационными данными:
                    .setLastName(lastName)
                    .userEmailName(userEmail)
                    .userGender(genterWrapper)
                    .userNumberName(userNumber)
                    //.setDate(day, month, year) //ошибка при таком подходе..
                    .setSubjectsInput(subj1, subj2)
                    .userHobbiesInput(hobbie)
                    .uploadFile(foto)
                    .userAddressInput(userAdress)
                    .userStateInput(userState)
                    .userCityInput(userCity)
                    .setDate(date);//rp.setDate(day, month, year);  //rp.setDate("13", "May", "1987");


        rp.submitPut(subimtForm);

        //Проверяем заполнение формы
                rp
                .checkForm("Student Name", firstName + " " + lastName)
                .checkForm("Student Email", userEmail)
                .checkForm("Gender", genterWrapper)
                .checkForm("Mobile", userNumber)
                .checkForm("Date of Birth", "13 April,1987")
                .checkForm("Subjects", subj1)
                .checkForm("Hobbies", hobbie)
                .checkForm("Address", userAdress)
                .checkForm("State and City",  userState+ " " +userCity);
    }
}

