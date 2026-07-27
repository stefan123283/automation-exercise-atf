package com.stefan.automation.managers;

import com.github.javafaker.Faker;
import com.stefan.automation.models.User;

public final class FakeDataManager {

    private static final Faker faker = new Faker();

    private FakeDataManager() {
    }

    public static User generateUser() {
        User user = new User();
        user.setUsername(generateRandomUsername());
        user.setEmail(generateRandomEmail());
        user.setPassword(generateRandomPassword());
        user.setBirthDay(generateRandomDay());
        user.setBirthMonth(generateRandomMonth());
        user.setBirthYear(generateRandomYear());
        user.setFirstName(generateRandomFirstName());
        user.setLastName(generateRandomLastName());
        user.setCompany(generateRandomCompany());
        user.setAddress(generateRandomStreetAddress());
        user.setState(generateRandomState());
        user.setCity(generateRandomCity());
        user.setZipCode(generateRandomZipCode());
        user.setMobileNumber(generateRandomMobileNumber());
        Log.info("Generated user data: " + user);
        return user;
    }

    public static String generateRandomUsername() {
        return faker.name().username();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateRandomPassword() {
        return faker.internet().password();
    }

    public static String generateRandomDay() {
        return String.valueOf(faker.number().numberBetween(1, 31));
    }

    public static String generateRandomMonth() {
        String firstLetterOfTheMonths = "JFMASOND";
        return String.valueOf(firstLetterOfTheMonths.charAt(faker.random().nextInt(firstLetterOfTheMonths.length())));
    }

    public static String generateRandomYear() {
        return String.valueOf(faker.number().numberBetween(1900, 2021));
    }

    public static String generateRandomFirstName() {
        return faker.name().firstName();
    }

    public static String generateRandomLastName() {
        return faker.name().lastName();
    }

    public static String generateRandomCompany() {
        return faker.company().name();
    }

    public static String generateRandomStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String generateRandomState() {
        return faker.address().state();
    }

    public static String generateRandomCity() {
        return faker.address().city();
    }

    public static String generateRandomZipCode() {
        return faker.address().zipCode();
    }

    public static String generateRandomMobileNumber() {
        return faker.phoneNumber().phoneNumber();
    }

}
