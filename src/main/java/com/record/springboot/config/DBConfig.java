package com.record.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("mysql.properties")
@Configuration
public class DBConfig {

}
