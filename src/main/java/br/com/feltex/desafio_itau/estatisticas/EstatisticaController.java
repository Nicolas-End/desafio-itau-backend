package br.com.feltex.desafio_itau.estatisticas;


import br.com.feltex.desafio_itau.transacao.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    private final TransacaoService transacaoService;
    public EstatisticaController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;

    }

    @GetMapping
    public ResponseEntity getStatistics(){
        return  this.transacaoService.getAllStatics();
    }
}
