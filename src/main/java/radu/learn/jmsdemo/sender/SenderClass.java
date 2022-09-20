package radu.learn.jmsdemo.sender;

import java.util.UUID;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import radu.learn.jmsdemo.configuration.JmsConfig;
import radu.learn.jmsdemo.model.FirstMessage;

@Slf4j
@Component
public class SenderClass {
	// this is a preconfigured template to talk to our ActiveMQ instance
	private final JmsTemplate jmsTemplate;
	
	public SenderClass(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}
	//Annotation that marks a method to be scheduled. Exactly one of the cron,
	//fixedDelay, or fixedRate attributes must be specified.
	@Scheduled(fixedRate = 2000)
	public void sendMessage() {
		log.debug("sendMessage...");
		FirstMessage message = FirstMessage.builder()
										   .uuid(UUID.randomUUID())
										   .message("Hello World")
										   .build();
		jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);
		log.debug("message send!");
		
	}
}
