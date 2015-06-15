package proj.logic;

import proj.obj.AttendanceLog;
import proj.service.AttendanceLogService;

import java.util.Date;

/**
 * Created by Stephen on 2015/06/04.
 */
public class AttendanceLogLogic {

    public void userSetInactive(int employeeID, Date entryDate) {

        SettingsLogic sl = new SettingsLogic();
        int logcode = sl.getInactivityCode();

        AttendanceLog attendanceLog = new AttendanceLog(employeeID, entryDate, logcode);

        AttendanceLogService als = AttendanceLogService.getInstance();
        als.insertAttendanceLog(attendanceLog);
    }
}
