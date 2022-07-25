package br.com.oobj.avaliacaooobj.integrador.service;

import br.com.oobj.avaliacaooobj.Receiver.CriaArquivoFinal;
import br.com.oobj.avaliacaooobj.Receiver.RecebeMensagem;
import br.com.oobj.avaliacaooobj.integrador.converter.ConverteArquivo;
import br.com.oobj.avaliacaooobj.enfileirador.LeitorArquivo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreImpressaoService {

    private final ConverteArquivo converteArquivo = new ConverteArquivo();

    private final CriaArquivoFinal criaArquivoFinal = new CriaArquivoFinal();

    private final LeitorArquivo leitorArquivo;

    private final RecebeMensagem recebeMensagem;
    public PreImpressaoService(LeitorArquivo leitorArquivo, RecebeMensagem recebeMensagem) {
        this.leitorArquivo = leitorArquivo;
        this.recebeMensagem = recebeMensagem;
    }

    public void realizarPreImpressao(String textoRequisicao) {
        // Recebe da Requisição e transforma em arquivo
        String diretorio = converteArquivo.converterTextoParaArquivo(textoRequisicao);

        // Realiza leitura e transforma em mensagem
        leitorArquivo.lerArquivo(diretorio);

        // Consumir as mensagens e enviar arquivo final
        List<String> listaDeMensagensConsumidas = recebeMensagem.retornaMensagem();

        criaArquivoFinal.criaLayout(listaDeMensagensConsumidas);

    }
}
