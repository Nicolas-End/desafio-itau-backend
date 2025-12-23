package br.com.feltex.desafio_itau.dtos;

import java.util.OptionalDouble;

/*
    Aqui são os parametros para retorar as estaticas das
    transações dos ultimos 60 segundos ao usuario
*/

public record StatisticsDTO(int count, double sum, double avg, OptionalDouble min, OptionalDouble max) {
}
