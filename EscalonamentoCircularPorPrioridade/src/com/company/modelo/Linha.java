package com.company.modelo;

import java.util.Comparator;

public class Linha{
    private int prioridade;
    private String NomeDado;
    private int CPU;
    private int TPE;
    private  int Turnaround;
    private  int Finalizado;
    private int Duracao;

    public String getNomeDado() {
        return NomeDado;
    }

    public void setNomeDado(String nomeDado) {
        NomeDado = nomeDado;
    }

    public int getCPU() {
        return CPU;
    }

    public void setCPU(int CPU) {
        this.CPU = CPU;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getTPE() {
        return TPE;
    }

    public void setTPE(int TPE) {
        this.TPE = TPE;
    }

    public int getTurnaround() {
        return Turnaround;
    }

    public void setTurnaround(int turnaround) {
        Turnaround = turnaround;
    }

    public int getFinalizado() {
        return Finalizado;
    }

    public void setFinalizado(int finalizado) {
        Finalizado = finalizado;
    }

    public int getDuracao() {
        return Duracao;
    }

    public void setDuracao(int duracao) {
        Duracao = duracao;
    }
}
