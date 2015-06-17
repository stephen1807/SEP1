package test;

import proj.logic.SalaryLogic;
import proj.logic.SettingsLogic;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Stephen on 2015/05/19.
 */
public class Test {

    public static void main(String[] args) {

        SettingsLogic logic = new SettingsLogic();

//        Calendar calendar = new GregorianCalendar();
//
//        calendar.set(Calendar.HOUR_OF_DAY, 20);
//        calendar.set(Calendar.MINUTE, 30);
//
//        logic.setOverworkStartTime(calendar.getTime());

        logic.setLoginCode(1);

        System.out.println(logic.getLoginCode());
    }
}
