package com.cg.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	
		//exchange will send the message through MESSAGE.QUEUE to queue
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
}
