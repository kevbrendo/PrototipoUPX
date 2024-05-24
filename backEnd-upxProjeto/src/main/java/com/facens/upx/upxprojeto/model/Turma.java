package com.facens.upx.upxprojeto.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeTurma;

    @OneToMany(mappedBy = "turma")
    private List<ObjetoReciclado> objetoReciclados;

    public Turma(String nomeTurma) {
        this.id = id;
        this.nomeTurma = nomeTurma;
    }

    public Turma(String nomeTurma, List<ObjetoReciclado> objetoReciclados) {
        this.nomeTurma = nomeTurma;
        this.objetoReciclados = objetoReciclados;
    }

    public Turma() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public List<ObjetoReciclado> getObjetoReciclados() {
        return objetoReciclados;
    }

    public void setObjetoReciclados(LinkedList<ObjetoReciclado> objetoReciclados) {
        this.objetoReciclados = objetoReciclados;
    }

    public void setObjetoReciclados(List<ObjetoReciclado> objetoReciclados) {
        this.objetoReciclados = objetoReciclados;
    }
}
