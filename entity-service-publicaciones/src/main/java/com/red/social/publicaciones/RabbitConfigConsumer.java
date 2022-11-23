package com.red.social.publicaciones;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfigConsumer {

	public final static String QUEUE_PUBLICACIONES = "queue-publicaciones";
	public final static String QUEUE_COMENTARIOS = "queue-comentarios";

	@Bean
	Queue queue() {
		return new Queue(QUEUE_PUBLICACIONES);
	}

	@Bean
	Queue queue2() {
		return new Queue(QUEUE_COMENTARIOS);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange-principal");
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_PUBLICACIONES);
	}

	@Bean
	Binding binding2(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(QUEUE_COMENTARIOS);
	}
}
