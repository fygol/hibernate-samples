package io.samples.hibernate.config;

import org.hibernate.cfg.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Constants are defined in org.hibernate.cfg.{@link Environment}.
 */
public class HibernateSettings {
    /*
        Example:
            Properties properties = new Properties();
            properties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");

            //log settings
            properties.put("hibernate.hbm2ddl.auto", "update");
            properties.put("hibernate.show_sql", "true");

            //driver settings
            properties.put("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
            properties.put("hibernate.connection.url", "jdbc:hsqldb:mem:test");
            properties.put("hibernate.connection.username", "sa");
            properties.put("hibernate.connection.password", "");
     */
    public static Map<String, Object> newH2Settings() {
        Map<String, Object> settings = new HashMap<>();

        DataSource dataSource = DataSources.newH2DataSource();
        DataSource dataSourceProxy = DataSources.newDataSourceProxy(dataSource);

        settings.put("hibernate.connection.datasource", dataSourceProxy);
        settings.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        settings.put("hibernate.hbm2ddl.auto", "create");
        settings.put("hibernate.order_updates", true);
        settings.put("hibernate.order_inserts", true);
        settings.put("hibernate.jdbc.batch_size", 10);
        settings.put("hibernate.current_session_context_class", "thread");

        return settings;
    }

}
