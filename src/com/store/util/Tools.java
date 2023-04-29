package com.store.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * random generate a string for order_id, customer_id, etc.
 */
public class Tools {
    /**
     * The constant defaultStyle.
     */
    public static String defaultStyle = "-fx-font-family: 'serif'";
    /**
     * The Str date format.
     */
    static String strDateFormat = "0yyyyMMddHHmmss0";
    /**
     * The Sdf.
     */
    static SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

    /**
     * The constant SOURCES.
     */
    public static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789";


    /**
     * Generate a random string.
     *
     * @param random     the random number generator.
     * @param characters the characters for generating string.
     * @param length     the length of the generated string.
     * @return string
     */
    static String makeOrder(Random random, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()) );
        }
        return new String(text);
    }

    /**
     * Get rand string string.
     *
     * @param len the len
     * @return the string
     */
    public static String getRandString(int len){
        return makeOrder(new Random(new Date().getTime()),SOURCES, len);
    }

    /**
     * Get date string string.
     *
     * @param date the date
     * @return the string
     */
    public static String getDateString(Date date){
        return sdf.format(date);
    }
}
