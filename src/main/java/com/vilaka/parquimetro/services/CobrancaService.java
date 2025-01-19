package com.vilaka.parquimetro.services;

import com.vilaka.parquimetro.interfaces.ICobrancaService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class CobrancaService implements ICobrancaService {


    @Override
    public double calcularCobranca(LocalDateTime entrada, LocalDateTime saida) {

        if (entrada == null || saida == null) {
            throw new IllegalArgumentException("As datas de entrada e saída não podem ser nulas.");
        }
        if (saida.isBefore(entrada)) {
            throw new IllegalArgumentException("A data de saída não pode ser anterior à data de entrada.");
        }

        long minutos = Duration.between(entrada, saida).toMinutes();

        // Set de valor padrão
        final double VALOR_MINIMO = 20.0;
        final int TEMPO_MINIMO = 15; // Em minutos
        final double VALOR_POR_MINUTO = VALOR_MINIMO / TEMPO_MINIMO;

        if (minutos <= TEMPO_MINIMO) {
            return VALOR_MINIMO;
        }

        return minutos * VALOR_POR_MINUTO;
    }
}
