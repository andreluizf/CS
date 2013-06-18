package com.cs.helper;

import java.math.BigDecimal;
import java.math.MathContext;

public class MoneyHelper {

    public static MathContext context = new MathContext(6);//6 de precisão

    public static BigDecimal subtrair(BigDecimal valor, BigDecimal subtrair) {
        return valor.subtract(subtrair);
    }

    public static BigDecimal dividir(BigDecimal valor, BigDecimal divisor) {
        return valor.divide(divisor, context.getPrecision(), BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal multiplicar(BigDecimal valor, BigDecimal multiplicador) {
        return valor.multiply(multiplicador, context);
    }
}
