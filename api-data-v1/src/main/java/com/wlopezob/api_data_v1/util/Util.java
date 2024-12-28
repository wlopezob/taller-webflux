package com.wlopezob.api_data_v1.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.SneakyThrows;

public class Util {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @SneakyThrows
    public static Date stringToDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.parse(dateString);
    }

    public static String dateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        return formatter.format(date);
    }
}
