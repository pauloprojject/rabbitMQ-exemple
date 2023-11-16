# rabbitMQ-exemple

Aplicação exemplo de implementação simples do rabbitMQ no spring boot.

requer: docker

comandos:

docker pull rabbitmq:3.12.8-management

docker run --rm -it -p 15672:15672 -p 5672:5672 rabbitmq:3.12.8-management

site: http://localhost:15672/
