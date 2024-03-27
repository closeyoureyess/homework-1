package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String titleText = "Student Registration Form";
    private SelenideElement
            lastNameInput = $("#lastName"),
            firstNameInput = $("#firstName"),
            emailInput = $("#userEmail");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        Selenide.executeJavaScript("$('fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value){
        firstNameInput.setValue(value);
    }

    public void setLastName(String value){
        lastNameInput.setValue("Egorov");
    }

    public void clearName(String value) {
        lastNameInput.clear();
    }

    public void setEmail(String value) {

        emailInput.setValue(value);
    }

}
