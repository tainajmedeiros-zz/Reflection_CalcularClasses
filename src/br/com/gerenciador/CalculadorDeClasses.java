package br.com.gerenciador;

import br.com.gerenciador.annotation.Somar;
import br.com.gerenciador.annotation.Subtrair;
import br.com.gerenciador.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    public BigDecimal somar(Object objeto) {
        return calcularValoresPorTipoDeClasse(objeto, Somar.class);
    }

    public BigDecimal subtrair(Object objeto) {
        return calcularValoresPorTipoDeClasse(objeto, Subtrair.class);
    }


    public BigDecimal totalizar(Object objeto) {
        BigDecimal subtracao = subtrair(objeto);
        BigDecimal somatorio = somar(objeto);
        if(subtracao != null && somatorio != null)
            return somatorio.subtract(subtracao);
        return BigDecimal.ZERO;

    }

    private BigDecimal calcularValoresPorTipoDeClasse(Object objeto, Class classe){
        BigDecimal somatorio = BigDecimal.ZERO;
        Field[] fields = objeto.getClass().getDeclaredFields();
        for(Field f: fields){
            if(f.isAnnotationPresent(classe) && f.getType().isAssignableFrom(BigDecimal.class)){
                try {
                    f.setAccessible(true);
                    BigDecimal value = (BigDecimal) f.get(objeto);
                    if(value != null)
                        somatorio = somatorio.add(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return somatorio;
    }

}