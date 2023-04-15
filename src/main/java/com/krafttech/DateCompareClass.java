package com.krafttech;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateCompareClass {
    public static void main(String[] args) throws ParseException {


        List<String> stringOfDates = List.of("2012-09-06", "2012-09-05", "2012-09-01");

        System.out.println("isDateOrdered(stringOfDates) = " + isDateOrdered(stringOfDates));
    }

    /**
     In Java, two dates can be compared using the compareTo() method of Comparable interface.
     This method returns '0' if both the dates are equal, it returns a value "greater than 0"
     if date1 is after date2 and it returns a value "less than 0" if date1 is before date2.
     */

    public static boolean isDateOrdered(List<String> stringOfDates) throws ParseException {
        List<Date> dates = new ArrayList<>();

        for (String stringOfDate : stringOfDates) {
            SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdformat.parse(stringOfDate);
            dates.add(date);
        }
        for (int i = 0; i < dates.size(); i++) {
            for (int j = i + 1; j < dates.size(); j++) {
                if (dates.get(i).compareTo(dates.get(j)) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
