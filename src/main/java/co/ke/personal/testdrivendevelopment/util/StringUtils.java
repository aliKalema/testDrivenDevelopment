package co.ke.personal.testdrivendevelopment.util;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {
    public static String generateRefId(){
        return RandomStringUtils.random(16, true, true);
    }
}
