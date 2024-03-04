import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyFirstHomework {

    @Test
    void myTest() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("QATest");
        $("#userEmail").setValue("work.qa@mail.ru");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("+78005553535");
        $("#dateOfBirthInput").click();
        //Это лишнее $("[class=react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select]").click();
        $(".react-datepicker__month-select")
                .selectOptionByValue("4");
        $(".react-datepicker__year-select")
                .selectOptionByValue("2000");
        $(".react-datepicker__day--019").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").setValue("Physics");
        //pressEnter, либо клик через реакт
        $("#react-select-2-option-0").click();



    }
}
