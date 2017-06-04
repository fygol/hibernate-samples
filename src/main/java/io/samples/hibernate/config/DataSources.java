package io.samples.hibernate.config;

import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

public class DataSources {
    public static DataSource newDataSourceProxy(DataSource dataSource) {
        return ProxyDataSourceBuilder.create(dataSource)
                .name("ProxyDataSource")
                .countQuery()
                .multiline()
//                .logQueryBySlf4j()
                .listener(new SLF4JQueryLoggingListener())
                .logSlowQueryToSysOut(1, TimeUnit.SECONDS)
                .build();
    }

    public static DataSource newH2DataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        ds.setUser("sa");
        ds.setPassword("");
        return ds;
    }
}
