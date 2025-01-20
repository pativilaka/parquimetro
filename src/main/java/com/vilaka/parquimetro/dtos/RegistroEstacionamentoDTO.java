package com.vilaka.parquimetro.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Representa os dados de registro de entrada e saída no estacionamento")
public class RegistroEstacionamentoDTO {

    @Schema(description = "ID do registro", example = "1")
    private Long id;

    @Schema(description = "Data e hora da entrada do veículo", example = "2025-01-20T15:00:00Z")
    private LocalDateTime entrada;

    @Schema(description = "Data e hora da saída do veículo (sempre null ao registrar entrada)", example = "null")
    private LocalDateTime saida;

    @Schema(description = "ID do veículo", example = "101")
    private Long veiculoId;

    @Schema(description = "ID da filial do estacionamento", example = "5")
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
