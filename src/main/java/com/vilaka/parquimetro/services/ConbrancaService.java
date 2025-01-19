package com.vilaka.parquimetro.services;

import com.vilaka.parquimetro.interfaces.ICobrancaService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class ConbrancaService implements ICobrancaService {


    @Override
    public double calcularCobranca(LocalDateTime entrada, LocalDateTime saida) {

        long minutos = Duration.between(entrada, saida).toMinutes();

        // Set de valor padrão
        double valorMinimo = 20.0;
        int tempoMinimo = 15;

        double valorPorMinuto = valorMinimo / tempoMinimo;

        if (minutos <= tempoMinimo) {
            return valorMinimo;
        }

        return minutos * valorPorMinuto;
    }
}
