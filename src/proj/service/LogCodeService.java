package proj.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.LogCode;

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
}
