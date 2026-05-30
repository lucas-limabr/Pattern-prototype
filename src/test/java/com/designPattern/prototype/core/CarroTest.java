package com.designPattern.prototype.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {

    Carro carro;
    ItemSerie itemSerie;
    ItemSerie itemSerie2;
    ItemSerie itemSerie3;

    @BeforeEach
    void setUp() {
        itemSerie = new ItemSerie("câmera de ré");
        itemSerie2 = new ItemSerie("direção elétrica");
        itemSerie3 = new ItemSerie("rodas de liga leve");
        carro = new Carro(001L, "v8", "automático", "elétrico", "123456789", true, "SUV", "Corolla Cross");
    }

    @Test
    @DisplayName("Apesar de um clone compartilhar do mesmo conteúdo do objeto original, ele ainda é outro objeto, ou seja, tem uma referência diferente na memória")
    void deveRetornarObjetosDiferentesComBaseEnderecoMemoria() {
        Carro carroClonado = carro.clone();
        assertNotSame(carro, carroClonado);
    }

    @Test
    @DisplayName("Um clone tem os mesmos valores de atributos em comparação ao objeto original, com exceção do seu identificador, que é o ID. O método equals() da classe será executado e com base no atributo de comparação definido na classe Automovel, que é o id, retornará false")
    void deveRetornarObjetosDiferentesComBaseConteudo() {
        Carro carroClonado = carro.clone();
        assertNotEquals(carro, carroClonado);
    }

    @Test
    void deveClonarEModificarValoresDeAtributosDoClone() {
        carro.setCor("preto");
        carro.setModelo("Virtus");
        carro.addItensSerie(itemSerie, itemSerie2, itemSerie3);

        Carro carroClonado = carro.clone();
        carroClonado.setCor("branco");
        carroClonado.setModelo("T-Cross");
        carroClonado.addItensSerie(itemSerie);

        assertEquals("Carro{categoria='SUV', cor='preto', modelo='Virtus', itensSerie='câmera de ré, direção elétrica, rodas de liga leve'}", carro.toString());

        assertEquals("Carro{categoria='SUV', cor='branco', modelo='T-Cross', itensSerie='câmera de ré'}", carroClonado.toString());
    }
}