# avaliacaoOobj
Projeto disponibilizado pela Oobj para avaliação

Encontra-se na branch master

O projeto desenvolvido consiste de uma solução de integração nos moldes das soluções conhecidas no mercado. Há 5 componentes principais:

Sender
- Simular as chamadas aos endpoints da API de integração.

Utilizar o postman e anexar no header da requisiçãoo seguinte trecho para a validação da segurança:
Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJQcm9qZWN0TkYiLCJzdWIiOiJBUEktS2V5IiwiaWF0IjoxNjU5MDUwNDg0fQ.XxuWDgE2ffVJNHOXoy04xDa7uGox0PwiHvIdbYGjhcA

Integrador
- Responsável por expor os endpoints de integração e salvar o conteúdo da requisição em um pasta de entrada da aplicação.
- Responsável por iniciar o fluxo apresentado acima que é executado automaticamente em resposta à “chegada” de uma requisição.

Enfileirador
- Responsável por ler os arquivos da pasta de entrada e enfileirar os dados no Message Broker.

Broker
- Desempenhado pelo Apache ActiveMQ irá distribuir as mensagens para as múltiplas instâncias consumidoras da aplicação Receiver.

Receiver
- Consumir as mensagens do Broker e, neste momento, apenas simular através de saída no console a impressão dos manifestos de transporte.

