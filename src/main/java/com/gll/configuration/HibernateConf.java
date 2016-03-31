package com.gll.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ComponentScan({ "com.gll" })
@PropertySource(value = { "classpath:db.properties" })
public class HibernateConf {

	private static final Logger logger = Logger.getLogger(HibernateConf.class);

	@Autowired
	private Environment environment;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.gll.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		if (environment.getRequiredProperty("database.name").equals("mysql_development")) {
			logger.info("...............registering mysql.......");
			dataSource.setDriverClassName(environment.getRequiredProperty("database.driver"));
			dataSource.setUrl(environment.getRequiredProperty("database.url"));
			dataSource.setUsername(environment.getRequiredProperty("database.user"));
			dataSource.setPassword(environment.getRequiredProperty("database.password"));
			logger.info("...............mysql registered.......");
		
		}else if(environment.getRequiredProperty("database.name").equals("postgres_test")){
			logger.info("...............postgres driver detected.......");
			dataSource.setDriverClassName(environment.getRequiredProperty("database.driver"));
			try {
				Class.forName("org.postgresql.Driver");
				logger.info("...............postgres driver registered.......");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.info("...............some error in postgres driver registration.......");
			}
			//dataSource.setUrl(environment.getRequiredProperty("database.url"));
			//dataSource.setUsername(environment.getRequiredProperty("database.user"));
			//dataSource.setPassword(environment.getRequiredProperty("database.password"));
			dataSource.setUrl("postgres://czfqcikbflcyrz:ref7RkTr08xzUrVEP5CLeZU4gX@ec2-107-20-136-89.compute-1.amazonaws.com:5432/d9bgeojprit0cq");

		}else if(environment.getRequiredProperty("database.name").equals("postgres_production")){
			logger.info("...............postgres driver detected.......");
			dataSource.setDriverClassName("org.postgresql.Driver");
			try {
				Class.forName("org.postgresql.Driver");
				logger.info("...............postgres driver registered.......");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				logger.info("...............some error in postgres driver registration.......");
			}
			dataSource.setUrl(System.getenv("JDBC_DATABASE_URL"));
		}
		return dataSource;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
}
