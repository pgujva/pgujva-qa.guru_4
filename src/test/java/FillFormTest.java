import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class FillFormTest {
  @BeforeAll
  static void setup() {
    Configuration.startMaximized = true;
  }

  @Test
  void successfulFillTest() {
    Configuration.timeout = 2000;
    //go to page
    open("https://demoqa.com/automation-practice-form");
    $("#firstName").setValue("pasha");
    $("#lastName").setValue("gujva");
    $("#userEmail").setValue("test@mail.ru");
    $("#genterWrapper").find(byText("Male")).click();
    $("#userNumber").setValue("8904442222");

    //календарь
    $("#dateOfBirthInput").click();
    // выбор месяца
    $(".react-datepicker__month-select").selectOption("July");
    // выбор года
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption("1991");
    // выбор дня
    $(".react-datepicker__day.react-datepicker__day--017").click();

    $("#subjectsContainer input").setValue("te").pressEnter();
    $(byText("Reading")).click();
    // загрузка файла
    $("#uploadPicture").uploadFile(new File("resources/_GihpfJgTSU.jpeg"));
    $("#currentAddress").setValue("5555");
    $("#state").click();
    $(byText("Uttar Pradesh")).click();
    $("#city").click();
    $(byText("Lucknow")).click();
    $("#submit").click();
    $$(".table-responsive tr" ).filterBy(text("Student name")).shouldHave(texts("pasha " + "gujva"));
    $$(".table-responsive tr" ).filterBy(text("Student Email")).shouldHave(texts("test@mail.ru"));
  }
}
