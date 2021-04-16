package pasha.test.fillformtests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pasha.test.fillformtests.PracticeFormData;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBase {

  @BeforeAll

  static void setup() {

    Configuration.startMaximized = true;

    goToPracticeForm();
 
  }

  public static void goToPracticeForm() {
    open("https://demoqa.com/automation-practice-form");
  }

  protected void asserts(String name, String lastname) {
    $$(".table-responsive tr").filterBy(text("Student name")).shouldHave(texts(name + " " + lastname));
    $$(".table-responsive tr").filterBy(text("Student Email")).shouldHave(texts("test@mail1.ru"));
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
    loadPicture();
    $("#currentAddress").setValue(practiceFormData.getAddress());
    $("#state").click();
    $(byText(practiceFormData.getState())).click();
    $("#city").click();
    $(byText(practiceFormData.getCity())).click();
  }

  public void loadPicture() {
    $("#uploadPicture").uploadFromClasspath("test1.jpg");
  }

  protected void submitForm() {
    $("#submit").click();
  }
}
