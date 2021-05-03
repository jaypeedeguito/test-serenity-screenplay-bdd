package com.framework.scaped.utils;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

    static Faker faker;

    public static String generateFirstName() {
        faker = new Faker();
        return faker.name().firstName();
    }

    public static String generateLastName() {
        faker = new Faker();
        return faker.name().lastName();
    }
}
