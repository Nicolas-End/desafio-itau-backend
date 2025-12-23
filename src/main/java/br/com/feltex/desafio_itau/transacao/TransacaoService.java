package br.com.feltex.desafio_itau.transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TransacaoService {

    // "base de dados" para salvar transações
    private List<TransacaoDTO> transacaoDatas = new ArrayList<>();

    public ResponseEntity AddNewTransacao(TransacaoDTO datas){

        // guarda a data de hoje e faz a verificação
        OffsetDateTime dateNow  = OffsetDateTime.now();
        if (dateNow.isBefore(datas.dateHour())) return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();

        transacaoDatas.add(datas);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity getAllTransacoes(){
        return ResponseEntity.ok(transacaoDatas);
    }

    public ResponseEntity deleteTransacoes(){
        transacaoDatas.clear();

        return ResponseEntity.ok().build();
    }

    public ResponseEntity getAllStatics(){

        OffsetDateTime dateNow = OffsetDateTime.now();


        List<TransacaoDTO> lastTransacoes = transacaoDatas.stream()
                .filter(datas ->
                        Duration.between(datas.dateHour(), OffsetDateTime.now()).toSeconds() <= 60
                )
                .toList();



    }
}
