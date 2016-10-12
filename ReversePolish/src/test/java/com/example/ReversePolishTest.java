package com.example;

import org.junit.Test;

/**
 * Created by dev on 10/11/16.
 */
public class ReversePolishTest {
    ReversePolish subject = new ReversePolish();
    @Test
    public void calcShouldBeAbleToCalculateSingleDigitNumbers() {
        assert subject.calc("1 2 +") ==  3.0d;
    }

    @Test
    public void calcShouldBeAbleToCalculateMultiDigitNumbers() {
        assert subject.calc("12 3 /") == 4.0d;
    }

    @Test
    public void calcShouldBeAbleToHandleNegativeNumbers() {
        assert subject.calc("-12 3 /") == -4.0d;
    }

    @Test
    public void calcShouldBeAbleToHandleDecimalNumbers() {
        assert subject.calc("-12.9 3 /") == -4.3d;
    }

    @Test
    public void calcShouldBeAbleToHandleMoreComplexNotations() {
        assert subject.calc("1 2 + 4 * 5 + 3 -") == 14.0d;
    }

}