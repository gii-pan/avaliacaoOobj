package br.com.oobj.avaliacaooobj.integrador.converter;

import br.com.oobj.avaliacaooobj.service.ArquivoService;
import org.springframework.stereotype.Component;

@Component
public class ConverteArquivo {
    public ArquivoService arquivoService = new ArquivoService();
    public String converterTextoParaArquivo(String texto, String nomeArquivo) {

        String diretorio = "src\\main\\resources\\arquivos\\entrada\\";

        arquivoService.escreveArquivo(diretorio, nomeArquivo,texto);
        return diretorio+nomeArquivo;
    }

}
