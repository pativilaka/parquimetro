package com.vilaka.parquimetro.dtos;

import java.time.LocalDateTime;

public class RegistroEstacionamentoDTO {
    private Long id;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private Long veiculoId;
    private Long filialId;

    // Construtor, Getters e Setters
    public RegistroEstacionamentoDTO() {}

    public RegistroEstacionamentoDTO(Long id, LocalDateTime entrada, LocalDateTime saida, Long veiculoId, Long filialId) {
        this.id = id;
        this.entrada = entrada;
        this.saida = saida;
        this.veiculoId = veiculoId;
        this.filialId = filialId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }

    public Long getFilialId() {
        return filialId;
    }

    public void setFilialId(Long filialId) {
        this.filialId = filialId;
    }
}
