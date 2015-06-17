package proj.obj;

import javax.persistence.*;

/**
 * Created by Stephen on 2015/06/15.
 */
@Entity
@Table(name = "setting")
public class Setting {

    private int setting_ID;
    private String setting_name;
    private String setting_content;

    public Setting() {
    }

    public Setting(String name, String content) {
        setting_name = name.trim();
        setting_content = content.trim();
    }

    @Id
    @GeneratedValue
    @Column(name = "setting_ID")
    public int getSetting_ID() {
        return setting_ID;
    }

    public void setSetting_ID(int setting_ID) {
        this.setting_ID = setting_ID;
    }

    @Basic
    @Column(name = "setting_name")
    public String getSetting_name() {
        return setting_name;
    }

    public void setSetting_name(String setting_name) {
        this.setting_name = setting_name.trim();
    }

    @Basic
    @Column(name = "setting_content")
    public String getSetting_content() {
        return setting_content;
    }

    public void setSetting_content(String setting_content) {
        this.setting_content = setting_content.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Setting)) return false;

        Setting setting = (Setting) o;

        if (setting_ID != setting.setting_ID) return false;
        if (setting_name != null ? !setting_name.equals(setting.setting_name) : setting.setting_name != null)
            return false;
        return !(setting_content != null ? !setting_content.equals(setting.setting_content) : setting.setting_content != null);

    }

    @Override
    public int hashCode() {
        int result = setting_ID;
        result = 31 * result + (setting_name != null ? setting_name.hashCode() : 0);
        result = 31 * result + (setting_content != null ? setting_content.hashCode() : 0);
        return result;
    }
}
