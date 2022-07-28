package br.com.oobj.avaliacaooobj.service;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ArquivoService {
    public void escreveArquivo(String diretorio, String nomeArquivo, String texto) {
        try{
            File arquivoEntrada = new File(diretorio,nomeArquivo);

            if(arquivoEntrada.createNewFile()){
                FileWriter fileWriter = new FileWriter(arquivoEntrada);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(texto);
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
            } else {
                System.out.println("Erro ao criar arquivo");
            }
        }catch (IOException e) {
            System.out.println("Erro ao converter arquivo");
            e.printStackTrace();
        }
    }

    public String retornaNomeDoArquivoDeEntradaFormatado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timestamp = LocalDateTime.now().format(formatter);
        return "pre-impressao-" + timestamp + ".txt";
    }

    public String retornaNomeDoArquivoDeSaidaFormatado(String nomeArquivo) {
        String nomeArquivoFinal = nomeArquivo.substring(0, 30);
        return nomeArquivoFinal + "-retorno.txt";
    }

}
