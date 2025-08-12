# Projeto de Mensageria com RabbitMQ e Spring Boot

Descrição

Este é um projeto simples de mensageria utilizando RabbitMQ como broker de mensagens e Spring Boot para o desenvolvimento de dois microsserviços:

User Service: Responsável por receber cadastros/logins de usuários e publicar mensagens no broker.

Email Service: Responsável por escutar mensagens do broker e enviar e-mails específicos aos usuários.

O banco de dados utilizado é o PostgreSQL, que é executado via Docker.

Tecnologias Utilizadas

Spring Boot (Spring Web, Spring AMQP, Spring Data JPA)

RabbitMQ (mensageria)

PostgreSQL (banco de dados)

Docker (gerenciamento de contêineres)

Estrutura do Projeto

O projeto é dividido em dois microsserviços:

1. User Service (usuários)

Expondo API REST para cadastro e login de usuários.

Salvando dados no PostgreSQL.

Publicando mensagens no RabbitMQ.

2. Email Service (e-mails)

Escutando mensagens do RabbitMQ.

Enviando e-mails específicos aos usuários.

Registrando logs no banco de dados.

Como Executar o Projeto

1. Subindo o Ambiente com Docker

Antes de iniciar os microsserviços, suba os containers do PostgreSQL e do RabbitMQ com o seguinte comando:

docker-compose up -d

O arquivo docker-compose.yml deve conter a configuração para PostgreSQL e RabbitMQ.

2. Configurando os Microsserviços

Certifique-se de definir as configurações corretas no application.yml de cada microsserviço, incluindo:

Configuração do banco de dados (PostgreSQL).

Configuração do RabbitMQ (host, porta, fila, exchange, routing key).

3. Rodando os Microsserviços

Execute cada microsserviço separadamente:

## Iniciando o User Service
cd user-service
mvn spring-boot:run

## Iniciando o Email Service
cd email-service
mvn spring-boot:run

Fluxo de Execução

O User Service recebe uma requisição de cadastro de usuário via API REST (POST /users).

O usuário é salvo no banco de dados e uma mensagem é publicada no RabbitMQ.

O Email Service escuta a mensagem publicada no broker.

O Email Service envia um e-mail de confirmação ao usuário.

O envio do e-mail é registrado no banco de dados.

Endpoints Disponíveis

User Service

POST /users - Cria um novo usuário e publica mensagem no RabbitMQ.

GET /users/{id} - Retorna os dados de um usuário.

Email Service

Escuta mensagens do RabbitMQ e envia e-mails automaticamente.

Considerações Finais

Este projeto demonstra a implementação de um sistema de mensageria simples com Spring Boot, RabbitMQ e Docker, promovendo um ambiente assíncrono entre microsserviços.
