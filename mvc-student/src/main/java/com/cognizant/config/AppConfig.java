package com.cognizant.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cognizant.dao.StudentDao;
import com.cognizant.dao.StudentDaoImpl;

@EnableWebMvc
@Configuration
@ComponentScan("com.cognizant")
@PropertySource(value = { "classpath:db.properties" })
public class AppConfig {


	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver intrenalResourceViewResover() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		return bean;
	}
	
	@Bean
	public DataSource dataSource() {
		
        DriverManagerDataSource ds = new DriverManagerDataSource();
        //MySQL database we are using
        ds.setDriverClassName(env.getRequiredProperty("DB_DRIVER_CLASS"));
        ds.setUrl(env.getRequiredProperty("DB_URL"));
        ds.setUsername(env.getRequiredProperty("DB_USERNAME"));
        ds.setPassword(env.getRequiredProperty("DB_PASSWORD"));
        return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) {
	       JdbcTemplate js = new JdbcTemplate(ds);
	        return js;
	}
	
	@Bean
	public StudentDao studentDao() {
		return new StudentDaoImpl();
	}
}
