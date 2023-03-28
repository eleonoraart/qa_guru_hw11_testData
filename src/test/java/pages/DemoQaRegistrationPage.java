package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import testsData.States;

import java.io.File;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exist;
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

    @Step("Открываем страницу регистрации на портале")
    public DemoQaRegistrationPage openRegistrationPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    @Step("Вводим имя в поле формы регистрации")
    public DemoQaRegistrationPage inputFirstName(String firstName){
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Вводим фамилию в поле формы регистрации")
    public DemoQaRegistrationPage inputLastName(String lastName){
        lastNaneInput.setValue(lastName);
        return this;
    }

    @Step("Выбераем пол в поле формы регистрации")
    public DemoQaRegistrationPage setGender(){
        $("label[for='gender-radio-1']").click();
        return this;
    }

    @Step("Вводим телефон в поле формы регистрации")
    public DemoQaRegistrationPage inputPhoneNumber(String phoneNumber){
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    @Step("Вводим дату рождения в поле формы регистрации")
    public DemoQaRegistrationPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setBDate(day, month, year);
        return this;
    }

    @Step("Вводим электронный адрес в поле формы регистрации")
    public DemoQaRegistrationPage inputEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    @Step("Выбираем предметы в поле формы регистрации")
    public DemoQaRegistrationPage setSubjects(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    @Step("Выбираем хобби из предложенных чек-боксов")
    public DemoQaRegistrationPage setHobbies(){
        $("label[for='hobbies-checkbox-3']").click();
        $("label[for='hobbies-checkbox-2']").click();
        return this;
    }

    @Step("Загружаем фотографию")
    public DemoQaRegistrationPage setPicture(){
        $("#uploadPicture").uploadFile(file);
        return this;
    }

    @Step("Вводим адрес в поле формы регистрации")
    public DemoQaRegistrationPage inputAddress(String address){
        addressInput.setValue(address);
        return this;
    }

    @Step("Выбираем штат в поле формы регистрации")
    public DemoQaRegistrationPage setState(String state){
        $("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }


    public DemoQaRegistrationPage setParamState(States state){
        $("#react-select-3-input").setValue(String.valueOf(state)).pressEnter();
        return this;
    }

    @Step("Выбираем город в поле формы регистрации")
    public DemoQaRegistrationPage setCity(String city){
        $("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public DemoQaRegistrationPage getCity(){
        $("#city").click();
        return this;
    }

    @Step("Нажимаем на кнопку подтверждения форме регистрации")
    public void clickSubmitButton(){
        $("#submit").click();

    }

    @Step("Проверка открытия модалки подтверждения регистрации")
    public DemoQaRegistrationPage checkResultsFormOpen(){
        registrationDataInputResultsForm.verifyResultsFormAppear();
        return this;
    }

    @Step("Сверка отображаемых данных в модалке подтверждения с ранее введенными")
    public DemoQaRegistrationPage checkResultsFormData(String lable, String value){
        registrationDataInputResultsForm.checkData(lable, value);
        return this;
    }

    public DemoQaRegistrationPage checkCitiesList(List<String> cities){
        $$(".css-11unzgr").shouldHave(texts(cities));
        return this;
    }

    @Step("Проверка наличия кнопки закрытия модального окна с результатами")
    public void checkCloseButtonExist(){

        $("#closeLargeModal").shouldHave(exist);
    }

}
