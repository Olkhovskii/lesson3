import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class NewTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";

    }



    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Andrew");
        $("#lastName").setValue("Olkhovskii");
        $("#userEmail").setValue("test@email.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999777654");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day--017:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.png");
        $("#currentAddress").setValue("Russia");
        $("#submit").scrollTo();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
        $("#submit").click();
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Andrew Olkhovskii"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@email.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8999777654"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("17 August,1990"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Commerce"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Russia"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}


