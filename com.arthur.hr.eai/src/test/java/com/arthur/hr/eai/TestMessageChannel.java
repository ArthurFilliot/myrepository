package com.arthur.hr.eai;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class TestMessageChannel {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context_eai_test.xml");

		MessageChannel channel = context.getBean("messageChannel", MessageChannel.class);
		Message<String> message1 = MessageBuilder.withPayload("bla").build();
		Message<String> message2 = MessageBuilder.withPayload("bla").build();
		Message<String> message3 = MessageBuilder.withPayload("bla").build();
		Message<String> message4 = MessageBuilder.withPayload("bli").build();
		Message<String> message5 = MessageBuilder.withPayload("bli").build();
		Message<String> message6 = MessageBuilder.withPayload("bli").build();
		channel.send(message1);
		channel.send(message2);
		channel.send(message3);
		channel.send(message4);
		channel.send(message5);
		channel.send(message6);
	}

}
