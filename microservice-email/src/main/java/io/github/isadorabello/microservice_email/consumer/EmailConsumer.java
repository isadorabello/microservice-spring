package io.github.isadorabello.microservice_email.consumer;

import io.github.isadorabello.microservice_email.dto.EmailRecordDTO;
import io.github.isadorabello.microservice_email.model.EmailModel;
import io.github.isadorabello.microservice_email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    private final EmailService service;

    public EmailConsumer(EmailService service){
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void ListenEmailQueue(@Payload EmailRecordDTO dto) {
//        System.out.println(dto.email());
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(dto, emailModel);
        service.sendEMail(emailModel);
    }

}
