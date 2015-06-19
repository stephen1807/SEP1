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
//        calendar.set(Calendar.HOUR_OF_DAY, 02);
//        calendar.set(Calendar.MINUTE, 00);
//
//        logic.setOverworkFinishTime(calendar.getTime());

        logic.setOverworkEndCode(4);

//        System.out.println(logic.getOverworkFinishTime());
    }
}
