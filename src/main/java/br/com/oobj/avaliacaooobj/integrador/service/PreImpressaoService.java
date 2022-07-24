package br.com.oobj.avaliacaooobj.integrador.service;

import br.com.oobj.avaliacaooobj.integrador.converter.ConverteArquivo;
import br.com.oobj.avaliacaooobj.enfileirador.LeitorArquivo;
import org.springframework.stereotype.Service;

@Service
public class PreImpressaoService {

    private final ConverteArquivo converteArquivo = new ConverteArquivo();

    private final LeitorArquivo leitorArquivo = new LeitorArquivo();

    public void realizarPreImpressao(String textoRequisicao) {
        // Recebe da Requisição e transforma em arquivo
        String diretorio = converteArquivo.converterTextoParaArquivo(textoRequisicao);

        // Realiza leitura e transforma em mensagem
        leitorArquivo.lerArquivo(diretorio);

    }
}
