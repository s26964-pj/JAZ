package com.example.customvalidator;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {


    @Primary
    @Bean(name = "mainDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource mainDataSource() {
        DataSourceProperties mainDataSourceProperties = new DataSourceProperties();
        return mainDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "dictionaryDataSource")
    @ConfigurationProperties("spring.datasource.dictionary")
    public DataSource dictionaryDataSource() {
        DataSourceProperties dictionaryDataSourceProperties = new DataSourceProperties();
        return dictionaryDataSourceProperties.initializeDataSourceBuilder().build();
    }
}
