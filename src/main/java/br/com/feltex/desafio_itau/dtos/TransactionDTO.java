package br.com.feltex.desafio_itau.dtos;

import java.time.OffsetDateTime;


/*
    são os dados que serão cadastrados de cada transação

    os parametros representam cada informaçã osbre a transação

 */
public record TransactionDTO(double value, OffsetDateTime dateHour) {
}
