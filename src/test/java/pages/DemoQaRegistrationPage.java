package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import testsData.States;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaRegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationDataInputResultsForm registrationDataInputResultsForm = new RegistrationDataInputResultsForm();
    File file = new File("src/test/resources/хомяк.png");
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNaneInput = $("#lastName"),
            emailInput = $("#userEmail"),
            phoneNumberInput = $("#userNumber"),
            addressInput = $("#currentAddress");

    public DemoQaRegistrationPage openRegistrationPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public DemoQaRegistrationPage inputFirstName(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    public DemoQaRegistrationPage inputLastName(String lastName){
        lastNaneInput.setValue(lastName);
        return this;
    }

    public DemoQaRegistrationPage setGender(){
        $("label[for='gender-radio-1']").click();
        return this;
    }

    public DemoQaRegistrationPage inputPhoneNumber(String phoneNumber){
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public DemoQaRegistrationPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setBDate(day, month, year);
        return this;
    }

    public DemoQaRegistrationPage inputEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public DemoQaRegistrationPage setSubjects(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public DemoQaRegistrationPage setHobbies(){
        $("label[for='hobbies-checkbox-3']").click();
        $("label[for='hobbies-checkbox-2']").click();
        return this;
    }

    public DemoQaRegistrationPage setPicture(){
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    public DemoQaRegistrationPage inputAddress(String address){
        addressInput.setValue(address);
        return this;
    }
    public DemoQaRegistrationPage setState(String state){
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public DemoQaRegistrationPage setParamState(States state){
        $("#react-select-3-input").setValue(String.valueOf(state)).pressEnter();
        return this;
    }
    public DemoQaRegistrationPage setCity(String city){
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public DemoQaRegistrationPage getCity(){
        $("#city").click();
        return this;
    }

    public void clickSubmitButton(){
        $("#submit").click();

    }

    public DemoQaRegistrationPage checkResultsFormOpen(){
        registrationDataInputResultsForm.verifyResultsFormAppear();
        return this;
    }

    public DemoQaRegistrationPage checkResultsFormData(String lable, String value){
        registrationDataInputResultsForm.checkData(lable, value);
        return this;
    }

    public DemoQaRegistrationPage checkCitiesList(List<String> cities){
        $$(".css-11unzgr").shouldHave(texts(cities));
        return this;
    }

    public void checkCloseButtonExist(){
        $("#closeLargeModal").exists();
    }

}
