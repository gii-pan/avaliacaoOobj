package br.com.oobj.avaliacaooobj.receiver;

import br.com.oobj.avaliacaooobj.service.ArquivoService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CriaArquivoFinal {
    private String itinerario = "";
    private final List<String> saidaFinal = new ArrayList<>();
    private final ArquivoService arquivoService;

    public CriaArquivoFinal(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }

    public void criaLayout(List<String> mensagemListener) {

        for (String mensagemConsumida : mensagemListener) {
            String[] linhasMensagem = mensagemConsumida.split("\n");

            for (String linha : linhasMensagem) {
                if (linha.startsWith("22002")) {
                    String linhaSemEspaco = linha.replace(" ", "");
                    itinerario = linhaSemEspaco.substring(linhaSemEspaco.indexOf("SUB-ITINERÁRIO:")+15);
                }
                if (linha.startsWith("22007")) {
                    String linhaSemEspaco = linha.replace(" ", "");
                    String sequencia = linhaSemEspaco.substring(linhaSemEspaco.indexOf("SEQ:") + 4);
                    String layoutFinal = itinerario+" | "+sequencia;
                    saidaFinal.add(layoutFinal.replace("\r", ""));
                }
            }
        }
        Collections.sort(saidaFinal);
    }

    public void escreveArquivoFinal(List<String> mensagemListener, String nomeArquivoEntrada) {
        criaLayout(mensagemListener);
        String ordena = String.join("\n", saidaFinal);
        String nomeArquivoSaida = arquivoService.retornaNomeDoArquivoDeSaidaFormatado(nomeArquivoEntrada);
        String diretorioSaida = "src\\main\\resources\\arquivos\\saida\\";
        arquivoService.escreveArquivo(diretorioSaida, nomeArquivoSaida, ordena);
        saidaFinal.clear();
    }
}
