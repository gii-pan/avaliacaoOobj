package br.com.oobj.avaliacaooobj.Receiver;

import br.com.oobj.avaliacaooobj.service.ArquivoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CriaArquivoFinal {
    private String itinerario = "";
    private final List<String> saidaFinal = new ArrayList<>();
    public String diretorio = "src\\main\\resources\\arquivos\\saida\\";
    private final ArquivoService arquivoService = new ArquivoService();

    public void criaLayout(List<String> mensagemListener) {

        for (String mensagemConsumida : mensagemListener) {
            String[] linhasmensagem = mensagemConsumida.split("\n");

            for (String linha : linhasmensagem) {
                if (linha.startsWith("22002")) {
                    String linhaSemEspaco = linha.replace(" ", "");
                    itinerario = linhaSemEspaco.substring(linhaSemEspaco.indexOf("SUB-ITINERÁRIO:")+15);
                }
                if (linha.startsWith("22007")) {
                    String linhaSemEspaco = linha.replace(" ", "");
                    String sequencia = linhaSemEspaco.substring(linhaSemEspaco.indexOf("SEQ:") + 4);
                    String layoutFinal = itinerario + " | " + sequencia;
                    saidaFinal.add(layoutFinal);
                }
            }
        }
        Collections.sort(saidaFinal);
    }

    public void escreveArquivoFinal(List<String> mensagemListener, String nomeArquivoEntrada) {
        criaLayout(mensagemListener);
        String ordena = String.join("\n", saidaFinal);
        String nomeArquivoSaida = arquivoService.retornaNomeDoArquivoDeSaidaFormatado(nomeArquivoEntrada);
        arquivoService.escreveArquivo(diretorio, nomeArquivoSaida, ordena);
    }
}
