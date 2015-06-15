package proj.logic;

import proj.obj.Setting;
import proj.service.SettingService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Stephen on 2015/06/12.
 */
public class SettingsLogic {

    public Date getWorkStartTime() {
        SettingService settingService = SettingService.getInstance();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(settingService.readSetting("WorkStartTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setWorkStartTime(Date time) {
        SettingService settingService = SettingService.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        settingService.writeSetting(new Setting("WorkStartTime", sdf.format(time)));
    }

    public Date getWorkFinishTime() {
        SettingService settingService = SettingService.getInstance();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(settingService.readSetting("WorkFinishTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setWorkFinishTime(Date time) {
        SettingService settingService = SettingService.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        settingService.writeSetting(new Setting("WorkFinishTime", sdf.format(time)));
    }

    public Date getOverworkStartTime() {
        SettingService settingService = SettingService.getInstance();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(settingService.readSetting("OverworkStartTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setOverworkStartTime(Date time) {
        SettingService settingService = SettingService.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        settingService.writeSetting(new Setting("OverworkStartTime", sdf.format(time)));
    }

    public Date getOverworkFinishTime() {
        SettingService settingService = SettingService.getInstance();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(settingService.readSetting("OverworkFinishTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setOverworkFinishTime(Date time) {
        SettingService settingService = SettingService.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        settingService.writeSetting(new Setting("OverworkFinishTime", sdf.format(time)));
    }

    public int getLoginCode() {
        SettingService settingService = SettingService.getInstance();
        return Integer.parseInt(settingService.readSetting("LoginCode"));
    }

    public void setLoginCode(int logcode) {
        SettingService settingService = SettingService.getInstance();
        settingService.writeSetting(new Setting("LoginCode", String.valueOf(logcode)));
    }

    public int getLogoutCode() {
        SettingService settingService = SettingService.getInstance();
        return Integer.parseInt(settingService.readSetting("LogoutCode"));
    }

    public void setLogoutCode(int logcode) {
        SettingService settingService = SettingService.getInstance();
        settingService.writeSetting(new Setting("LogoutCode", String.valueOf(logcode)));
    }

    public int getInactivityCode() {
        SettingService settingService = SettingService.getInstance();
        return Integer.parseInt(settingService.readSetting("InactivityLogCode"));
    }

    public void setInactivityCode(int logcode) {
        SettingService settingService = SettingService.getInstance();
        settingService.writeSetting(new Setting("InactivityLogCode", String.valueOf(logcode)));
    }

    public void setOverworkCode(int logcode) {
        SettingService settingService = SettingService.getInstance();
        settingService.writeSetting(new Setting("OverworkCode", String.valueOf(logcode)));
    }

    public int getOverworkCode(int logcode) {
        SettingService settingService = SettingService.getInstance();
        return Integer.parseInt(settingService.readSetting("OverworkCode"));
    }
}
