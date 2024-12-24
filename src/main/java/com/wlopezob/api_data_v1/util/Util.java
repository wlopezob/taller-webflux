package com.wlopezob.api_data_v1.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

import lombok.SneakyThrows;

public class Util {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    @SneakyThrows
    public static Date convertStringToDate(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return new Date(sdf.parse(dateString).getTime());
    }
}
