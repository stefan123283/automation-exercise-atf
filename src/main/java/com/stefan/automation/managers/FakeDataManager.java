package com.stefan.automation.managers;

import com.github.javafaker.Faker;

public class FakeDataManager {

    private static final Faker faker = new Faker();

    public static String generateRandomPassword() {
        String password = faker.internet().password();
        Log.info("Generated password: " + password);
        return password;
    }

    public static String generateRandomDay() {
        String day = String.valueOf(faker.number().numberBetween(1, 31));
        Log.info("Generated day: " + day);
        return day;
    }

    public static String generateRandomMonth() {
        String firstLetterOfTheMonths = "JFMASOND";
        String month = String.valueOf(firstLetterOfTheMonths.charAt(faker.random().nextInt(firstLetterOfTheMonths.length())));
        Log.info("Generated month: " + month);
        return month;
    }

    public static String generateRandomYear() {
        String year = String.valueOf(faker.number().numberBetween(1900, 2021));
        Log.info("Generated year: " + year);
        return year;
    }

    public static String generateRandomFirstName() {
        String firstName = faker.name().firstName();
        Log.info("Generated first name: " + firstName);
        return firstName;
    }

    public static String generateRandomLastName() {
        String lastName = faker.name().lastName();
        Log.info("Generated last name: " + lastName);
        return lastName;
    }

    public static String generateRandomCompany() {
        String company = faker.company().name();
        Log.info("Generated company: " + company);
        return company;
    }

    public static String generateRandomStreetAddress() {
        String address = faker.address().streetAddress();
        Log.info("Generated address: " + address);
        return address;
    }

    public static String generateRandomState() {
        String state = faker.address().state();
        Log.info("Generated state: " + state);
        return state;
    }

    public static String generateRandomCity() {
        String city = faker.address().city();
        Log.info("Generated city: " + city);
        return city;
    }

    public static String generateRandomZipCode() {
        String zipCode = faker.address().zipCode();
        Log.info("Generated ZIP code: " + zipCode);
        return zipCode;
    }

    public static String generateRandomMobileNumber() {
        String phoneNumber = faker.phoneNumber().phoneNumber();
        Log.info("Generated phone number: " + phoneNumber);
        return phoneNumber;
    }

}
