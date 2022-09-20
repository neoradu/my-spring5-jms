package radu.learn.jmsdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableScheduling.html
@EnableScheduling
//https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/scheduling/annotation/EnableAsync.html
@EnableAsync
@Configuration
public class TaskConfig {
	
	@Bean //https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/scheduling.html
	TaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}
}
