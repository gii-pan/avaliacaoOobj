package br.com.oobj.avaliacaooobj.controller;

import br.com.oobj.avaliacaooobj.ConverteArquivo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("api")
@RestController
public class ProcessamentoController {

    private final ConverteArquivo converteArquivo;

    public ProcessamentoController(ConverteArquivo converteArquivo){
        this.converteArquivo = converteArquivo;
    }

    @PostMapping("/pre-impressao")
    public String enviaDocumento(@RequestBody String texto) throws IOException {
        converteArquivo.converteArquivo(texto);
        return "{\"preImpressaoSolicitada\":true}";

    }

}
