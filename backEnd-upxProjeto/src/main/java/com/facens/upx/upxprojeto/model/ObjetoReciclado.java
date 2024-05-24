package com.facens.upx.upxprojeto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class ObjetoReciclado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeObjeto;

    private String tipoObjeto;

    private int quatidade;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "turma_id", nullable = false)
    @JsonIgnore
    private Turma turma;

    public ObjetoReciclado(String nomeObjeto, String tipoObjeto) {
        this.nomeObjeto = nomeObjeto;
        this.tipoObjeto = tipoObjeto;
    }

    public ObjetoReciclado(String nomeObjeto, String tipoObjeto, Turma turma) {
        this.nomeObjeto = nomeObjeto;
        this.tipoObjeto = tipoObjeto;
        this.turma = turma;
    }

    public ObjetoReciclado(String nomeObjeto, String tipoObjeto, int quatidade, Turma turma) {
        this.nomeObjeto = nomeObjeto;
        this.tipoObjeto = tipoObjeto;
        this.quatidade = quatidade;
        this.turma = turma;
    }

    public ObjetoReciclado() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeObjeto() {
        return nomeObjeto;
    }

    public void setNomeObjeto(String nomeObjeto) {
        this.nomeObjeto = nomeObjeto;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    @Override
    public String toString() {
        return "ObjetoReciclado{" +
                "id=" + id +
                ", nomeObjeto='" + nomeObjeto + '\'' +
                ", tipoObjeto='" + tipoObjeto + '\'' +
                '}';
    }
}
