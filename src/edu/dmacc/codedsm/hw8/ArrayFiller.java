package edu.dmacc.codedsm.hw8;

import java.util.Random;

public class ArrayFiller {

    public static String[] validStrings = new String[5];
    public static int i = 0;

    public static void main(String[] args) {

        while(i < 5) {
            addString(createRandomAlphaNumericString(5));
        }
        for (int j = 0; j < 5; j++) {
            System.out.println(validStrings[j]);
        }
    }

    public static String createRandomAlphaNumericString(int randomStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(randomStringLength);
        for (int i = 0; i < randomStringLength; i++) {
            if (random.nextInt(10) >= 9) {
                buffer.append(random.nextInt(9));
            } else {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                char characterForString = (char) randomLimitedInt;
                if (random.nextBoolean()) {
                    characterForString = Character.toUpperCase(characterForString);
                }
                buffer.append(characterForString);
            }
        }
        return buffer.toString();
    }

    public static void addString(String value) {
        if (value.matches(".*\\d+.*")) {
            System.out.println("Value with numbers encountered. BOOOOOOO!");
        }
        else {
            if (value.matches("([AEIOU]).*")) {
                validStrings[i] = value;
                i++;
            }
        }
    }
}




