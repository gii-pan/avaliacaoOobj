package br.com.oobj.avaliacaooobj.integrador.converter;

import br.com.oobj.avaliacaooobj.service.ArquivoService;
import org.springframework.stereotype.Component;

@Component
public class ConverteArquivo {
    private final ArquivoService arquivoService;
    public ConverteArquivo(ArquivoService arquivoService) {
        this.arquivoService = arquivoService;
    }
    public String converterTextoParaArquivo(String texto, String nomeArquivo) {

        String diretorioEntrada = "src\\main\\resources\\arquivos\\entrada\\";
        arquivoService.escreveArquivo(diretorioEntrada, nomeArquivo,texto);

        return diretorioEntrada +nomeArquivo;
    }

}
