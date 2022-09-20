package radu.learn.jmsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JmsdemoApplication {

	public static void main(String[] args) throws Exception {
		//THis is not necesarry. If we have the dependencies in the pom, Spring boot will runs an embedded server automatically
		/*ActiveMQServer server = ActiveMQServers.newActiveMQServer(
				                                  new ConfigurationImpl()
				                                  	  .setPersistenceEnabled(false)
				                                  	  .setJournalDirectory("target/data/journal")
				                                  	  .setSecurityEnabled(false)
				                                  	  .addAcceptorConfiguration("invm", "vm://0"));
		server.start();*/
		SpringApplication.run(JmsdemoApplication.class, args);
	}

}
