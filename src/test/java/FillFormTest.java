import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class FillFormTest extends TestBase{

  @Test
  void successfulFillTest() {
    goToPracticeForm();
    $("#firstName").setValue("pasha");
    $("#lastName").setValue("gujva");
    $("#userEmail").setValue("test@mail.ru");
    $("#genterWrapper").find(byText("Male")).click();
    $("#userNumber").setValue("8904442222");
    //календарь
    $("#dateOfBirthInput").clear();
    $(".react-datepicker__month-select").selectOption("July");
    $(".react-datepicker__year-select").selectOption("1991");
    $(".react-datepicker__day.react-datepicker__day--017").click();
    // set subject
    $("#subjectsContainer input").setValue("te").pressEnter();
    $(byText("Reading")).click();
    // загрузка файла
    $("#uploadPicture").uploadFromClasspath("test1.jpg");
    $("#currentAddress").setValue("5555");
    $("#state").click();
    $(byText("Uttar Pradesh")).click();
    $("#city").click();
    $(byText("Lucknow")).click();
    submitForm();
    $$(".table-responsive tr" ).filterBy(text("Student name")).shouldHave(texts("pasha " + "gujva"));
    $$(".table-responsive tr" ).filterBy(text("Student Email")).shouldHave(texts("test@mail.ru"));
  }

  private void submitForm() {
    $("#submit").click();
  }

}
