package com.vilaka.parquimetro.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cobranca")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;
    private boolean pago;

    @OneToOne
    @MapsId
    private RegistroEstacionamento registro;

    public Cobranca() {
    }

    public Cobranca(Long id, Double valor, boolean pago, RegistroEstacionamento registro) {
        this.id = id;
        this.valor = valor;
        this.pago = pago;
        this.registro = registro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public RegistroEstacionamento getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroEstacionamento registro) {
        this.registro = registro;
    }
}
