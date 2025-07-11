package com.seleniumexpress.postgresql.databaseConfiguration;

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
@EnableJpaRepositories(
basePackages = "com.seleniumexpress.postgresql.repository", 
transactionManagerRef = "postgresqlTransactionManager",
entityManagerFactoryRef = "postgresqlentityManagerFactory")
@EnableTransactionManagement
public class PostgreSqlConfig {

	@Bean
	@ConfigurationProperties(value = "spring.datasource.postgresql")
	public DataSourceProperties postgreSqlDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "postgresql")
	public DataSource postgresqldataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(postgreSqlDataSourceProperties().getUrl());
		dataSource.setUsername(postgreSqlDataSourceProperties().getUsername());
		dataSource.setPassword(postgreSqlDataSourceProperties().getPassword());
		dataSource.setDriverClassName(postgreSqlDataSourceProperties().getDriverClassName());
		return dataSource;
	}

	@Bean(name = "postgresqlentityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("com.seleniumexpress.postgresql.entity");
		emf.setDataSource(postgresqldataSource());
		emf.setJpaProperties(properties);
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}

	@Bean(name = "postgresqlTransactionManager")
	public PlatformTransactionManager postgreSqlTransactionManager(
			@Qualifier("postgresqlentityManagerFactory") EntityManagerFactory emf) {
		JpaTransactionManager manager = new JpaTransactionManager(emf);
		return manager;
	}

}
