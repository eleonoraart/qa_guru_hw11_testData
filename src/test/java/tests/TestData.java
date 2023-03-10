package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.randomUtil.*;

public class TestData {

    static Faker faker = new Faker(new Locale("ru"));

    static String[] subjects = {"Physics", "Hindi", "English", "Maths", "Chemistry", "Economics"},
                    cities = {"Delhi", "Noida", "Gurgaon"},
                    month = {"January", "February", "March", "April", "May", "June", "July"};


    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.animal().name() + "@gmail.com",
            userPhone = "7" + faker.phoneNumber().subscriberNumber(9),
            bDay = String.valueOf(getRandomInt(1,28)),
            bMonth = getRandomValueFromArray(month),
            bYear = String.valueOf(getRandomInt(1960,2005)),
            useAddress = faker.address().fullAddress(),
            subject = getRandomValueFromArray(subjects),
            state = "NCR",
            city = getRandomValueFromArray(cities);


}
