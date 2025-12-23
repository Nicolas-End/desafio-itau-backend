package br.com.feltex.desafio_itau.estatisticas;

import java.util.OptionalDouble;

public record StatisticsDTO(int count, double sum, double avg, OptionalDouble min, OptionalDouble max) {
}
