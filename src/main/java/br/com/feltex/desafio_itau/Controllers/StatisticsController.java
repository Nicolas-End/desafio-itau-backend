package br.com.feltex.desafio_itau.Controllers;


import br.com.feltex.desafio_itau.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransactionService transactionService;
    public StatisticsController(TransactionService transactionService){
        this.transactionService = transactionService;

    }

    @GetMapping
    public ResponseEntity getStatistics(){
        return  this.transactionService.getAllStatics();
    }
}
