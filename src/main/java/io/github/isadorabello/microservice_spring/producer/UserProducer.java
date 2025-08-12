package io.github.isadorabello.microservice_spring.producer;

import io.github.isadorabello.microservice_spring.model.Email;
import io.github.isadorabello.microservice_spring.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer (RabbitTemplate template){
        this.rabbitTemplate = template;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(User user){
        var email  = new Email();

        email.setUserId(user.getId());
        email.setEmailTo(user.getEmail());
        email.setSubject("Cadastro realizado com sucesso!");
        email.setText(user.getName() + ", seja bem vindo(a)!\nAgradecemos o seu cadastro, aproveite agora e saiba mais sobre todos os recursos disponíveis na nossa plataforma.");


        rabbitTemplate.convertAndSend("", routingKey, email);
    }


}
