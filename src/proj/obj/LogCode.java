package proj.obj;

import javax.persistence.*;

/**
 * Created by Stephen on 2015/05/28.
 */
@Entity
@Table(name = "logcode")
public class LogCode {

    private int logcode;
    private String logname;
    private String logdescription;
    private float logcost;
    private String logunit;
    private float logcost_permission;
    private boolean available;

    @Id
    @GeneratedValue()
    @Column(name = "logcode")
    public int getLogcode() {
        return logcode;
    }

    public void setLogcode(int logcode) {
        this.logcode = logcode;
    }

    @Basic
    @Column(name = "logname")
    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname;
    }

    @Basic
    @Column(name = "logdescription")
    public String getLogdescription() {
        return logdescription;
    }

    public void setLogdescription(String logdescription) {
        this.logdescription = logdescription;
    }

    @Basic
    @Column(name = "logcost")
    public float getLogcost() {
        return logcost;
    }

    public void setLogcost(float logcost) {
        this.logcost = logcost;
    }

    @Basic
    @Column(name = "logunit")
    public String getLogunit() {
        return logunit;
    }

    public void setLogunit(String logunit) {
        this.logunit = logunit;
    }

    @Basic
    @Column(name = "logcost_permission")
    public float getLogcost_permission() {
        return logcost_permission;
    }

    public void setLogcost_permission(float logcost_permission) {
        this.logcost_permission = logcost_permission;
    }

    @Basic
    @Column(name = "available")
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogCode)) return false;

        LogCode logCode = (LogCode) o;

        if (logcode != logCode.logcode) return false;
        if (Float.compare(logCode.logcost, logcost) != 0) return false;
        if (Float.compare(logCode.logcost_permission, logcost_permission) != 0) return false;
        if (available != logCode.available) return false;
        if (logname != null ? !logname.equals(logCode.logname) : logCode.logname != null) return false;
        if (logdescription != null ? !logdescription.equals(logCode.logdescription) : logCode.logdescription != null)
            return false;
        return !(logunit != null ? !logunit.equals(logCode.logunit) : logCode.logunit != null);

    }

    @Override
    public int hashCode() {
        int result = logcode;
        result = 31 * result + (logname != null ? logname.hashCode() : 0);
        result = 31 * result + (logdescription != null ? logdescription.hashCode() : 0);
        result = 31 * result + (logcost != +0.0f ? Float.floatToIntBits(logcost) : 0);
        result = 31 * result + (logunit != null ? logunit.hashCode() : 0);
        result = 31 * result + (logcost_permission != +0.0f ? Float.floatToIntBits(logcost_permission) : 0);
        result = 31 * result + (available ? 1 : 0);
        return result;
    }
}