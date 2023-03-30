package tests;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static tests.TestData.*;

public class DemoQaPracticeFormTest extends TestBase {

    @Tag("registration_with_params")
    @Test
    void studentRegistrationTest(){

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
                .inputAddress(useAddress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        demoQaRegistrationPage.checkResultsFormOpen()
                .checkResultsFormData("Student Name", firstName + " " + lastName)
                .checkResultsFormData("Student Email", userEmail)
                .checkResultsFormData("Gender", "Male")
                .checkResultsFormData("Mobile", userPhone)
                .checkResultsFormData("Date of Birth", bDay + " " + bMonth + "," + bYear)
                .checkResultsFormData("Subjects", subject)
                .checkResultsFormData("Hobbies", "Music, Reading")
                .checkResultsFormData("Picture", "hamster.png")
                .checkResultsFormData("Address", useAddress)
                .checkResultsFormData("State and City", state + " " + city)
                .checkCloseButtonExist();

    }

}
