package br.com.oobj.avaliacaooobj.enfileirador;

import br.com.oobj.avaliacaooobj.broker.EnviaMensagem;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class LeitorArquivo {
    private String diretorioDoArquivo = "";
    private final EnviaMensagem enviaMensagem;
    public LeitorArquivo(EnviaMensagem enviaMensagem) {
        this.enviaMensagem = enviaMensagem;
    }

    public void lerArquivo(String diretorio){

        try {
            FileReader fileReader = new FileReader(diretorio);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            StringBuilder conteudo = new StringBuilder();
            String linha = bufferedReader.readLine();

            while (linha != null) {
                conteudo.append(linha);
                conteudo.append(System.lineSeparator());

                if(linha.equals("25000;STAPLE_TOP_LEFT")){
                    String mensagem = conteudo.toString();
                    String fila = "pre_impressao";
                    enviaMensagem.enviaMensagem(fila, mensagem);
                    conteudo.delete(0, conteudo.length());
                }
                linha = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
            diretorioDoArquivo = diretorio;
            moverArquivoParaProcessados();

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public void moverArquivoParaProcessados(){
        File diretorioEntrada = new File(diretorioDoArquivo);

        File diretorioDestino = new File("src\\main\\resources\\arquivos\\processados\\");


        boolean sucesso = diretorioEntrada.renameTo(new File(diretorioDestino, diretorioEntrada.getName()));
        if (sucesso) {
            System.out.println("Arquivo será movido para '" + diretorioDestino.getAbsolutePath() + "'");
        } else {
            System.out.println("Erro ao mover arquivo '" + diretorioEntrada.getAbsolutePath() + "' para '"
                    + diretorioDestino.getAbsolutePath() + "'");
        }
    }
}
