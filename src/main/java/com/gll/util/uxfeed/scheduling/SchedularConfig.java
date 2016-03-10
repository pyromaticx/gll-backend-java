package com.gll.util.uxfeed.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.gll.util.uxfeed.scheduling")
public class SchedularConfig implements SchedulingConfigurer {

	/*@Bean
	public ShortSchedular getShortSchedular() {
		return new ShortSchedular();
	}
	
	@Bean
	public LongSchedular getLongSchedular() {
		return new LongSchedular();
	}*/
    
	@Autowired
	ShortSchedular shortSchedular;
	
	@Autowired
	LongSchedular longSchedular;
	
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(taskExecutor());
    }

    @Bean(destroyMethod="shutdown")
    public Executor taskExecutor() {
        return Executors.newScheduledThreadPool(10);
    }

}
