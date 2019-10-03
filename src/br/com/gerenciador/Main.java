package br.com.gerenciador;

import br.com.gerenciador.teste.ClasseTeste;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        ClasseTeste teste = new ClasseTeste(BigDecimal.valueOf(10),BigDecimal.valueOf(20),BigDecimal.valueOf(30),BigDecimal.valueOf(40));

        CalculadorDeClasses calc = new CalculadorDeClasses();

        System.out.println("A soma dos atributos com anotação somar foi " + calc.somar(teste));
        System.out.println("A soma dos atributos com anotação subtrair foi " + calc.subtrair(teste));
        System.out.println("A subtração das anotações foi " + calc.totalizar(teste));


    }
}
