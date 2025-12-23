package br.com.feltex.desafio_itau.transacao;

import br.com.feltex.desafio_itau.estatisticas.StatisticsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.atomic.AtomicReference;

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

        // pega a penas as transações com menos de 60 segundos = 1 minuto
        List<TransacaoDTO> lastTransacoes = transacaoDatas.stream()
                .filter(datas ->
                        Duration.between(datas.dateHour(), OffsetDateTime.now()).toSeconds() <= 60
                )
                .toList();



        return ResponseEntity.ok(createStaticsDTO(lastTransacoes));

    }

    private StatisticsDTO createStaticsDTO(List<TransacaoDTO> lastTransacoes){
        double sum = lastTransacoes.stream()
                .mapToDouble(TransacaoDTO::value)
                .sum();

        double avg = lastTransacoes.stream()
                .mapToDouble(TransacaoDTO::value)
                .average().getAsDouble();

        OptionalDouble min = lastTransacoes.stream()
                .mapToDouble(TransacaoDTO::value)
                .min();

        OptionalDouble max = lastTransacoes.stream()
                .mapToDouble(TransacaoDTO::value)
                .max();

        return new StatisticsDTO(lastTransacoes.size(),sum,avg,min,max);
    }
}
