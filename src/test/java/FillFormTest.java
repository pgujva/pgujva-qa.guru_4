import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class FillFormTest extends TestBase{

  @Test
  void successfulFillTest() {
    goToPracticeForm();
    fillTestForm(new PracticeFormData("pasha",
            "gujva",
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
    asserts();
  }

}
