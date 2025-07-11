package com.seleniumexpress.mySql.databaseConfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(basePackages = "com.seleniumexpress.mySql.repository", transactionManagerRef = "mysqlTransactionManager", entityManagerFactoryRef = "mySqlentityManagerFactory")
@EnableTransactionManagement
public class MySqlConfig {

	@Bean
	@ConfigurationProperties(value = "spring.datasource.mysql")
	public DataSourceProperties mysqlDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "mysqlData")
	public DataSource mySqldataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(mysqlDataSourceProperties().getUrl());
		dataSource.setUsername(mysqlDataSourceProperties().getUsername());
		dataSource.setPassword(mysqlDataSourceProperties().getPassword());
		dataSource.setDriverClassName(mysqlDataSourceProperties().getDriverClassName());
		return dataSource;
	}

	@Bean(name = "mySqlentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("com.seleniumexpress.mySql.entity");
		emf.setDataSource(mySqldataSource());
		emf.setJpaProperties(properties);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return emf;
	}

	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager mysqlTransactionManager(
			@Qualifier("mySqlentityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager(emf);
		return manager;
	}

}
