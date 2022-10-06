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
	 * Annotated JMS listener methods are allowed to have flexible signatures :

	 * javax.jms.Session to get access to the JMS session
	 * javax.jms.Message or one of its subclasses to get access to the raw JMS message
	 * org.springframework.messaging.Message to use Spring's messaging abstraction counterpart
     * @Payload-annotated method arguments, including support for validation
     * @Header-annotated method arguments to extract specific header values, including 
     * standard JMS headers defined by org.springframework.jms.support.JmsHeaders
	 * @Headers-annotated method argument that must also be assignable to java.util.Map for obtaining access to all headers
	 * org.springframework.messaging.MessageHeaders arguments for obtaining access to all headers
     * org.springframework.messaging.support.MessageHeaderAccessor or org.springframework.jms.support.JmsMessageHeaderAccessor
     * for convenient access to all method arguments
	 */
	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload FirstMessage msg,
					   @Headers MessageHeaders headers,
					   Message message) {// Messagenot the jms flavor
		log.debug(String.format("Received:%s", message.getPayload().toString()));
		//
	}
	
}
