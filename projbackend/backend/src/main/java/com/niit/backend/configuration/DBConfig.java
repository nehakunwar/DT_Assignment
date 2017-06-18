package com.niit.backend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.backend.model.User;

@Configuration
@ComponentScan("com.niit.backend")
@EnableTransactionManagement
public class DBConfig {
	// create an instance
	/*
	 * @Bean(name = "dataSource") public DataSource getOracleDataSource() {
	 * DriverManagerDataSource dataSource = new DriverManagerDataSource();
	 * 
	 * dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	 * dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	 * 
	 * dataSource.setUsername("PUFFDB"); // Schema name
	 * dataSource.setPassword("12345");
	 * 
	 * Properties connectionProperties = new Properties();
	 * 
	 * connectionProperties.setProperty("hibernate.dialect",
	 * "org.hibernate.dialect.Oracle10gDialect");
	 * 
	 * connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");
	 * connectionProperties.setProperty("hibernate.show_sql", "true");
	 * 
	 * connectionProperties.setProperty("hibernate.format_sql", "true");
	 * connectionProperties.setProperty("hibernate.jdbc.use_get_generated_keys",
	 * "true");
	 * 
	 * // connectionProperties.setProperty("hibernate.default_schema", //
	 * "COLB_DB"); dataSource.setConnectionProperties(connectionProperties);
	 * return dataSource; }
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "sessionFactory") public SessionFactory
	 * getSessionFactory(DataSource dataSource) { LocalSessionFactoryBuilder
	 * sessionBuilder = new LocalSessionFactoryBuilder(dataSource); //
	 * sessionBuilder.addProperties(getHibernateProperties());
	 * sessionBuilder.addAnnotatedClass(User.class); return
	 * sessionBuilder.buildSessionFactory(); }
	 * 
	 * @Autowired
	 * 
	 * @Bean(name = "transactionManager") public HibernateTransactionManager
	 * getTransactionManager(SessionFactory sessionFactory) {
	 * HibernateTransactionManager transactionManager = new
	 * HibernateTransactionManager(sessionFactory);
	 * 
	 * return transactionManager; }
	 */

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder lsf = new LocalSessionFactoryBuilder(getDataSource());
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		lsf.addProperties(hibernateProperties);
		Class classes[] = { User.class };
		return lsf.addAnnotatedClasses(classes)

				.buildSessionFactory();
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("NEHADB");
		dataSource.setPassword("12345");
		return dataSource;
	}

	@Bean
	public HibernateTransactionManager hibTransManagement() {
		return new HibernateTransactionManager(sessionFactory());
	}

}