package com.arthur.hr.eai;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class TestEmployeesFeedChannel {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context_eai.xml");
		
		MessageChannel channel = context.getBean("employeeFeedChannel", MessageChannel.class);
		Message<String> message = MessageBuilder.withPayload("nop").build();
		channel.send(message);
	}

}
