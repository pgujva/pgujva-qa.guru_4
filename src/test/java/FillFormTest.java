import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class FillFormTest extends TestBase{

  @Test
  void successfulFillTest() {
    Faker faker = new Faker();
    goToPracticeForm();
    String name = faker.name().firstName();
    String lastname =  faker.name().lastName();
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
    submitForm();
    asserts(name, lastname);

  }

}
