package pkg.spring.basic.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by ArIF on 28-Mar-17.
 */
@Configuration
@ComponentScan("pkg.spring.basic")
@EnableTransactionManagement
// Load to Environment
/*@PropertySource({
        "classpath:hibernateCustom.properties",
        "classpath:hikari.properties"
})*/
@PropertySources({
        @PropertySource("classpath:hibernateCustom.properties"),
        @PropertySource("classpath:hikari.properties")
})
public class AppContextConfig {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Bean
    public Logger getLogger(){
        return LoggerFactory.getLogger(this.getClass());
    }
    @Autowired
    private Logger logger;
    // The Environment class serves as the property holder
    // and stores all the properties loaded by the @PropertySource
    @Autowired
    private Environment env;

    /*@Autowired
    private UserInfoDAO userInfoDAO;*/

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
        rb.setBasenames("messages/validator");  // use new String[]{} if multiple path
        return rb;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(env.getProperty("dataSource.driverClassName"));// Use it if not works
        config.setJdbcUrl(env.getProperty("dataSource.jdbcUrl"));
        config.setUsername(env.getProperty("dataSource.user"));
        config.setPassword(env.getProperty("dataSource.password"));

        /*config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");*/

        HikariDataSource dataSource = new HikariDataSource(config);
        logger.info("## getDataSource: " + dataSource);

        return dataSource;
    }

    

    // to get rid instantiating JdbcTemplate elsewhere
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    private Properties hibernateProperties(){
        // convert this anonymous class into lamda exp
        Properties properties = new Properties();
        properties.setProperty(AvailableSettings.DIALECT,
                env.getProperty("hibernate.dialect"));

        properties.setProperty("hibernate.format_sql",
                env.getProperty("hibernate.format_sql"));
        properties.setProperty("hibernate.show_sql",
                env.getProperty("hibernate.show_sql"));
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO,
                env.getProperty("hibernate.hbm2ddl.auto"));
        /*return new Properties() {
            {
                *//*setProperty("hibernate.hbm2ddl.auto",
                        env.getProperty("hibernate.hbm2ddl.auto"));*//*
                setProperty(AvailableSettings.DIALECT,
                        env.getProperty("hibernate.dialect"));
                setProperty("hibernate.format_sql",
                        env.getProperty("hibernate.format_sql"));
                setProperty("hibernate.show_sql",
                        env.getProperty("hibernate.show_sql"));
                setProperty(AvailableSettings.HBM2DDL_AUTO,
                        env.getProperty("hibernate.hbm2ddl.auto"));*//*
                setProperty(AvailableSettings.CONNECTION_PROVIDER,
                        env.getProperty("hibernate.connection.provider_class"));*//*
                *//*setProperty(AvailableSettings.AUTOCOMMIT,
                        env.getProperty("hibernate.connection.autocommit"));*//*
            }
        };*/
        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setPackagesToScan("pkg.spring.basic.model");
        lsfb.setHibernateProperties(hibernateProperties());

        return lsfb;
    }

// Transaction Manager

    @Bean(name = "transactionManager")
    @Autowired  // sessionFactory
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }



}
