package br.com.oobj.avaliacaooobj.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {

    public void lerArquivo(String diretorio){
        try {
            FileReader arq = new FileReader(diretorio);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine();
            String mensagem = "";
            while (linha != null) {
                if(linha.equals("…")){
                    linha = lerArq.readLine();
                }
                mensagem.concat(linha);
                System.out.printf("%s\n", linha);
                if(linha.equals("25000;STAPLE_TOP_LEFT")){
                    // chamar função para mandar mensagem para o ActiveMQ
                    System.out.println(mensagem);
                }
                linha = lerArq.readLine();
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
}
