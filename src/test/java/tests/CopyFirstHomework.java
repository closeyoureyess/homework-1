package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CopyFirstHomework {

    @Test
    void myTest() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        String userName = "Vadim";
        String userLastName = "QATest";

        open("https://demoqa.com/automation-practice-form");

        Selenide.executeJavaScript("$('fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue("work.qa@mail.ru");
//        $("[for=gender-radio-2]").click(); //okay
//        $(byName("gender")).selectRadio("Female"); // okay(2)
        $("#gender-radio-2").parent().click();
        $("#userNumber").setValue("8800555353");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select")
                .selectOptionByValue("4");
        $(".react-datepicker__year-select")
                .selectOptionByValue("2000");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
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

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text(userLastName), text("work.qa@mail.ru"), text("Female"),
                text("8800555353"), text("30 May,2000"), text("Physics"), text("Music"), text("meow.txt"), text("New-York, Down East-Side"),
                text("Haryana Panipat"));

        $("div.modal-footer button").click();

    }
}
}
