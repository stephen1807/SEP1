package proj.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import proj.obj.Permission;
import proj.obj.PermissionGlobal;
import proj.obj.PermissionIndividual;

import java.util.*;

/**
 * Created by Stephen on 2015/05/20.
 * Ver 1.0
 */
public class PermissionService {

    private static PermissionService instance = new PermissionService();
    SessionFactory factory;

    private PermissionService() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("proj/resources/sep1.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static PermissionService getInstance() {
        return instance;
    }

    public void insertPermission(Permission newP) {

        Session session = factory.openSession();

        Transaction tr = null;

        try {

            tr = session.beginTransaction();

            session.save(newP);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<PermissionIndividual> getPermissionIndividual(int employeeID, Date date, int logcode) {

        Session session = factory.openSession();

        Transaction tr = null;

        List<PermissionIndividual> result = new ArrayList<>();

        try {

            tr = session.beginTransaction();

            result = (List<PermissionIndividual>) session.createQuery("FROM PermissionIndividual WHERE employeeID = ? and logcode = ? and ? between startTime and endTime").setParameter(0, employeeID).setParameter(1, logcode).setParameter(2, date).list();
            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public List<PermissionGlobal> getPermissionGlobal(Date time, int logcode) {
        Session session = factory.openSession();

        Transaction tr = null;

        List<PermissionGlobal> result = new ArrayList<>();

        try {

            tr = session.beginTransaction();

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(time);

            result = (List<PermissionGlobal>) session.createQuery("FROM PermissionGlobal WHERE ((? between startHour and endHour) OR (? = startHour and ? between startMinute and endMinute)) AND logcode = ?")
                    .setParameter(0, calendar.get(Calendar.HOUR_OF_DAY)).setParameter(1, calendar.get(Calendar.HOUR_OF_DAY)).setParameter(2, calendar.get(Calendar.MINUTE)).setParameter(3, logcode).list();
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
