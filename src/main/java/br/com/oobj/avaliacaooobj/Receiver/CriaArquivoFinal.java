package br.com.oobj.avaliacaooobj.Receiver;

import java.util.ArrayList;
import java.util.List;

public class CriaArquivoFinal {
    public String itinerario = "";
    public String sequencia = "";
    public String layoutFinal = "";
    public void criaLayout(List<String> mensagemListener) {
        List<String> saidaFinal = new ArrayList<>();

        for (String mensagemConsumida : mensagemListener) {
            String[] linhasmensagem = mensagemConsumida.split("\n");

            for (String linha : linhasmensagem) {
                if (linha.startsWith("22002")) {
                    String linhaSemEspaco = linha.replace(" ", "");
                    itinerario = linhaSemEspaco.substring(linhaSemEspaco.indexOf("SUB-ITINERÁRIO:")+15);
                }
                if (linha.startsWith("22007")) {
                    String linhaSemEspaco = linha.replace(" ", "");
                    sequencia = linhaSemEspaco.substring(linhaSemEspaco.indexOf("SEQ:")+4);
                    layoutFinal = itinerario+" | "+sequencia;
                    saidaFinal.add(layoutFinal);
                }
            }
        }
    }
}
