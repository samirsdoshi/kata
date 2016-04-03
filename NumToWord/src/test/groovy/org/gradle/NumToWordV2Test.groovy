package org.gradle

import org.junit.Test

class NumToWordV2Test {

    @Test
    void 'when num is less than 10 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(8)
        assert "eight" == ntw.toWord()
    }

    @Test
    void 'when num is less than 20 it returns correct text'() {
        NumToWordV2 ntw =new NumToWordV2(17)
        assert "seventeen" == ntw.toWord()
    }

    @Test
    void 'when num is less than 100 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(67)
        assert "sixty seven" == ntw.toWord()
    }

    @Test
    void 'when num is less than 1000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(783)
        assert "seven hundred eighty three" == ntw.toWord()
    }


    @Test
    void 'when num is less than 10,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(7831)
        assert "seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 100,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(67831)
        assert "sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 1,000,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(567831)
        assert "five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 10,000,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(3567831)
        assert "three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 100,000,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(273567831)
        assert "two hundred seventy three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 1,000,000,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(273567831)
        assert "two hundred seventy three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 10,000,000,000 it returns correct text'() {
        NumToWordV2  ntw =new NumToWordV2(1273567831)
        assert "one billion two hundred seventy three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

}
