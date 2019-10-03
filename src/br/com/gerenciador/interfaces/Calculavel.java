package br.com.gerenciador.interfaces;

import java.math.BigDecimal;

public interface Calculavel {
    public BigDecimal somar(Object objeto);
    public BigDecimal subtrair(Object objeto);
    public BigDecimal totalizar(Object objeto);
}
