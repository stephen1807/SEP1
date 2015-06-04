package proj.logic;

import proj.obj.AttendanceLog;
import proj.obj.LogCode;
import proj.obj.Permission;
import proj.service.AttendanceLogService;
import proj.service.EmployeeService;
import proj.service.LogCodeService;
import proj.service.PermissionService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen on 2015/05/28.
 */
public class SalaryLogic {

    public float calculateSalary(int employeeID, int month) {

        float result = 0;

        EmployeeService employeeService = EmployeeService.getInstance();
        AttendanceLogService attendanceLogService = AttendanceLogService.getInstance();
        LogCodeService logCodeService = LogCodeService.getInstance();
        PermissionService permissionService = PermissionService.getInstance();

        float baseSalary = employeeService.getEmployee(employeeID).getBaseSalary();

        List<AttendanceLog> attendanceLogList = attendanceLogService.getAttendanceLog(employeeID, month);

        for (AttendanceLog attendanceLog : attendanceLogList) {

            List<Permission> list = new ArrayList<>();
            list.addAll(permissionService.getPermissionGlobal(attendanceLog.getEntrydate(), attendanceLog.getLogcode()));
            list.addAll(permissionService.getPermissionIndividual(employeeID, attendanceLog.getEntrydate(), attendanceLog.getLogcode()));

            LogCode temp = logCodeService.getLogCode(attendanceLog.getLogcode());

            if (list.isEmpty()) {
                result += temp.getLogcost();
            } else {
                for (Permission pg : list) {
                    result += temp.getLogcost_permission();
                }
            }
        }

        return result + baseSalary;
    }
}
