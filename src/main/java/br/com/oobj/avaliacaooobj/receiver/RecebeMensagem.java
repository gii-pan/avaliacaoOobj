package br.com.oobj.avaliacaooobj.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RecebeMensagem {

    public List<String> listaDeMensagem = new ArrayList<>();

    @JmsListener(destination = "pre_impressao", concurrency = "2")
    public void recebeMensagem(String str) {
        listaDeMensagem.add(str);
    }

    public List<String> retornaMensagem() {
        return listaDeMensagem;
    }

    public void resetarLista() {
        listaDeMensagem.clear();
    }

}
