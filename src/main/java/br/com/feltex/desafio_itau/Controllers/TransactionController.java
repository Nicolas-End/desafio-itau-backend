package br.com.feltex.desafio_itau.Controllers;


import br.com.feltex.desafio_itau.dtos.TransactionDTO;
import br.com.feltex.desafio_itau.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }


    @PostMapping
    public ResponseEntity RegisterNewTransaction(@RequestBody TransactionDTO datas) {

        return transactionService.AddNewTransaction(datas);
    }

    @GetMapping
    public  ResponseEntity returnAllTransactions(){
        return this.transactionService.getAllTransactions();
    }

    @DeleteMapping
    public ResponseEntity deleteAllTransaction(){
        return this.transactionService.deleteTransactions();
    }
}