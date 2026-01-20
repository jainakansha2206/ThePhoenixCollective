package com.thephoenixcollective.user_service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class EmailConfig {

    @Bean("emailExecutor")
    public TaskExecutor emailExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);  // 20 workers
        executor.setMaxPoolSize(50);
        executor.setThreadNamePrefix("email-");
        executor.initialize();
        return executor;
    }
}
