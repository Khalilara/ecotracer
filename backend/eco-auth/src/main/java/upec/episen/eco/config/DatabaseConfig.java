package upec.episen.eco.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class DatabaseConfig {

    @Value("${DATABASE_URL}")
    private String dbHost;

    @Value("${DATABASE_NAME}")
    private String dbName;

    @Value("${DATABASE_USERNAME}")
    private String dbUser;

    @Value("${DATABASE_PASSWORD}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        String jdbcUrl = "jdbc:postgresql://" + dbHost + "/" + dbName + "?characterEncoding=UTF-8";

        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl(jdbcUrl);
        config.setUsername(dbUser);
        config.setPassword(dbPassword);

        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setShowSql(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(vendorAdapter);

        factory.setPackagesToScan("upec.episen.eco");

        Map<String, Object> jpaProps = new HashMap<>();
        jpaProps.put(AvailableSettings.HBM2DDL_AUTO, "update");
        jpaProps.put(AvailableSettings.SHOW_SQL, false);

        factory.setJpaPropertyMap(jpaProps);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
