package br.com.oobj.avaliacaooobj.converter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConverteArquivo {

    public String converterTextoParaArquivo(String texto) {
        try{
            String nomeArquivo = retornaNomeDoArquivoFormatado();
            String diretorio = "C:/Users/Giulia-Oobj/Oobj/Avaliacao/entrada/";
            File arquivoEntrada = new File(diretorio,nomeArquivo);

            if(arquivoEntrada.createNewFile()){
                FileWriter myWriter = new FileWriter(arquivoEntrada);
                myWriter.write(texto);
                myWriter.close();
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
