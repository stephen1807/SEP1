package proj.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.LogCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephen on 2015/05/28.
 */
public class LogCodeService {

    private static LogCodeService instance = new LogCodeService();
    SessionFactory factory;

    private LogCodeService() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("proj/resources/sep1.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static LogCodeService getInstance() {
        return instance;
    }

    public List<LogCode> getAllLogCodes() {

        Session session = factory.openSession();

        Transaction tr = null;

        List<LogCode> result = new ArrayList<LogCode>();

        try {

            tr = session.beginTransaction();

            result = session.createQuery("FROM LogCode").list();

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public LogCode getLogCode(int logid) {

        Session session = factory.openSession();

        Transaction tr = null;

        LogCode result = null;

        try {

            tr = session.beginTransaction();

            result = (LogCode) session.get(LogCode.class, logid);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public void editLogCode(LogCode newLC) {
        Session session = factory.openSession();

        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            session.update(newLC);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
