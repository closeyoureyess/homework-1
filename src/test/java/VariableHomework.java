import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VariableHomework {
    @Test
    void myTest() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("QATest");
        $("#userEmail").setValue("work.qa@mail.ru");

        //Выбор пола

//        $("[for=gender-radio-2]").click(); //okay
//        $(byName("gender")).selectRadio("Female"); // okay(2)
//        $("genterWrapper").$(byText("Other")).click(); //okay
        $("#gender-radio-2").parent().click();
        
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        //Это лишнее $("[class=react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select]").click();
        $(".react-datepicker__month-select")
                .selectOptionByValue("4");
        $(".react-datepicker__year-select")
                .selectOptionByValue("2000");
        $(".react-datepicker__day--030").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").setValue("Physics");
        //pressEnter, либо клик через реакт
        $("#react-select-2-option-0").click();
        //$(byText("Music")).click();
        $("[for=hobbies-checkbox-3]").click();
        //
        $("#uploadPicture").uploadFile(new File("C:\\Users\\vadim\\Downloads\\meow.txt"));
        //
        $("#currentAddress").setValue("New-York, Down East-Side");
        //
        $("div#state").click();
        $("#react-select-3-option-2").click();
        //
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

    }
}
