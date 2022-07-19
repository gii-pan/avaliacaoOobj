package br.com.oobj.avaliacaooobj;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConverteArquivo {

    public void converteArquivo(String arquivo) throws IOException {
        try{

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");

            String timestamp = LocalDateTime.now().format(formatter);

            String nomeArquivo = "pre-impressao-" + timestamp + ".txt";

            String caminho = new ClassPathResource("arquivos/").getFile().getPath();

            File arquivos = new File(caminho,nomeArquivo);

            if(arquivos.createNewFile()){
                FileWriter myWriter = new FileWriter(arquivos);
                myWriter.write(arquivo);
                myWriter.close();
            } else {
                System.out.println("Erro ao criar arquivo");
            }

        }catch (IOException e) {
            System.out.println("Erro ao converter arquivo");
            e.printStackTrace();
        }


    }
}
