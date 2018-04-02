package com.arthur.hr.eai;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class TestEmployeesFeedChannelWithControlBus {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context_eai.xml");
		
		MessageChannel operationChannel = context.getBean("operationChannel", MessageChannel.class);
		Message<String> stop = MessageBuilder.withPayload("@employeeFeedServiceActivator.stop()").build();
	    operationChannel.send(stop);
	    
		MessageChannel channel = context.getBean("employeeFeedChannel", MessageChannel.class);
		Message<String> message = MessageBuilder.withPayload("nop").build();
		channel.send(message);
		
		System.out.println("No service processing here");
		
		Message<String> start = MessageBuilder.withPayload("@employeeFeedServiceActivator.start()").build();
	    operationChannel.send(start);
		
		System.out.println("Service is processing now");

		context.close();
	}

}
