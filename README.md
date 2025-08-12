
# Mensageria com RabbitMQ

Este é um projeto simples de mensageria utilizando RabbitMQ como broker de mensagens e Spring Boot para o desenvolvimento de dois microsserviços:

User Service: Responsável por receber cadastros de usuários e publicar mensagens no broker.
- Expondo API REST para cadastro e login de usuários.
- Salvando dados no PostgreSQL.
- Publicando mensagens no RabbitMQ.

Email Service: Responsável por escutar mensagens do broker e enviar e-mails específicos aos usuários.
- Escutando mensagens do RabbitMQ.
- Enviando e-mails específicos aos usuários.
- Registrando logs no banco de dados.

O banco de dados utilizado é o PostgreSQL, que é executado via Docker.

Certifique-se de clonar os dois repositórios (producer e Consumer).

## Requisitos do Sistema

Para rodar esta aplicação, você precisa de:

- Java: JDK 21 ou superior.
- Maven: Versão 3.8.1 ou superior.
- Git: Para clonar o repositório.
- Docker (Opcional): Para rodar a imagem do PostgreSQL


## Como Rodar o PostgreSQL no Docker (Opcional)

Crie a Imagem Docker Certifique-se de que o Docker está instalado e execute:


Crie uma rede entre os dois containers
```bash
docker network create ms-network
```

Crie as imagens do PostgreSQL e do Servidor PgAdmin4

```bash
docker run --name ms -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=ms-email -p 5432:5432 -d --network ms-network postgres:16
```

```bash
docker run --name pgadmin4-ms -e PGADMIN_DEFAULT_EMAIL=admin@admin.com -e PGADMIN_DEFAULT_PASSWORD=admin -p 15432:80 -d --network ms-network dpage/pgadmin4:9.0
```

## Configurando os Microsserviços

Certifique-se de definir as configurações corretas no application.yml de cada microsserviço, incluindo:
- Configuração do banco de dados (PostgreSQL).
- Configuração do RabbitMQ (host, porta, fila, exchange, routing key.




## Rodando Localmente

Clone o projeto

```bash
  git clone https://github.com/isadorabello/microservice-spring.git
```

Entre no diretório do projeto

```bash
  cd microservice-spring
```

Compile o Projeto

```bash
   mvn clean install
```

Inicie o servidor

```bash
  mvn spring-boot:run
```


## Documentação da API

#### Criar um novo usuário

```http
  POST /users
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `String` | **Obrigatório**. O nome do usuário|
| `email` | `String` | **Obrigatório**. O email do usuário|
