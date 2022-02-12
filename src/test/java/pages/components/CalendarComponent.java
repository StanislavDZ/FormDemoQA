package pages.components;

import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void dateInput(String date) {
        //$("#dateOfBirthInput").sendKeys( Keys.CONTROL,"a");
        //$("react-datepicker__month-select").selectOption(month);
        //$("react-datepicker__year-select").selectOption(year);
        //$(".react-datepicker__day--0" + day + "").click()
        //$("[aria-label$='" + month + " " + day + "th, " + year + "']").click();
        $("#dateOfBirthInput").sendKeys( Keys.CONTROL,"a");
        $("#dateOfBirthInput").sendKeys( "13 apr 1987", Keys.ENTER);

    }
}
