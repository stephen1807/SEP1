package proj.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

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
}
