package br.com.oobj.avaliacaooobj;

import br.com.oobj.avaliacaooobj.converter.ConverteArquivo;
import br.com.oobj.avaliacaooobj.reader.LeitorArquivo;
import org.springframework.stereotype.Service;

@Service
public class PreImpressaoService {

    private  ConverteArquivo converteArquivo = new ConverteArquivo();

    private LeitorArquivo leitorArquivo = new LeitorArquivo();
    private String diretorio = "";

    public void realizarPreImpressao(String textoRequisicao) {
        // Recebe da Requisição e transforma em arquivo
        diretorio = converteArquivo.converterTextoParaArquivo(textoRequisicao);

        // Realiza leitura e transforma em mensagem
        leitorArquivo.lerArquivo(diretorio);

    }
}
