package com.vilaka.parquimetro.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_filial")
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    private List<RegistroEstacionamento> registros = new ArrayList<>();

    public Filial() {
    }

    public Filial(Long id, String nome, String endereco, List<RegistroEstacionamento> registros) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.registros = registros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<RegistroEstacionamento> getRegistros() {
        return registros;
    }

    public void setRegistros(List<RegistroEstacionamento> registros) {
        this.registros = registros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filial filial = (Filial) o;
        return Objects.equals(id, filial.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
