package utils;

import java.util.concurrent.ThreadLocalRandom;

public class randomUtil {

    public static int getRandomInt(int min, int max){

        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomValueFromArray(String[] values){

        int index = getRandomInt(0, values.length -1);
        return values[index];
    }
}
