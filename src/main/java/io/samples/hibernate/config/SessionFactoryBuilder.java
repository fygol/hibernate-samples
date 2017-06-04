package io.samples.hibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Map;

public class SessionFactoryBuilder {
    private Map<String, Object> settings;

    private Class<?>[] entities;

    public SessionFactoryBuilder() {
        settings = HibernateSettings.newH2Settings();
    }

    public SessionFactoryBuilder settings(Map<String, Object> settings) {
        this.settings = settings;
        return this;
    }

    public SessionFactoryBuilder entities(Class<?>... entities) {
        this.entities = entities;
        return this;
    }

    public SessionFactory build() {
        StandardServiceRegistry standardRegistry = null;
        try {
            StandardServiceRegistryBuilder standardRegistryBuilder = new StandardServiceRegistryBuilder();

            standardRegistryBuilder.applySettings(settings);
            standardRegistry = standardRegistryBuilder.build();

            MetadataSources metadataSources = new MetadataSources(standardRegistry);

            for(Class<?> entityClass : entities) {
                metadataSources.addAnnotatedClass(entityClass);
            }

            Metadata metadata = metadataSources.getMetadataBuilder().build();
            return metadata.buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex.getMessage());
            StandardServiceRegistryBuilder.destroy(standardRegistry);
            throw new ExceptionInInitializerError(ex.getCause());
        }

    }
}
