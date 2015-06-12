package proj.logic;

import proj.obj.AttendanceLog;
import proj.obj.Employee;
import proj.service.AttendanceLogService;
import proj.service.EmployeeService;

import java.util.Date;

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

                int code = sl.getLoginCode();

                AttendanceLogService als = AttendanceLogService.getInstance();

                AttendanceLog attendanceLog = new AttendanceLog(temp.getEmployeeID(), new Date(), code);

                als.insertAttendanceLog(attendanceLog);

                return temp;
            } else return null;

        } else return null;
    }

    public void employeeLogout(int employeeID) {

        SettingsLogic sl = new SettingsLogic();

        int code = sl.getLogoutCode();

        AttendanceLogService als = AttendanceLogService.getInstance();

        AttendanceLog attendanceLog = new AttendanceLog(employeeID, new Date(), code);

        als.insertAttendanceLog(attendanceLog);

    }
}
