package com.jpt.restservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.jpt.restservice.service"})
@Import(SecurityConfiguration.class)
public class ApplicationConfig {

}
