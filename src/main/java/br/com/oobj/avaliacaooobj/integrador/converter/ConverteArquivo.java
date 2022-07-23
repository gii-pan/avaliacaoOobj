package br.com.oobj.avaliacaooobj.integrador.converter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConverteArquivo {

    public String converterTextoParaArquivo(String texto) {
        try{
            String nomeArquivo = retornaNomeDoArquivoFormatado();
            String diretorio = "src\\main\\resources\\arquivos\\entrada\\";
            File arquivoEntrada = new File(diretorio,nomeArquivo);

            if(arquivoEntrada.createNewFile()){
                FileWriter fileWriter = new FileWriter(arquivoEntrada);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(texto);
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();

                return diretorio+nomeArquivo;
            } else {
                System.out.println("Erro ao criar arquivo");
            }
        }catch (IOException e) {
            System.out.println("Erro ao converter arquivo");
            e.printStackTrace();
        }
        return null;
    }

    public String retornaNomeDoArquivoFormatado(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timestamp = LocalDateTime.now().format(formatter);
        return "pre-impressao-" + timestamp + ".txt";
    }
}
