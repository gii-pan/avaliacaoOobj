package br.com.oobj.avaliacaooobj.enfileirador;

import br.com.oobj.avaliacaooobj.broker.EnviarMensagem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivo {
    public String diretorioDoArquivo = "";
    public EnviarMensagem enviarMensagem = new EnviarMensagem();
    public void lerArquivo(String diretorio){
        try {
            FileReader fileReader = new FileReader(diretorio);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String mensagem;
            StringBuilder conteudo = new StringBuilder();
            String linha = bufferedReader.readLine();

            while (linha != null) {
                conteudo.append(linha);
                conteudo.append(System.lineSeparator());

                if(linha.equals("25000;STAPLE_TOP_LEFT")){

                    mensagem = conteudo.toString();
                    enviarMensagem.enviaMensagem(mensagem, "pre_impressao");
//                    System.out.println(mensagem);
                }
                linha = bufferedReader.readLine();
            }
            fileReader.close();
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
            System.out.println("Arquivo movido para '" + diretorioDestino.getAbsolutePath() + "'");
        } else {
            System.out.println("Erro ao mover arquivo '" + diretorioEntrada.getAbsolutePath() + "' para '"
                    + diretorioDestino.getAbsolutePath() + "'");
        }
    }
}
