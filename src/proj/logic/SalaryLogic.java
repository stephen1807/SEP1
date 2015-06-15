package proj.logic;

import proj.obj.*;
import proj.service.AttendanceLogService;
import proj.service.EmployeeService;
import proj.service.LogCodeService;
import proj.service.PermissionService;

import java.util.*;

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
        SettingsLogic settingsLogic = new SettingsLogic();

        float baseSalary = employeeService.getEmployee(employeeID).getBaseSalary();

        List<AttendanceLog> attendanceLogList = attendanceLogService.getAttendanceLog(employeeID, month);
        removeSameDay(attendanceLogList);

        for (int i = 0; i < attendanceLogList.size(); i++) {

            AttendanceLog attendanceLog = attendanceLogList.get(i);

            List<Permission> permissionList = new ArrayList<>();
            permissionList.addAll(permissionService.getPermissionGlobal(attendanceLog.getEntrydate(), attendanceLog.getLogcode()));
            permissionList.addAll(permissionService.getPermissionIndividual(employeeID, attendanceLog.getEntrydate(), attendanceLog.getLogcode()));

            LogCode temp = logCodeService.getLogCode(attendanceLog.getLogcode());

            //If doesn't affect salary, skip
            if (temp.getLogcost() == 0 && temp.getLogcost_permission() == 0) continue;

            int time_multiplier = 1;

            if (temp.getLogunit().equals("HOUR")) {
                //If overwork
                if (attendanceLog.getLogcode() == settingsLogic.getOverworkStartCode()) {

                    //Declare dates
                    Calendar currentDate = new GregorianCalendar(), thisDate = new GregorianCalendar();
                    currentDate.setTime(attendanceLog.getEntrydate());

                    Date endTime = null;

                    //Find end of overwork time
                    for (int j = i; j < attendanceLogList.size(); j++) {

                        AttendanceLog thisAL = attendanceLogList.get(j);

                        thisDate.setTime(thisAL.getEntrydate());
                        //If the next day
                        if (thisDate.get(Calendar.DATE) != currentDate.get(Calendar.DATE)) break;
                        //If find end of overwork time
                        if (thisAL.getLogcode() == settingsLogic.getOverworkEndCode()) {
                            endTime = thisAL.getEntrydate();
                        }
                    }
                    if (endTime == null) {
                        endTime = settingsLogic.getOverworkFinishTime();
                    }
                    time_multiplier = calcHour(attendanceLog.getEntrydate(), endTime);
                    //If else
                } else {
                    if (permissionList.isEmpty()) { //If no permissions, calculate until end of work time
                        time_multiplier = calcHour(attendanceLog.getEntrydate(), settingsLogic.getWorkFinishTime());
                    } else { //If have permission, calculate time with permission
                        List<Integer> multiplierCandidate = new ArrayList<>();

                        for (Permission permission : permissionList) {
                            if (permission instanceof PermissionIndividual) {
                                multiplierCandidate.add(calcHour(((PermissionIndividual) permission).getStartTime(), ((PermissionIndividual) permission).getEndTime()));
                            } else if (permission instanceof PermissionGlobal) {
                                multiplierCandidate.add(calcHour(((PermissionGlobal) permission).getStartHour(), ((PermissionGlobal) permission).getStartMinute(),
                                        ((PermissionGlobal) permission).getEndHour(), ((PermissionGlobal) permission).getEndMinute()));
                            } else {
                                continue;
                            }
                        }
                        Collections.sort(multiplierCandidate);
                        time_multiplier = multiplierCandidate.get(0);
                    }
                }
            }

            if (permissionList.isEmpty()) {
                result += time_multiplier * temp.getLogcost();
            } else {
                result += time_multiplier * temp.getLogcost_permission();

            }
        }

        return result + baseSalary;
    }

    private int calcHour(Date start, Date end) {

        Calendar startTime = new GregorianCalendar(), endTime = new GregorianCalendar();

        startTime.setTime(start);
        endTime.setTime(end);

        return calcHour(startTime.get(Calendar.HOUR_OF_DAY), startTime.get(Calendar.MINUTE), endTime.get(Calendar.HOUR_OF_DAY), endTime.get(Calendar.MINUTE));
    }

    private int calcHour(int startHour, int startMinute, int endHour, int endMinute) {

        int minDiff = (endMinute - startMinute < 15) ? 0 : 1;
        int hourDiff = endHour - startHour;

        return (hourDiff + minDiff == 0) ? 1 : hourDiff + minDiff;
    }

    private void removeSameDay(List<AttendanceLog> mainList) {

        LogCodeService logCodeService = LogCodeService.getInstance();

        List<LogCode> temp = logCodeService.getAllLogCodes();

        Set<Integer> canRemove = new HashSet<>();

        //Create set of log codes with "DAY" as unit
        for (int i = temp.size() - 1; i > 0; i--) {
            if (temp.get(i).getLogunit().equals("DAY")) {
                canRemove.add(temp.get(i).getLogcode());
            }
        }

        //Begin removal
        for (int j = mainList.size() - 1; j > 0; j--) {
            AttendanceLog attendanceLog = mainList.get(j);

            if (canRemove.contains(attendanceLog.getLogcode())) {
                int latestInDay = getDay(attendanceLog.getEntrydate());
                //As long in the same day
                for (int k = j - 1; getDay(mainList.get(k).getEntrydate()) == latestInDay && k > 0; k--) {
                    mainList.remove(k);
                }
            }
        }
    }

    private int getDay(Date date) {
        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        return calendar.get(Calendar.DATE);
    }
}
