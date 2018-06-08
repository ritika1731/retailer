package com.cg.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
	
	//exchange will send the message through MESSAGE_QUEUE to queue
		public static final String MESSAGE_QUEUE="queue.key";
		
		//queue will recieve the message and make it durable
		@Bean
		Queue queue()
		{
			return new Queue(MESSAGE_QUEUE, true);
		}
		
		@Bean
		TopicExchange exchange()
		{
			return new TopicExchange("queue_exchange");
			
		}
		
		@Bean
		Binding binding(Queue queue, TopicExchange exchange)
		{
			return BindingBuilder.bind(queue).to(exchange).with(MESSAGE_QUEUE);
			
		}
		//to listen the message
		@Bean
		SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory, MessageListenerAdapter adapter)
		{
			SimpleMessageListenerContainer container=new SimpleMessageListenerContainer();
			container.setConnectionFactory(connectionFactory);
			container.setQueueNames(MESSAGE_QUEUE);
			container.setMessageListener(adapter);
			
			return container;
			
		}
		//onMessage method will consume the message
		@Bean
		MessageListenerAdapter listner(RabbitListener listner)
		{
			return new MessageListenerAdapter(listner,"onMessage");
		}
}