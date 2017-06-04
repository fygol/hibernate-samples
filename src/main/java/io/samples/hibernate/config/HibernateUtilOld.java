package io.samples.hibernate.config;

import io.samples.hibernate.model.User;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSource;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtilOld {
//    private static final SessionFactory sessionFactory = buildSessionFactory();
//
//    private static SessionFactory buildSessionFactory() {
////        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
////
////        serviceRegistryBuilder
////                .applySetting("hibernate.connection.driver_class", "org.h2.Driver")
////                .applySetting("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MVCC=TRUE")
////                .applySetting("hibernate.connection.username", "sa")
////                .applySetting("hibernate.connection.password", "")
////                .applySetting("hibernate.show_sql", "true")
////                .applySetting("hibernate.format_sql", "true")
////                .applySetting("hibernate.hbm2ddl.auto", "create");
////
////        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
////
////        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
////        metadataSources.addAnnotatedClass(User.class);
////
////        MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();
////        Metadata metadata = metadataBuilder.build();
////        return metadata.buildSessionFactory();
//
//
//
////        try {
////            // Create the SessionFactory from hibernate.cfg.xml
////            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
////                    .configure("hibernate.cfg.xml")
////                    .build();
////            return new Configuration().configure().buildSessionFactory(serviceRegistry);
////        }
////        catch (Throwable ex) {
////            // Make sure you log the exception, as it might be swallowed
////            System.err.println("Initial SessionFactory creation failed." + ex);
////            throw new ExceptionInInitializerError(ex);
////        }
//
//        return newSessionFactory();
//    }
//
//    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    private static SessionFactory newSessionFactory() {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        //log settings
//        properties.put("hibernate.hbm2ddl.auto", "create");
//        //data source settings
//        properties.put("hibernate.connection.datasource", newDataSource());
//
//        return new Configuration()
//                .addProperties(properties)
//                .addAnnotatedClass(User.class)
//                .buildSessionFactory(
//                        new StandardServiceRegistryBuilder()
//                                .applySettings(properties)
//                                .build()
//                );
//    }
//
//    private static ProxyDataSource newDataSource() {
//        JdbcDataSource actualDataSource = new JdbcDataSource();
//        actualDataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;MVCC=TRUE");
//        actualDataSource.setUser("sa");
//        actualDataSource.setPassword("");
//        ProxyDataSource proxyDataSource = new ProxyDataSource();
//        proxyDataSource.setDataSource(actualDataSource);
//        proxyDataSource.setListener(new SLF4JQueryLoggingListener());
//        return proxyDataSource;
//    }
}
