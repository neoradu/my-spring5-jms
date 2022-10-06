package radu.learn.jmsdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;

@Configuration
@EnableJms 
public class JmsConfig {
	public static final String MY_QUEUE = "my-jms-queue";
	@Bean
	public MessageConverter messageConverter() {
		//under the covers when we send a message to JMS, this will convert that payload to a 
		//JMS TEXT message with a JSON payload  
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		//Specify the name of the JMS message property that carries the type id 
		//for the contained object: either a mapped id value or a raw Java class name.
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
