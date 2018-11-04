package com.gameof3.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.gameof3.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.gameof3.entity" })
public class RepositoryConfig {
}
