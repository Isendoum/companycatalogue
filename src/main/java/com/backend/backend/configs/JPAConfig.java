package com.backend.backend.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.backend.backend.repositories")
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("uyu0m8ckqzgaumvl");
        dataSource.setPassword("PA7LSS9hfp2JFXzJOS7Z");
        dataSource.setUrl("jdbc:mysql://uyu0m8ckqzgaumvl:PA7LSS9hfp2JFXzJOS7Z@b7zbas9ctlowoqil6c8a-mysql.services.clever-cloud.com:3306/b7zbas9ctlowoqil6c8a");
        //development link:jdbc:mysql://localhost:3306/qnr
        //production link:jdbc:mysql://uyu0m8ckqzgaumvl:PA7LSS9hfp2JFXzJOS7Z@b7zbas9ctlowoqil6c8a-mysql.services.clever-cloud.com:3306/b7zbas9ctlowoqil6c8a
        return dataSource;
    }



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.backend.backend.entities" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }


    @Bean
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        return properties;
    }

}
