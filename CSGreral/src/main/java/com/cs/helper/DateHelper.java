package com.cs.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private DateHelper() {
    }

    public static String formatDefault(Date data) {
        return sdf.format(data);
    }

    public static Date parseDefault(String data) throws ParseException {
        return sdf.parse(data);
    }
}
