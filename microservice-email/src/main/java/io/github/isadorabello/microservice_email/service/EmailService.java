package io.github.isadorabello.microservice_email.service;

import io.github.isadorabello.microservice_email.model.EmailModel;
import io.github.isadorabello.microservice_email.model.StatusEmail;
import io.github.isadorabello.microservice_email.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    final EmailRepository repository;
    final JavaMailSender sender;

    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.repository = emailRepository;
        this.sender = javaMailSender;
    }

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailModel sendEMail(EmailModel model){
        try{
            model.setSendDateEmail(LocalDateTime.now());
            model.setEmailFrom(emailFrom);


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(model.getEmailTo());
            message.setSubject(model.getSubject());
            message.setText(model.getTextEmail());
            sender.send(message);

            model.setStatusEmail(StatusEmail.SENT);

        }catch (MailException e){
            model.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return repository.save(model);
        }
    }

}
