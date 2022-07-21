package br.com.oobj.avaliacaooobj.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProcessamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveriaDevolver200CasoDadosDaRequisicaoEstejamCorretos() throws Exception {
        URI uri = new URI("/api/pre-impressao");

        String arquivoDaRequisicao = "IMPRESSORA;MANIFESTO\n" +
                "SELECTOR;01206820000873;003;034\n" +
                "22000;DIAS E DIAS PARADOS MEDICAMENTOS PANDEMICOS - CNPJ : 13.607.139/0001-40\n" +
                "22001;CLIENTE:0000104555 – MOGNO MAGALU MED LTDA EPP - CNPJ : 53.865.827/0001-24\n" +
                "22002;ITINERÁRIO : 034 SUB-ITINERÁRIO : 034_010\n" +
                "22007;Nr. TRANSPORTE :0701148602;SEQ :003\n" +
                "22012;MANIFESTO DE CARGA:282995\n" +
                "22013;Reimpressão : 28/04/2022-08:47\n" +
                "22014;Rota : 034 Roteiro : 034_010\n" +
                "23000;0458493052;1;1;6441317;TESTEIMPRE;;\n" +
                "24000;29220401206820000873550030064413171201984460\n" +
                "25000;STAPLE_TOP_LEFT\n" +
                "…\n" +
                "IMPRESSORA;MANIFESTO\n" +
                "SELECTOR;01206820000873;003;034\n" +
                "22000;PANPHARMA DISTRIB DE MEDICAMENTOS - CNPJ : 01.206.820/0008-73\n" +
                "22001;CLIENTE:0000136759 – DROGARIA VILLA MARIANA LTDA - CNPJ : 13.448.766/0002-66\n" +
                "22002;ITINERÁRIO : 034 SUB-ITINERÁRIO : 034_010\n" +
                "22007;Nr. TRANSPORTE :0701148602;SEQ :004\n" +
                "22012;MANIFESTO DE CARGA:282993\n" +
                "22013;Reimpressão : 28/04/2022-08:47\n" +
                "22014;Rota : 034 Roteiro : 034_010\n" +
                "23000;0458493037;1;1;6441343;TESTEIMPRE;;\n" +
                "24000;29220401206820000873550030064413431468697602\n" +
                "25000;STAPLE_TOP_LEFT";

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post(uri)
                        .content(arquivoDaRequisicao)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    void deveriaDevolver401CasoNaoExistaAutorizacao() throws Exception {
        URI uri = new URI("/api/pre-impressao");

    }
}