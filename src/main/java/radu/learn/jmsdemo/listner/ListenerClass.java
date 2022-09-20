package radu.learn.jmsdemo.listner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import radu.learn.jmsdemo.configuration.JmsConfig;
import radu.learn.jmsdemo.model.FirstMessage;

@Slf4j
@Component
public class ListenerClass {
	/*
	 * Annotation that marks a method to be the target of a JMS message 
	 * listener on the specified destination.
	 * The containerFactory identifies the org.springframework.jms.config.JmsListenerContainerFactory
	 * to use to build the JMS listener container. If not set, a default container factory is assumed
	 * to be available with a bean name of jmsListenerContainerFactory unless an explicit default has
	 * been provided through configuration.
	 */
	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload FirstMessage msg,
					   @Headers MessageHeaders headers,
					   Message message) {// Messagenot the jms flavor
		log.debug(String.format("Received:%s", message.getPayload().toString()));
		//
	}
	
}
