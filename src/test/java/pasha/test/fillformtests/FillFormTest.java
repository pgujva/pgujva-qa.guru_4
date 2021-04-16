package pasha.test.fillformtests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class FillFormTest extends TestBase{

  @Test
  void successfulFillTest() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String lastname = faker.name().lastName();
    step("Заполняем форму", () -> {
      fillTestForm(new PracticeFormData(
              name,
              lastname,
              "test@mail.ru",
              "Male",
              "8904442222",
              "July",
              "1991",
              "English",
              "Reading",
              "5555",
              "Uttar Pradesh",
              "Lucknow"));
    });
    step("подтверждение формы", () -> {
      submitForm();
    });
    step("проверяем,что данные в таблице верные", () -> {
      asserts(name, lastname);
    });

  }

}
