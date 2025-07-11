package com.seleniumexpress.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mySqlEntityManager", basePackages = "com.seleniumexpress.mysql.repository", transactionManagerRef = "mySqlTransactionManager"

)
@Configuration
@ComponentScan("com.seleniumexpress")
public class MySqlconfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSourceProperties mySqldataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource mySqlDataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setUsername(mySqldataSourceProperties().getUsername());
		source.setUrl(mySqldataSourceProperties().getUrl());
		source.setPassword(mySqldataSourceProperties().getPassword());
		source.setDriverClassName(mySqldataSourceProperties().getDriverClassName());

		// return dataSourceProperties().initializeDataSourceBuilder().build();
		return source;
	}

	@Bean(name = "mySqlEntityManager")
	public LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean() {

		Map<String, Object> properties = new HashMap<>();
		// properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");

		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setPackagesToScan("com.seleniumexpress.entity.mysql");
		emf.setDataSource(mySqlDataSource());
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		emf.setJpaPropertyMap(properties);

		return emf;

	}

	@Bean
	public PlatformTransactionManager mySqlTransactionManager(
			@Qualifier(value = "mySqlEntityManager") EntityManagerFactory emf) {

		JpaTransactionManager manager = new JpaTransactionManager(emf);

		return manager;

	}
}
