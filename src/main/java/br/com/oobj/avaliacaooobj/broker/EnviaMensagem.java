package br.com.oobj.avaliacaooobj.broker;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EnviaMensagem {
    private final JmsTemplate jmsTemplate;

    public EnviaMensagem(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void enviaMensagem(String fila, String mensagem){
        jmsTemplate.convertAndSend(fila, mensagem);
    }
}
