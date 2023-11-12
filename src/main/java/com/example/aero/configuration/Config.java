package com.example.aero.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {
    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(env.getProperty("driverClassName"));
        driverManagerDataSource.setUrl(env.getProperty("url"));
        driverManagerDataSource.setUsername(env.getProperty("user"));
        driverManagerDataSource.setPassword(env.getProperty("password"));
        return driverManagerDataSource;
    }
}
