import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $("#dateOfBirthInput").clear();

        Thread.sleep(15000);

        $("#dateOfBirthInput").setValue("19 May 2000")
                .pressEnter();
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").uploadFile(new File("C:\\Users\\vadim\\Downloads meow.txt"));



    }
}
