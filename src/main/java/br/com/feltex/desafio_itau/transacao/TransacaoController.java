package br.com.feltex.desafio_itau.transacao;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;
    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }


    @PostMapping
    public ResponseEntity RegisterNewTransacao(@RequestBody TransacaoDTO datas) {

        return transacaoService.AddNewTransacao(datas);
    }

    @GetMapping
    public  ResponseEntity returnAllTransacoes(){
        return this.transacaoService.getAllTransacoes();
    }

    @DeleteMapping
    public ResponseEntity deleteAllTransacoes(){
        return this.transacaoService.deleteTransacoes();
    }
}