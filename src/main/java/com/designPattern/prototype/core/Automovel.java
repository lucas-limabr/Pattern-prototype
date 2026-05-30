package com.designPattern.prototype.core;

import java.util.Objects;

public abstract class Automovel implements Prototype {
    public Long id;
    public String motor;
    public String cambio;
    public String tipoCombustao;
    public String loteFabricacao;
    public boolean arCondicionado;

    public Automovel(Long id, String motor, String cambio, String tipoCombustao, String loteFabricacao, boolean arCondicionado) {
        this.id = id;
        this.motor = motor;
        this.cambio = cambio;
        this.tipoCombustao = tipoCombustao;
        this.loteFabricacao = loteFabricacao;
        this.arCondicionado = arCondicionado;
    }

    public Automovel(Automovel automovel) {
        this(null, automovel.motor, automovel.cambio, automovel.tipoCombustao, automovel.loteFabricacao, automovel.arCondicionado);
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getTipoCombustao() {
        return tipoCombustao;
    }

    public void setTipoCombustao(String tipoCombustao) {
        this.tipoCombustao = tipoCombustao;
    }

    public String getLoteFabricacao() {
        return loteFabricacao;
    }

    public void setLoteFabricacao(String loteFabricacao) {
        this.loteFabricacao = loteFabricacao;
    }

    public boolean ArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Automovel automovel = (Automovel) o;
        return Objects.equals(id, automovel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract Prototype clone();
}
