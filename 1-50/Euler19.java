/*
You are given the following information, but you may prefer to do some research for yourself.
1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.

A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

runtime s12 ms
*/

import java.util.*;

public class Euler19 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        /*
            0 -> monday
            1 -> tuesday
            ...
            6 -> sunday
        */

        Map<Integer, Integer> months = new TreeMap<Integer,Integer>();
        months.put(0, 31);
        months.put(1, 28);
        months.put(2, 31);
        months.put(3, 30);
        months.put(4, 31);
        months.put(5, 30);
        months.put(6, 31);
        months.put(7, 31);
        months.put(8, 30);
        months.put(9, 31);
        months.put(10, 30);
        months.put(11, 31);

        int sundaysCounter = 0;
        int current = 0;
        int dayCounter = 0;
        int leapYearCounter = 4;
        boolean isLeapYear = false;
        int lastMonthDays = 0;
        for (int i = 0; i <= 100; i++) {
            int year = i + 1900;

            // check if year is leap
            if (leapYearCounter  % 4 == 0 && year != 1900) {
                //System.out.println("Leap year: " + year);
                leapYearCounter = 1;
                isLeapYear = true;    
            } else {
                leapYearCounter += 1;
            }

            // iterate over months of a year
            Iterator it = months.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                
                // get current number of days
                int daysInCurrentMonth = (int) pairs.getValue();

                // update if it's leap and february
                if (pairs.getKey() == 1 && isLeapYear) {
                    daysInCurrentMonth += 1;
                    isLeapYear = false;
                }

                // increment day counter
                dayCounter += daysInCurrentMonth;

                // find what day is the next first in month
                int diff = dayCounter % 7;
                current += diff;
                if (current >= 7)
                    current = current % 7;
                dayCounter = 0;

                // if first is sunday, update the counter
                if (current == 6) {
                    sundaysCounter += 1;
                    int month = (int) pairs.getKey() + 2;
                    if (month > 12) {
                        month %= 12;
                        year += 1;
                    }
                    System.out.println("It is sunday, in " + month + ". Year is " + year);
                }
            }
        }
        // - 2 for 2 sundays in 1900
        System.out.println("Number of sundays is: " + (sundaysCounter - 2));
        System.out.println("Program runtime: " + (System.currentTimeMillis() - time) + "ms");
    }

}