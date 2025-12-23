package br.com.feltex.desafioitau.transacao;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    List<TransacaoDTO> transacaoDatas = new ArrayList<>();

    @PostMapping
    public RegisterNewTransacao(@RequestBody TransacaoDTO datas) {



    }
}