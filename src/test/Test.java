package test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Stephen on 2015/05/19.
 */
public class Test {

    public static void main(String[] args) {
        Date d = new Date();

        Calendar c = new GregorianCalendar();

        System.out.println(d.getTime());
    }
}
