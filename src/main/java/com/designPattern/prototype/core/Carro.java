package com.designPattern.prototype.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Carro extends Automovel {
    public String categoria;
    public String cor;
    public String modelo;
    public ArrayList<ItemSerie> itensSerie = new ArrayList<>();

    public Carro(Long id, String motor, String cambio, String tipoCombustao, String loteFabricacao, boolean arCondicionado, String categoria, String modelo) {
        super(id, motor, cambio, tipoCombustao, loteFabricacao, arCondicionado);
        this.categoria = categoria;
        this.modelo = modelo;
    }

    //constructor for prototype
    public Carro(Carro carro) {
        super(carro);
        this.categoria = carro.categoria;
        this.cor = carro.cor;
        this.modelo = carro.modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<ItemSerie> getItensSerie() {
        return itensSerie;
    }

    public boolean addItensSerie(ItemSerie... itensSerie) {
        return this.itensSerie.addAll(Arrays.asList(itensSerie));
    }

    public int getSizeItensSerie() {
        return this.itensSerie.size();
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public Carro clone() {
        return new Carro(this);
    }

    @Override
    public String toString() {
        StringBuilder descricao;
        descricao = new StringBuilder("Carro{" +
                "categoria='" + categoria + '\'' +
                ", cor='" + cor + '\'' +
                ", modelo='" + modelo + '\'' +
                ", itensSerie='");

        for (ItemSerie itemSerie : itensSerie) {
            descricao.append(itemSerie.getDescricaoItem());
            if (!itemSerie.equals(itensSerie.getLast())) {
                descricao.append(", ");
            }
        }
        descricao.append("'}");
        return descricao.toString();
    }
}
