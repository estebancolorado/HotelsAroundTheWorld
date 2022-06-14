package com.ceiba;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProbarTest
{
    @Test
    void validarSuma()
    {
        int a = 5;
        int b = 2;
        int c = 7;

        Probar probar = new Probar();

        Assertions.assertEquals(c, probar.sumar(a, b));
    }
}