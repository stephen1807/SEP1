package proj.obj;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by Stephen on 2015/05/28.
 */
public class LogCode {

    private int logcode;
    private String logname;
    private String logdescription;
    private float logcost;
    private String logunit;
    private float logcost_permission;

    @Id
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
}