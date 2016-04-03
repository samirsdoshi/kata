package org.gradle

import org.junit.Test

class NumToWordTest {

    @Test
    void 'when num is less than 10 it returns correct text'() {
        NumToWord  ntw =new org.gradle.NumToWord(8)
        assert "eight" == ntw.toWord()
    }

    @Test
    void 'when num is less than 20 it returns correct text'() {
        org.gradle.NumToWord ntw =new NumToWord(17)
        assert "seventeen" == ntw.toWord()
    }

    @Test
    void 'when num is less than 100 it returns correct text'() {
        NumToWord  ntw =new NumToWord(67)
        assert "sixty seven" == ntw.toWord()
    }

    @Test
    void 'when num is less than 1000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(783)
        assert "seven hundred eighty three" == ntw.toWord()
    }


    @Test
    void 'when num is less than 10,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(7831)
        assert "seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 100,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(67831)
        assert "sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 1,000,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(567831)
        assert "five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 10,000,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(3567831)
        assert "three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 100,000,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(273567831)
        assert "two hundred seventy three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 1,000,000,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(273567831)
        assert "two hundred seventy three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

    @Test
    void 'when num is less than 10,000,000,000 it returns correct text'() {
        NumToWord  ntw =new NumToWord(1273567831)
        assert "one billion two hundred seventy three million five hundred sixty seven thousand eight hundred thirty one" == ntw.toWord()
    }

}
