package proj.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.Setting;

/**
 * Created by Stephen on 2015/06/15.
 */
public class SettingService {

    private static SettingService ourInstance = new SettingService();
    SessionFactory factory;

    private SettingService() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("proj/resources/sep1.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SettingService getInstance() {
        return ourInstance;
    }

    public void writeSetting(Setting newSetting) {
        Session session = factory.openSession();

        Transaction tr = null;


        try {

            tr = session.beginTransaction();

            session.saveOrUpdate(newSetting);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public String readSetting(String settingName) {
        Session session = factory.openSession();

        Transaction tr = null;

        Setting result = new Setting();

        try {

            tr = session.beginTransaction();

            result = (Setting) session.createQuery("FROM Setting where setting_name = ?").setParameter(0, settingName).uniqueResult();

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result.getSetting_content();
    }
}
