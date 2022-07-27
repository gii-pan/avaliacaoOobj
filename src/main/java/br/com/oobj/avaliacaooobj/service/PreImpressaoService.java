package br.com.oobj.avaliacaooobj.service;

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

    private final ArquivoService arquivoService = new ArquivoService();

    private final LeitorArquivo leitorArquivo;

    private final RecebeMensagem recebeMensagem;
    public PreImpressaoService(LeitorArquivo leitorArquivo, RecebeMensagem recebeMensagem) {
        this.leitorArquivo = leitorArquivo;
        this.recebeMensagem = recebeMensagem;
    }

    public void realizarPreImpressao(String textoRequisicao) {
        // Retorna o nome do arquivo de entrada formatado
        String nomeArquivoDeEntrada = arquivoService.retornaNomeDoArquivoDeEntradaFormatado();

        // Recebe da Requisição e transforma em arquivo
        String diretorio = converteArquivo.converterTextoParaArquivo(textoRequisicao, nomeArquivoDeEntrada);

        // Realiza leitura e transforma em mensagem
        leitorArquivo.lerArquivo(diretorio);

        // Consumir as mensagens e enviar arquivo final
        List<String> listaDeMensagensConsumidas = recebeMensagem.retornaMensagem();

        // Cria arquivo final formatado
        criaArquivoFinal.escreveArquivoFinal(listaDeMensagensConsumidas, nomeArquivoDeEntrada);

    }
}
