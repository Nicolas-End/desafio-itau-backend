package br.com.feltex.desafio_itau.services;

import br.com.feltex.desafio_itau.dtos.TransactionDTO;
import br.com.feltex.desafio_itau.dtos.StatisticsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class TransactionService {

    // "base de dados" para salvar transações
    private List<TransactionDTO> transacaoDatas = new ArrayList<>();


    public ResponseEntity AddNewTransaction(TransactionDTO datas){

        // guarda a data de hoje e faz a verificação
        OffsetDateTime dateNow  = OffsetDateTime.now();
        if (dateNow.isBefore(datas.dateHour())) return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();

        transacaoDatas.add(datas);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public ResponseEntity getAllTransactions(){
        return ResponseEntity.ok(transacaoDatas);
    }

    public ResponseEntity deleteTransactions(){
        //limpa os dados das transações
        transacaoDatas.clear();

        return ResponseEntity.ok().build();
    }

    public ResponseEntity getAllStatics(){

        // pega a penas as transações com menos de 60 segundos = 1 minuto
        List<TransactionDTO> lastTransacoes = transacaoDatas.stream()
                .filter(datas ->
                        Duration.between(datas.dateHour(), OffsetDateTime.now()).toSeconds() <= 60
                )
                .toList();


        return ResponseEntity.ok(createStaticsDTO(lastTransacoes));

    }

    // cria as informações das estatiscas para retornar ao usuario
    private StatisticsDTO createStaticsDTO(List<TransactionDTO> lastTransacoes){
        double sum = lastTransacoes.stream()
                .mapToDouble(TransactionDTO::value)
                .sum();

        double avg = lastTransacoes.stream()
                .mapToDouble(TransactionDTO::value)
                .average().getAsDouble();

        OptionalDouble min = lastTransacoes.stream()
                .mapToDouble(TransactionDTO::value)
                .min();

        OptionalDouble max = lastTransacoes.stream()
                .mapToDouble(TransactionDTO::value)
                .max();

        return new StatisticsDTO(lastTransacoes.size(),sum,avg,min,max);
    }
}
