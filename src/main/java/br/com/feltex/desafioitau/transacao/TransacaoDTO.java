package br.com.feltex.desafioitau.transacao;

import java.time.OffsetDateTime;


// são os dados que serão cadastrados de cada transação
// os parametros representam cada informaçã osbre a transação
public record TransacaoDTO(double value, OffsetDateTime dateHour) {
}
