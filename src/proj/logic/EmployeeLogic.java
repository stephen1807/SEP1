package proj.logic;

import proj.obj.AttendanceLog;
import proj.obj.Employee;
import proj.service.AttendanceLogService;
import proj.service.EmployeeService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Stephen on 2015/05/22.
 * Ver 1.0
 */
public class EmployeeLogic {

    public Employee employeeLogin(String username, String password) {

        EmployeeService es = EmployeeService.getInstance();

        Employee temp = es.getEmployee(username);

        if (temp != null) {
            if (temp.getUserpass().equals(password)) {

                SettingsLogic sl = new SettingsLogic();

                //Login time
                Calendar calendar = new GregorianCalendar();
                //Overwork start time
                Calendar calendar1 = new GregorianCalendar();

                calendar1.setTime(sl.getOverworkStartTime());

                int h1 = calendar.get(Calendar.HOUR_OF_DAY), h2 = calendar1.get(Calendar.HOUR_OF_DAY);
                int m1 = calendar1.get(Calendar.MINUTE), m2 = calendar1.get(Calendar.MINUTE);

                int code;

                //If overwork time
                if (h1 > h2 || (h1 == h2) && (m1 >= m2)) {
                    code = sl.getOverworkStartCode();
                } else {
                    code = sl.getLoginCode();
                }

                AttendanceLogService als = AttendanceLogService.getInstance();

                AttendanceLog attendanceLog = new AttendanceLog(temp.getEmployeeID(), new Date(), code);

                als.insertAttendanceLog(attendanceLog);

                return temp;

            } else return null;

        } else return null;
    }

    public void employeeLogout(int employeeID) {

        SettingsLogic sl = new SettingsLogic();

        //Logout time
        Calendar calendar = new GregorianCalendar();
        //Work end time
        Calendar calendar1 = new GregorianCalendar();

        calendar1.setTime(sl.getWorkFinishTime());

        int h1 = calendar.get(Calendar.HOUR_OF_DAY), h2 = calendar1.get(Calendar.HOUR_OF_DAY);
        int m1 = calendar1.get(Calendar.MINUTE), m2 = calendar1.get(Calendar.MINUTE);

        int code;

        //If after work time
        if (h1 > h2 || (h1 == h2) && (m1 >= m2)) {
            code = sl.getOverworkEndCode();
        } else {
            code = sl.getLogoutCode();
        }

        AttendanceLogService als = AttendanceLogService.getInstance();

        AttendanceLog attendanceLog = new AttendanceLog(employeeID, new Date(), code);

        als.insertAttendanceLog(attendanceLog);

    }
}
