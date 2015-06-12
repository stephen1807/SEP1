package proj.logic;

import proj.io.XML_IO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Stephen on 2015/06/12.
 */
public class SettingsLogic {

    public Date getWorkStartTime() {
        XML_IO xml_io = new XML_IO();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(xml_io.readSetting("WorkStartTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setWorkStartTime(Date time) {
        XML_IO xml_io = new XML_IO();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        xml_io.writeSetting("WorkStartTime", sdf.format(time));
    }

    public Date getWorkFinishTime() {
        XML_IO xml_io = new XML_IO();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(xml_io.readSetting("WorkFinishTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setWorkFinishTime(Date time) {
        XML_IO xml_io = new XML_IO();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        xml_io.writeSetting("WorkFinishTime", sdf.format(time));
    }

    public Date getOverworkStartTime() {
        XML_IO xml_io = new XML_IO();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(xml_io.readSetting("OverworkStartTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setOverworkStartTime(Date time) {
        XML_IO xml_io = new XML_IO();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        xml_io.writeSetting("OverworkStartTime", sdf.format(time));
    }

    public Date getOverworkFinishTime() {
        XML_IO xml_io = new XML_IO();
        Date result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        try {
            result = sdf.parse(xml_io.readSetting("OverworkFinishTime"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setOverworkFinishTime(Date time) {
        XML_IO xml_io = new XML_IO();
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        xml_io.writeSetting("OverworkFinishTime", sdf.format(time));
    }

    public int getLoginCode() {
        XML_IO xml_io = new XML_IO();
        return Integer.parseInt(xml_io.readSetting("LoginCode"));
    }

    public void setLoginCode(int logcode) {
        XML_IO xml_io = new XML_IO();
        xml_io.writeSetting("LoginCode", String.valueOf(logcode));
    }

    public int getLogoutCode() {
        XML_IO xml_io = new XML_IO();
        return Integer.parseInt(xml_io.readSetting("LogoutCode"));
    }

    public void setLogoutCode(int logcode) {
        XML_IO xml_io = new XML_IO();
        xml_io.writeSetting("LogoutCode", String.valueOf(logcode));
    }

    public int getInactivityCode() {
        XML_IO xml_io = new XML_IO();
        return Integer.parseInt(xml_io.readSetting("InactivityLogCode"));
    }

    public void setInactivityCode(int logcode) {
        XML_IO xml_io = new XML_IO();
        xml_io.writeSetting("InactivityLogCode", String.valueOf(logcode));
    }

    public void setOverworkCode(int logcode) {
        XML_IO xml_io = new XML_IO();
        xml_io.writeSetting("OverworkCode", String.valueOf(logcode));
    }

    public int getOverworkCode(int logcode) {
        XML_IO xml_io = new XML_IO();
        return Integer.parseInt(xml_io.readSetting("OverworkCode"));
    }
}
