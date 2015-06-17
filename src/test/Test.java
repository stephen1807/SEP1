package test;

import proj.logic.SalaryLogic;

import java.util.Date;

/**
 * Created by Stephen on 2015/05/19.
 */
public class Test {

    public static void main(String[] args) {

        SalaryLogic salaryLogic = new SalaryLogic();

        System.out.println(salaryLogic.getDay(new Date()));
    }


}
