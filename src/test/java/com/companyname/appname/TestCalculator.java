package com.companyname.appname;

import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {
    @Test
    public void testAdd() throws Exception{
        Calculator calculator = new Calculator();
        int result = calculator.add(2, 5);
        Assert.assertEquals(7, result);
    }
}