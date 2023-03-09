import org.junit.jupiter.api.Test;

public class DemoQaPracticeFormTest extends TestBase{

    @Test
    void studentRegistrationTest(){

        demoQaRegistrationPage.openRegistrationPage()
                .inputFirstName("Иван")
                .inputLastName("Тестов")
                .inputEmail("testov@gmail.com")
                .setGender()
                .inputPhoneNumber("9030000001")
                .setBirthDate("11", "March", "1960")
                .setSubjects("Physics")
                .setHobbies()
                .setPicture()
                .inputAddress("Село Кукуево, К.Маркса street")
                .setState("Haryana")
                .setCity("Panipat")
                .clickSubmitButton();

        demoQaRegistrationPage.checkResultsFormOpen()
                .checkResultsFormData("Student Name", "Иван Тестов")
                .checkResultsFormData("Student Email", "estov@gmail.com")
                .checkResultsFormData("Gender", "Male")
                .checkResultsFormData("Mobile", "9030000001")
                .checkResultsFormData("Date of Birth", "11 March,1960")
                .checkResultsFormData("Subjects", "Physics")
                .checkResultsFormData("Hobbies", "Music, Reading")
                .checkResultsFormData("Picture", "хомяк.png")
                .checkResultsFormData("Address", "Село Кукуево, К.Маркса street")
                .checkResultsFormData("State and City", "Haryana Panipat")
                .checkCloseButtonExist();

    }


}
