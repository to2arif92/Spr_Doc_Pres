package pkg.spring.basic.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ArIF on 28-Mar-17.
 */
@Configuration
@ComponentScan("pkg.spring.basic")
@EnableTransactionManagement
// Load to Environment
@PropertySource("classpath:database.properties")
public class AppContextConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
        rb.setBasenames(new String[]{"messages/validator"});
        return rb;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        // See: datasouce-cfg.properties
        dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
        dataSource.setJdbcUrl(env.getProperty("ds.url"));
        dataSource.setUsername(env.getProperty("ds.username"));
        dataSource.setPassword(env.getProperty("ds.password"));

        logger.info("## getDataSource: " + dataSource);

        return dataSource;
    }

    

    // to get rid instantiating JdbcTemplate elsewhere
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    private Properties hibernateProperties(){
        return new Properties() {
            {
                /*setProperty("hibernate.hbm2ddl.auto",
                        env.getProperty("hibernate.hbm2ddl.auto"));*/
                setProperty("hibernate.dialect",
                        env.getProperty("hibernate.dialect"));
                setProperty("hibernate.format_sql",
                        env.getProperty("hibernate.format_sql"));
                setProperty("hibernate.show_sql",
                        env.getProperty("hibernate.show_sql"));
            }
        };
    }

    @Bean
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(getDataSource());
        lsfb.setPackagesToScan("pkg.spring.basic.entity");
        lsfb.setHibernateProperties(hibernateProperties());
        try {
            lsfb.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lsfb.getObject();
    }

    // Transaction Manager

    @Bean(name = "transactionManager")
    public HibernateTransactionManager transactionManager(){
        /*HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;*/
        return new HibernateTransactionManager(sessionFactory());
    }



}
