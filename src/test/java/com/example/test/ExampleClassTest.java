package com.example.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by jairtabares on 24/10/16.
 */
public class ExampleClassTest {
    @Test(description = "Test a sum",
            groups = {"test1"})
    @Parameters(value={"termA","termB","resultSum1"})
    public void testSum(Float termA, Float termB, Float expected) throws Exception {
        ExampleClass exampleClass =  new ExampleClass();
        Float toVerify = exampleClass.sum(termA,termB);
        Assert.assertTrue(toVerify.equals(expected)); //para comparar 2 objetos por el valor, el equals es lo necesario. utilizar
        //el operador == implica validar que los objtos on iguales, no solo el valor
    }

    @Test(description = "Divide test",
            groups = {"test1"})
    @Parameters(value={"termB","termC","resultDivide"})
    public void testDivide(Float termA, Float termB, Float expected) throws Exception {
        ExampleClass exampleClass =  new ExampleClass();
        Float toVerify = exampleClass.divide(termA,termB);
        Assert.assertTrue(toVerify.equals(expected));
    }

}