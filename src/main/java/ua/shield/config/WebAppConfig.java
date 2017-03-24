package ua.shield.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactoryBean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by sa on 24.03.17.
 */
//@Configuration
//@EnableWebMvc
//@EnableTransactionManagement
//@ComponentScan
//@PropertySources("classpath:")
//@EnableJpaRepositories("ua.shield.service")
public class WebAppConfig {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    //@Resource
    Environment environment;

    //@Bean
     public DataSource dataSource(){
         EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
         EmbeddedDatabase db = builder
                 .setType(EmbeddedDatabaseType.H2) //.H2 or .DERBY
                 .addScript("db/sql/create-db.sql")
                 .addScript("db/sql/insert-data.sql")
                 .build();
         return db;
     }


}
