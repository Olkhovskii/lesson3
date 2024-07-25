
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class NewTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.pageLoadStrategy = "eager";
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()"); 
    }

    private static void executeJavaScript(String s) {
    }

    @Test
    void fillFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Andrew");
        $("#lastName").setValue("Olkhovskii");
        $("#userEmail").setValue("test@email.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999777654");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Architecture");
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Russia");
        $("div").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
        $("tbody > tr:nth-child(1) > td:nth-child(2)").shouldHave(text("Andrew Olkhovskii"));
        $("tr:nth-child(2) > td:nth-child(2)").shouldHave(text("test@email.com"));
        $("tbody > tr:nth-child(3) > td:nth-child(2)").shouldHave(text("Male"));
        $("tbody > tr:nth-child(4) > td:nth-child(2)").shouldHave(text("8999777654"));
        $("tbody > tr:nth-child(5) > td:nth-child(2)").shouldHave(text("17 August,1990"));
        $("tbody > tr:nth-child(7) > td:nth-child(2)").shouldHave(text("Sports"));
        $("tbody > tr:nth-child(8) > td:nth-child(2)").shouldHave(text("1.png"));
        $("tbody > tr:nth-child(9) > td:nth-child(2)").shouldHave(text("Russia"));
        $("tbody > tr:nth-child(10) > td:nth-child(2)").shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}
