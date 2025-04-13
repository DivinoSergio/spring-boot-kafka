# spring-boot-kafka
A aplicação é um sistema de processamento de mensagens que gerencia eventos representados por um DTO (MensagemDTO). Quando uma mensagem é recebida, o sistema publica um evento no Kafka para notificar outros serviços. Esses serviços consomem as mensagens de forma assíncrona, processam suas tarefas e, se necessário, publicam novos eventos no Kafka.
