package com.dev.codemycloud.samplecalculadorpruebaunitaria;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import androidx.test.filters.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SmallTest
public class CalculadorTest {
    private Calculator mCalculator;
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }


    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void DivTwonumber(){
        double result = mCalculator.div(6d,2d);
        assertThat(result,is(equalTo(3d)));
    }
    @Test
    public  void MultTwonumber(){
        double reultRes = mCalculator.mul(3d,3d);
        assertThat(reultRes,is(equalTo(9d)));
    }
}
