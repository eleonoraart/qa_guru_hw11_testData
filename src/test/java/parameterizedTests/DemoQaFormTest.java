package parameterizedTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.DemoQaRegistrationPage;
import tests.TestBase;
import testsData.States;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;
import static tests.TestData.*;

public class DemoQaFormTest extends TestBase{

    DemoQaRegistrationPage demoQaRegistrationPage = new DemoQaRegistrationPage();

    @ValueSource(strings = {
            "Омск, ул.Степная д 5", "75 PARK PLACE 8TH FLOOR NEW YORK NY 10007"
    })
    @Tag("Regress")
    @DisplayName("Корректное отображение адреса введенного при регистрации в модальном окне подтверждения")
    @ParameterizedTest
    void studentRegistrationWithCorrectAddressTest(String paramAddress){

        demoQaRegistrationPage.openRegistrationPage()
                .inputFirstName(firstName)
                .inputLastName(lastName)
                .inputEmail(userEmail)
                .setGender()
                .inputPhoneNumber(userPhone)
                .setBirthDate(bDay, bMonth, bYear)
                .setSubjects(subject)
                .setHobbies()
                .setPicture()
                .inputAddress(paramAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        demoQaRegistrationPage.checkResultsFormOpen()
                .checkResultsFormData("Address", paramAddress);
    }

    @CsvSource(value = {
            "John,     Snow",
            "Саша,     Иванов"
    })
    @Tag("Smoke")
    @ParameterizedTest(name = "Отображение локализованных веденных данных {0} при регистрации, в модальном окне подтверждения")
    void studentRegistrationWithLocalNameTest(String paramFirstName, String paramLastName){

        demoQaRegistrationPage.openRegistrationPage()
                .inputFirstName(paramFirstName)
                .inputLastName(paramLastName)
                .inputEmail(userEmail)
                .setGender()
                .inputPhoneNumber(userPhone)
                .setBirthDate(bDay, bMonth, bYear)
                .setSubjects(subject)
                .setHobbies()
                .setPicture()
                .inputAddress(useAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        demoQaRegistrationPage.checkResultsFormOpen()
                .checkResultsFormData("Student Name", paramFirstName + " " + paramLastName);
    }

    static Stream<Arguments> checkCityListForStateTest(){
     return Stream.of(
             Arguments.of(States.NCR, List.of("Delhi Gurgaon Noida")),
             Arguments.of(States.Haryana, List.of("Karnal Panipat"))
     );
    }
    @MethodSource
    @Tag("Smoke")
    @ParameterizedTest(name = "Проверка соответствия списка городов выбранному штату{0}")
    void checkCityListForStateTest(States state, List<String> expectedCities){

        demoQaRegistrationPage.openRegistrationPage()

                .setParamState(state)
                .getCity();
                $$(".css-11unzgr").shouldHave(texts(expectedCities));

    }

}
