import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {

  @BeforeAll
  static void setup() {
    goToPracticeForm();
    Configuration.startMaximized = true;
  }

  public static void goToPracticeForm() {
    open("https://demoqa.com/automation-practice-form");
  }

  protected void asserts() {
    $$(".table-responsive tr" ).filterBy(text("Student name")).shouldHave(texts("pasha " + "gujva"));
    $$(".table-responsive tr" ).filterBy(text("Student Email")).shouldHave(texts("test@mail.ru"));
  }

  protected void fillTestForm(PracticeFormData practiceFormData) {
    $("#firstName").setValue(practiceFormData.getName());
    $("#lastName").setValue(practiceFormData.getLastname());
    $("#userEmail").setValue(practiceFormData.getEmail());
    $("#genterWrapper").find(byText(practiceFormData.getGender())).click();
    $("#userNumber").setValue(practiceFormData.getPhone());
    //календарь
    $("#dateOfBirthInput").clear();
    $(".react-datepicker__month-select").selectOption(practiceFormData.getMonth());
    $(".react-datepicker__year-select").selectOption(practiceFormData.getYear());
    $(".react-datepicker__day.react-datepicker__day--017").click();
    // set subject
    $("#subjectsContainer input").setValue(practiceFormData.getSubject()).pressEnter();
    $(byText(practiceFormData.getHobby())).click();
    // загрузка файла
    $("#uploadPicture").uploadFromClasspath("test1.jpg");
    $("#currentAddress").setValue(practiceFormData.getAddress());
    $("#state").click();
    $(byText(practiceFormData.getState())).click();
    $("#city").click();
    $(byText(practiceFormData.getCity())).click();
  }

  protected void submitForm() {
    $("#submit").click();
  }
}
