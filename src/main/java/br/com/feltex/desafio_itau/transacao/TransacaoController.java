package br.com.feltex.desafio_itau.transacao;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    List<TransacaoDTO> transacaoDatas = new ArrayList<>();

    @PostMapping
    public ResponseEntity RegisterNewTransacao(@RequestBody TransacaoDTO datas) {

        this.transacaoDatas.add(datas);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public  ResponseEntity returnAllTransacoes(){
        return ResponseEntity.ok(this.transacaoDatas);
    }
}