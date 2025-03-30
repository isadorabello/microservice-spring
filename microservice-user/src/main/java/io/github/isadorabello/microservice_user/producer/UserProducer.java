package io.github.isadorabello.microservice_user.producer;

import io.github.isadorabello.microservice_user.model.EmailModel;
import io.github.isadorabello.microservice_user.model.UserModel;
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

    public void publishMessageEmail(UserModel model){
        var emailModel  = new EmailModel();

        emailModel.setId(model.getId());
        emailModel.setEmail(model.getEmail());
        emailModel.setSubject("Cadastro realizado com sucesso!");
        emailModel.setText(model.getName() + ", seja bem vindo(a)!\nAgradecemos o seu cadastro, aproveite agora e saiba mais sobre todos os recursos disponíveis na nossa plataforma.");


        rabbitTemplate.convertAndSend("", routingKey, emailModel);
    }


}
