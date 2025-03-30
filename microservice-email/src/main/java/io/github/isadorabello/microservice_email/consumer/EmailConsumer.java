package io.github.isadorabello.microservice_email.consumer;

import io.github.isadorabello.microservice_email.dto.EmailRecordDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void ListenEmailQueue(@Payload EmailRecordDTO dto) {
        System.out.println(dto.email());
    }

}
