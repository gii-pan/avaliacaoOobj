package br.com.oobj.avaliacaooobj.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviarMensagem {
    @Autowired
    private JmsTemplate jmsTemplate;
    public void enviaMensagem(final String mensagem, String fila) {
         jmsTemplate.convertAndSend(fila, mensagem);
    }
}
