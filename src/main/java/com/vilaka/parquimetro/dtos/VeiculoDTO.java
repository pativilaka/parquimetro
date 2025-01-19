package com.vilaka.parquimetro.dtos;

public class VeiculoDTO {

    private Long id;
    private String placa;
    private String modelo;
    private Long clienteId;

    // Construtor, Getters e Setters
    public VeiculoDTO() {}

    public VeiculoDTO(Long id, String placa, String modelo, Long clienteId) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
