package com.vilaka.parquimetro.dtos;

public class CobrancaDTO {

    private Long id;
    private double valor;
    private boolean pago;
    private Long registroId;

    // Construtor, Getters e Setters
    public CobrancaDTO() {}

    public CobrancaDTO(Long id, double valor, boolean pago, Long registroId) {
        this.id = id;
        this.valor = valor;
        this.pago = pago;
        this.registroId = registroId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Long getRegistroId() {
        return registroId;
    }

    public void setRegistroId(Long registroId) {
        this.registroId = registroId;
    }
}
