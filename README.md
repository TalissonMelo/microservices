# Microserviços
Esse projeto tem como objetivo inicial demonstrar o uso das tecnologias Spring Boot, Spring Cloud, Eureka Discovery, Zuul Gateway, Spring Security, Spring Web, MySQL, Flyway , Lombok, Hibernate, Rest Repositories e Gradle Project.

![exemplo](https://github.com/TalissonMelo/microservices/blob/master/image/img.jpg)

Microservices  valoriza a granularidade, a leveza e a capacidade de compartilhar processos semelhantes entre várias aplicações. Trata-se de um componente indispensável para a otimização do desenvolvimento de aplicações para um modelo nativo em nuvem, os microsserviços são componentes separados que trabalham juntos para realizar as mesmas tarefas. Cada um dos componentes ou serviços  é um microsserviço.
Para o cliente se comunicar com um microservice ele tem que passar por uma api gateway que atravez do service register sabe onde cada microservice esta registrado e a api gateway tambem esta registrada no service register o service register conversa com o service descovery que tem o ip, port e servidor de cada microservice  e a api gateway vai direcionar a requisição corretamente para cada service com os dados fornecidos. 
