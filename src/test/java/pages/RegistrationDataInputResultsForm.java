package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationDataInputResultsForm {

    public void verifyResultsFormAppear(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

    public void checkData(String label, String value){
        $(".table-responsive").$(byText(label)).closest("tr").shouldHave(text(value));
    }
}
