package com.vilaka.parquimetro.dtos;

import java.time.LocalDateTime;

public class RegistroSaidaDTO {
    private LocalDateTime saida;

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }
}
