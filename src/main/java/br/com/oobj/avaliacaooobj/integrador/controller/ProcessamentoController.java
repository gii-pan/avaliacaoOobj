package br.com.oobj.avaliacaooobj.integrador.controller;

import br.com.oobj.avaliacaooobj.integrador.service.PreImpressaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ProcessamentoController {

    private final PreImpressaoService preImpressaoService;

    public ProcessamentoController(PreImpressaoService preImpressaoService){
        this.preImpressaoService = preImpressaoService;
    }

    @PostMapping("/pre-impressao")
    public ResponseEntity<String> enviaDocumento(@RequestBody String texto) {
        if(!texto.isEmpty()){
            preImpressaoService.realizarPreImpressao(texto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Não autorizado");

    }

}
